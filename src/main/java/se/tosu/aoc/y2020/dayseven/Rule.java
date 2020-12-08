package se.tosu.aoc.y2020.dayseven;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Rule {
    private final String bagColor;
    private final List<Constraint> constraints;

    public Rule(String bagColor) {
        this(bagColor, Collections.emptyList());
    }

    public Rule(String bagColor, List<Constraint> constraints) {
        this.bagColor = bagColor;
        this.constraints = Collections.unmodifiableList(constraints);
    }

    public static Rule parse(String ruleAsString) {
        String[] split = ruleAsString.split("contain");
        Matcher matcher = Pattern.compile("([\\w\\s]+)\\sbag[s|]").matcher(split[0]);
        matcher.find();
        String matchingColor = matcher.group(1);

        if (split.length == 2) {
            List<Constraint> constraints = new LinkedList<>();
            String[] constraintSplit = split[1].split(",");
            for (String s :
                    constraintSplit) {
                Matcher constraintMatcher = Pattern.compile("\\s+(\\d+)\\s([\\w\\s]+)\\sbag[s|].*").matcher(s);
                constraintMatcher.find();

                int requiredCount = Integer.parseInt(constraintMatcher.group(1));
                new Constraint(requiredCount, Rule.parse(constraintMatcher.group(2)));

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
}
