package se.tosu.aoc.y2020.dayfive;

import se.tosu.aoc.input.Input;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DayFive {
    private final String inputResourcePath;

    public DayFive(String inputResourcePath) {
        this.inputResourcePath = inputResourcePath;
    }

    public static void main(String[] args) {
        DayFive dayFive = new DayFive("2020/5.txt");
        dayFive.task1();
        dayFive.task2();
    }

    private void task1() {
        int seatId = findBoardingPassWithHighestSeatId().getSeatId();
        System.out.printf("The boarding pass with highest id has id: %d\n", seatId);
    }

    private void task2() {
        List<BoardingPass> allBoardingPasses = getBoardingPassStream()
            .sorted(Comparator.comparingInt(BoardingPass::getSeatId))
                .collect(Collectors.toCollection(ArrayList::new));

        System.out.printf("The missing boarding pass has id: %d\n", getMissingId(allBoardingPasses));
    }

    private int getMissingId(List<BoardingPass> allBoardingPasses) {
        int missingId = 0;
        for(int i = 0; i < (allBoardingPasses.size() - 1); ++i) {
            BoardingPass current = allBoardingPasses.get(i);
            if ( allBoardingPasses.get(i + 1).getSeatId() - allBoardingPasses.get(i).getSeatId() == 2) {
                missingId = current.getSeatId() + 1;
            }

        }
        return missingId;
    }


    List<String> readFile() {
        return new Input().getFileRowsAsListOfStrings(inputResourcePath);
    }

    public BoardingPass findBoardingPassWithHighestSeatId() {
        return getBoardingPassStream()
                .max(Comparator.comparingInt(BoardingPass::getSeatId))
                .get();
    }


    private Stream<BoardingPass> getBoardingPassStream() {
        List<String> input = readFile();
        return input.stream()
                .map(BoardingPass::new);
    }

    public List<BoardingPass> getAllBoardingPasses() {
        return getBoardingPassStream().collect(Collectors.toList());
    }
}
