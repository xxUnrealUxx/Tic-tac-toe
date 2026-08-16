package tictactoe.model;
import java.util.*;

public enum Symbol{
    X("X"),
    O("O"),
    EMPTY(" ");

    private final String display;

    Symbol(String display){
        this.display = display;
    }

    public String getDisplay(){
        return display;
    }
}