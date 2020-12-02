package se.tosu.aoc.y2020.daytwo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DayTwoTest {

    @Test
    void runSolutionOnTestData() {
        int actual = new DayTwo().runSolution("2020/D2-test1.txt");
        assertEquals(actual, 2);
    }
}