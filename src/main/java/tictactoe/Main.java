package tictactoe;
import tictactoe.controller.GameTerminalController;
import tictactoe.model.*;
import tictactoe.ui.TerminalUI;
import java.util.*;

public class Main {

    public static void main(String[] args){
        Game game = new Game();
        TerminalUI ui = new TerminalUI(new Scanner(System.in));
        GameTerminalController controller = new GameTerminalController(game, ui);
        controller.play();
    }
}
