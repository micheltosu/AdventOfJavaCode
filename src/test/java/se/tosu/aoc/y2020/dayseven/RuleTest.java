package se.tosu.aoc.y2020.dayseven;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;

class RuleTest {
    @Test
    void testCreateRuleFromString() {
        Rule expected = new Rule("muted yellow",
                List.of(new Constraint(2, new Rule("shiny gold")),
                        new Constraint(9, new Rule("faded blue"))));

        Rule actual = Rule.parse("muted yellow bags contain 2 shiny gold bags, 9 faded blue bags.");

        MatcherAssert.assertThat(actual, is(expected));
    }
}