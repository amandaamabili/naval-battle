package src.br.com.letscode.navalbattle.grid;

import src.br.com.letscode.navalbattle.grid.enums.Column;
import src.br.com.letscode.navalbattle.grid.enums.Row;
import src.br.com.letscode.navalbattle.grid.enums.Status;

public class Position {

    private final Column column;
    private final Row row;

    private Status status;
//
    public Position(Column c, Row r) {
        this.row = r;
        this.column = c;
        this.status = Status.EMPTY;
    }

    public Row getRow() {
        return row;
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
