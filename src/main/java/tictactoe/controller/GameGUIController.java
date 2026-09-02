package tictactoe.controller;

import tictactoe.model.Game;
import tictactoe.model.Player;
import tictactoe.model.Symbol;
import tictactoe.ui.GUI;

public class GameGUIController {

    private GUI gui;
    private Game game;

    public GameGUIController(GUI gui, Game game){
        this.gui = gui;
        this.game = game;
    }

    public String boardClick(int row, int column){
        Symbol current = game.getCurrentPlayer().getSymbol();
        game.makeMove(row, column);
        if(current == Symbol.X) return "X";
        else if(current == Symbol.O) return "O";
        return null;
    }

    public Player getWinner(){
        return game.getWinner();
    }

    public boolean isGameOver(){
        return game.isGameOver();
    }

    public void resetGame(){
        game.reset();
    }

    public Player getPlayer1(){
        return game.getPlayers()[0];
    }

    public Player getPlayer2(){
        return game.getPlayers()[1];
    }

    public Player getCurrentPlayer(){
        return game.getCurrentPlayer();
    }

    public void setPlayerName(int index, String newName) {
        game.getPlayers()[index].setName(newName);
    }
}
