package se.tosu.aoc.y2020.daynine;

import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;


public class AddendFinder {

    public static boolean collectionHasAddendsForNumber(Collection<Integer> given, int i) {
        List<BigInteger> bigIntegers = given.stream()
                .map(BigInteger::valueOf)
                .collect(Collectors.toList());

        return collectionHasAddendsForNumber(bigIntegers, BigInteger.valueOf(i));
    }

    public static boolean collectionHasAddendsForNumber(Collection<BigInteger> given, BigInteger i) {
        for (BigInteger x : given) {
            for (BigInteger y : given) {
                if (!y.equals(x) && x.add(y).equals(i))
                    return true;
            }
        }
        return false;
    }


    public static List<Integer> findContiguousSetOfAddendsForNumber(List<Integer> given, int i) {
        List<BigInteger> bigIntegers = given.stream()
                .map(BigInteger::valueOf)
                .collect(Collectors.toList());

        List<BigInteger> setOfBigAddends = findContiguousSetOfAddendsForNumber(bigIntegers, BigInteger.valueOf(i));
        return Objects.requireNonNull(setOfBigAddends).stream()
                .map(BigInteger::intValue)
                .collect(Collectors.toList());
    }

    public static List<BigInteger> findContiguousSetOfAddendsForNumber(List<BigInteger> bigIntegers, BigInteger number) {

        for (int loopCount = 0; loopCount < bigIntegers.size(); ++loopCount) {
            List<BigInteger> possibleAddends = new LinkedList<>();
            for (int i = loopCount; i < bigIntegers.size(); ++i) {
                possibleAddends.add(bigIntegers.get(i));

                BigInteger sumOfPossibleAddends = possibleAddends.stream()
                        .reduce(BigInteger::add)
                        .orElseThrow(() -> new RuntimeException("En error occurred when trying to sum possibleIntegers"));

                if (sumOfPossibleAddends.equals(number)) {
                    return possibleAddends;
                } else if (sumOfPossibleAddends.compareTo(number) > 0) {
                    break;
                }
            }


        }

        return Collections.emptyList();
    }
}
