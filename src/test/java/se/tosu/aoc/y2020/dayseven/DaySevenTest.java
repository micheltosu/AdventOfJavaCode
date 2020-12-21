package se.tosu.aoc.y2020.dayseven;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DaySevenTest {

    private static final String TEST_FILE = "2020/D7-test1.txt";

    @Test
    void testFindRulesAllowingGoldBags() {
        assertEquals(2, new DaySeven(TEST_FILE).getRulesAllowing("shiny gold").size());
    }

    @Test
    void testGetNumberOfColorsAbleToContainGoldBags() {
        assertEquals(4, new DaySeven(TEST_FILE).getColorsAbleToContainColor("shiny gold").size());
    }

    @Test
    void testGetBagsNeededToUseBag() {
        assertEquals(32, new DaySeven(TEST_FILE).getBagsNeeded("shiny gold"));
    }
}