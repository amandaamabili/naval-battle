package src.br.com.letscode.navalbattle;

public class Board {

//    Array de slots para armazenar os navios e marcar as jogadas
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

//  Array auxiliar pra listar as letras ao início de cada LINHA ("row");
    private static String[] columnLetter = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};

//    Função que "renderiza" o tabuleiro na tela;
    public static void drawBoard() {

//        Cabeçalho
        System.out.println(
            "---------------------------------------------\n"
            +"                  JOGADOR                 \n"+
            "---------------------------------------------\n"+
            "|   | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |\n"+
            "---------------------------------------------"
        );

//        loops que  perpassam por cada linha e itens do array board[][]. Primeiro, o loop que passa pelo primeiro nível da matriz;
        for (int row = 0; row < board.length; row++) {

//            Aqui chamamos a letra que inicia cada linha do tabuleiro;
            System.out.printf("| %s ", columnLetter[row]);

//            E aqui fazemos mais um loop no segundo nível da matriz, no array de espaços ("tiles") e os projetamos com as divisões;
            for (int tile = 0; tile < board[row].length; tile++) {
                System.out.printf("| %s ", board[row][tile]);
            }

//            Ao terminar de printar na tela cada "tile" da "row", printamos a linha de baixo e o loop da "row" se reinicia;
            System.out.printf("|\n---------------------------------------------\n");

        }










    }
}
