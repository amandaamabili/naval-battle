package src.br.com.letscode.navalbattle;

public class Main {

    public static void main(String[] args) {


        var board = new Board();
        board.initializeMatch();

        while (!board.hasWinner()) {
            board.humanTurn();
            board.iaTurn();

            board.printPositions(board.p1);
            board.printPositions(board.p2);

            board.score();
        }
    }
}
