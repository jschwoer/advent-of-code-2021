package de.jatech.adventofcode.day14;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import de.jatech.adventofcode.common.Utils;

public class Day14Part2Test {
	@Test
	void testPuzzle() throws Exception {
		final List<String> list = Utils.readLinesFromFile("day14/input_example.txt");

		final long result = Day14Part2.solvePuzzle(list);

		assertEquals(2188189693529L, result);
	}
}
