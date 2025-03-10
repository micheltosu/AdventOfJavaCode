package se.tosu.aoc.y2020.dayone;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ExpenseReport {
    public List<Integer> findTwoIntsThatSumTo2020(List<Integer> entries) {

        for (int entryA :
                entries) {
            for (int entryB :
                    entries) {
                if (entryA + entryB == 2020) {
                    return Arrays.asList(entryA, entryB);
                }
            }
        }

        return Collections.emptyList();
    }

    public List<Integer> findThreeIntsThatSumTo2020(List<Integer> entries) {

        for (int entryA :
                entries) {
            for (int entryB :
                    entries) {
                for (int entryC :
                        entries) {
                    if (entryA + entryB + entryC == 2020) {
                        return Arrays.asList(entryA, entryB, entryC);
                    }
                }
            }
        }

        return Collections.emptyList();
    }
}
