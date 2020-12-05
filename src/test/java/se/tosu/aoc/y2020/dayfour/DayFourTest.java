package se.tosu.aoc.y2020.dayfour;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class DayFourTest {
    @Test
    void testParseFile() {
        List<Passport> actual = new DayFour("2020/D4-test1.txt").getAllPassports();
        assertThat(actual, contains(
                allOf(
                        hasProperty("ecl", is("gry")),
                        hasProperty("pid", is("860033327")),
                        hasProperty("eyr", is("2020")),
                        hasProperty("hcl", is("#fffffd")),
                        hasProperty("byr", is("1937")),
                        hasProperty("iyr", is("2017")),
                        hasProperty("cid", is("147")),
                        hasProperty("hgt", is("183cm"))
                ),
                allOf(
                        hasProperty("ecl", is("brn")),
                        hasProperty("pid", is("760753108")),
                        hasProperty("eyr", is("2024")),
                        hasProperty("hcl", is("#ae17e1")),
                        hasProperty("byr", is("1931")),
                        hasProperty("iyr", is("2013")),
                        hasProperty("hgt", is("179cm"))
                )
        ));
    }

    @Test
    void testParseInputForFileThatDoesntWork() {
        assertThat(new DayFour("2020/D4-test2.txt").getAllPassports().size(), is(4));
    }

    @Test
    void testTaskTwoOnlyInvalidPasswords() {
        DayFour dayFour = new DayFour("2020/D4-test2.txt");
        Stream<Passport> validPasswordStream = getValidPasswordStream(dayFour);
        assertThat(validPasswordStream.count(), is(0L));
    }

    @Test
    void testTaskTwoOnlyValidPasswords() {
        DayFour dayFour = new DayFour("2020/D4-test3.txt");
        assertThat(getValidPasswordStream(dayFour).count(), is(4L));
    }

    private Stream<Passport> getValidPasswordStream(DayFour dayFour) {
        return dayFour.getAllPassports().stream().filter(Passport::propertiesAreValid);
    }
}