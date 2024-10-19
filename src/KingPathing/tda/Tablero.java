package KingPathing.tda;

import java.util.ArrayList;
import java.util.List;

public class Tablero {

    private int n;
    private int kingX;
    private int kingY;
    private int[][] weightedBoard;

    public Tablero (int n) {
        this.n = n;
        this.kingX = randomNumberInteger(n + 1);
        this.kingY = randomNumberInteger(n + 1);
        this.weightedBoard = randomWeights();
    }

    public List<String> getMinPath () {
        List<String> path = new ArrayList<>();

        return path;
    }

    private List<String> possibleDirections (int x, int y) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {

            }
        }
        return null;
    }

    private int[][] randomWeights () {
        int[][] returnWeights = new int[n][n];
        for (int[] returnWeight : returnWeights) {
            for (int i : returnWeight) {
                returnWeight[i] = randomNumberInteger(10); //pesos del 1 al 9
            }
        }
        return returnWeights;
    }

    private int randomNumberInteger (int n) {
        return Integer.parseInt(Long.toString(System.currentTimeMillis() % (n)));
    }
}