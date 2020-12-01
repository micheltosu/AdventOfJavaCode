package se.tosu.aoc.y2020.dayone;

import se.tosu.aoc.input.Input;

import java.util.List;
import java.util.function.Function;

public class DayOne {

    private final List<Integer> input;
    private final ExpenseReport expenseReport;

    public DayOne(String resourcePath) {
        input = new Input().getListOfIntegersFromInputFile(resourcePath);
        expenseReport = new ExpenseReport();
    }

    public static void main(String[] args) {
        DayOne dayOne = new DayOne("2020/1.txt");
        System.out.printf("The two entries that sum to 2020 multiplied together is: %d%n", dayOne.task1());
        System.out.printf("The three entries that sum to 2020 multiplied together is: %d%n", dayOne.task2());
    }

    public Integer task1() {
        return operateOnListAndMultiplyResult(expenseReport::findTwoIntsThatSumTo2020);
    }

    public Integer task2() {
        return operateOnListAndMultiplyResult(expenseReport::findThreeIntsThatSumTo2020);
    }

    private int operateOnListAndMultiplyResult(Function<List<Integer>, List<Integer>> listOperator) {
        List<Integer> resultAfterOperator = listOperator.apply(input);
        return multiplyInts(resultAfterOperator);
    }

    private int multiplyInts(List<Integer> inputList) {
        return inputList.stream().reduce(Math::multiplyExact).orElseThrow();
    }
}
