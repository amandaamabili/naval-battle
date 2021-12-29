package src.br.com.letscode.navalbattle;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

import static src.br.com.letscode.navalbattle.Randomizer.*;
import static src.br.com.letscode.navalbattle.Player.*;
import static src.br.com.letscode.navalbattle.Main.*;


public class Board {

//    protected static Scanner input = new Scanner(System.in);
//    protected static char[] coordinate = new char[2];
//    protected static int  coordinateRow, coordinateTile;
//    protected static int submarineNumber = 1;



//    Array de slots para armazenar os navios e marcar as jogadas
    protected static String[][] playerBoard = {
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

    protected static String[][] enemyBoard = {
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
    protected static String[] columnLetter = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};

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

//--------------------------------------------------------------------------------------------------------------------
    public static void drawEnemyBoard() {
        System.out.println(
                "---------------------------------------------\n"
                +"                     IA                     \n"+
                "---------------------------------------------\n"+
                "|   | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |\n"+
                "---------------------------------------------"
        );
        for (int row = 0; row < enemyBoard.length; row++) {
            System.out.printf("| %s ", columnLetter[row]);
            for (int tile = 0; tile < enemyBoard[row].length; tile++) {
                System.out.printf("| %s ", enemyBoard[row][tile]);
            }
            System.out.printf("|\n---------------------------------------------\n");
        }
    }
}
