package de.jatech.adventofcode.day01;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import de.jatech.adventofcode.common.Utils;

public class Day01Part2Test {
	@Test
	void testPuzzle() throws Exception {
		final List<Integer> list = Utils.readListInt("day01/input_example.txt");

		final int result = Day01Part2.solvePuzzle(list);

		assertEquals(5, result);
	}
}
