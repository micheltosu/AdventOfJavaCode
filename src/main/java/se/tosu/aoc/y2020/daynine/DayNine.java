package se.tosu.aoc.y2020.daynine;

import se.tosu.aoc.input.Input;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;

public class DayNine {
    private final String resourcePath;

    public DayNine(String resourcePath) {
        this.resourcePath = resourcePath;
    }

    public static void main(String[] args) {
        DayNine dayNine = new DayNine("2020/9.txt");
        BigInteger task1 = dayNine.task1(25);
        System.out.printf("The first non-matching number in input: %d\n", task1);

        System.out.printf("Adding min and max addends of the invalid number gives: %s",
                dayNine.task2(task1));
    }

    public BigInteger task1(int bufferSize) {
        List<BigInteger> input = new Input().getListOfBigIntegersFromInputFile(resourcePath);
        List<BigInteger> buffer = new LinkedList<>();

        for (int i = 0; i < bufferSize; ++i) {
            buffer.add(input.remove(0));
        }

        for (BigInteger num : input) {
            if (AddendFinder.collectionHasAddendsForNumber(buffer, num)) {
                buffer.remove(0);
                buffer.add(num);
            } else {
                return num;
            }
        }

        throw new RuntimeException("All numbers in input fulfilled the constraints");
    }

    public BigInteger task2(BigInteger number) {
        List<BigInteger> input = new Input().getListOfBigIntegersFromInputFile(resourcePath);
        List<BigInteger> setOfAddendsForNumber = AddendFinder.findContiguousSetOfAddendsForNumber(input, number);

        BigInteger max = setOfAddendsForNumber.stream()
                .reduce(BigInteger::max)
                .get();

        BigInteger min = setOfAddendsForNumber.stream()
                .reduce(BigInteger::min)
                .get();

        return max.add(min);

    }
}
