package tictactoe.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    @Test
    void validArgumentsAcceptsValidCoordinates() {
        Board board = new Board();

        assertDoesNotThrow(() -> board.validArguments(0, 0));
        assertDoesNotThrow(() -> board.validArguments(1, 1));
        assertDoesNotThrow(() -> board.validArguments(2, 2));
    }

    @Test
    void validArgumentsRejectsInvalidCoordinates() {
        Board board = new Board();

        assertThrows(IllegalArgumentException.class, () -> board.validArguments(-1, 0));
        assertThrows(IllegalArgumentException.class, () -> board.validArguments(3, 0));
        assertThrows(IllegalArgumentException.class, () -> board.validArguments(0, -1));
        assertThrows(IllegalArgumentException.class, () -> board.validArguments(0, 3));
    }

    @Test
    void emptyBoardContainsEmptyCells() {
        Board board = new Board();

        assertEquals(Symbol.EMPTY, board.getCell(0, 0));
        assertEquals(Symbol.EMPTY, board.getCell(1, 1));
        assertEquals(Symbol.EMPTY, board.getCell(2, 2));
    }

    @Test
    void emptyCellIsRecognizedAsEmpty() {
        Board board = new Board();

        assertTrue(board.isCellEmpty(0, 0));
    }

    @Test
    void placeMovePlacesSymbolOnEmptyCell() {
        Board board = new Board();

        assertTrue(board.placeMove(1, 1, Symbol.X));
        assertEquals(Symbol.X, board.getCell(1, 1));
    }

    @Test
    void cannotPlaceMoveOnOccupiedCell() {
        Board board = new Board();

        board.placeMove(1, 1, Symbol.X);

        assertFalse(board.placeMove(1, 1, Symbol.O));
        assertEquals(Symbol.X, board.getCell(1, 1));
    }

    @Test
    void detectsHorizontalWinner() {
        Board board = new Board();

        board.placeMove(0, 0, Symbol.X);
        board.placeMove(0, 1, Symbol.X);
        board.placeMove(0, 2, Symbol.X);

        assertEquals(Symbol.X, board.checkWinner());
    }

    @Test
    void detectsVerticalWinner() {
        Board board = new Board();

        board.placeMove(0, 1, Symbol.O);
        board.placeMove(1, 1, Symbol.O);
        board.placeMove(2, 1, Symbol.O);

        assertEquals(Symbol.O, board.checkWinner());
    }

    @Test
    void detectsDiagonalWinner() {
        Board board = new Board();

        board.placeMove(0, 0, Symbol.X);
        board.placeMove(1, 1, Symbol.X);
        board.placeMove(2, 2, Symbol.X);

        assertEquals(Symbol.X, board.checkWinner());
    }

    @Test
    void detectsOtherDiagonalWinner() {
        Board board = new Board();

        board.placeMove(0, 2, Symbol.O);
        board.placeMove(1, 1, Symbol.O);
        board.placeMove(2, 0, Symbol.O);

        assertEquals(Symbol.O, board.checkWinner());
    }

    @Test
    void returnsEmptyWhenThereIsNoWinner() {
        Board board = new Board();

        board.placeMove(0, 0, Symbol.X);
        board.placeMove(0, 1, Symbol.O);
        board.placeMove(1, 1, Symbol.X);

        assertEquals(Symbol.EMPTY, board.checkWinner());
    }
}