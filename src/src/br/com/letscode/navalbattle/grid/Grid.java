package src.br.com.letscode.navalbattle.grid;

import src.br.com.letscode.navalbattle.grid.enums.Column;
import src.br.com.letscode.navalbattle.grid.enums.Row;

public class Grid {

    public Position[][] positionList = new Position[10][10];
    public int shipsAdded = 0;
    public int shipsDestroyed = 0;

    final int DIMENSION = 10;

    public Grid() {
        this.initializeEmptyGrid();
    }

    public void printPositions(String player) {

        printHeader(player);
        for (int row = 0; row < DIMENSION; row++) {
            System.out.printf("| %s ", positionList[row][0].getColumn().letter);
            for (int column = 0; column < DIMENSION; column++) {
                System.out.printf("| %s ", positionList[row][column].getStatus().mark);
            }
            System.out.print("|\n---------------------------------------------\n");
        }
    }

    private void printHeader(String name) {
        System.out.println(
                "---------------------------------------------\n"
                        + "                  " + name + "                 \n" +
                        "---------------------------------------------\n" +
                        "|   | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9|\n" +
                        "---------------------------------------------"
        );
    }

    private void initializeEmptyGrid() {
        for (Column column : Column.values()) {
            for (Row row : Row.values()) {
                positionList[row.ordinal()][column.ordinal()] = new Position(column, row);
            }
        }
    }

    public void updateGrid(int r, int c, boolean hit) {
        var position = this.positionList[r][c];
        position.updateAfterShoot(hit);
    }

    public boolean attack(int r, int c) {
        var position = this.positionList[r][c];
        if (position.hasShip()) {
            shipsDestroyed++;
            return true;
        }
        return false;
    }

}