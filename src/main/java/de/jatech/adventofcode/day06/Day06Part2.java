package de.jatech.adventofcode.day06;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import de.jatech.adventofcode.common.Utils;

public class Day06Part2 {
	public static void main(final String[] args) throws IOException, URISyntaxException {
		final List<String> input = Utils.readLinesFromFile("day06/input.txt");

		final long result = solvePuzzle(input, 256);

		System.out.println("Result: " + result);
	}

	static long solvePuzzle(final List<String> input, final int numberOfDays) {
		int[] numbers = Arrays.stream(input.get(0).split(",")).mapToInt(Integer::parseInt).toArray();

		Map<Integer, Long> ageToNumber = new HashMap<>();
		for (int number : numbers) {
			long currentValue = ageToNumber.getOrDefault(number, 0L);
			ageToNumber.put(number, currentValue + 1);
		}

		System.out.println(String.format("Initial state: %s", asStringList(numbers)));
		for (int day = 1; day <= numberOfDays; day++) {
			long fishToAdd = ageToNumber.get(0) == null ? 0 : ageToNumber.get(0);

			for (int age = 0; age <= 8; age++) {
				ageToNumber.put(age, ageToNumber.get(age + 1));
			}

			if (fishToAdd > 0) {
				ageToNumber.put(8, fishToAdd);

				Long value6 = ageToNumber.get(6) == null ? 0 : ageToNumber.get(6);
				ageToNumber.put(6, value6 + fishToAdd);
			}
			System.out.println(String.format("After %02d days: %s", day, ageToNumber.toString()));
		}

		long sum = ageToNumber.values().stream().filter(Objects::nonNull).mapToLong(l -> l).sum();

		System.out.println("Total: " + sum);
		return sum;
	}

	private static String asStringList(final int[] numbers) {
		return Arrays.stream(numbers).mapToObj(String::valueOf).collect(Collectors.joining(","));
	}
}
