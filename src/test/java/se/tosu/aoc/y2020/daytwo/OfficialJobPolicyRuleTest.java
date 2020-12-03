package se.tosu.aoc.y2020.daytwo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OfficialJobPolicyRuleTest {

    @Test
    void testParseGivesCorrectRule() {

        assertEquals(new OfficialJobPolicyRule("a", 3, 5), OfficialJobPolicyRule.parse("3-5 a: fadsf"));
    }

    @Test
    void testAllowsValidPattern() {
        assertTrue(OfficialJobPolicyRule.parse("1-3 a: abcde").allows("abcde"));
    }

    @Test
    void testAllowsValidPatternInSecondPosition() {
        assertTrue(OfficialJobPolicyRule.parse("2-3 c: abcde").allows("abcde"));
    }

    @Test
    void testAllowsPatternIfOnePositionIsOutsideOfString() {
        assertFalse(OfficialJobPolicyRule.parse("18-30 a: abcde").allows("abcde"));
    }

    @Test
    void testDoesNotAllowPatternInBothPositions() {
        assertFalse(OfficialJobPolicyRule.parse("1-4 a: axxa").allows("axxa"));
    }
}