package src.br.com.letscode.navalbattle;

import java.util.Arrays;
import java.util.Scanner;

import static src.br.com.letscode.navalbattle.Randomizer.*;
import static src.br.com.letscode.navalbattle.Player.*;
import static src.br.com.letscode.navalbattle.Main.*;


public class Board {

    public static Scanner input = new Scanner(System.in);
    public static char[] coordinate = new char[2];
    public static int submarineNumber = 1;



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


        private static int  coordinateRow, coordinateTile;

        public static void playerInsertShipsOnBoard() {

            while (submarineNumber <= 10) {

                System.out.printf("Selecione a localização do Submarino %d %n", submarineNumber);

//                armazenamos a coordenada inserida
//                (que deve vir em formato LetraNúmero, exemplos: B2, C4)
//                em um array de chars;
                coordinate = input.next().toCharArray();

                 /*
                    O que estamos fazendo é o seguinte:
                    Temos o array de char que recebeu a entrada: [char B, char 2] por exemplo.
                    Vamos armazenar o primeiro char em coordinateRow e o segundo em coordinateTile,
                    Linha e Casinha respectivamente.
                    Convertemos o primeiro char da entrada para String: [String "B", char 2]
                    buscamos seu índice usando o array auxiliar de letras lá encima: [int 1, char 2]
                    Esse índice será passado no primeiro parâmetro: playerboard[1][].
                    No segundo nível, convertemos o char numérico para Integer: [int 1, int 2]
                    e ele se torna o segundo parâmetro: playerboard[1][2].

                    Fazemos um teste antes para ver se já há um "N" naquele espaço.
                    Se houver, usamos o princípio da RECURSÃO e chamamos a função dentro dela mesmo de novo.
                    Se não houver, preencemos o Tile com o "N" e incrementamos o contador para o próximo Submarino.
                     */
                coordinateRow = Arrays.asList(columnLetter).indexOf(Character.toString(coordinate[0]).toUpperCase());
                coordinateTile = Character.getNumericValue(coordinate[1]);

                if (playerBoard[coordinateRow][coordinateTile] == "N") {
                    System.err.println("Já existe um Submarino nesta casa. Tente novamente em outro lugar.");
                    playerInsertShipsOnBoard();
                } else {
                    playerBoard[coordinateRow][coordinateTile] = "N";
                    submarineNumber++;
                }
            }

        }


        public static void playerShot() {

        }


//        public static void placeEnemyShips(){
//            enemyBoard[randomCoordinatesGenerator()][randomCoordinatesGenerator()] = "N";
//        }

//---------------------------------------------------------------------------------------------------------------------
//        Função onde a IA espalha seus 10 submarinos aleatoriamente no tabuleiro dela
        public static void enemyPlacingShipsOnBoard() {

//              reutilizamos o contador da função do jogador, resetamos para 1 para começar o loop
            submarineNumber = 1;
            enemyCheckBoardAndPlaceShip();

        }

//        método interno de enemyPlacingShipsOnBoard();
//        Alternativa: Zerar o contador no Main e mesclar esses dois métodos aqui.
    private static void enemyCheckBoardAndPlaceShip() {
        while (submarineNumber <= 10) {

//                gerados 2 numeros aleatórios que serão testados se já foram usados (verificando se já tem um "N" lá)
            coordinateRow = randomCoordinatesGenerator();
            coordinateTile = randomCoordinatesGenerator();

            if (Objects.equals(enemyBoard[coordinateRow][coordinateTile], "N")) {
                enemyCheckBoardAndPlaceShip();
            } else {
                enemyBoard[coordinateRow][coordinateTile] = "N";
                submarineNumber++;
            }
        }
    }

//--------------------------------------------------------------------------------------------------------------------
        public static void enemyMoves(){
            if(playerBoard[randomCoordinatesGenerator()][randomCoordinatesGenerator()] == "N") {
                playerBoard[randomCoordinatesGenerator()][randomCoordinatesGenerator()] = "*";

            } else {
                enemyBoard[randomCoordinatesGenerator()][randomCoordinatesGenerator()] = "-";
            }
        }

//--------------------------------------------------------------------------------------------------------------------
    public static void drawEnemyBoard() {
        System.out.println(
                "---------------------------------------------\n"
                        +"                  JOGADOR                 \n"+
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
