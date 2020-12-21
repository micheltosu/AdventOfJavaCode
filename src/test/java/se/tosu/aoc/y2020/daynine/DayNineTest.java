package se.tosu.aoc.y2020.daynine;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class DayNineTest {

    private DayNine dayNine;

    @BeforeEach
    void setUp() {
        dayNine = new DayNine("2020/D9-test1.txt");
    }

    @Test
    void testTask1ReturnsFirstNumberThatDoesNotHaveAddendsInBuffer() {
        assertEquals(new BigInteger("127"), dayNine.task1(5));
    }

    @Test
    void testTask2ReturnsSumOfLargestAndSmallestAddendsOfAddendSet() {
        assertEquals(new BigInteger("62"), dayNine.task2(BigInteger.valueOf(127)));
    }
}