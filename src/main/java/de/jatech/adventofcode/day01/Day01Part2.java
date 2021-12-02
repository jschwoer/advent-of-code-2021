package de.jatech.adventofcode.day01;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import de.jatech.adventofcode.common.Utils;

public class Day01Part2 {
	public static void main(final String[] args) throws IOException, URISyntaxException {
		final List<Integer> input = Utils.readListInt("input.txt");

		for (final int i : input) {
			System.out.println(i);
		}

		final int count = solvePuzzle(input);

		System.out.println("Counter: " + count);
	}

	static int solvePuzzle(final List<Integer> input) {
		int count = 0;
		for (int idx = 1; idx < input.size() - 2; idx++) {
			final int prevSum = getSlidingWindow(input, idx - 1);
			final int nextSum = getSlidingWindow(input, idx);
			if (nextSum > prevSum) {
				count++;
			}
		}
		return count;
	}

	private static Integer getSlidingWindow(final List<Integer> input, final int startIndex) {
		return input.subList(startIndex, startIndex + 2).stream().mapToInt(e -> e).sum();
	}
}
