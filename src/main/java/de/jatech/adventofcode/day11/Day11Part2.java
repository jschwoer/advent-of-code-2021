package de.jatech.adventofcode.day11;

import java.awt.Point;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import de.jatech.adventofcode.common.Utils;

public class Day11Part2 {
	public static void main(final String[] args) throws IOException, URISyntaxException {
		final List<String> input = Utils.readLinesFromFile("day11/input.txt");

		final long result = solvePuzzle(input);

		System.out.println("Result: " + result);
	}

	static long solvePuzzle(final List<String> input) {

		final int maxY = input.size();
		final int maxX = input.get(0).length();

		int[][] matrix = new int[maxY][maxX];

		for (int y = 0; y < maxY; y++) {
			for (int x = 0; x < maxX; x++) {
				matrix[y][x] = Integer.parseInt(String.valueOf(input.get(y).charAt(x)));
			}
		}

		long matrixSize = maxX * maxY;
		int allFlashStep = -1;

		int step = 0;
		while (allFlashStep < 0) {
			step++;

			for (int y = 0; y < matrix.length; y++) {
				for (int x = 0; x < matrix[y].length; x++) {
					matrix[y][x]++;
				}
			}

			flash(matrix);

			long flashesCount = 0;
			for (int y = 0; y < matrix.length; y++) {
				for (int x = 0; x < matrix[y].length; x++) {
					if (matrix[y][x] > 9) {
						flashesCount++;
						matrix[y][x] = 0;
					}
				}
			}

			if (flashesCount == matrixSize) {
				allFlashStep = step;
				break;
			}
		}

		return allFlashStep;
	}

	private static void flash(final int[][] matrix) {
		boolean flashagain = true;

		Set<Point> alreadyFlashed = new HashSet<>();

		while (flashagain) {
			flashagain = false;

			for (int y = 0; y < matrix.length; y++) {
				for (int x = 0; x < matrix[y].length; x++) {
					Point point = new Point(x, y);
					if (alreadyFlashed.contains(point)) {
						continue;
					}

					if (matrix[y][x] > 9) {
						alreadyFlashed.add(point);

						increaseValues(matrix, y, x);
						flashagain = true;
					}
				}
			}
		}
	}

	private static void increaseValues(final int[][] matrix, final int y, final int x) {
		matrix[y][x]++;

		// vertical
		if (y > 0) {
			matrix[y - 1][x]++;
		}
		if (y < matrix.length - 1) {
			matrix[y + 1][x]++;
		}

		// horizontal
		if (x > 0) {
			matrix[y][x - 1]++;
		}
		if (x < matrix[y].length - 1) {
			matrix[y][x + 1]++;
		}

		// diagonal 1
		if (y > 0 && x > 0) {
			matrix[y - 1][x - 1]++;
		}
		if (y < matrix.length - 1 && x < matrix[y].length - 1) {
			matrix[y + 1][x + 1]++;
		}

		// diagonal 2
		if (y > 0 && x < matrix[y].length - 1) {
			matrix[y - 1][x + 1]++;
		}
		if (y < matrix.length - 1 && x > 0) {
			matrix[y + 1][x - 1]++;
		}
	}

	private static void printMatrix(final int[][] matrix) {
		for (int[] element : matrix) {
			for (int element2 : element) {
				System.out.print(String.format("%02d ", element2));
			}
			System.out.println();
		}
	}
}
