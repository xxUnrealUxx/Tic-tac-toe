package tictactoe.ui;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import tictactoe.controller.GameGUIController;
import tictactoe.model.Game;
import tictactoe.model.Player;

public class GUI extends Application {

    private GameGUIController controller;
    private Scene mainMenuScene;
    private Scene gameScene;
    private Scene changeNameScene;
    private Button[][] gridButtons;

    @Override
    public void start(Stage stage) throws Exception {
        Game game = new Game();
        controller = new GameGUIController(this, game);

        setMainMenuScene(stage);

        stage.setTitle("Tic-tac-toe");
        stage.setScene(mainMenuScene);
        stage.show();
    }

    /**
     * Sets up the Main-Menu Window
     * @param stage
     */
    private void setMainMenuScene(Stage stage){
        var title = new Label("Tic-Tac-Toe");
        var playButton = new Button("Play Game");
        var quitButton = new Button("Quit");
        var changeNameButton = new Button("Change name");

        var layout = new VBox(10, title, playButton, changeNameButton, quitButton);

        mainMenuScene = new Scene(layout, 300, 400);
        layout.setStyle("-fx-alignment: top-center; -fx-text-alignment: center; -fx-spacing: 40px;");
        VBox.setMargin(playButton, new Insets(100, 0, 0, 0));
        VBox.setMargin(title, new Insets(20, 0, 0, 0));

        playButton.setOnAction((event) -> {
            setGameScene(stage);
            stage.setScene(gameScene);
        });

        changeNameButton.setOnAction((event) -> {
            changeNameScene(stage);
            stage.setScene(changeNameScene);
        });

        quitButton.setOnAction((event) -> {
            stage.close();
        });
    }

    /**
     * Sets up the Game Window
     * @param stage
     */
    private void setGameScene(Stage stage){
        var labelplayer1 = new Label(controller.getPlayer1().getName() + " : " + controller.getPlayer1().getScore());
        var labelplayer2 = new Label(controller.getPlayer2().getName() + " : " + controller.getPlayer2().getScore());
        Button backButton = new Button("Back");
        var playAgainButton = new Button("Play Again");
        playAgainButton.setVisible(false);
        var scoreboard = new HBox(10, labelplayer1, labelplayer2);
        var currentMove = new Label(controller.getCurrentPlayer().getName() + "'s turn");
        var grid = new GridPane();
        grid.setStyle("-fx-border-color: black");
        var layout = new VBox(10, scoreboard, currentMove, grid, backButton, playAgainButton);
        gridButtons = new Button[3][3];

        for(int i = 0; i < 3; i++)
            for(int j = 0; j < 3; j++){
                Button button = new Button();

                grid.add(button, j, i);
                gridButtons[i][j] = button;

                button.setOnAction((event) -> {
                    button.setText(controller.boardClick(grid.getRowIndex(button), grid.getColumnIndex(button)));
                    button.setDisable(true);
                    currentMove.setText(controller.getCurrentPlayer().getName() + "'s turn");

                    Player winner = controller.getWinner();
                    if(winner == null && controller.isGameOver()) {
                        currentMove.setText("Draw!");
                        disableButtons();
                        playAgainButton.setVisible(true);
                    }

                    else if(winner != null) {
                        currentMove.setText(winner.getName() + " has won the round!");
                        disableButtons();
                        playAgainButton.setVisible(true);
                    }
                });
            }

        layout.setStyle("-fx-alignment: top-center; -fx-text-alignment: center; -fx-spacing: 40px;");
        gameScene = new Scene(layout, 300, 400);

        backButton.setOnAction((event) -> {
            stage.setScene(mainMenuScene);
        });

        playAgainButton.setOnAction((event) -> {
            controller.resetGame();
            setGameScene(stage);
            stage.setScene(gameScene);
        });
    }

    private void changeNameStage(int index){
        Stage changeName = new Stage();
        changeName.initModality(Modality.APPLICATION_MODAL);
        changeName.setTitle("Change name");
        Label label = new Label("Choose your new name:");
        TextField t = new TextField();
        t.setPromptText("Insert text here...");
        var confirmButton = new Button("Confirm");
        var exitButton = new Button("Cancel");

        HBox box1 = new HBox(10, t, confirmButton);
        VBox box2 = new VBox(10, label, box1, exitButton);
        box2.setStyle("-fx-alignment: top-center; -fx-text-alignment: center;");
        Scene scene = new Scene(box2, 200, 200);
        changeName.setScene(scene);


        confirmButton.setOnAction((event) -> {
            controller.setPlayerName(index, t.getText());
            changeName.close();
        });

        exitButton.setOnAction((event) -> {
            changeName.close();
        });

        changeName.showAndWait();
    }

    private void changeNameScene(Stage stage){
        Label player1 = new Label("Player 1 : " + controller.getPlayer1().getName());
        Label player2 = new Label("Player 2 : " + controller.getPlayer2().getName());
        Button backButton = new Button("Back");

        Button change1 = new Button("Change name");
        Button change2 = new Button("Change name");

        HBox p1 = new HBox(player1, change1);
        HBox p2 = new HBox(player2, change2);

        VBox layout = new VBox(10, p1, p2, backButton);
        layout.setStyle("-fx-alignment: top-center; -fx-text-alignment: center;");
        changeNameScene = new Scene(layout, 300, 400);

        change1.setOnAction((event) -> {
            changeNameStage(0);
            refresh(player1, player2);
        });

        change2.setOnAction((event) -> {
            changeNameStage(1);
            refresh(player1, player2);
        });

        backButton.setOnAction(event -> {
            stage.setScene(mainMenuScene);
        });
    }

    private void refresh(Label p1, Label p2){
        p1.setText("Player 1 : " + controller.getPlayer1().getName());
        p2.setText("Player 2 : " + controller.getPlayer2().getName());
    }

    private void disableButtons(){
        for(int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++)
                gridButtons[i][j].setDisable(true);
        }
    }

    public static void main(String[] args) {
        launch();
    }
}
