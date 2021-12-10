package de.jatech.adventofcode.day10;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import de.jatech.adventofcode.common.Utils;

public class Day10Part1 {
	public static void main(final String[] args) throws IOException, URISyntaxException {
		final List<String> input = Utils.readLinesFromFile("day10/input.txt");

		final long result = solvePuzzle(input);

		System.out.println("Result: " + result);
	}

	static long solvePuzzle(final List<String> input) {
		Map<String, String> patterns = Map.of("(", ")", "[", "]", "{", "}", "<", ">");

		List<String> illegalChars = new ArrayList<>();

		Stack<String> openChunks = new Stack<>();
		for (String s : input) {
			openChunks.clear();

			for (char c : s.toCharArray()) {
				String currentChar = String.valueOf(c);

				if (patterns.containsKey(currentChar)) {
					openChunks.push(currentChar);
				} else {
					String lastBracket = openChunks.pop();

					if (!patterns.get(lastBracket).equals(currentChar)) {
						illegalChars.add(currentChar);
						break;
					}
				}
			}
		}

		long count1 = illegalChars.stream().filter(s -> s.equals(")")).count() * 3;
		long count2 = illegalChars.stream().filter(s -> s.equals("]")).count() * 57;
		long count3 = illegalChars.stream().filter(s -> s.equals("}")).count() * 1197;
		long count4 = illegalChars.stream().filter(s -> s.equals(">")).count() * 25137;
		long sum = count1 + count2 + count3 + count4;

		return sum;
	}
}
