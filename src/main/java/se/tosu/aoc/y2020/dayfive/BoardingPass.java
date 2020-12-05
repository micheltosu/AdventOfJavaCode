package se.tosu.aoc.y2020.dayfive;

import java.util.LinkedList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BoardingPass {
    private final int row;
    private final int col;
    private final int seatId;

    public BoardingPass(String s) {
        this.row = binaryParser(s.substring(0,7));
        this.col = binaryParser(s.substring(7));
        this.seatId = (row * 8) + col;
    }

    int binaryParser(String substring) {
        List<Integer> currentTree = IntStream.rangeClosed(0, (int) Math.pow(2, substring.length()))
                .boxed()
                .collect(Collectors.toList());

        for (char c : substring.toCharArray()) {
            int currentSize = currentTree.size();
            if (c == 'B' || c == 'R') {
                currentTree = new LinkedList<>(currentTree.subList(currentSize / 2, currentSize));
            } else if (c == 'F' || c == 'L')
                currentTree = new LinkedList<>(currentTree.subList(0, currentSize / 2));
        }

        return currentTree.get(0);
    }

    public int getSeatId() {
        return seatId;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}
