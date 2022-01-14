package src.br.com.letscode.navalbattle.grid;

import src.br.com.letscode.navalbattle.grid.enums.Column;
import src.br.com.letscode.navalbattle.grid.enums.Row;

public class Grid {

    //aqui a posição, é um array de 10 índices. Ou seja, seu tamanho será uma matriz 10 x 10
    public Position[][] positionList = new Position[10][10];
    public int shipsAdded = 0;
    public int shipsDestroyed = 0;

    //Você pode atribuir um valor a uma variável final apenas uma vez, ou seja, seus valores não podem ser alterados e  a dimensão sempre será 10 x 10.
    final int DIMENSION = 10;


    // 'this.initializeEmptyGrid()' é o método 'initializeEmptyGrid()' da classe "Grid"
    //Usamos o 'this' dentro da classe. Assim, sempre que colocarmos 'this.' antes de uma variável ou método, fica implícito ao Java que estamos nos referindo aos atributos e métodos daquela Classe.
    public Grid() {
        this.initializeEmptyGrid();
    }

    //método da classe para imprimir posições do jogador
    public void printPositions(String player) {

        //chama a função imprimir do  cabeçalho do jogo e imprime a linha row que vai continuar incrementando até que continue a  ser menor que a dimensão 10 e em cada linha ele adciona o letter.
        //Depois no column ele faz a mesma coisa mas já imprimindo a linha, coluna e marcando o status do jogo com o Mark que é o status ""
        printHeader(player);
        for (int row = 0; row < DIMENSION; row++) {
            System.out.printf("| %s ", positionList[row][0].getRow().letter);
            for (int column = 0; column < DIMENSION; column++) {
                System.out.printf("| %s ", positionList[row][column].getStatus().mark);
            }
            System.out.print("|\n---------------------------------------------\n");
        }
    }
// função para imprimir o cabeçalho do jogo e o nome do jogador
    private void printHeader(String name) {
        System.out.println(
                "---------------------------------------------\n"
                        + "                  " + name + "                 \n" +
                        "---------------------------------------------\n" +
                        "|   | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9|\n" +
                        "---------------------------------------------"
        );
    }

    //inicializa uma entrada vazia de início do jogo onde ele está pegando os valores da linha e coluna e imprimindo a lista de posições
    // de ambos ordinalmente  e  atribuindo essa nova posição com coluna e linha
    private void initializeEmptyGrid() {
        for (Column column : Column.values()) {
            for (Row row : Row.values()) {
                positionList[row.ordinal()][column.ordinal()] = new Position(column, row);
            }
        }
    }
 // atualiza a grade retornando os novos valores de cada posição baseado nos acertos e status da função getStatusAfterShoot() do enum Status
    public void updateGrid(int r, int c, boolean hit) {
        var position = this.positionList[r][c];
        position.updateAfterShoot(hit);
    }
//ele vai atacar, se na posição estiver um navio posicionado ele vai aumentar o contador e retornar verdadeiro, caso contrario retorna falso
    public boolean attack(int r, int c) {
        var position = this.positionList[r][c];
        if (position.hasShip()) {
            shipsDestroyed++;
            return true;
        }
        return false;
    }

}