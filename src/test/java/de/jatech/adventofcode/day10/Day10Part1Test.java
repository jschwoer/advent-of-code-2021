package de.jatech.adventofcode.day10;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import de.jatech.adventofcode.common.Utils;

public class Day10Part1Test {
	@Test
	void testPuzzle() throws Exception {
		final List<String> list = Utils.readLinesFromFile("day10/input_example.txt");

		final long result = Day10Part1.solvePuzzle(list);

		assertEquals(26397, result);
	}
}
