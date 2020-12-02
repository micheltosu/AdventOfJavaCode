package se.tosu.aoc.y2020.daytwo;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class PolicyRule {
    private final String pattern;
    private final int min;
    private final int max;

    public PolicyRule(String pattern, int min, int max) {
        this.pattern = pattern;
        this.min = min;
        this.max = max;
    }

    public static PolicyRule parse(String ruleAsString) {

        List<String> parts = Arrays.stream(ruleAsString.split("[-\\W:]"))
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .collect(Collectors.toList());

        return new PolicyRule(parts.get(2), Integer.parseInt(parts.get(0)), Integer.parseInt(parts.get(1)));
    }

    public PolicyRule copy() {
        return new PolicyRule(pattern, min, max);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (!(obj instanceof PolicyRule)) {
            return false;
        } else {
            PolicyRule other = (PolicyRule) obj;
            return this.pattern.equals(other.pattern)
                    && this.min == other.min
                    && this.max == other.max;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(pattern, min, max);
    }

    public boolean allows(String query) {
        int occurrences = countOccurancesOfPatternInString(query);
        return occurrences >= min && occurrences <= max;
    }

    private int countOccurancesOfPatternInString(String query) {
        if (!query.contains(pattern))
            return 0;

        int occurrences = 0;
        int indexOf = 0;
        do {
            indexOf = query.indexOf(pattern, indexOf);
            if (indexOf != -1) {
                indexOf += 1;
                occurrences += 1;
            }
        } while (indexOf != -1);

        return occurrences;
    }
}
