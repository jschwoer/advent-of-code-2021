package de.jatech.adventofcode.day11;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import de.jatech.adventofcode.common.Utils;

public class Day11Part2Test {
	@Test
	void testPuzzle() throws Exception {
		final List<String> list = Utils.readLinesFromFile("day11/input_example.txt");

		final long result = Day11Part2.solvePuzzle(list);

		assertEquals(195, result);
	}
}
