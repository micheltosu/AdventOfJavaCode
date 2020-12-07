package se.tosu.aoc.y2020.dayseven;

import se.tosu.aoc.input.Input;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

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

    int getBagsNeeded(String shiny_gold) {

        Collection<String[]> bagsNeeded =  getRulesThatApplyForColor(shiny_gold);
        Collection<String[]> descendantRules = bagsNeeded;

        do {
            descendantRules = descendantRules.stream()
                    .map(rule -> rule[1].split(","))
                    .flatMap(Arrays::stream)
                    .map(s -> s.replaceAll("(bags|bag)(\\.|)", ""))
                    .map(String::strip)
                    .map(s -> s.replaceAll("\\s*\\d+\\s*", ""))
                    .map(this::getRulesThatApplyForColor)
                    .flatMap(Collection::stream)
                    .collect(Collectors.toList());


            bagsNeeded.addAll(descendantRules);
        } while (descendantRules.size() != 0);

        return bagsNeeded.stream().map(strings -> strings[0]).distinct().map(this::getNumBagsNeededForColor).reduce(Integer::sum).get();
    }


    Collection<String> getColorsAbleToContainColor(String keyword) {
        Collection<String[]> validRules = getRulesAllowing(keyword);
        Collection<String[]> ancestorRules = validRules;

        do {
            ancestorRules = ancestorRules.stream()
                    .map(rule -> getRulesAllowing(rule[0]))
                    .flatMap(Collection::stream)
                    .collect(Collectors.toList());

            validRules.addAll(ancestorRules);
        } while (ancestorRules.size() != 0);

        return validRules.stream()
                .map(strings -> strings[0])
                .distinct()
                .collect(Collectors.toList());
    }

    Collection<String[]> getRulesAllowing(String keyword) {
        List<String> inputRows = new Input().getFileRowsAsListOfStrings(path);
        String strippedKeyword = keyword.strip();

        return inputRows.stream()
                .map(s -> s.split("contain"))
                .filter(rule -> rule[1].contains(strippedKeyword))
                .map(rule -> Arrays.stream(rule)
                        .map( s -> s.replaceAll("bags|bag", ""))
                        .map(String::strip)
                        .toArray(String[]::new))
                .collect(Collectors.toList());

    }

    Collection<String[]> getRulesThatApplyForColor(String keyword) {
        List<String> inputRows = new Input().getFileRowsAsListOfStrings(path);
        String strippedKeyword = keyword.strip();

        return inputRows.stream()
                .map(s -> s.split("contain"))
                .filter(rule -> rule[0].contains(strippedKeyword))
                .collect(Collectors.toList());
    }

    int getNumBagsNeededForColor(String keyword) {
        List<String> inputRows = new Input().getFileRowsAsListOfStrings(path);
        String strippedKeyword = keyword.strip().replaceAll("bags|bag", "");

        return getRulesThatApplyForColor(strippedKeyword).stream()
                .map(s -> s[1].split(","))
                .filter(rule -> rule[0].contains(strippedKeyword))
                .map(rule -> Arrays.stream(rule)
                        .map( s -> s.replaceAll("bags|bag", ""))
                        .map(String::strip)
                        .toArray(String[]::new))
                .map(strings -> strings[1].split(","))
                .flatMap(strings -> Arrays.stream(strings.clone()))
                .map(Integer::parseInt)
                .reduce(Integer::sum)
                .get();

    }
}
