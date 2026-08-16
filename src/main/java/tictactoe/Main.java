package tictactoe;
import tictactoe.model.*;

public class Main {

    public static void main(String[] args){
        Player player1 = new Player("Player1", Symbol.X);
        Player player2 = new Player("Player2", Symbol.O);
        Game game = new Game(player1, player2);
        game.play();
    }
}
