package tictactoe;
import tictactoe.controller.GameTerminalController;
import tictactoe.model.*;
import tictactoe.ui.TerminalUI;
import java.util.*;

public class Main {

    public static void main(String[] args){
        Player player1 = new Player("Player1", Symbol.X);
        Player player2 = new Player("Player2", Symbol.O);
        Game game = new Game(player1, player2);
        TerminalUI ui = new TerminalUI(new Scanner(System.in));
        GameTerminalController controller = new GameTerminalController(game, ui);
        controller.play();
    }
}
