package de.jatech.adventofcode.day08;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import de.jatech.adventofcode.common.Utils;

public class Day08Part1Test {
	@Test
	void testPuzzle() throws Exception {
		final List<String> list = Utils.readLinesFromFile("day08/input_example.txt");

		final long result = Day08Part1.solvePuzzle(list);

		assertEquals(26, result);
	}
}
