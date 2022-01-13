package src.br.com.letscode.navalbattle.grid;

import src.br.com.letscode.navalbattle.grid.enums.Column;
import src.br.com.letscode.navalbattle.grid.enums.Row;
import src.br.com.letscode.navalbattle.grid.enums.Status;

public class Position {

    private final Column row;
    private final Row column;

    private Status status;

    public Position(Column r, Row c) {
        this.row = r;
        this.column = c;
        this.status = Status.EMPTY;
    }

    public Row getColumn() {
        return column;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public boolean isEmpty() {
        return this.status == Status.EMPTY;
    }

    public boolean hasShip() {
        return this.status == Status.FILLED || this.status == Status.SHOOTED_WATER_WITH_SHIP
                || this.status == Status.DESTROYED_WITH_SHIP;
    }

    public void updateAfterShoot(boolean hit) {
        this.status = this.status.getStatusAfterShoot(hit);
    }


}
