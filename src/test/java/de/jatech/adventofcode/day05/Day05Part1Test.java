package de.jatech.adventofcode.day05;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import de.jatech.adventofcode.common.Utils;

public class Day05Part1Test {
	@Test
	void testPuzzle() throws Exception {
		final List<String> list = Utils.readLinesFromFile("day05/input_example.txt");

		final long result = Day05Part1.solvePuzzle(list);

		assertEquals(5, result);
	}

	@Test
	void testGetCoverPoints_SameX() throws Exception {
		final Line line = new Line(1, 1, 1, 3);
		final List<Point> coverPoints = line.getCoverPoints();

		assertEquals(3, coverPoints.size());
		assertEquals(new Point(1, 1), coverPoints.get(0));
		assertEquals(new Point(1, 2), coverPoints.get(1));
		assertEquals(new Point(1, 3), coverPoints.get(2));
	}

	@Test
	void testGetCoverPoints_SameY() throws Exception {
		final Line line = new Line(9, 7, 7, 7);
		final List<Point> coverPoints = line.getCoverPoints();

		assertEquals(3, coverPoints.size());
		assertEquals(new Point(7, 7), coverPoints.get(0));
		assertEquals(new Point(8, 7), coverPoints.get(1));
		assertEquals(new Point(9, 7), coverPoints.get(2));
	}

	@Test
	void testGetCoverPoints_DifferentXandY() throws Exception {
		final Line line = new Line(8, 0, 0, 8);
		final List<Point> coverPoints = line.getCoverPoints();

		assertEquals(0, coverPoints.size());
	}
}
