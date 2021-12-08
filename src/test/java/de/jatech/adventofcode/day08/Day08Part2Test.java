package de.jatech.adventofcode.day08;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import de.jatech.adventofcode.common.Utils;

public class Day08Part2Test {
	@Test
	void testPuzzle() throws Exception {
		final List<String> list = Utils.readLinesFromFile("day08/input_example.txt");

//		final long result = Day08Part2.solvePuzzle(Collections
//				.singletonList("acedgfb cdfbe gcdfa fbcad dab cefabd cdfgeb eafb cagedb ab | cdfeb fcadb cdfeb cdbaf"));
		final long result = Day08Part2.solvePuzzle(list);

		assertEquals(61229, result);
	}
}
