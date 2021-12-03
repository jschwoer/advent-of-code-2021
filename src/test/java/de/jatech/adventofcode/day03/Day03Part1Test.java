package de.jatech.adventofcode.day03;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import de.jatech.adventofcode.common.Utils;

public class Day03Part1Test {
	@Test
	void testPuzzle() throws Exception {
		final List<String> list = Utils.readLinesFromFile("day03/input_example.txt");

		final int result = Day03Part1.solvePuzzle(list);

		assertEquals(198, result);
	}
}
