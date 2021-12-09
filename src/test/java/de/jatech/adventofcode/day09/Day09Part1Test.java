package de.jatech.adventofcode.day09;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import de.jatech.adventofcode.common.Utils;

public class Day09Part1Test {
	@Test
	void testPuzzle() throws Exception {
		final List<String> list = Utils.readLinesFromFile("day09/input_example.txt");

		final long result = Day09Part1.solvePuzzle(list);

		assertEquals(15, result);
	}
}
