package se.tosu.aoc.input;

import java.io.InputStream;
import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Input {

    public List<Integer> getListOfIntegersFromInputFile(String path) {
        try {
            return getFileRowsAsListOfStrings(path).stream()
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException("Could not read file", e);
        }
    }

    public List<BigInteger> getListOfBigIntegersFromInputFile(String resourcePath) {
        try {
            return getFileRowsAsListOfStrings(resourcePath).stream()
                    .map(BigInteger::new)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException("Could not read file", e);
        }
    }

    public List<String> getFileRowsAsListOfStrings(String path) {
        InputStream inputStream = openResourceFromString(path);
        return readStreamAndReturnLinesAsListOfStrings(inputStream);
    }

    private InputStream openResourceFromString(String resourcePath) {
        return getClass().getClassLoader().getResourceAsStream(resourcePath);
    }

    private List<String> readStreamAndReturnLinesAsListOfStrings(InputStream file) {
        Scanner scanner = new Scanner(file);
        List<String> lines = new LinkedList<>();
        while (scanner.hasNext()) {
            lines.add(scanner.nextLine());
        }

        return lines;
    }
}
