package de.jatech.adventofcode.day10;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import de.jatech.adventofcode.common.Utils;

public class Day10Part2 {
	public static void main(final String[] args) throws IOException, URISyntaxException {
		final List<String> input = Utils.readLinesFromFile("day10/input.txt");

		final long result = solvePuzzle(input);

		System.out.println("Result: " + result);
	}

	static long solvePuzzle(final List<String> input) {
		Map<String, String> patterns = Map.of("(", ")", "[", "]", "{", "}", "<", ">");
		Map<String, Integer> patternScore = Map.of(")", 1, "]", 2, "}", 3, ">", 4);

		List<String> illegalChars = new ArrayList<>();
		List<String> completionStrings = new ArrayList<>();
		List<Long> scores = new ArrayList<>();

		Stack<String> openChunks = new Stack<>();
		for (String s : input) {
			openChunks.clear();
			boolean corrupted = false;

			for (char c : s.toCharArray()) {
				String currentChar = String.valueOf(c);

				if (patterns.containsKey(currentChar)) {
					openChunks.push(currentChar);
				} else {
					String lastBracket = openChunks.pop();

					if (!patterns.get(lastBracket).equals(currentChar)) {
						illegalChars.add(currentChar);
						corrupted = true;
						break;
					}
				}
			}

			if (!corrupted) {
				long score = 0;

				StringBuilder completion = new StringBuilder();
				while (!openChunks.isEmpty()) {
					String closing = patterns.get(openChunks.pop());
					completion.append(closing);

					Integer charScore = patternScore.get(closing);
					score *= 5;
					score += charScore;
				}
				completionStrings.add(completion.toString());
				scores.add(score);
			}
		}

		Collections.sort(scores);
		int middleIdx = scores.size() / 2;
		long result = scores.get(middleIdx);

		return result;
	}
}
