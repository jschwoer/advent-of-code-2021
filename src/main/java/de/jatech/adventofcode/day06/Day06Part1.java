package de.jatech.adventofcode.day06;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import de.jatech.adventofcode.common.Utils;

public class Day06Part1 {
	public static void main(final String[] args) throws IOException, URISyntaxException {
		final List<String> input = Utils.readLinesFromFile("day06/input.txt");

		final long result = solvePuzzle(input, 80);

		System.out.println("Result: " + result);
	}

	static long solvePuzzle(final List<String> input, final int numberOfDays) {
		int[] numbers = Arrays.stream(input.get(0).split(",")).mapToInt(Integer::parseInt).toArray();

		System.out.println(String.format("Initial state: %s", asStringList(numbers)));
		for (int day = 0; day < numberOfDays; day++) {
			int fishToAdd = 0;

			for (int idx = 0; idx < numbers.length; idx++) {
				if (numbers[idx] == 0) {
					numbers[idx] = 6;
					fishToAdd++;
				} else {
					numbers[idx]--;
				}
			}

			if (fishToAdd > 0) {
				int[] updatedNumbers = new int[numbers.length + fishToAdd];
				System.arraycopy(numbers, 0, updatedNumbers, 0, numbers.length);
				Arrays.fill(updatedNumbers, numbers.length, updatedNumbers.length, 8);
				numbers = updatedNumbers;
			}

//			System.out.println(String.format("After %02d days: %s", day, asStringList(numbers)));
		}

		System.out.println("Total: " + numbers.length);
		return numbers.length;
	}

	private static String asStringList(final int[] numbers) {
		return Arrays.stream(numbers).mapToObj(String::valueOf).collect(Collectors.joining(","));
	}
}
