package se.tosu.aoc.y2020.daytwo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PolicyRuleTest {

    private static final String PATTERN = "a";
    private static final int MIN = 1;
    private static final int MAX = 2;
    private static final PolicyRule RULE_A = new PolicyRule(PATTERN, MIN, MAX);

    @Test
    void testCopyReturnsNewRule() {
        PolicyRule policyRule = RULE_A;
        assertNotSame(policyRule, policyRule.copy());
    }

    @Test
    void testRuleWithSameConstraintsEqualsTrue() {
        PolicyRule rule = RULE_A;

        assertEquals(rule, rule.copy());
    }

    @Test
    void testRulesWithDifferentMaxConstraintEqualsFalse() {
        assertNotEquals(RULE_A, new PolicyRule(PATTERN, MIN, 4));
    }

    @Test
    void testRulesWithDifferentPatternConstraintEqualsFalse() {
        assertNotEquals(RULE_A, new PolicyRule("other pattern", MIN, MAX));
    }

    @Test
    void testRulesWithDifferentMinConstraintEqualsFalse() {
        assertNotEquals(RULE_A, new PolicyRule(PATTERN, 0, MAX));
    }

    @Test
    void testHashIsSameForEqualObject() {
        assertEquals(RULE_A.hashCode(), RULE_A.hashCode());
    }

    @Test
    void testHashIsDifferentForNonEqualObject() {
        assertNotEquals(RULE_A.hashCode(), new PolicyRule(PATTERN, 3, MAX).hashCode());
    }

    @Test
    void testParseStringToRule() {
        PolicyRule expected = new PolicyRule("a", 1,3);

        PolicyRule actual = PolicyRule.parse("1-3 a: xxxuufdio");

        assertEquals(actual, expected);
    }

    @Test
    void testParseDifferentStringsDoesNotEqual() {
        assertNotEquals(PolicyRule.parse("2-3 a: sjkl"), PolicyRule.parse("1-3 b: bbb"));
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