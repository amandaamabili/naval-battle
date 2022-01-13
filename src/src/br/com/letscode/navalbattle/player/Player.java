package src.br.com.letscode.navalbattle.player;

import src.br.com.letscode.navalbattle.grid.Grid;
import src.br.com.letscode.navalbattle.grid.enums.Status;

import static src.br.com.letscode.navalbattle.utils.Randomizer.randomCoordinatesGenerator;

public abstract class Player {
    protected String name;
    protected boolean isHuman;
    public Grid grid;

    public Player(String name, boolean isHuman) {
        this.name = name;
        this.isHuman = isHuman;
        this.grid = new Grid();
    }


    public abstract void shoot(Grid enemyGrid);

    public boolean shoot(int r, int c, Grid enemyGrid) {
        return enemyGrid.attack(r, c);
    }

    public void distributeShipsRandomly() {
        while (this.grid.shipsAdded <= 10) {

            var randomRow = randomCoordinatesGenerator();
            var randomColumn = randomCoordinatesGenerator();

            var position = this.grid.positionList[randomRow][randomColumn];
            if (position.isEmpty()) {
                position.setStatus(Status.FILLED);
                this.grid.shipsAdded++;
            }
        }
    }
    public void printPositions(){
        this.grid.printPositions(this.name);
    }

}
