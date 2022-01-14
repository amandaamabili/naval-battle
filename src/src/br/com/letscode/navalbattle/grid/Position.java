package src.br.com.letscode.navalbattle.grid;

import src.br.com.letscode.navalbattle.grid.enums.Column;
import src.br.com.letscode.navalbattle.grid.enums.Row;
import src.br.com.letscode.navalbattle.grid.enums.Status;

public class Position {

    private final Column column;
    private final Row row;

    private Status status;
//  'this.row' é a variável 'row' da classe "Position" e ' r' é a variável que a classe recebeu da classe Row- Enum para criar um objeto!
    //  'this.column' é a variável 'column' da classe "Position" e ' c' é a variável que a classe recebeu da classe Column- Enum para criar um objeto!
    //  'this.status' é a variável 'status' da classe "Position" e ' Status.EMPTY' é a variável que a classe recebeu da classe Status- Enum para criar um objeto!
    //Usamos o 'this' dentro da classe. Assim, sempre que colocarmos 'this.' antes de uma variável, fica implícito ao Java que estamos nos referindo aos atributos daquela Classe.
    public Position(Column c, Row r) {
        this.row = r;
        this.column = c;
        this.status = Status.EMPTY;
    }
//metodo que pega a Linha e retorna a linha
    public Row getRow() {
        return row;
    }
//metodo que pega o status e retorna o Status
    public Status getStatus() {
        return status;
    }
//método que altera o status para o Status  atual
    public void setStatus(Status status) {
        this.status = status;
    }

    //método para retornar caso o status esteja vazio retornando o Empty "" do enum status
    public boolean isEmpty() {
        return this.status == Status.EMPTY;
    }

    //se tem  navio ele retorna  o status do enum Navio posicionado N ou o status caso Tiro na água com navio posicionado n
    // ou retorna Tiro certeiro com navio posicionado X
    public boolean hasShip() {
        return this.status == Status.FILLED || this.status == Status.SHOOTED_WATER_WITH_SHIP
                || this.status == Status.DESTROYED_WITH_SHIP;
    }
    //ele retorna o status atual após a jogada
    public void updateAfterShoot(boolean hit) {
        this.status = this.status.getStatusAfterShoot(hit);
    }


}
