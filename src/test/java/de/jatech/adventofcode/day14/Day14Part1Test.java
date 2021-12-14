package de.jatech.adventofcode.day14;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import de.jatech.adventofcode.common.Utils;

public class Day14Part1Test {
	@Test
	void testPuzzle() throws Exception {
		final List<String> list = Utils.readLinesFromFile("day14/input_example.txt");

		final long result = Day14Part1.solvePuzzle(list);

		assertEquals(1588, result);
	}
}
