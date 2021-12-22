package src.br.com.letscode.navalbattle;

import java.util.Arrays;
import java.util.Scanner;

public class Board {

    public static Scanner input = new Scanner(System.in);
    public static char[] coordinate = new char[2];
    public static String coordLetter;
    public static int coordNumber;



//    Array de slots para armazenar os navios e marcar as jogadas
    private static String[][] playerBoard = {
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

    private static String[][] enemyBoard = {
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

//  Array auxiliar pra listar as letras ao início de cada LINHA ("row").
//  Ele é usado tanto pra nos dar o index de cada letra
//  quanto para printar a coluna de letras em cada renderização do tabuleiro;
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

//        loops que perpassam por cada linha e itens do array board[][].
//        Primeiro, o loop que passa pelo primeiro nível da matriz;
        for (int row = 0; row < playerBoard.length; row++) {

//            Aqui chamamos a letra que inicia cada linha do tabuleiro;
            System.out.printf("| %s ", columnLetter[row]);

//            E aqui fazemos mais um loop no segundo nível da matriz,
//            no array de espaços ("tiles") e os projetamos com as divisões de cada quadrinho;
            for (int tile = 0; tile < playerBoard[row].length; tile++) {
                System.out.printf("| %s ", playerBoard[row][tile]);
            }

//            Ao terminar de printar na tela cada "tile" da "row",
//            printamos a linha de baixo e o loop da "row" se reinicia;
            System.out.printf("|\n---------------------------------------------\n");

        }
    }

//        Função para o jogador inserir manualmente suas peças no tabuleiro
        public static void playerInsertShipsOnBoard() {
            for (int submarineNumber = 1; submarineNumber <= 10 ; submarineNumber++) {
                System.out.printf("Selecione a localização do Submarino %d \n", submarineNumber);

//                armazenamos a coordenada inserida
//                (que deve vir em formato LetraNúmero, exemplos: B2, C4)
//                em um array de chars;

                coordinate = input.next().toCharArray();

                    /*
                    Aqui inserimos um "N" nas coordenadas passadas acima.
                    O que estamos fazendo é o seguinte:
                    Chamamos o playerBoard[][] e
                    dentro do primeiro nível, convertemos o char para String e buscamos seu índice
                    usando o array auxiliar de letras lá encima. Esse índice é passado no primeiro parâmetro.
                    No segundo nível, convertemos o char numérico para Integer e ele se torna o segundo parâmetro,
                    onde o "N" será inserido naquela linha
                     */

                playerBoard
                        [Arrays.asList(columnLetter).indexOf(Character.toString(coordinate[0]).toUpperCase())]
                        [Character.getNumericValue(coordinate[1])]
                        = "N";
            }
        }
}
