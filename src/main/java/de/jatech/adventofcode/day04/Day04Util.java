package de.jatech.adventofcode.day04;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day04Util {
	public static List<Integer> parseIntegerToList(final String string, final String delimiter) {
		final Pattern pattern = Pattern.compile("(\\d+)");
		final Matcher matcher = pattern.matcher(string);

		final List<Integer> result = new ArrayList<>();
		while (matcher.find()) {
			result.add(Integer.parseInt(matcher.group(1)));
		}
		return result;
	}
}
