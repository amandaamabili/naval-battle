package src.br.com.letscode.navalbattle;

import java.util.Random;

public class Randomizer {

    private static Random random = new Random();


//    Para usar um número aleatório de 0 a 9 (índices possíveis das colunas e casas do tabuleiro),
//    basta chamar a função abaixo onde se quer o número;
//    Ex.: playerBoard[randomCoordinatesGenerator()][randomCoordinatesGenerator()];
    public static int randomCoordinatesGenerator() {
        return random.nextInt(10);
    }



}
