package de.jatech.adventofcode.day07;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import de.jatech.adventofcode.common.Utils;

public class Day07Part2 {
	public static void main(final String[] args) throws IOException, URISyntaxException {
		final List<String> input = Utils.readLinesFromFile("day07/input.txt");

		final long result = solvePuzzle(input);

		System.out.println("Result: " + result);
	}

	static long solvePuzzle(final List<String> input) {
		int[] numbers = Arrays.stream(input.get(0).split(",")).mapToInt(Integer::parseInt).toArray();

		System.out.println("Length: " + numbers.length);
		int total = Arrays.stream(numbers).sum();
		// example inout
		int average = (int)Math.floor((total / numbers.length) + 1);
		// solution input
		// int average = (int)Math.floor((total / numbers.length));

		System.out.println("Total: " + total);
		System.out.println("Avg: " + average);
		
		int sum = Arrays.stream(numbers).map(i -> sumOfNumbers(Math.abs(i - average))).sum();
		System.out.println("Sum: " +  sum);

		return sum;
	}

	private static int sumOfNumbers(int value)
	{
		int result = (value * (value + 1)) / 2;
		return result;
	}

	private static String asStringList(final int[] numbers) {
		return Arrays.stream(numbers).mapToObj(String::valueOf).collect(Collectors.joining(","));
	}
}
