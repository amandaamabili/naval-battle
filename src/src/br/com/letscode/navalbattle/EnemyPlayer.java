package src.br.com.letscode.navalbattle;

import java.util.Objects;

import static src.br.com.letscode.navalbattle.Board.*;
import static src.br.com.letscode.navalbattle.Randomizer.*;

public class EnemyPlayer extends Player {

    public EnemyPlayer(int pontosIniciais) {
        super.points = pontosIniciais;
    }


//----------------------------------------------------------------------------------------------------------------

//      Função para a IA realizar uma jogada.
//    public static void enemyMoves(){
//        if(playerBoard[randomCoordinatesGenerator()][randomCoordinatesGenerator()] == "N") {
//            playerBoard[randomCoordinatesGenerator()][randomCoordinatesGenerator()] = "*";
//
//        } else {
//            enemyBoard[randomCoordinatesGenerator()][randomCoordinatesGenerator()] = "-";
//        }
//    }

    public void enemyMoves(){
        coordinateRow = randomCoordinatesGenerator();
        coordinateTile = randomCoordinatesGenerator();
        if(playerBoard[coordinateRow][coordinateTile] == "N") {
            playerBoard[coordinateRow][coordinateTile] = "*";
            enemyBoard[coordinateTile][coordinateRow] = "*";
            this.points++;
        } else {
            if (enemyBoard[coordinateRow][coordinateTile] == "N") {
                enemyBoard[coordinateRow][coordinateTile] = "X";
            } else{
            enemyBoard[coordinateRow][coordinateTile] = "-";
            }
        }
    }

    //----------------------------------------------------------------------------------------------------------------

//        Função onde a IA espalha seus 10 submarinos aleatoriamente no tabuleiro dela
    public void enemyPlacingShipsOnBoard() {

//              reutilizamos o contador da função do jogador, resetamos para 1 para começar o loop
        //TODO: Substituir esse submarineNumber pela variavel interna submarineCounter,
        // assim não precisamos da função enemyCheckBoardAndPlaceShip,
        // o código fica tudo dentro deessa função aqui mesmo;
        submarineNumber = 1;
        enemyCheckBoardAndPlaceShip();

    }

    //        método interno de enemyPlacingShipsOnBoard();
//        Alternativa: Zerar o contador no Main e mesclar esses dois métodos aqui.
    private void enemyCheckBoardAndPlaceShip() {
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

}
