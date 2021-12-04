package de.jatech.adventofcode.day04;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import de.jatech.adventofcode.common.Utils;

public class Day04Part1Test {
	@Test
	void testPuzzle() throws Exception {
		final List<String> list = Utils.readLinesFromFile("day04/input_example.txt");

		final int result = Day04Part1.solvePuzzle(list);

		assertEquals(198, result);
	}
}
