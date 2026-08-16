package tictactoe.model;
import java.util.*;

public class Game{
    private final Board board;
    private final Player[] players;

    public Game(Player playerX, Player playerO){
        this.board = new Board();
        players = new Player[2];
        this.players[0] = playerX;
        this.players[1] = playerO;
    }

    /**
     * The whole mechanism of the game
     * @return winning player
     */
    public Player play() {
        Scanner s = new Scanner(System.in);
        Player winner = null;
        int row;
        int column;

        for(int i = 0; i < 9; i++){

            System.out.println(players[i%2].getName() + "'s turn");
            System.out.println("Choose row");
            row = s.nextInt();
            System.out.println("Choose column");
            column = s.nextInt();

            while(!board.placeMove(row, column, players[i%2].getSymbol())){
                System.out.println(players[i%2].getName() + "'s turn");
                System.out.println("Choose row");
                row = s.nextInt();
                System.out.println("Choose column");
                column = s.nextInt();
            }

            winner = Player.getSymbolPlayer(players, board.checkWinner());
            if(winner != null) break;
        }

        board.clear();
        return winner;
    }
}