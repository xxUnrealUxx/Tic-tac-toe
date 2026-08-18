package tictactoe.ui;
import tictactoe.model.*;
import java.util.*;

public class TerminalUI{

    private final Scanner scanner;

    public TerminalUI(Scanner scanner){
        this.scanner = scanner;
    }

    /**
     * Prints that arguments are invalid
     */
    public void printInvalidArgs(){
        System.out.println("Invalid row and/or column.");
    }

    /**
     * Prints the menu and returns the choice
     */
    public int menuChoice(){
        System.out.println("""
                ----------MENU---------
                1. Play round
                2. Change player name
                3. Exit
                ----------------------
                Select option: """);

        int choice = scanner.nextInt();
        clearNewLine();
        return choice;
    }

    public int changeNameChoice(String player1, String player2){
        System.out.printf(
                """
                    ------Players--------------------------
                    1. Change name - Player 1: %s 
                    2. Change name - Player 2: %s
                    3. Exit
                    ---------------------------------------
                    Select option: """, player1, player2);

        int choice = scanner.nextInt();
        clearNewLine();
        return choice;
    }

    public String changeName(){
        System.out.print("Choose a new name: ");
        return scanner.nextLine().trim();
    }

    /**
     * Announces a player's turn
     * @param player - player of the game
     */
    public void playerAnnouncement(Player player){
        System.out.println(player.getName() + "'s turn");
    }

    /**
     * Prints the board on the terminal
     * @param board - ticktactoe board
     */
    public void printBoard(Board board){
        var cells = board.getCells();

        for(int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("  " + cells[i][j].getDisplay() + "  ");
                if(j < 2)
                    System.out.print("|");
            }
            System.out.println();
            if(i < 2) System.out.println("------------------");
        }

        System.out.println();
    }

    /**
     * Prints a message and then reads from the input a value
     * @param message - message to be printed
     * @return int
     */
    public int chooseCoordinate(String message){
        System.out.print(message);
        int r = scanner.nextInt();
        clearNewLine();
        return r;
    }

    /**
     * Clears the screen
     */
    public void clearScreen(){
        System.out.print("\n".repeat(5));
        System.out.flush();
    }

    /**
     * Prints the winner
     */
    public void announceWinner(Player player){
        System.out.println(player.getName() + " has won this round");
    }

    /**
     * Prints draw
     */
    public void announceDraw(){
        System.out.println();
    }

    /**
     * Shall be used after each scanner function call
     */
    public void clearNewLine(){
        scanner.nextLine();
    }
}
