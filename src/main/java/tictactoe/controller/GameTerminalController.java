package tictactoe.controller;
import tictactoe.model.*;
import tictactoe.ui.TerminalUI;

public class GameTerminalController {

    private final Game game;
    private final TerminalUI ui;

    public GameTerminalController(Game game, TerminalUI ui) {
        this.game = game;
        this.ui = ui;
    }

    /**
     * Prints the main menu and lets the user choose
     */
    public void play(){
        while(true) {
            int choice = ui.menuChoice();
            switch (choice) {
                case 1 -> {
                    round();
                    ui.clearScreen();
                    break;
                }

                case 2 -> {
                    changeName();
                    ui.clearScreen();
                    break;
                }

                case 3 -> {
                    return;
                }

                default -> {
                    ui.invalidChoice();
                    break;
                }
            }
        }
    }

    /**
     * Prints the possible options and lets the user choose whether to change the name of a player
     */
    public void changeName(){
        while(true) {
            Player player1 = game.getPlayers()[0];
            Player player2 = game.getPlayers()[1];
            int choice = ui.changeNameChoice(player1.getName(), player2.getName());
            switch (choice) {
                case 1 -> {
                    player1.setName(ui.changeName());
                    ui.clearScreen();
                    break;
                }

                case 2 -> {
                    player2.setName(ui.changeName());
                    ui.clearScreen();
                    break;
                }
                case 3 -> {
                    return;
                }
                default -> {
                    ui.invalidChoice();
                    break;
                }
            }
        }
    }

    /**
     * Handles the flow of a single ticktacktoe game round
     */
    public void round() {
        while(!game.iGameOver()){
            Player winner = null;
            ui.clearScreen();
            ui.printBoard(game.getBoard());
            ui.playerAnnouncement(game.getCurrentPlayer());

            while(!game.makeMove(ui.chooseCoordinate("Choose row: "), ui.chooseCoordinate("Choose column: "))){
                ui.printInvalidArgs();
            }

            winner = game.getWinner();
            if(winner != null) {
                ui.printBoard(game.getBoard());
                ui.announceWinner(winner);
                game.reset();
                return;
            }
        }

        ui.printBoard(game.getBoard());
        ui.announceDraw();
        game.reset();
    }
}
