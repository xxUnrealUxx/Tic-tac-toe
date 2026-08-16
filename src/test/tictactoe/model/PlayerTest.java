package tictactoe.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void returnsPlayerWithMatchingSymbol() {
        Player xPlayer = new Player("Alice", Symbol.X);
        Player oPlayer = new Player("Bob", Symbol.O);

        Player[] players = {xPlayer, oPlayer};

        Player result = Player.getSymbolPlayer(players, Symbol.X);

        assertEquals(xPlayer, result);
    }

    @Test
    void returnsOPlayerWhenSearchingForO() {
        Player xPlayer = new Player("Alice", Symbol.X);
        Player oPlayer = new Player("Bob", Symbol.O);

        Player[] players = {xPlayer, oPlayer};

        Player result = Player.getSymbolPlayer(players, Symbol.O);

        assertEquals(oPlayer, result);
    }

    @Test
    void returnsNullWhenNoPlayerHasSymbol() {
        Player xPlayer = new Player("Alice", Symbol.X);

        Player[] players = {xPlayer};

        Player result = Player.getSymbolPlayer(players, Symbol.O);

        assertNull(result);
    }

    @Test
    void returnsNullForNullPlayersArray() {
        assertNull(Player.getSymbolPlayer(null, Symbol.X));
    }

    @Test
    void returnsNullForNullSymbol() {
        Player player = new Player("Alice", Symbol.X);
        Player[] players = {player};

        assertNull(Player.getSymbolPlayer(players, null));
    }

    @Test
    void returnsNullWhenSearchingForEmptySymbol() {
        Player xPlayer = new Player("Alice", Symbol.X);
        Player oPlayer = new Player("Bob", Symbol.O);

        Player[] players = {xPlayer, oPlayer};

        assertNull(Player.getSymbolPlayer(players, Symbol.EMPTY));
    }

    @Test
    void returnsFirstPlayerWhenMultiplePlayersHaveSameSymbol() {
        Player firstPlayer = new Player("Alice", Symbol.X);
        Player secondPlayer = new Player("Charlie", Symbol.X);

        Player[] players = {firstPlayer, secondPlayer};

        Player result = Player.getSymbolPlayer(players, Symbol.X);

        assertEquals(firstPlayer, result);
    }
}