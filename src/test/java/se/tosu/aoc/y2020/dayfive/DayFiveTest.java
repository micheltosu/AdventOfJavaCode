package se.tosu.aoc.y2020.dayfive;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.is;
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

    @Test
    void testGetAllBoardingPasses() {
        assertThat(new DayFive(TEST_FILE).getAllBoardingPasses(), contains(
                is(allOf(
                        hasProperty("row", is(70)),
                        hasProperty("col", is(7)),
                        hasProperty("seatId", is(567))

                )),
                is(allOf(
                        hasProperty("row", is(14)),
                        hasProperty("col", is(7)),
                        hasProperty("seatId", is(119))

                )),
                is(allOf(
                        hasProperty("row", is(102)),
                        hasProperty("col", is(4)),
                        hasProperty("seatId", is(820))

                ))
        ));
    }
}