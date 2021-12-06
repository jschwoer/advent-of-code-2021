package de.jatech.adventofcode.day06;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import de.jatech.adventofcode.common.Utils;

public class Day06Part1Test {
	@Test
	void testPuzzle() throws Exception {
		final List<String> list = Utils.readLinesFromFile("day06/input_example.txt");

		final long result = Day06Part1.solvePuzzle(list, 80);

		assertEquals(5934, result);
	}
}
