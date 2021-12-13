package de.jatech.adventofcode.day13;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import de.jatech.adventofcode.common.Utils;

public class Day13Part1 {
	public static void main(final String[] args) throws IOException, URISyntaxException {
		final List<String> input = Utils.readLinesFromFile("day13/input.txt");

		final long result = solvePuzzle(input);

		System.out.println("Result: " + result);
	}

	static long solvePuzzle(final List<String> input) {

		Set<Point> dots = new HashSet<>();
		int sectionStart = 0;
		for (String s : input) {
			if (s.isEmpty()) {
				break;
			}

			sectionStart++;

			String[] coords = s.split(",");
			Point dot = new Point(Integer.parseInt(coords[0]), Integer.parseInt(coords[1]));
			dots.add(dot);
		}

		Paper paper = new Paper(dots);

		List<FoldInstruction> instructions = new ArrayList<>();
		Pattern pattern = Pattern.compile("fold along (x|y)=(\\d+)");
		for (int idx = sectionStart + 1; idx < input.size(); idx++) {
			Matcher matcher = pattern.matcher(input.get(idx));
			if (matcher.matches()) {
				FoldInstruction instruction = new FoldInstruction(matcher.group(1).equals("y"),
						Integer.parseInt(matcher.group(2)));
				instructions.add(instruction);
			}
		}

		paper.print();
		for (FoldInstruction instruction : instructions) {
			System.out.println(instruction);
		}

		System.out.println("------");
		Paper foldedPaper = foldPaper(paper, instructions.get(0));
		foldedPaper.print();

		return foldedPaper.getDots().size();
	}

	private static Paper foldPaper(final Paper paper, final FoldInstruction foldInstruction) {
		Set<Point> result = new HashSet<>();

		for (Point dot : paper.getDots()) {
			if (foldInstruction.isFoldHorizontal()) {
				if (dot.getY() < foldInstruction.getValue()) {
					result.add(dot);
				} else {
					int newY = foldInstruction.getValue() * 2 - dot.getY();
					Point foldedDot = new Point(dot.getX(), newY);
					result.add(foldedDot);
				}
			} else if (dot.getX() < foldInstruction.getValue()) {
				result.add(dot);
			} else {
				int newX = foldInstruction.getValue() * 2 - dot.getX();
				Point foldedDot = new Point(newX, dot.getY());
				result.add(foldedDot);
			}
		}

		Paper newPaper = new Paper(result);
		if (foldInstruction.isFoldHorizontal()) {
			newPaper.setMaxX(paper.getMaxX());
			newPaper.setMaxY(paper.getMaxY() / 2 - 1);
		} else {
			newPaper.setMaxX(paper.getMaxX() / 2 - 1);
			newPaper.setMaxY(paper.getMaxY());
		}
		return newPaper;
	}

	public static class Paper {
		private Set<Point> dots;
		private int maxX;
		private int maxY;

		public Paper(final Set<Point> dots) {
			this.dots = new HashSet<>(dots);
			maxX = dots.stream().mapToInt(Point::getX).max().getAsInt();
			maxY = dots.stream().mapToInt(Point::getY).max().getAsInt();
		}

		public void setMaxX(final int maxX) {
			this.maxX = maxX;
		}

		public int getMaxX() {
			return maxX;
		}

		public void setMaxY(final int maxY) {
			this.maxY = maxY;
		}

		public int getMaxY() {
			return maxY;
		}

		public Set<Point> getDots() {
			return dots;
		}

		private void print() {
			for (int y = 0; y <= maxY; y++) {
				for (int x = 0; x <= maxX; x++) {
					Point dot = new Point(x, y);
					String value = dots.contains(dot) ? "#" : ".";
					System.out.print(value);
				}
				System.out.println();
			}
		}
	}

	static class FoldInstruction {
		final boolean foldHorizontal;
		final int value;

		public FoldInstruction(final boolean foldHorizontal, final int value) {
			this.foldHorizontal = foldHorizontal;
			this.value = value;
		}

		public boolean isFoldHorizontal() {
			return foldHorizontal;
		}

		public int getValue() {
			return value;
		}

		@Override
		public String toString() {
			String x = foldHorizontal ? "x" : "y";
			return "fold along " + x + "=" + value;
		}
	}

	static class Point {
		final int x;
		final int y;

		public Point(final int x, final int y) {
			this.x = x;
			this.y = y;
		}

		public int getX() {
			return x;
		}

		public int getY() {
			return y;
		}

		@Override
		public int hashCode() {
			return Objects.hash(x, y);
		}

		@Override
		public boolean equals(final Object obj) {
			if (this == obj) {
				return true;
			}
			if (obj == null || getClass() != obj.getClass()) {
				return false;
			}
			Point other = (Point) obj;
			return x == other.x && y == other.y;
		}
	}
}
