package se.tosu.aoc.y2020.daytwo;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class PasswordPolicyTest {

    private static final OldJobPolicyRule RULE_B = new OldJobPolicyRule("b", 1, 3);
    private static final OldJobPolicyRule RULE_A = new OldJobPolicyRule("a", 1, 3);

    @Test
    void testPasswordPoliciesWithSameRulesEqualsTrue() {
        PasswordPolicy policy1 = new PasswordPolicy().withRule(RULE_A);

        Boolean actual = policy1.equals(new PasswordPolicy().withRule(RULE_A));

        assertThat(actual, is(true));
    }

    @Test
    void testPasswordPoliciesWithDifferentNumberOfRuleEqualsFalse() {
        PasswordPolicy policy1 = new PasswordPolicy().withRule(mock(OldJobPolicyRule.class));

        assertNotEquals(policy1, new PasswordPolicy());
    }

    @Test
    void testPasswordPolicyWithDifferentRulesEqualsFalse() {
        PasswordPolicy rule1 = new PasswordPolicy().withRule(RULE_B);
        PasswordPolicy rule2 = new PasswordPolicy().withRule(RULE_A);

        assertNotEquals(rule1, rule2);
    }
}