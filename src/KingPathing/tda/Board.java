package KingPathing.tda;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private int n;
    private int kingX;
    private int kingY;
    private int[][] weightedBoard;

    public Board (int n) {
        this.n = n;
        this.kingX = randomNumberInteger(n + 1);
        this.kingY = randomNumberInteger(n + 1);
        this.weightedBoard = randomWeights();
        System.out.println(kingX + ";" + kingY);
    }

    public List<String> getMinPath () {
        List<String> path = new ArrayList<>();
        int[][][] possibleDirections = possibleDirections(kingX, kingY);
        return path;
    }

    private int[][][] possibleDirections (int x, int y) {
        int[][][] directions = new int[3][3][2];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int posX = x - 1 - i;
                int posY = y - 1 - j;
                if (posX > n || posY > n || posX < 0 || posY < 0) {
                    continue;
                }
                directions[i][j][0] = posX;
                directions[i][j][1] = posY;
            }
        }
        //arrayPrinter(directions);
        return directions;
    }

    private int[][] randomWeights () {
        int[][] returnWeights = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                returnWeights[i][j] = randomNumberInteger(10); // Generates a number between 0 and 9
            }
        }
        arrayPrinter(returnWeights);
        return returnWeights;
    }

    private int randomNumberInteger (int n) {
        return Integer.parseInt(Long.toString(System.currentTimeMillis() % (n)));
    }

    private void arrayPrinter (int[][] a) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; i < n; i++) {
                System.out.println(a[i][j]);
            }
        }
    }

    private void arrayPrinter (int[][][] a) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; i < n; i++) {
                for (int k = 0; i < 2; i++) {
                    System.out.println(a[i][j][k]);
                }
            }
        }
    }
}