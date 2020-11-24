package se.tosu.aoc2019.dayone;

import java.util.List;

public class FuelCalculator {

    public int returnFuelNeededForMass(int mass) {
        return (mass / 3) - 2;
    }

    public int returnFuelNeededForModules(List<Integer> moduleMasses) {
        return moduleMasses.stream()
                .map(this::returnFuelNeededForMass)
                .reduce(Integer::sum)
                .orElseThrow();
    }
}
