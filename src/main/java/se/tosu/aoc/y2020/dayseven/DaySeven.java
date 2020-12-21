package se.tosu.aoc.y2020.dayseven;

import se.tosu.aoc.input.Input;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DaySeven {

    private final String path;

    public DaySeven(String path) {
        this.path = path;
    }

    public static void main(String[] args) {
        new DaySeven("2020/7.txt").task1();
        new DaySeven("2020/7.txt").task2();
    }

    private void task1() {
        System.out.printf("Number of bag colors a gold bag can be in: %d\n",
                getColorsAbleToContainColor("shiny gold").size());
    }

    private void task2() {
        System.out.printf("Number of bag colors a gold bag needs to contain: %d\n",
                getBagsNeeded("shiny gold"));
    }

    Collection<Rule> getColorsAbleToContainColor(String keyword) {
        Collection<Rule> validRules = getRulesAllowing(keyword);
        Queue<Rule> ancestorRules = new LinkedList<>(validRules);

        while (!ancestorRules.isEmpty()) {
            Collection<Rule> allowingRules = getRulesAllowing(ancestorRules.poll().getBagColor());
            ancestorRules.addAll(allowingRules);
            validRules.addAll(allowingRules);
        }

        return validRules.stream().distinct().collect(Collectors.toList());
    }

    Collection<Rule> getRulesAllowing(String keyword) {
        String strippedKeyword = keyword.strip();

        return getRuleStream()
                .filter(rule -> rule.getConstraints().stream()
                        .flatMap(constraint -> Stream.of(constraint.getRule().getBagColor()))
                        .anyMatch(s -> s.equals(strippedKeyword)))
                .collect(Collectors.toList());
    }

    int getBagsNeeded(String bagColor) {
        Map<String, Rule> ruleMap = getRuleStream().collect(Collectors.toMap(Rule::getBagColor, rule -> rule));

        Rule rootRule = ruleMap.get(bagColor);
        if (rootRule == null)
            throw new RuntimeException("Could not find a rule for"  + bagColor);

        Queue<Rule> incompleteRules = new LinkedList<>();
        incompleteRules.add(rootRule);

        while (!incompleteRules.isEmpty()) {
            Rule actual = incompleteRules.poll();
            List<Constraint> linkedConstraints = new ArrayList<>();
            for (Constraint constraint : actual.getConstraints()) {
                Rule foundRule = ruleMap.get(constraint.getRule().getBagColor());
                if (foundRule != null) {
                    linkedConstraints.add(new Constraint(constraint.getRequiredCount(), foundRule));

                } else {
                    throw new RuntimeException("Could not find a rule matching constraint: " + constraint);
                }

                incompleteRules.add(foundRule);
            }

            actual.setConstraints(linkedConstraints);
        }

        return rootRule.getBagsNeeded();
    }

    private Stream<Rule> getRuleStream() {
        return new Input().getFileRowsAsListOfStrings(path).stream()
                .map(Rule::parse);
    }
}
