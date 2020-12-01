package se.tosu.aoc.y2020.dayone;

import se.tosu.aoc.input.Input;

import java.util.List;

public class DayOne {

    public static void main(String[] args) {
        Integer task1output = new DayOne().task1("2020/1.txt");
        Integer task2output = new DayOne().task2("2020/1.txt");
        System.out.printf("The two entries that sum to 2020 multiplied together is: %d%n", task1output);
        System.out.printf("The three entries that sum to 2020 multiplied together is: %d%n", task2output);
    }

    public Integer task1(String resource) {
        List<Integer> inputList = new Input().getListOfIntegersFromInputFile(resource);
        List<Integer> intsThatSumTo2020 = new ExpenseReport().findTwoIntsThatSumTo2020(inputList);
        return multiplyInts(intsThatSumTo2020);
    }

    public Integer task2(String resource) {
        List<Integer> inputList = new Input().getListOfIntegersFromInputFile(resource);
        List<Integer> intsThatSumTo2020 = new ExpenseReport().findThreeIntsThatSumTo2020(inputList);
        return multiplyInts(intsThatSumTo2020);
    }

    private int multiplyInts(List<Integer> inputList) {
        return inputList.stream().reduce(Math::multiplyExact).orElseThrow();
    }
}
