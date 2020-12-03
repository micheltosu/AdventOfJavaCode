package se.tosu.aoc.y2020.daytwo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class OfficialJobPolicyRule extends PolicyRule<OfficialJobPolicyRule> {
    public OfficialJobPolicyRule(String pattern, int min, int max) {
        super(pattern, min, max);
    }

    public static PolicyRule<OfficialJobPolicyRule> parse(String ruleAsString) {
        List<String> parts = Arrays.stream(ruleAsString.split("[-\\W:]"))
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .collect(Collectors.toList());

        return new OfficialJobPolicyRule(parts.get(2), Integer.parseInt(parts.get(0)), Integer.parseInt(parts.get(1)));
    }

    @Override
    public boolean allows(String query) {
        boolean posA = false;
        boolean posB = false;
        if (isWithinStringIndex(query, getMin() - 1)) {
            posA = query.charAt(getMin() - 1) == getPattern().charAt(0);
        }

        if (isWithinStringIndex(query, getMax() - 1)) {
            posB = query.charAt(getMax() - 1) == getPattern().charAt(0);
        }

        return posA != posB;
    }

    private boolean isWithinStringIndex(String query, int pos) {
        return query.length() >= pos && pos >= 0;
    }

    @Override
    public OfficialJobPolicyRule copy() {
        throw new RuntimeException("not implemented");
    }
}
