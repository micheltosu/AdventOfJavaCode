package se.tosu.aoc.y2020.dayfive;

import se.tosu.aoc.input.Input;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class DayFive {
    private final String inputfilePath;

    public DayFive(String inputfilePath) {

        this.inputfilePath = inputfilePath;
    }

    public static void main(String[] args) {
        BoardingPass highestSeatId = new DayFive("2020/5.txt").findBoardingPassWithHighestSeatId();
        System.out.printf("The boarding pass with highest id has id: %d", highestSeatId.getSeatId());
    }


    List<String> readFile() {
        return new Input().getFileRowsAsListOfStrings(inputfilePath);
    }

    public BoardingPass findBoardingPassWithHighestSeatId() {
        List<String> input = readFile();
        return input.stream()
                .map(BoardingPass::new)
                .max(Comparator.comparingInt(BoardingPass::getSeatId))
                .get();
    }
}
