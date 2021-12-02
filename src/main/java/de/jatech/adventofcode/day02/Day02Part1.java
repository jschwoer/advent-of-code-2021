package de.jatech.adventofcode.day02;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import de.jatech.adventofcode.common.Utils;

public class Day02Part1 {
	public static void main(final String[] args) throws IOException, URISyntaxException {
		final List<String> input = Utils.readLinesFromFile("day02/input.txt");

		final int result = solvePuzzle(input);

		System.out.println("Result: " + result);
	}

	static int solvePuzzle(final List<String> input) {

		final int sumForward = input.stream().filter(s -> s.startsWith("forward"))
				.mapToInt(s -> Integer.parseInt(s.split(" ")[1])).sum();

		final int sumUp = input.stream().filter(s -> s.startsWith("up"))
				.mapToInt(s -> Integer.parseInt(s.split(" ")[1])).sum();

		final int sumDown = input.stream().filter(s -> s.startsWith("down"))
				.mapToInt(s -> Integer.parseInt(s.split(" ")[1])).sum();

		final int depth = sumDown - sumUp;

		return sumForward * depth;
	}
}
