package src.br.com.letscode.navalbattle;

import static src.br.com.letscode.navalbattle.Board.*;


public class Player {


//        Função para o jogador inserir manualmente suas peças no tabuleiro
    public static void playerInsertShipsOnBoard() {
        for (int submarineNumber = 1; submarineNumber <= 10; submarineNumber++) {
            System.out.printf("Selecione a localização do Submarino %d \n", submarineNumber);
            inputSymbolOnPlayerBoard("N");
        }
    }

//    Função para fazer uma jogada - uma tentativa de acertar o submarino do tabuleiro inimigo
    public static void boardTurnPlay() {


    }

    public static void randomBoardTurnPlay() {

    }

}
