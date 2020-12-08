package se.tosu.aoc.y2020.dayseven;

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
}
