package de.jatech.adventofcode;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class Day01Part1 {
	public static void main(final String[] args) throws IOException, URISyntaxException {
		final List<Integer> input = readList(Day01Part1.class.getClassLoader().getResource("input.txt"));

		for (final int i : input) {
			System.out.println(i);
		}

		int count = 0;
		for (int idx = 1; idx < input.size() - 2; idx++) {
			final int prevSum = input.get(idx - 1) + input.get(idx) + input.get(idx + 1);
			final int nextSum = input.get(idx) + input.get(idx + 1) + input.get(idx + 2);
			if (nextSum > prevSum) {
				count++;
			}
		}

		System.out.println("Counter: " + count);
	}

	private static List<Integer> readList(final URL url) throws IOException, URISyntaxException {
		final List<String> allLines = Files.readAllLines(Paths.get(url.toURI()));
		return allLines.stream().map(Integer::parseInt).collect(Collectors.toList());
	}
}
