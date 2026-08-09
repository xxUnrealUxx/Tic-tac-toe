import java.util.*;

public class Game{
    private Board board;
    private Player[2] players;
    private Symbol[2] symbols;

    private Player currentPlayer;

    public Game(Player playerX, Player playerO){
        this.board = new Board();
        this.players[0] = playerX;
        this.players[1] = playerO;
        currentPlayer = playerX;
        symbols[0] = Symbols.X;
        symbols[1] = Symbols.O;
    }

    public Symbol play() {
        Scanner s = new Scanner(System.in);
        for(int i = 0; i < 9; i++){
            int row = s.nextInt();
            int column = s.nextInt();

            board.placeMove(row, column, symbols[i%2]);
            Symbol w = board.checkWinner();
            if(w != Symbol.EMPTY)
                return w;
        }
    }
}