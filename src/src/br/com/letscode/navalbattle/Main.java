package src.br.com.letscode.navalbattle;

import static src.br.com.letscode.navalbattle.Board.*;
import static src.br.com.letscode.navalbattle.HumanPlayer.*;
import static src.br.com.letscode.navalbattle.EnemyPlayer.*;
import static src.br.com.letscode.navalbattle.Randomizer.*;
import static src.br.com.letscode.navalbattle.Player.*;

public class Main {

    public static void main(String[] args) {

        /*
        A fim de praticar os conceitos aprendidos, usamos deliberadamente na arquitetura do jogo:
        - HERANÇA: Criada uma superclasse Player, e duas classes EnemyPlayer e HumanPlayer que herdam atributos daquela.
        - RECURSÃO: Como auxiliar no tratamento de erros, algumas funções chamam a si mesmas para manter seu laço de repetição.
          */

        EnemyPlayer enemyPlayer = new EnemyPlayer(0);
        HumanPlayer humanPlayer = new HumanPlayer(0);
        boolean humanPlayerturn = true;

        System.out.println("Começou o jogo");

//        TODO: Create option for player to randomize ships on board

        humanPlayer.playerInsertShipsOnBoard();

        System.out.println("A IA agora vai espalhar as peça dela igual uma louca");

        enemyPlayer.enemyPlacingShipsOnBoard();


        while ((humanPlayer.points < 10) && (enemyPlayer.points < 10)) {

           if (humanPlayerturn) {
                System.out.println("Sua vez, jogador de carne");
                humanPlayer.playerMoves();
                humanPlayerturn = false;
                drawBoard();
           } else {
                System.out.println("Vez da IA");
                enemyPlayer.enemyMoves();
                humanPlayerturn = true;
           }
        }

        System.out.printf("%s", humanPlayer.points==10? "Ganhou!" : "Perdeu!");
        drawBoard();
        drawEnemyBoard();


    }




}
