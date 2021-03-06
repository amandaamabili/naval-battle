package src.br.com.letscode.navalbattle.player;

import src.br.com.letscode.navalbattle.grid.Grid;

import static src.br.com.letscode.navalbattle.utils.Randomizer.randomCoordinatesGenerator;

public class IA extends Player {

    public IA() {
        super("IA", false);
        this.distributeShipsRandomly();
    }

    public void shoot(Grid enemyGrid) {
        var randomRow = randomCoordinatesGenerator();
        var randomColumn = randomCoordinatesGenerator();
        var hit = shoot(randomRow, randomColumn, enemyGrid);
        grid.updateGrid(randomRow, randomColumn, hit);
    }

}
