package se.tosu.aoc.y2020.daynine;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collection;
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

}