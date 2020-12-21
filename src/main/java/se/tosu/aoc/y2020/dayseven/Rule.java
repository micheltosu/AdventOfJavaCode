package se.tosu.aoc.y2020.dayseven;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Rule {
    private final String bagColor;
    private List<Constraint> constraints;

    public Rule(String bagColor) {
        this(bagColor, Collections.emptyList());
    }

    public Rule(String bagColor, List<Constraint> constraints) {
        this.bagColor = bagColor;
        this.constraints = Collections.unmodifiableList(constraints);
    }

    public static Rule parse(String ruleAsString) {
        String[] split = ruleAsString.split("contain");
        Matcher matcher = Pattern.compile("([\\w|\\s]+)\\sbag?").matcher(split[0]);
        matcher.find();
        String matchingColor = matcher.group(1);

        if (split.length == 2 && !split[1].strip().equals("no other bags.")) {
            List<Constraint> constraints = new LinkedList<>();
            String[] constraintSplit = split[1].split(",");
            for (String s :
                    constraintSplit) {
                Matcher constraintMatcher = Pattern.compile("\\s*(\\d+)\\s([\\w\\s]+\\sbags?)").matcher(s);
                boolean found = constraintMatcher.find();

                int requiredCount = Integer.parseInt(constraintMatcher.group(1));
                constraints.add(new Constraint(requiredCount, Rule.parse(constraintMatcher.group(2))));

            }

            return new Rule(matchingColor, constraints);
        } else {
            return new Rule(matchingColor);
        }
    }

    public String getBagColor() {
        return bagColor;
    }

    public List<Constraint> getConstraints() {
        return constraints;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rule rule = (Rule) o;
        return bagColor.equals(rule.bagColor) &&
                Objects.equals(constraints, rule.constraints);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bagColor, constraints);
    }

    public void setConstraints(List<Constraint> constraints) {
        this.constraints = constraints;
    }

    public int getBagsNeeded() {
        return constraints.stream()
                .map(Constraint::getBagsNeeded)
                .reduce(Math::addExact)
                .orElse(0);
    }
}
