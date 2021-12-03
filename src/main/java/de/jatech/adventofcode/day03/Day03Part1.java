package de.jatech.adventofcode.day03;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import de.jatech.adventofcode.common.Utils;

public class Day03Part1 {
	public static void main(final String[] args) throws IOException, URISyntaxException {
		final List<String> input = Utils.readLinesFromFile("day03/input.txt");

		final int result = solvePuzzle(input);

		System.out.println("Result: " + result);
	}

	static int solvePuzzle(final List<String> input) {

		final int numberOfBits = input.get(0).length();

		final StringBuilder gammaString = new StringBuilder();
		final StringBuilder epsilonString = new StringBuilder();

		for (int idx = 0; idx < numberOfBits; idx++) {
			final int index = idx;
			final long count0 = input.stream().filter(s -> s.charAt(index) == '0').count();
			final long count1 = input.size() - count0;

			if (count0 > count1) {
				gammaString.append("0");
				epsilonString.append("1");
			} else {
				gammaString.append("1");
				epsilonString.append("0");
			}
		}

		final int gamma = Integer.parseInt(gammaString.toString(), 2);
		final int epsilon = Integer.parseInt(epsilonString.toString(), 2);

		return gamma * epsilon;
	}
}
