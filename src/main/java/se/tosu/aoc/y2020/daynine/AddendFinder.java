package se.tosu.aoc.y2020.daynine;

import java.math.BigInteger;
import java.util.Collection;
import java.util.List;
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
}
