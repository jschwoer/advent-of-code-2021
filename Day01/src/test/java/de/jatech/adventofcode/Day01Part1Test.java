package de.jatech.adventofcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

public class Day01Part1Test {
	@Test
	void testPuzzle() throws Exception {
		final List<Integer> list = Day01Part1.readList("input_example.txt");

		final int result = Day01Part1.solvePuzzle(list);

		assertEquals(7, result);
	}
}
