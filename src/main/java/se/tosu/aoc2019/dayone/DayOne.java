package se.tosu.aoc2019.dayone;

import se.tosu.aoc2019.input.Input;

import java.util.List;

public class DayOne {
    public static void main(String[] args) {
        List<Integer> moduleWeights = new Input().getListOfIntegersFromInputFile("2019/1.txt");
        int totalNeededFuel = new FuelCalculator().returnFuelNeededForModules(moduleWeights);

        System.out.printf("The total amount of fuel needed is %d%n", totalNeededFuel);
    }
}
