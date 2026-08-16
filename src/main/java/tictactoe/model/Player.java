package tictactoe.model;
import java.util.*;

public class Player{
     private final Symbol symbol;
     private final String name;

     public Player(String name, Symbol symbol){
         this.name = name;
         this.symbol = symbol;
     }

    /**
     * Searches the first occurrence of a player with a certain symbol
     * @param players - array of players
     * @param symbol  - symbol to be searched
     * @return the first player object with the symbol, null otherwise
     */
    public static Player getSymbolPlayer(Player[] players, Symbol symbol){
         if(players == null || symbol == null || symbol == Symbol.EMPTY)
             return null;

         for(int i = 0; i < players.length; i++)
             if(players[i] != null && players[i].symbol == symbol)
                 return players[i];

         return null;
    }

    public String getName() {
        return name;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return symbol == player.symbol && Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(symbol, name);
    }
}