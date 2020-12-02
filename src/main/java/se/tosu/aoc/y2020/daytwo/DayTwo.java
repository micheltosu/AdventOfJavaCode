package se.tosu.aoc.y2020.daytwo;

import se.tosu.aoc.input.Input;

import java.util.List;

public class DayTwo {

    public static void main(String[] args) {
        int task1AllowedCount = new DayTwo().runSolution("2020/2.txt");
        System.out.printf("Number of allowed passwords are: %d\n", task1AllowedCount);
    }

    public int runSolution(String resource) {
        List<String> inputStrings = new Input().getFileRowsAsListOfStrings(resource);
        int numberOfValidPasswords = 0;

        for (String input : inputStrings) {
            String[] split = input.split(":");

            if (PolicyRule.parse(split[0]).allows(split[1]))
                numberOfValidPasswords += 1;
        }

        return numberOfValidPasswords;
    }
}
