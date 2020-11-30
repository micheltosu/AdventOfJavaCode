package se.tosu.aoc.y2019.dayone;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class FuelCalculatorTest {

    private final FuelCalculator fuelCalculator = new FuelCalculator();

    @Test
    void calculateFuelForMass12Returns2() {
        int mass = 12;

        int fuel = new FuelCalculator().returnFuelNeededForMass(mass);

        assertThat(fuel, is(2));
    }

    @Test
    void calculateFuelForMass100756Returns33583() {
        int mass = 100756;

        int fuel = fuelCalculator.returnFuelNeededForMass(mass);

        assertThat(fuel, is(33583));
    }

    @Test
    void calculateSumOfFuelForTwoModules() {
        List<Integer> moduleMasses = Stream.of(1969, 100756).collect(Collectors.toList());

        int fuel = fuelCalculator.returnFuelNeededForModules(moduleMasses);

        assertThat(fuel, is(34237));
    }

    @Test
    void calculateFuelNeededIncludingFuelWeight() {
        int actual = fuelCalculator.returnFuelNeededForModuleAndFuel(100756);

        assertThat(actual, is(50346));
    }

    @Test
    void calculateSumOfFuelNeedeForModuleAndFuelWeightForTwoModules() {
        List<Integer> moduleMasses = Stream.of(1969, 100756).collect(Collectors.toList());

        int actual = fuelCalculator.returnFuelNeededForModulesAndTheirFuel(moduleMasses);

        assertThat(actual, is(966 + 50346));
    }
}