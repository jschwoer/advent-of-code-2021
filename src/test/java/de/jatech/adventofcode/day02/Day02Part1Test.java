package de.jatech.adventofcode.day02;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import de.jatech.adventofcode.common.Utils;

public class Day02Part1Test {
	@Test
	void testPuzzle() throws Exception {
		final List<String> list = Utils.readLinesFromFile("day02/input_example.txt");

		final int result = Day02Part1.solvePuzzle(list);

		assertEquals(150, result);
	}
}
