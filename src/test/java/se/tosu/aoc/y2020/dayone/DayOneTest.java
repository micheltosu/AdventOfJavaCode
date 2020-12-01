package se.tosu.aoc.y2020.dayone;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
class DayOneTest {

    @Test
    void testFindProductOfEntriesThatSumsTo2020() {
        Integer actual = new DayOne("2020/D1-test1.txt").task1();
        assertThat(actual, is(514579));
    }

    @Test
    void testFindProductOfThreeEntriesThatSumsTo2020() {
        Integer actual = new DayOne("2020/D1-test1.txt").task2();
        assertThat(actual, is(241861950));
    }

    @Test
    void testOperateOnlis() {

    }
}