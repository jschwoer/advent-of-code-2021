package de.jatech.adventofcode.day08;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.jatech.adventofcode.common.Utils;

public class Day08Part2 {
	public static void main(final String[] args) throws IOException, URISyntaxException {
		final List<String> input = Utils.readLinesFromFile("day08/input.txt");

		final long result = solvePuzzle(input);

		System.out.println("Result: " + result);
	}

	static long solvePuzzle(final List<String> input) {
		long sum = 0;
		for (String line : input) {
			String[] splittedLine = line.split("\\|");
			String patterns = splittedLine[0];
			String outputValues = splittedLine[1];

			Map<Integer, String> valueToPatternMap = findPatterns(patterns.split(" "));
			String leftOver = subtract(valueToPatternMap.get(4), valueToPatternMap.get(1));

			String number = "";
			for (String pattern : outputValues.split(" ")) {
				switch (pattern.length()) {
					case 2:
						number = number + "1";
						break;
					case 3:
						number = number + "7";
						break;
					case 4:
						number = number + "4";
						break;
					case 7:
						number = number + "8";
						break;
					case 6:
						if (!contains(pattern, valueToPatternMap.get(1))) {
							number = number + "6";
						} else if (contains(pattern, valueToPatternMap.get(4))) {
							number = number + "9";
						} else {
							number = number + "0";
						}
						break;
					case 5:
						if (contains(pattern, valueToPatternMap.get(1))) {
							number = number + "3";
						} else if (contains(pattern, leftOver)) {
							number = number + "5";
						} else {
							number = number + "2";
						}
						break;
				}
			}

			System.out.println("number: " + number);
			sum += Integer.parseInt(number);
		}

		System.out.println("Sum: " + sum);

		return sum;
	}

	private static String subtract(final String string, final String remove) {
		StringBuilder result = new StringBuilder();
		char[] chars = string.toCharArray();
		for (char c : chars) {
			if (remove.indexOf(c) == -1) {
				result.append(c);
			}
		}
		return result.toString();
	}

	private static boolean contains(final String pattern, final String string) {
		for (char c : string.toCharArray()) {
			if (pattern.indexOf(c) == -1) {
				return false;
			}
		}
		return true;
	}

	private static Map<Integer, String> findPatterns(final String[] strings) {
		Map<Integer, String> result = new HashMap<>();
		for (String value : strings) {
			int length = value.length();

			switch (length) {
				case 2:
					result.put(1, value);
					break;
				case 3:
					result.put(7, value);
					break;
				case 4:
					result.put(4, value);
					break;
				case 7:
					result.put(8, value);
					break;
			}
		}
		return result;
	}
}
