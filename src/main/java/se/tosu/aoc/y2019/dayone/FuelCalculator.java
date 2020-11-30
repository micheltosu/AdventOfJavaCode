package se.tosu.aoc.y2019.dayone;

import java.util.List;

public class FuelCalculator {

    public int returnFuelNeededForMass(int mass) {
        int fuel = (mass / 3) - 2;
        return Math.max(fuel, 0);
    }

    public int returnFuelNeededForModules(List<Integer> moduleMasses) {
        return moduleMasses.stream()
                .map(this::returnFuelNeededForMass)
                .reduce(Integer::sum)
                .orElseThrow();
    }

    public int returnFuelNeededForModuleAndFuel(int i) {
        if (i <= 0) {
            return 0;
        } else {
            int fuel = returnFuelNeededForMass(i);
            return fuel + returnFuelNeededForModuleAndFuel(fuel);
        }
    }

    public int returnFuelNeededForModulesAndTheirFuel(List<Integer> moduleMasses) {
        return moduleMasses.stream()
                .map(this::returnFuelNeededForModuleAndFuel)
                .reduce(Integer::sum)
                .orElseThrow();
    }
}
