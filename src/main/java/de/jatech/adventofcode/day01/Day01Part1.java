package de.jatech.adventofcode.day01;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import de.jatech.adventofcode.common.Utils;

public class Day01Part1 {
	public static void main(final String[] args) throws IOException, URISyntaxException {
		final List<Integer> input = Utils.readListInt("day01/input.txt");

		for (final int i : input) {
			System.out.println(i);
		}

		final int count = solvePuzzle(input);

		System.out.println("Counter: " + count);
	}

	static int solvePuzzle(final List<Integer> input) {
		int count = 0;
		for (int idx = 1; idx < input.size(); idx++) {
			if (input.get(idx) > input.get(idx - 1)) {
				count++;
			}
		}
		return count;
	}
}
