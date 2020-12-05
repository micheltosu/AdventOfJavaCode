package se.tosu.aoc.y2020.dayfour;

import se.tosu.aoc.input.Input;

import java.util.*;

public class DayFour {
    private String file;

    public DayFour(String fileName) {
        file = fileName;
    }

    public static void main(String[] args) {
        System.out.printf("The number of valid passwords are: %d\n", new DayFour("2020/4.txt").task1());
        System.out.printf("The number of valid passwords are: %d\n", new DayFour("2020/4.txt").task2());
    }

    private int task1() {
        List<Passport> passports = getAllPassports();
        return passports.size();
    }

    private int task2() {
        List<Passport> passports = getAllPassports();
        return (int) passports.stream().filter(Passport::propertiesAreValid).count();
    }

    public List<Passport> getAllPassports() {
        List<String> inputLines = new Input().getFileRowsAsListOfStrings(file);

        Map<String, String> passportProperties = new HashMap<>();
        List<Passport> passports = new ArrayList<>();
        for (String line :
                inputLines) {
            if (!line.isEmpty()) {
                String[] keyValuePairs = line.split("\\s");
                for (String pair :
                        keyValuePairs) {
                    String[] split = pair.split(":");
                    passportProperties.put(split[0], split[1]);
                }
            } else {
                addPassportIfHasRequiredFields(passportProperties, passports);
                passportProperties = new HashMap<>();
            }
        }
        addPassportIfHasRequiredFields(passportProperties, passports);

        return passports;
    }

    private void addPassportIfHasRequiredFields(Map<String, String> passportProperties, List<Passport> passports) {
        try {
            passports.add(Passport.createPassportFromMap(passportProperties));
        } catch (RuntimeException e) {
            //System.out.printf("Could not create passport from map with content %s\n", passportProperties);
        }
    }
}
