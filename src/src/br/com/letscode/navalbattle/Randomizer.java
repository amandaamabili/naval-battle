package src.br.com.letscode.navalbattle;

import java.util.Random;

public class Randomizer {

    private static Random random = new Random();

    public static int randomCoordinatesGenerator() {
        return random.nextInt(10);
    }



}
