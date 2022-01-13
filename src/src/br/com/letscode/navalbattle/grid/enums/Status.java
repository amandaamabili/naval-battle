package src.br.com.letscode.navalbattle.grid.enums;

public enum Status {
    FILLED("N"),
    DESTROYED("*"),
    SHOOTED_WATER("-"),
    DESTROYED_WITH_SHIP("X"),
    SHOOTED_WATER_WITH_SHIP("n"),
    EMPTY(" ");


    public final String mark;

    Status(String mark) {
        this.mark = mark;
    }

    public Status getStatusAfterShoot(boolean hit) {
        Status nextStatus;
        switch (this) {
            case EMPTY:
                nextStatus = hit ? DESTROYED : Status.SHOOTED_WATER;
                break;
            case FILLED:
                nextStatus = hit ? DESTROYED_WITH_SHIP : Status.SHOOTED_WATER_WITH_SHIP;
                break;
            case DESTROYED:
                nextStatus = DESTROYED;
                break;
            case SHOOTED_WATER_WITH_SHIP:
                nextStatus = SHOOTED_WATER_WITH_SHIP;
                break;
            default:
                nextStatus = DESTROYED_WITH_SHIP;
        }
        return nextStatus;
    }
}
