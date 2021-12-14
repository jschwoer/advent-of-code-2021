package de.jatech.adventofcode.day14;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import de.jatech.adventofcode.common.Utils;

public class Day14Part2 {
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

		Map<String, Long> pairs = findPairs(template);
		for (int step = 0; step < 40; step++) {
			pairs = processPairs(pairs, rules);
		}

		Map<String, Long> histogram = new HashMap<>();

		histogram.put(template.substring(template.length() - 1, template.length()), 1L);

		for (String pair : pairs.keySet()) {
			String s1 = pair.substring(0, 1);

			Long value1 = histogram.get(s1);
			if (value1 == null) {
				value1 = 0L;
			}
			value1 += pairs.get(pair);
			histogram.put(s1, value1);
		}

		System.out.println(histogram);

		long min = histogram.values().stream().mapToLong(l -> l).min().getAsLong();
		long max = histogram.values().stream().mapToLong(l -> l).max().getAsLong();

		return max - min;
	}

	private static Map<String, Long> processPairs(final Map<String, Long> pairs, final Map<String, String> rules) {
		Map<String, Long> result = new HashMap<>();
		for (String s : pairs.keySet()) {
			if (rules.containsKey(s)) {
				String addString = rules.get(s);
				String pair1 = s.substring(0, 1) + addString;
				String pair2 = addString + s.substring(1, 2);

				Long value1 = pairs.get(s);
				if (value1 == null) {
					value1 = 0L;
				}
				Long long1 = result.getOrDefault(pair1, 0L);
				result.put(pair1, long1 + value1);

				Long value2 = pairs.get(s);
				if (value2 == null) {
					value2 = 0L;
				}
				Long long2 = result.getOrDefault(pair2, 0L);
				result.put(pair2, long2 + value2);
			}
		}
		return result;
	}

	private static Map<String, Long> findPairs(final String template) {
		Map<String, Long> result = new HashMap<>();
		for (int idx = 0; idx < template.length() - 1; idx++) {
			String pair = template.substring(idx, idx + 2);
			Long value = result.get(pair);
			if (value == null) {
				value = 0L;
			}
			result.put(pair, ++value);
		}

		return result;
	}
}
