package de.jatech.adventofcode.day08;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.jatech.adventofcode.common.Utils;

public class Day08Part1 {
	public static void main(final String[] args) throws IOException, URISyntaxException {
		final List<String> input = Utils.readLinesFromFile("day08/input.txt");

		final long result = solvePuzzle(input);

		System.out.println("Result: " + result);
	}

	static long solvePuzzle(final List<String> input) {
		Map<Integer, Integer> histogram = new HashMap<>();
		for (String line : input) {
			String[] splittedLine = line.split("\\|");
			String outputValues = splittedLine[1];

			for (String value : outputValues.split(" ")) {
				int length = value.length();

				switch (length) {
					case 2:
						add(histogram, 1);
						break;
					case 3:
						add(histogram, 7);
						break;
					case 4:
						add(histogram, 4);
						break;
					case 7:
						add(histogram, 8);
						break;
				}
			}
		}

		long sum = histogram.values().stream().mapToInt(i -> i).sum();
		System.out.println("Sum: " + sum);

		return sum;
	}

	private static void add(final Map<Integer, Integer> histogram, final int i) {
		Integer value = histogram.get(i);
		if (value == null) {
			value = 0;
		}

		value += 1;
		histogram.put(i, value);
	}
}
