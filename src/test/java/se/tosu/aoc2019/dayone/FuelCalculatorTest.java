package se.tosu.aoc2019.dayone;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class FuelCalculatorTest {
    @Test
    void calculateFuelForMass12Returns2() {
        int mass = 12;

        int fuel = new FuelCalculator().returnFuelNeededForMass(mass);

        assertThat(fuel, is(2));
    }

    @Test
    void calculateFuelForMass100756Returns33583() {
        int mass = 100756;

        int fuel = new FuelCalculator().returnFuelNeededForMass(mass);

        assertThat(fuel, is(33583));
    }

    @Test
    void calculateSumOfFuelForTwoModules() {
        Stream<Integer> moduleMasses = Stream.of(1969, 100756);

        int fuel = new FuelCalculator().returnFuelNeededForModules(moduleMasses.collect(Collectors.toList()));

        assertThat(fuel, is(34237));
    }
}