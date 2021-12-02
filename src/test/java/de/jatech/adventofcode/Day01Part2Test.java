package de.jatech.adventofcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

public class Day01Part2Test {
	@Test
	void testPuzzle() throws Exception {
		final List<Integer> list = Day01Part2.readList("input_example.txt");

		final int result = Day01Part2.solvePuzzle(list);

		assertEquals(5, result);
	}
}
