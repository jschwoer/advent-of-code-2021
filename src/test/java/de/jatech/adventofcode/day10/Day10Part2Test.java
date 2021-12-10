package de.jatech.adventofcode.day10;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import de.jatech.adventofcode.common.Utils;

public class Day10Part2Test {
	@Test
	void testPuzzle() throws Exception {
		final List<String> list = Utils.readLinesFromFile("day10/input_example.txt");

		final long result = Day10Part2.solvePuzzle(list);

		assertEquals(288957, result);
	}
}
