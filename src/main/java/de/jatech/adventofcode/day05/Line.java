package de.jatech.adventofcode.day05;

import java.util.ArrayList;
import java.util.List;

class Line {
	final Point start;
	final Point end;

	public Line(final int x1, final int y1, final int x2, final int y2) {
		this(new Point(x1, y1), new Point(x2, y2));
	}

	public Line(final Point start, final Point end) {
		this.start = start;
		this.end = end;
	}

	public List<Point> getCoverPoints() {
		final List<Point> result = new ArrayList<>();

		if (start.getX() == end.getX()) {
			int distance = Math.abs(start.getY() - end.getY());
			int lowerValue = Math.min(start.getY(), end.getY());

			for (int y = 0; y <= distance; y++) {
				result.add(new Point(start.getX(), y + lowerValue));
			}
		} else if (start.getY() == end.getY()) {
			int distance = Math.abs(start.getX() - end.getX());
			int lowerValue = Math.min(start.getX(), end.getX());

			for (int x = 0; x <= distance; x++) {
				result.add(new Point(x + lowerValue, start.getY()));
			}
		} else {
			int distanceX = Math.abs(start.getX() - end.getX());

			int directionX = start.getX() < end.getX() ? 1 : -1;
			int directionY = start.getY() < end.getY() ? 1 : -1;

			int x = start.getX();
			int y = start.getY();
			for (int distance = 0; distance <= distanceX; distance++) {
				result.add(new Point(x, y));
				x += directionX;
				y += directionY;
			}
		}
		return result;
	}

	public Point getStart() {
		return start;
	}

	public Point getEnd() {
		return end;
	}

	@Override
	public String toString() {
		return start + " -> " + end;
	}
}