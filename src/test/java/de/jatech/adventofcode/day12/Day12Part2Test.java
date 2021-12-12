package de.jatech.adventofcode.day12;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import de.jatech.adventofcode.common.Utils;
import de.jatech.adventofcode.day12.Day12Part2.Cave;

public class Day12Part2Test {
	@Test
	void testPuzzle() throws Exception {
		final List<String> list = Utils.readLinesFromFile("day12/input_example.txt");

		final long result = Day12Part2.solvePuzzle(list);

		assertEquals(3509, result);
	}

	@Test
	void testHasTwoSmallCaves_OnlyBig() throws Exception {
		assertFalse(Day12Part2
				.hasTwoSameSmallCaves(Arrays.asList(new Cave("start"), new Cave("A"), new Cave("b"), new Cave("A"))));
	}

	@Test
	void testHasTwoSmallCaves_OnlyOne() throws Exception {
		assertFalse(Day12Part2
				.hasTwoSameSmallCaves(Arrays.asList(new Cave("start"), new Cave("A"), new Cave("b"), new Cave("c"))));
	}

	@Test
	void testHasTwoSmallCaves_CaveB() throws Exception {
		Cave caveB = new Cave("b");
		assertTrue(Day12Part2.hasTwoSameSmallCaves(Arrays.asList(new Cave("start"), new Cave("A"), caveB, caveB)));
	}
}
