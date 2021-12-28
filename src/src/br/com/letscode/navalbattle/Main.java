package src.br.com.letscode.navalbattle;

import static src.br.com.letscode.navalbattle.Board.*;
import static src.br.com.letscode.navalbattle.Randomizer.*;
import static src.br.com.letscode.navalbattle.Player.*;

public class Main {

    public static void main(String[] args) {
        playerInsertShipsOnBoard();
        drawBoard();
        enemyPlacingShipsOnBoard();
        drawEnemyBoard();
    }

}
