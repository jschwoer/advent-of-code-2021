package de.jatech.adventofcode.day14;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import de.jatech.adventofcode.common.Utils;

public class Day14Part1 {
	public static void main(final String[] args) throws IOException, URISyntaxException {
		final List<String> input = Utils.readLinesFromFile("day14/input.txt");

		final long result = solvePuzzle(input);

		System.out.println("Result: " + result);
	}

	static long solvePuzzle(final List<String> input) {

		Map<String, String> rules = new HashMap<>();
		String template = input.get(0);

		Pattern pattern = Pattern.compile("(\\w\\w) -> (\\w)");
		for (String s : input) {
			Matcher matcher = pattern.matcher(s);
			if (matcher.matches()) {
				rules.put(matcher.group(1), matcher.group(2));
			}
		}

		String processed = template;
		for (int step = 0; step < 10; step++) {
			processed = process(processed, rules);
			System.out.println(processed);
		}

		Map<String, Long> histogram = new HashMap<>();
		for (int idx = 0; idx < processed.length(); idx++) {
			char c = processed.charAt(idx);
			if (!histogram.containsKey(String.valueOf(c))) {
				long count = processed.chars().filter(i -> i == c).count();
				histogram.put(String.valueOf(c), count);
			}
		}

		System.out.println(histogram);

		long min = histogram.values().stream().mapToLong(l -> l).min().getAsLong();
		long max = histogram.values().stream().mapToLong(l -> l).max().getAsLong();

		return max - min;
	}

	private static String process(final String template, final Map<String, String> rules) {
		StringBuilder result = new StringBuilder();

		for (int idx = 0; idx < template.length() - 1; idx++) {
			String pair = template.substring(idx, idx + 2);
			if (rules.containsKey(pair)) {
				if (idx == 0) {
					result.append(pair.charAt(0));
				}
				result.append(rules.get(pair));
				result.append(pair.charAt(1));
			}
		}

		return result.toString();
	}
}
