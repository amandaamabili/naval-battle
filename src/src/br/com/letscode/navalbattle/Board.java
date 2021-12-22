package src.br.com.letscode.navalbattle;

public class Board {

    private static String[][] board = {
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
    };


    private static String[] columnLetter = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};

    public static void drawBoard() {
        System.out.println(
            "---------------------------------------------\n"
            +"                  JOGADOR                 \n"+
            "---------------------------------------------\n"+
            "|   | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |\n"+
            "---------------------------------------------"
        );

        for (int row = 0; row < board.length; row++) {


            System.out.printf("| %s ", columnLetter[row]);

            for (int tile = 0; tile < board[row].length; tile++) {
                System.out.printf("| %s ", board[row][tile]);
            }

            System.out.printf("|\n---------------------------------------------\n");

        }










    }
}
