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
//pega o status após o lançamento inicial e os próximos.
    public Status getStatusAfterShoot(boolean hit) {
        Status nextStatus;
        switch (this) {
            // caso vazio ele verifica se o próximo status é: acertou? então  destruido *, senão: caiu na agua -
            case EMPTY:
                nextStatus = hit ? DESTROYED : Status.SHOOTED_WATER;
                break;
            // caso Navio posicionado N ele verifica se o próximo status é: acertou? então  Tiro certeiro com navio posicionado X, senão:Tiro na água com navio posicionado n
            case FILLED:
                nextStatus = hit ? DESTROYED_WITH_SHIP : Status.SHOOTED_WATER_WITH_SHIP;
                break;
                //caso Tiro certeiro * o proximo status é : Tiro certeiro
            case DESTROYED:
                nextStatus = DESTROYED;
                break;
                //caso Tiro na água com navio posicionado n o proximo status é: tiro  na agua com navio posicionado
            case SHOOTED_WATER_WITH_SHIP:
                nextStatus = SHOOTED_WATER_WITH_SHIP;
                break;
                // Tiro certeiro com navio posicionado X
            default:
                nextStatus = DESTROYED_WITH_SHIP;
        }
        return nextStatus;
    }
}
