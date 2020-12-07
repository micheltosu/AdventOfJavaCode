package se.tosu.aoc.y2020.dayseven;

import se.tosu.aoc.input.Input;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class DaySeven {

    private final String path;

    public DaySeven(String path) {
        this.path = path;
    }

    public static void main(String[] args) {
        new DaySeven("2020/7.txt").task1();
    }

    private void task1() {
        System.out.printf("Number of bag colors a gold bag can be in: %d",
                getColorsAbleToContainColor("shiny gold").size());
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
}
