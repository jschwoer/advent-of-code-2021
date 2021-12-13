package de.jatech.adventofcode.day13;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import de.jatech.adventofcode.common.Utils;

public class Day13Part2Test {
	@Test
	void testPuzzle() throws Exception {
		final List<String> list = Utils.readLinesFromFile("day13/input_example.txt");

		final long result = Day13Part2.solvePuzzle(list);

		assertEquals(3509, result);
	}
}
