package se.tosu.aoc.y2020.daytwo;

import java.util.ArrayList;
import java.util.HashSet;

public class PasswordPolicy {
    private final ArrayList<OldJobPolicyRule> rules;

    public PasswordPolicy() {
        rules = new ArrayList<>();
    }

    private PasswordPolicy(PasswordPolicy passwordPolicy, OldJobPolicyRule rule) {
        this.rules = new ArrayList<>(passwordPolicy.rules);
        this.rules.add(rule.copy());
    }


    public PasswordPolicy withRule(OldJobPolicyRule rule) {
        return new PasswordPolicy(this, rule);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        else if (obj instanceof PasswordPolicy) {
            HashSet<OldJobPolicyRule> otherRules = new HashSet<>(((PasswordPolicy) obj).rules);
            for (OldJobPolicyRule ownRule : rules) {
                if (otherRules.contains(ownRule))
                    otherRules.remove(ownRule);
                else
                    return false;
            }

            return otherRules.size() == 0;
        } else {
            return false;
        }
    }
}
