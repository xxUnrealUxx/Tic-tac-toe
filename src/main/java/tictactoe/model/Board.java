package tictactoe.model;
import java.util.*;

public class Board{
    private Symbol[][] cells = new Symbol[3][3];

    public Board(){
        for(int i = 0; i < 3; i++)
            for(int j = 0; j < 3; j++)
                cells[i][j] = Symbol.EMPTY;
    }

    public Board(Symbol[][] cells){
        this.cells = cells;
    }

    /**
     * Checks whether the given parameters are valid
     * @param row - row of the box chosen
     * @param column - column of the box chosen
     * @throws IllegalArgumentException if parameters are invalid
     */
    public void validArguments(int row, int column){
        if (!((row >= 0 && row < 3) && (column >= 0 && column < 3)))
            throw new IllegalArgumentException("Invalid cell coordinates");
    }

    /**
     * Places a symbol at a certain, valid coordinate
     * @param row - row of the box
     * @param column - column of the box
     * @param s - symbol
     * @return {@code true} if placed, {@code false} if not
     */
    public boolean placeMove(int row, int column, Symbol s){
        if(!isCellEmpty(row, column))
            return false;

        cells[row][column] = s;
        return true;
    }

    /**
     * Checks whether a cell if empty (and implicitly if it is in bounds)
     * @param row - row of the box
     * @param column - column of the box
     * @return {@code true} if the cell is empty and in bounds, {@code false} otherwise
     */
    public boolean isCellEmpty(int row, int column){
        try {
            validArguments(row, column);
            return cells[row][column] == Symbol.EMPTY;
        } catch (IllegalArgumentException e){
            return false;
        }
    }

    /**
     * Check whether there is a winner on the table
     * @return the winning symbol or Symbol.EMPTY if no winners
     */
    public Symbol checkWinner(){
        for(int i = 0; i < 3; i++)
            if(cells[i][1] == cells[i][0] && cells[i][1] == cells[i][2] && cells[i][1] != Symbol.EMPTY)
                return cells[i][1];

        for(int i = 0; i < 3; i++)
            if(cells[1][i] == cells[0][i] && cells[1][i] == cells[2][i] && cells[1][i] != Symbol.EMPTY)
                return cells[1][i];

        if(cells[0][0] == cells[1][1] && cells[1][1] == cells[2][2] && cells[1][1] != Symbol.EMPTY)
            return cells[0][0];

        if(cells[0][2] == cells[1][1] && cells[1][1] == cells[2][0] && cells[1][1] != Symbol.EMPTY)
            return cells[0][2];

        return Symbol.EMPTY;
    }

    /**
     * Resets the board to all empty
     */
    public void clear(){
        for(int i = 0; i < 3; i++)
            for(int j = 0; j < 3; j++)
                cells[i][j] = Symbol.EMPTY;
    }

    public Symbol getCell(int row, int column){
        try{
            validArguments(row, column);
            return cells[row][column];
        } catch (IllegalArgumentException e){
            return null;
        }
    }

    public Symbol[][] getCells(){
        return cells;
    }
}