package se.tosu.aoc.y2020.daysix;

import se.tosu.aoc.input.Input;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DaySix {

    private String path;

    public DaySix(String path) {
        this.path = path;
    }

    public static void main(String[] args) {
        System.out.printf("The number of questions someone answered yes to is: %d\n", new DaySix("2020/6.txt").task1());
        System.out.printf("The number of questions all answered yes to is: %d\n", new DaySix("2020/6.txt").task2());
    }

    public int task1() {
        return countAnswersThatAnyoneAnsweredPositively();
    }

    public int task2() {
        return countAnswersThatAllMembersInAGroupAnsweredPositvely();

    }

    private Integer countAnswersThatAnyoneAnsweredPositively() {
        return getAnswersPerGroupAsStream()
                .map(Set::size)
                .reduce(Math::addExact)
                .get();
    }

    private Integer countAnswersThatAllMembersInAGroupAnsweredPositvely() {
        return getGroupedAnswersAsStream()
                .map(this::findCommonCharsInAllStrings)
                .map(Set::size)
                .reduce(Math::addExact)
                .get();
    }

    private Stream<Set<Character>> getAnswersPerGroupAsStream() {
        return getGroupedAnswersAsStream()
                .map(this::reduceArrayOfStringsToSetOfChars);
    }

    private Stream<List<String>> getGroupedAnswersAsStream() {
        return groupListElementsByEmptyLine().stream();
    }

    public Set<Character> findCommonCharsInAllStrings(List<String> stringList) {
        HashMap<Character, Integer> mapOfCharacterCounts = countOccurrencesOfCharsInListOfStrings(stringList);

        return getCharsWithCountHigherThanInt(mapOfCharacterCounts, stringList.size());
    }

    private HashMap<Character, Integer> countOccurrencesOfCharsInListOfStrings(List<String> stringList) {
        return stringList.stream()
                .flatMap(s -> s.chars().mapToObj(value -> (char) value))
                .collect(HashMap::new, this::increaseIntValueForCharacterAsKey, this::combineValuesForKeysOfHashMaps);
    }

    private Set<Character> getCharsWithCountHigherThanInt(HashMap<Character, Integer> mapWithCharCounts, int countThreshold) {
        return mapWithCharCounts.keySet().stream()
                .filter(character -> mapWithCharCounts.getOrDefault(character, 0) == countThreshold)
                .collect(Collectors.toSet());
    }

    private void increaseIntValueForCharacterAsKey(HashMap<Character, Integer> mapOfCharCount, Character character1) {
        mapOfCharCount.put(character1, mapOfCharCount.getOrDefault(character1, 0) + 1);
    }

    private void combineValuesForKeysOfHashMaps(HashMap<Character, Integer> characterIntegerHashMap, HashMap<Character, Integer> characterIntegerHashMap2) {
        characterIntegerHashMap2.keySet().forEach(character -> {
            characterIntegerHashMap.put(
                    character,
                    characterIntegerHashMap.getOrDefault(character, 0) +
                            characterIntegerHashMap2.getOrDefault(character, 0));
        });
    }

    Set<Character> reduceArrayOfStringsToSetOfChars(List<String> strings) {
        return strings.stream()
                .flatMap(s -> s.chars().mapToObj(c -> (char)c))
                .collect(Collectors.toSet());
    }

    private List<List<String>> groupListElementsByEmptyLine() {
        List<String> answers = getInputRowsAsList();
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

    private List<String> getInputRowsAsList() {
        return new Input().getFileRowsAsListOfStrings(path);
    }
}
