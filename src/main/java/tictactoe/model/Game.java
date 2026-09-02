package tictactoe.model;
import java.util.*;

public class Game{
    private final Board board;
    private final Player[] players;
    private int counter = 0;
    private int offset = 0;

    public Game(){
        this.board = new Board();
        players = new Player[2];
        this.players[0] = new Player("Player1", Symbol.X);
        this.players[1] = new Player("Player2", Symbol.O);
    }

    public boolean makeMove(int row, int column){
        if(!board.placeMove(row, column, players[(offset + counter)%2].getSymbol())) return false;
        counter++;
        return true;
    }

    public Player getWinner(){
        Player winner = Player.getSymbolPlayer(players, board.checkWinner());
        if(winner != null)
            winner.hasWon();

        return winner;
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

    public boolean isGameOver(){
        return counter > 8;
    }

    public void reset(){
        counter = 0;
        offset = (offset + 1) % 2;
        board.clear();
    }
}