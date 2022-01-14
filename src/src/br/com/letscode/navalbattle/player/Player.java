package src.br.com.letscode.navalbattle.player;

import src.br.com.letscode.navalbattle.grid.Grid;
import src.br.com.letscode.navalbattle.grid.enums.Status;

import static src.br.com.letscode.navalbattle.utils.Randomizer.randomCoordinatesGenerator;

//classe abstrata pois  está forçando as classes HUman e Ia a usarem o método shoot
public abstract class Player {
    protected String name;
    protected boolean isHuman;
    public Grid grid;

    public Player(String name, boolean isHuman) {
        this.name = name;
        this.isHuman = isHuman;
        this.grid = new Grid();
    }

//método abstrato shoot  que retorna  na grade inimiga o ataque printado na posição (r,c)
    public abstract void shoot(Grid enemyGrid);

    public boolean shoot(int r, int c, Grid enemyGrid) {
        return enemyGrid.attack(r, c);
    }

    //método que distribui os navios randomicamente dentro da grade
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
