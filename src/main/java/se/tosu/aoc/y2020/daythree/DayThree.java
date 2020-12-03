package se.tosu.aoc.y2020.daythree;

import se.tosu.aoc.input.Input;

import java.util.List;

public class DayThree {
    public static void main(String[] args) {
        new DayThree().runSolution();
    }

    private void runSolution() {
        List<String> mapOfTerrain = new Input().getFileRowsAsListOfStrings("2020/3.txt");

        //mapOfTerrain.stream().forEach(System.out::println);

        int mapWidth = mapOfTerrain.get(0).length();
        int mapHeight = mapOfTerrain.size();
        int treeCount = 0;
        for (int y = 0, x = 0; y < mapHeight; ++y, x = (x += 3) % mapWidth) {
            System.out.printf("Going to position: x: %d, y: %d\n", x, y);
            if (mapOfTerrain.get(y).charAt(x) == '#')
                ++treeCount;
        }

        System.out.printf("Count of threes in path are: %d", treeCount);
    }
}
