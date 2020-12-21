package se.tosu.aoc.y2020.daynine;

import org.junit.jupiter.api.Test;
import se.tosu.aoc.input.Input;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class AddendFinderTest {
    @Test
    void testCollectionHasAddendsForNumber() {
        Collection<Integer> given = IntStream.range(0, 26).boxed().collect(Collectors.toList());

        assertTrue(AddendFinder.collectionHasAddendsForNumber(given, 26));
    }

    @Test
    void testCollectionHasAddendsForNumberReturnsFalse() {
        Collection<Integer> given = IntStream.range(0, 26).boxed().collect(Collectors.toList());

        assertFalse(AddendFinder.collectionHasAddendsForNumber(given, 100));
    }

    @Test
    void testSmallerCollectionHasAddendsForNumber() {
        List<Integer> given = Arrays.asList(35, 20, 15, 25, 47);

        assertTrue(AddendFinder.collectionHasAddendsForNumber(given, 40));
    }

    @Test
    void testSmallerCollectionHasAddendsForNumberReturnsFalse() {
        List<Integer> given = Arrays.asList(95, 102, 117, 150, 182);

        assertFalse(AddendFinder.collectionHasAddendsForNumber(given, 127));
    }

    @Test
    void testFindContigousSetOfAddendsForNumber() {
        List<Integer> given = new Input().getListOfIntegersFromInputFile("2020/D9-test1.txt");

        assertEquals(Arrays.asList(15, 25, 47, 40), AddendFinder.findContiguousSetOfAddendsForNumber(given, 127));
    }

    @Test
    void testFindContigousSetOfAddendsForNumberWhenSetDoesntExist() {
        List<Integer> given = new Input().getListOfIntegersFromInputFile("2020/D9-test1.txt");

        assertEquals(Collections.emptyList(), AddendFinder.findContiguousSetOfAddendsForNumber(given, 50000));
    }
}