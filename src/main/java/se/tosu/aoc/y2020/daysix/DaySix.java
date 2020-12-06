package se.tosu.aoc.y2020.daysix;

import se.tosu.aoc.input.Input;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Stream.of;

public class DaySix {

    private String path;

    public DaySix(String path) {
        this.path = path;
    }

    public static void main(String[] args) {
        System.out.printf("The number of questions someone answered yes to is: %d", new DaySix("2020/6.txt").task1());
        System.out.printf("The number of questions all answered yes to is: %d", new DaySix("2020/6.txt").task2());
    }

    public int task1() {
        List<List<String>> groupedAnswers = getGroupedAnswers();
        List<Set<Character>> groupAnswers = groupedAnswers.stream().map(this::reduceArrayOfStringsToSetOfChars).collect(Collectors.toList());

        return groupAnswers.stream().map(Set::size).reduce(Math::addExact).get();
    }

    public int task2() {
        List<List<String>> groupedAnswers = getGroupedAnswers();
        return groupedAnswers.stream()
                .map(this::findCommonCharsInAllStrings)
                .map(Set::size)
                .reduce(Math::addExact)
                .get();

    }

    private List<List<String>> getGroupedAnswers() {
        List<String> answers = new Input().getFileRowsAsListOfStrings(path);
        List<List<String>> groupedAnswers = groupListElementsByEmptyLine(answers);
        return groupedAnswers;
    }

    private static List<List<String>> groupListElementsByEmptyLine(List<String> answers) {
        List<List<String>> groupedElements = new LinkedList<>();

        int group = 0;
        for (String element : answers) {
            if (element.isEmpty()) {
                ++group;
            } else {
                if (groupedElements.size() == group) {
                    groupedElements.add(new LinkedList<>());
                }
                groupedElements.get(group).add(element);
            }
        }

        return groupedElements;

    }

    Set<Character> reduceArrayOfStringsToSetOfChars(List<String> strings) {
        return strings.stream()
                .flatMap(s -> s.chars().mapToObj(c -> (char)c))
                .collect(Collectors.toSet());
    }

    public Set<Character> findCommonCharsInAllStrings(List<String> stringList) {
        HashMap<Character, Integer> collect = stringList.stream()
                .flatMap(s -> s.chars().mapToObj(value -> (char) value))
                .collect(HashMap::new, (mapOfCharCount, character) -> {
                    mapOfCharCount.put(character, mapOfCharCount.getOrDefault(character, 0) + 1);
                }, (characterIntegerHashMap, characterIntegerHashMap2) -> {
                    Set<Character> keys = new HashSet<>();
                    keys.addAll(characterIntegerHashMap.keySet());
                    keys.addAll(characterIntegerHashMap2.keySet());
                    keys.forEach(character -> {
                        characterIntegerHashMap2.put(
                                character,
                                characterIntegerHashMap.getOrDefault(character, 0) +
                                        characterIntegerHashMap2.getOrDefault(character, 0));
                    });


                });
        return collect.keySet().stream().filter(character -> collect.getOrDefault(character, 0) == stringList.size()).collect(Collectors.toSet());
    }
}
