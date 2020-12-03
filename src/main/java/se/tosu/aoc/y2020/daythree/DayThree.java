package se.tosu.aoc.y2020.daythree;

import se.tosu.aoc.input.Input;

import java.math.BigInteger;
import java.util.List;

public class DayThree {
    public static void main(String[] args) {
        new DayThree().runSolution();
    }

    private void runSolution() {
        List<String> mapOfTerrain = new Input().getFileRowsAsListOfStrings("2020/3.txt");

        BigInteger treeCount = BigInteger.valueOf(getTreeCount(mapOfTerrain, 1, 1))
                .multiply(BigInteger.valueOf(getTreeCount(mapOfTerrain, 3, 1)))
                .multiply(BigInteger.valueOf(getTreeCount(mapOfTerrain, 5, 1)))
                .multiply(BigInteger.valueOf(getTreeCount(mapOfTerrain, 7, 1)))
                .multiply(BigInteger.valueOf(getTreeCount(mapOfTerrain, 1, 2)));

        System.out.printf("Total count of threes in path are: %d\n", treeCount);
    }

    private int getTreeCount(List<String> mapOfTerrain, int xMovement, int yMovement) {
        int treeCount = 0;
        int mapWidth = mapOfTerrain.get(0).length();
        int mapHeight = mapOfTerrain.size();
        for (int y = 0, x = 0; y < mapHeight; y += yMovement, x = (x + xMovement) % mapWidth) {
            if (mapOfTerrain.get(y).charAt(x) == '#')
                ++treeCount;
        }
        System.out.printf("Count of threes in path are: %d\n", treeCount);
        return treeCount;
    }
}
