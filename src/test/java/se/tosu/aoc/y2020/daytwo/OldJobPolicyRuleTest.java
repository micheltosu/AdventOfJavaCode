package se.tosu.aoc.y2020.daytwo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OldJobPolicyRuleTest {

    private static final String PATTERN = "a";
    private static final int MIN = 1;
    private static final int MAX = 2;
    private static final OldJobPolicyRule RULE_A = new OldJobPolicyRule(PATTERN, MIN, MAX);

    @Test
    void testCopyReturnsNewRule() {
        OldJobPolicyRule oldJobPolicyRule = RULE_A;
        assertNotSame(oldJobPolicyRule, oldJobPolicyRule.copy());
    }

    @Test
    void testRuleWithSameConstraintsEqualsTrue() {
        OldJobPolicyRule rule = RULE_A;

        assertEquals(rule, rule.copy());
    }

    @Test
    void testRulesWithDifferentMaxConstraintEqualsFalse() {
        assertNotEquals(RULE_A, new OldJobPolicyRule(PATTERN, MIN, 4));
    }

    @Test
    void testRulesWithDifferentPatternConstraintEqualsFalse() {
        assertNotEquals(RULE_A, new OldJobPolicyRule("other pattern", MIN, MAX));
    }

    @Test
    void testRulesWithDifferentMinConstraintEqualsFalse() {
        assertNotEquals(RULE_A, new OldJobPolicyRule(PATTERN, 0, MAX));
    }

    @Test
    void testHashIsSameForEqualObject() {
        assertEquals(RULE_A.hashCode(), RULE_A.hashCode());
    }

    @Test
    void testHashIsDifferentForNonEqualObject() {
        assertNotEquals(RULE_A.hashCode(), new OldJobPolicyRule(PATTERN, 3, MAX).hashCode());
    }

    @Test
    void testParseStringToRule() {
        OldJobPolicyRule expected = new OldJobPolicyRule("a", 1,3);

        OldJobPolicyRule actual = OldJobPolicyRule.parse("1-3 a: xxxuufdio");

        assertEquals(actual, expected);
    }

    @Test
    void testParseDifferentStringsDoesNotEqual() {
        assertNotEquals(OldJobPolicyRule.parse("2-3 a: sjkl"), OldJobPolicyRule.parse("1-3 b: bbb"));
    }

    @Test
    void testMatchesPolicyReturnsTrue() {
        assertTrue(RULE_A.allows("xxxaxx"));
    }

    @Test
    void testPatternExistToFewTimesIsNotAllowed() {
        assertFalse(RULE_A.allows("xxxxx"));
    }

    @Test
    void testPatternRepeatingTooManyTimesReturnsFalse() {
        assertFalse(RULE_A.allows("xxaaaxax"));
    }

    @Test
    void testPatternExistMaxNumberOfTimesIsAllowed() {
        assertTrue(RULE_A.allows("xaxax"));
    }
}