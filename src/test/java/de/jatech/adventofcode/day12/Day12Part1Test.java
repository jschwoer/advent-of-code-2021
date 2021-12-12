package de.jatech.adventofcode.day12;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import de.jatech.adventofcode.common.Utils;

public class Day12Part1Test {
	@Test
	void testPuzzle() throws Exception {
		final List<String> list = Utils.readLinesFromFile("day12/input_example.txt");

		final long result = Day12Part1.solvePuzzle(list);

		assertEquals(226, result);
	}
}
