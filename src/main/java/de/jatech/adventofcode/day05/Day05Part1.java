package de.jatech.adventofcode.day05;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.OptionalInt;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import de.jatech.adventofcode.common.Utils;

public class Day05Part1 {
	public static void main(final String[] args) throws IOException, URISyntaxException {
		final List<String> input = Utils.readLinesFromFile("day05/input.txt");

		final long result = solvePuzzle(input);

		System.out.println("Result: " + result);
	}

	static long solvePuzzle(final List<String> input) {
		List<Line> lines = parseLines(input);
		for (Line line : lines) {
			System.out.println(line);
		}

		Map<Point, Integer> heatMap = new HashMap<>();
		for (Line line : lines) {
			List<Point> coverPoints = line.getCoverPoints(false);
			for (Point point : coverPoints) {
				Integer value = heatMap.get(point);
				if (value == null) {
					value = 0;
				}

				heatMap.put(point, ++value);
			}
		}

		printMap(lines, heatMap);

		long count = heatMap.values().stream().filter(x -> x > 1).count();

		return count;
	}

	private static void printMap(final List<Line> lines, final Map<Point, Integer> heatMap) {
		OptionalInt maxX = lines.stream().mapToInt(l -> Math.max(l.getStart().getX(), l.getEnd().getX())).max();
		OptionalInt maxY = lines.stream().mapToInt(l -> Math.max(l.getStart().getY(), l.getEnd().getY())).max();

		for (int y = 0; y <= maxY.getAsInt(); y++) {
			for (int x = 0; x <= maxX.getAsInt(); x++) {
				Point point = new Point(x, y);
				Integer value = heatMap.get(point);
				if (value != null) {
					System.out.print(value);
				} else {
					System.out.print(".");
				}
			}
			System.out.println();
		}
	}

	private static List<Line> parseLines(final List<String> input) {
		Pattern pattern = Pattern.compile("(\\d+),(\\d+) -\\> (\\d+),(\\d+)");
		List<Line> result = new ArrayList<>();

		for (String s : input) {
			Matcher matcher = pattern.matcher(s);
			if (matcher.matches()) {
				Point startPoint = new Point(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2)));
				Point endPoint = new Point(Integer.parseInt(matcher.group(3)), Integer.parseInt(matcher.group(4)));
				Line line = new Line(startPoint, endPoint);
				result.add(line);
			}
		}
		return result;
	}
}
