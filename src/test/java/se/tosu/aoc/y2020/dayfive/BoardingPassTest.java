package se.tosu.aoc.y2020.dayfive;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasProperty;

class BoardingPassTest {
    @Test
    void testCreateBordingPassFromString() {
        assertThat(new BoardingPass("BBFFBBFRLL"), is(allOf(
                hasProperty("row", is(102)),
                hasProperty("col", is(4)),
                hasProperty("seatId", is(820))
        )));
    }

    @Test
    void testBinaryParserForTwoExponents() {
        Integer actual = new BoardingPass("BBFFBBFRLL").binaryParser("BF");
        assertThat(actual, is(2));
    }


    @Test
    void testBinaryParser() {
        Integer actual = new BoardingPass("BBFFBBFRLL").binaryParser("BFFFBBF");
        assertThat(actual, is(70));
    }
}