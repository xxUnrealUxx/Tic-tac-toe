import java.util.*;

public class Board{
    private Symbol[][] cells = new Symbol[3][3];

    public Board();

    public Board(Symbol[][] cells){
        this.cells = cells;
    }

    public boolean validArguments(int row, int column){
        return (row >= 0 || row < 3) && (column <= 0 || column < 3)
    }

    public boolean placeMove(int row, int column, Symbol s){
        if(!validArguments(row, column))
            return false;

        cells[row][column] = s;
        return true;
    }

    public boolean isCellEmpty(int row, int column){
        if(!validArguments(row, column))
            return false;

        if(cells[row][column] == Symbol.EMPTY)
            return true;
    }

    public Symbol getCell(int row, int column){
        if(!validArguments(row, column))
            return false;

        return cells[row][columns];
    }

    public Symbol checkWinner(){
        for(int i = 0; i < 3; i++)
            if(cells[i][1] == cells[i][0] && cells[i][1] == cells[i][2])
                return cells[i][1];

        for(int i = 0; i < 3; i++)
            if(cells[1][i] == cells[0][i] && cells[1][i] == cells[2][i])
                return cells[1][i];

        if(cells[0][0] == cells[1][1] && cells[1][1] == cells[2][2])
            return cells[0][0];

        if(cells[0][2] == cells[1][1] && cells[1][1] == cells[0][2])
            return cells[0][2];

        return Symbol.EMPTY;
    }

}