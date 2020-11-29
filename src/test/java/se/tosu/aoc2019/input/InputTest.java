package se.tosu.aoc2019.input;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class InputTest {
    @Test
    void fromInputWithIntSeparatedByNewlineReturnIntList() {
        List<Integer> actual = new Input().getListOfIntegersFromInputFile("D1-test1.txt");

        List<Integer> expected = Stream.of(321, 3928, 321, 54837).collect(Collectors.toList());
        assertThat(actual, is(expected));
    }

    @Test
    void readFileAndReturnEachLineAsStringInList() {
        List<String> actual = new Input().getFileRowsAsListOfStrings("D1-test1.txt");

        List<String> expected = Stream.of("321", "3928", "321", "54837").collect(Collectors.toList());
        assertThat(actual, is(expected));
    }

    @Test
    void readFileWhenIncorrectPathShouldThrow() {
        Executable actual = () -> {
            Input input = new Input();
            input.getListOfIntegersFromInputFile("non-existing file");
        };

        RuntimeException runtimeException = assertThrows(RuntimeException.class, actual, "Try to read input file that doesn't exist");
        assertEquals("Could not read file", runtimeException.getMessage());
    }
}