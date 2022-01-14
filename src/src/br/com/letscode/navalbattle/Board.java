package src.br.com.letscode.navalbattle;

import src.br.com.letscode.navalbattle.player.Human;
import src.br.com.letscode.navalbattle.player.IA;
import src.br.com.letscode.navalbattle.player.Player;

import java.util.Scanner;
//classe Board é o tabuleiro completo
public class Board {

    Scanner scanner = new Scanner(System.in);
    public Human p1;
    public IA p2 = new IA();

    Board() {
        p1 = new Human(getPlayerName(), scanner);
    }

    public String getPlayerName() {
        System.out.println("Qual o nome do jogador");
        return scanner.next();
    }

    public void initializeMatch() {
        p1.distributeShipsRandomly();
    }

    public boolean hasWinner() {
        return p1.grid.shipsDestroyed == 10 || p2.grid.shipsDestroyed == 10;
    }

    public void score() {
        System.out.printf("SHIPS DESTROYED ON EACH SIDE | PLAYER1: %d, IA:%d\n", p1.grid.shipsDestroyed, p2.grid.shipsDestroyed);
    }

    public void printPositions(Player player) {
        player.printPositions();
    }

    public void humanTurn() {
        p1.shoot(p2.grid);
    }

    public void iaTurn() {
        p2.shoot(p1.grid);
    }

}
