package de.jatech.adventofcode.day06;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import de.jatech.adventofcode.common.Utils;

public class Day06Part2Test {
	@Test
	void testPuzzle() throws Exception {
		final List<String> list = Utils.readLinesFromFile("day06/input_example.txt");

		final long result = Day06Part2.solvePuzzle(list, 256);

		assertEquals(26984457539L, result);
	}
}
