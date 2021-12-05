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

	public List<Point> getCoverPoints(boolean considerVertical) {
		final List<Point> result = new ArrayList<>();
		
		if (start.getX() == end.getX()) {
			int distance = Math.abs(start.getY() - end.getY());
			int lowerValue = Math.min(start.getY(), end.getY());
			
			for (int y = 0; y <= distance; y++) {
				result.add(new Point(start.getX(), y + lowerValue));
			}
		} else {
			if (considerVertical || (start.getY() == end.getY())) {
				// y = ax + b
				int a = (end.getY() - start.getY()) / (end.getX() - start.getX());
				
				int ax = (a*start.getX());
				
				int b = start.getY() - ax;
				
				int lowerX = Math.min(start.getX(), end.getX());
				int upperX = Math.max(start.getX(), end.getX());
				for (int x = lowerX; x <= upperX; x++){
					int y = a*x+b;
					result.add(new Point(x, y));
				}
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