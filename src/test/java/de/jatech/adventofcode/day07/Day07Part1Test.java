package de.jatech.adventofcode.day07;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import de.jatech.adventofcode.common.Utils;

public class Day07Part1Test {
	@Test
	void testPuzzle() throws Exception {
		final List<String> list = Utils.readLinesFromFile("day07/input_example.txt");

		final long result = Day07Part1.solvePuzzle(list);

		assertEquals(37, result);
	}
}
