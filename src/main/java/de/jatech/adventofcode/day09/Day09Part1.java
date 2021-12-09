package de.jatech.adventofcode.day09;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import de.jatech.adventofcode.common.Utils;

public class Day09Part1 {
	public static void main(final String[] args) throws IOException, URISyntaxException {
		final List<String> input = Utils.readLinesFromFile("day09/input.txt");

		final long result = solvePuzzle(input);

		System.out.println("Result: " + result);
	}

	static long solvePuzzle(final List<String> input) {
		int maxY = input.size();
		int maxX = input.get(0).length();

		int[][] heightMap = new int[maxY + 2][maxX + 2];
		for (int[] element : heightMap) {
			Arrays.fill(element, Integer.MAX_VALUE);
		}

		for (int y = 0; y < maxY; y++) {
			for (int x = 0; x < maxX; x++) {
				heightMap[y + 1][x + 1] = Integer.parseInt(String.valueOf(input.get(y).charAt(x)));
			}
		}

		printHeightMap(heightMap);

		List<Integer> lowPoints = new ArrayList<>();
		for (int y = 1; y <= maxY; y++) {
			for (int x = 1; x <= maxX; x++) {
				int leftValue = heightMap[y][x - 1];
				int rightValue = heightMap[y][x + 1];
				int topValue = heightMap[y - 1][x];
				int bottomValue = heightMap[y + 1][x];

				int height = heightMap[y][x];

				if (leftValue > height && rightValue > height && topValue > height && bottomValue > height) {
					lowPoints.add(height);
				}
			}
		}

		int sum = lowPoints.stream().map(i -> i + 1).mapToInt(i -> i).sum();

		return sum;
	}

	private static void printHeightMap(final int[][] heightMap) {
		for (int y = 1; y < heightMap.length - 1; y++) {
			for (int x = 1; x < heightMap[y].length - 1; x++) {
				System.out.print(heightMap[y][x]);
			}
			System.out.println();
		}
	}
}
