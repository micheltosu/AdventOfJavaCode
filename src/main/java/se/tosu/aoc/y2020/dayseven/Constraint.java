package se.tosu.aoc.y2020.dayseven;

import java.util.Objects;

public class Constraint {
    private final int requiredCount;
    private final Rule rule;

    public Constraint(int requiredCount, Rule rule) {
        this.requiredCount = requiredCount;
        this.rule = rule;
    }

    public int getRequiredCount() {
        return requiredCount;
    }

    public Rule getRule() {
        return rule;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Constraint that = (Constraint) o;
        return requiredCount == that.requiredCount &&
                rule.equals(that.rule);
    }

    @Override
    public int hashCode() {
        return Objects.hash(requiredCount, rule);
    }

    @Override
    public String toString() {
        return "Constraint{" +
                "requiredCount=" + requiredCount +
                ", rule=" + rule +
                '}';
    }
}
