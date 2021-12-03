package de.jatech.adventofcode.day03;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;

import de.jatech.adventofcode.common.Utils;

public class Day03Part2 {
	public static void main(final String[] args) throws IOException, URISyntaxException {
		final List<String> input = Utils.readLinesFromFile("day03/input.txt");

		final int result = solvePuzzle(input);

		System.out.println("Result: " + result);
	}

	static int solvePuzzle(final List<String> input) {

		final int numberOfBits = input.get(0).length();

		List<String> oxygenList = input;
		while (oxygenList.size() > 1) {
			for (int idx = 0; idx < numberOfBits; idx++) {
				if (oxygenList.size() == 1) {
					break;
				}
				final int index = idx;

				final long count0 = oxygenList.stream().filter(s -> s.charAt(index) == '0').count();
				final long count1 = oxygenList.size() - count0;

				if (count0 > count1) {
					oxygenList = oxygenList.stream().filter(s -> s.charAt(index) == '0').collect(Collectors.toList());
				} else {
					oxygenList = oxygenList.stream().filter(s -> s.charAt(index) == '1').collect(Collectors.toList());
				}
			}
		}

		List<String> co2List = input;
		while (co2List.size() > 1) {
			for (int idx = 0; idx < numberOfBits; idx++) {
				if (co2List.size() == 1) {
					break;
				}
				final int index = idx;

				final long count0 = co2List.stream().filter(s -> s.charAt(index) == '0').count();
				final long count1 = co2List.size() - count0;

				if (count0 > count1) {
					co2List = co2List.stream().filter(s -> s.charAt(index) == '1').collect(Collectors.toList());
				} else {
					co2List = co2List.stream().filter(s -> s.charAt(index) == '0').collect(Collectors.toList());
				}
			}
		}

		final int oxygenRating = Integer.parseInt(oxygenList.get(0), 2);
		final int co2Rating = Integer.parseInt(co2List.get(0), 2);

		return oxygenRating * co2Rating;
	}
}
