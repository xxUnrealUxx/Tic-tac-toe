package tictactoe.model;
import java.util.*;

public class Game{
    private final Board board;
    private final Player[] players;
    private int counter = 0;

    public Game(Player playerX, Player playerO){
        this.board = new Board();
        players = new Player[2];
        this.players[0] = playerX;
        this.players[1] = playerO;
    }

    public boolean makeMove(int row, int column){
        if(!board.placeMove(row, column, players[counter%2].getSymbol())) return false;
        counter++;
        return true;
    }

    public Player getWinner(){
        return Player.getSymbolPlayer(players, board.checkWinner());
    }

    public Player getCurrentPlayer(){
        return players[counter%2];
    }

    public Player[] getPlayers(){
        return players;
    }

    public Board getBoard(){
        return board;
    }

    public boolean iGameOver(){
        return counter > 8;
    }

    public void reset(){
        counter = 0;
        board.clear();
    }
}