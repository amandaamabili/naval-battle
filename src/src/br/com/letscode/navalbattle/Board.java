package src.br.com.letscode.navalbattle;

public class Board {

    private String[][] board = {
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}
    };

    public static void drawBoard() {
        System.out.println(
                "---------------------------------------------\n"
        +"                  JOGADOR                 \n"+
                        "---------------------------------------------\n"+
                        "|   | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |");


    }
}
