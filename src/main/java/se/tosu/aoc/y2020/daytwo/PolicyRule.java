package se.tosu.aoc.y2020.daytwo;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public abstract class PolicyRule<T> {
    private final String pattern;
    private final int min;
    private final int max;

    public String getPattern() {
        return pattern;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    public PolicyRule(String pattern, int min, int max) {
        this.pattern = pattern;
        this.min = min;
        this.max = max;
    }

    public abstract boolean allows(String query);

    public abstract T copy();

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
}
