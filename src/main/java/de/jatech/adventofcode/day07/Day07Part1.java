package de.jatech.adventofcode.day07;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import de.jatech.adventofcode.common.Utils;

public class Day07Part1 {
	public static void main(final String[] args) throws IOException, URISyntaxException {
		final List<String> input = Utils.readLinesFromFile("day07/input.txt");

		final long result = solvePuzzle(input);

		System.out.println("Result: " + result);
	}

	static long solvePuzzle(final List<String> input) {
		int[] numbers = Arrays.stream(input.get(0).split(",")).mapToInt(Integer::parseInt).toArray();

		Arrays.sort(numbers);

		final int median;
		if (numbers.length % 2 == 0)
		{
			// even
			int idx = numbers.length / 2;
			median = ((numbers[idx-1] + numbers[idx])) / 2;
		}
		else{
			// odd
			int idx = (numbers.length + 1) / 2;
			median = numbers[idx -1];
		}
		
		int sum = Arrays.stream(numbers).map(i -> Math.abs(i - median)).sum();
		System.out.println("Median: " + median);
		System.out.println("Sum: " +  sum);

		return sum;
	}
}
