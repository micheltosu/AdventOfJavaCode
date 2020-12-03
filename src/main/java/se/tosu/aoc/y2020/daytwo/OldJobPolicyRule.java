package se.tosu.aoc.y2020.daytwo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class OldJobPolicyRule extends PolicyRule<OldJobPolicyRule> {

    public OldJobPolicyRule(String pattern, int min, int max) {
        super(pattern, min, max);
    }

    public static OldJobPolicyRule parse(String ruleAsString) {
        List<String> parts = Arrays.stream(ruleAsString.split("[-\\W:]"))
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .collect(Collectors.toList());

        return new OldJobPolicyRule(parts.get(2), Integer.parseInt(parts.get(0)), Integer.parseInt(parts.get(1)));

    }

    public OldJobPolicyRule copy() {
        return new OldJobPolicyRule(getPattern(), getMin(), getMax());
    }

    public boolean allows(String query) {
        int occurrences = countOccurancesOfPatternInString(query);
        return occurrences >= getMin() && occurrences <= getMax();
    }

    private int countOccurancesOfPatternInString(String query) {
        if (!query.contains(getPattern()))
            return 0;

        int occurrences = 0;
        int indexOf = 0;
        do {
            indexOf = query.indexOf(getPattern(), indexOf);
            if (indexOf != -1) {
                indexOf += 1;
                occurrences += 1;
            }
        } while (indexOf != -1);

        return occurrences;
    }
}
