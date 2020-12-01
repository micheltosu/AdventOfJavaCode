package se.tosu.aoc.y2020.dayone;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class ExpenseReportTest {

    @Test
    void findTwoEntriesThatSumsTo2020() {
        List<Integer> expected = Stream.of(1721, 299).collect(Collectors.toList());
        List<Integer> entries = Stream.of(1721, 979, 366, 299, 675, 1456).collect(Collectors.toList());

        List<Integer> actual = new ExpenseReport().findTwoIntsThatSumTo2020(entries);

        assertThat(actual, is(expected));

    }

    @Test
    void findThreeEntriesThatSumsTo2020() {
        List<Integer> expected = Stream.of(979,366,675).collect(Collectors.toList());
        List<Integer> entries = Stream.of(1721, 979, 366, 299, 675, 1456).collect(Collectors.toList());

        List<Integer> actual = new ExpenseReport().findThreeIntsThatSumTo2020(entries);

        assertThat(actual, is(expected));
    }
}