package de.jatech.adventofcode.day02;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import de.jatech.adventofcode.common.Utils;

public class Day02Part2 {
	public static void main(final String[] args) throws IOException, URISyntaxException {
		final List<String> input = Utils.readLinesFromFile("day02/input.txt");

		final int result = solvePuzzle(input);

		System.out.println("Result: " + result);
	}

	static int solvePuzzle(final List<String> input) {
		int aim = 0;
		int depth = 0;
		int position = 0;

		for (final String s : input) {
			final String[] values = s.split(" ");
			final String command = values[0];
			final int value = Integer.parseInt(values[1]);

			switch (command) {
				case "down" -> aim += value;
				case "up" -> aim -= value;
				case "forward" -> {
					position += value;
					depth = depth + aim * value;
				}
			}
		}

		return depth * position;
	}
}
