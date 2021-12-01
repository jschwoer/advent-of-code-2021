package de.jatech.adventofcode;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class Day01Part1 {
	public static void main(final String[] args) throws IOException, URISyntaxException {
		final List<Integer> input = readList("input.txt");

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

	static List<Integer> readList(final String inputName) throws IOException, URISyntaxException {
		final List<String> allLines = Files
				.readAllLines(Paths.get(Day01Part2.class.getClassLoader().getResource(inputName).toURI()));
		return allLines.stream().map(Integer::parseInt).collect(Collectors.toList());
	}
}
