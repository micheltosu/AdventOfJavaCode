package se.tosu.aoc.y2020.dayfive;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class DayFiveTest {

    private static final String TEST_FILE = "2020/D5-test.txt";

    @Test
    void testReadInput() {
        List<String> actual = new DayFive("2020/D5-test.txt").readFile();
        assertThat(actual, contains(
                is("BFFFBBFRRR"),
                is("FFFBBBFRRR"),
                is("BBFFBBFRLL")));
    }

    @Test
    void testFindHighestBoardingPass() {
        int actual = new DayFive(TEST_FILE).findBoardingPassWithHighestSeatId().getSeatId();
        assertThat(actual, is(820));
    }
}