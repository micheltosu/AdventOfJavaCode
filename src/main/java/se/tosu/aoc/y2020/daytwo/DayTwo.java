package se.tosu.aoc.y2020.daytwo;

import se.tosu.aoc.input.Input;

import java.util.List;

public class DayTwo {


    public static void main(String[] args) {
        int numberOfValidPasswords = new DayTwo().getTaskOneSolution("2020/2.txt");
        int numberOfOfficialValidPasswords = new DayTwo().getTaskTwoSolution("2020/2.txt");
        System.out.printf("Number of allowed passwords are: %d\n", numberOfValidPasswords);
        System.out.printf("Number of allowed passwords are: %d\n", numberOfOfficialValidPasswords);
    }


    public int getTaskOneSolution(String resource) {
        List<String> inputStrings = new Input().getFileRowsAsListOfStrings(resource);
        return getNumberOfValidPasswords(inputStrings);
    }

    private int getTaskTwoSolution(String resource) {
        List<String> inputStrings = new Input().getFileRowsAsListOfStrings(resource);
        return getNumberOfOfficialValidPasswords(inputStrings);
    }

    private int getNumberOfValidPasswords(List<String> inputStrings) {
        int numberOfValidPasswords = 0;
        for (String input : inputStrings) {
            String[] split = input.split(":");

            if (OldJobPolicyRule.parse(split[0]).allows(split[1]))
                numberOfValidPasswords += 1;
        }
        return numberOfValidPasswords;
    }

    private int getNumberOfOfficialValidPasswords(List<String> inputStrings) {
        int numberOfValidPasswords = 0;
        for (String input : inputStrings) {
            String[] split = input.split(":");

            if (OfficialJobPolicyRule.parse(split[0]).allows(split[1].trim()))
                numberOfValidPasswords += 1;

        }
        return numberOfValidPasswords;
    }

}
