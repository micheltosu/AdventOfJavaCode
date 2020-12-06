package se.tosu.aoc.y2020.daysix;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DaySixTest {

    private static final String TEST_PATH = "2020/D6-test1.txt";

    @Test
    void testReduceListOfStringsToSetOfChars() {
        List<String> stringList = List.of("abcx", "abcy", "abcz");

        Set<Character> actual = new DaySix("2020/D6-test1.txt").reduceArrayOfStringsToSetOfChars(stringList);

        assertEquals(Stream.of('a','b','c','x','y','z').collect(Collectors.toCollection(HashSet::new)), actual);
    }

    @Test
    void testGetCharsFromEverySet() {
        List<String> stringList = List.of("abcx", "abcy", "abcz");

        Set<Character> actual = new DaySix("2020/D6-test1.txt").findCommonCharsInAllStrings(stringList);

        assertEquals(Stream.of('a','b','c').collect(Collectors.toCollection(HashSet::new)), actual);
    }

    @Test
    void testTask1() {
        assertEquals(11, new DaySix(TEST_PATH).task1());
    }

    @Test
    void testTask2() {
        assertEquals(6, new DaySix(TEST_PATH).task2());
    }

    @Test
    void testTaskTwoReturnsCorrectValue() {
        assertEquals(3202, new DaySix("2020/6.txt").task2());
    }
}