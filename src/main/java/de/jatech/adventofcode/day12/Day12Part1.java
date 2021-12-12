package de.jatech.adventofcode.day12;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import de.jatech.adventofcode.common.Utils;

public class Day12Part1 {
	public static void main(final String[] args) throws IOException, URISyntaxException {
		final List<String> input = Utils.readLinesFromFile("day12/input.txt");

		final long result = solvePuzzle(input);

		System.out.println("Result: " + result);
	}

	static long solvePuzzle(final List<String> input) {

		Map<String, Cave> caves = new HashMap<>();
		for (String s : input) {
			String[] startEnd = s.split("-");

			Cave startCave = caves.get(startEnd[0]);
			if (startCave == null) {
				startCave = new Cave(startEnd[0]);
				caves.put(startCave.getName(), startCave);
			}

			Cave endCave = caves.get(startEnd[1]);
			if (endCave == null) {
				endCave = new Cave(startEnd[1]);
				caves.put(endCave.getName(), endCave);
			}

			startCave.addCave(endCave);
			endCave.addCave(startCave);
		}

		List<List<Cave>> paths = findPaths(caves.get("start"), caves.get("end"), caves);
		for (List<Cave> path : paths) {
			System.out.println(path);
		}

		return paths.size();
	}

	private static List<List<Cave>> findPaths(final Cave startCave, final Cave endCave, final Map<String, Cave> caves) {
		List<List<Cave>> allPaths = new ArrayList<>();

		Set<Cave> visited = new HashSet<>();
		List<Cave> pathList = new ArrayList<>();
		pathList.add(startCave);

		findAllPaths(startCave, endCave, visited, pathList, allPaths);

		return allPaths;
	}

	private static void findAllPaths(final Cave start, final Cave end, final Set<Cave> visitedCaves,
			final List<Cave> localPathList, final List<List<Cave>> allPaths) {

		if (start.equals(end)) {
			System.out.println(localPathList);
			allPaths.add(new ArrayList<>(localPathList));
			return;
		}

		if (start.isSmallCave()) {
			visitedCaves.add(start);
		}

		for (Cave i : start.getNextCaves()) {
			if (!visitedCaves.contains(i)) {
				localPathList.add(i);

				findAllPaths(i, end, visitedCaves, localPathList, allPaths);

				localPathList.remove(i);
			}
		}

		visitedCaves.remove(start);
	}

	static class Cave {
		private String name;
		private boolean smallCave;
		private boolean startCave;
		private boolean endCave;

		private List<Cave> nextCaves = new ArrayList<>();

		public Cave(final String name) {
			this.name = name;
			this.smallCave = name.equals(name.toLowerCase());

			startCave = name.equals("start");
			endCave = name.equals("end");
		}

		public String getName() {
			return name;
		}

		public boolean isSmallCave() {
			return smallCave;
		}

		public boolean isStartCave() {
			return startCave;
		}

		public boolean isEndCave() {
			return endCave;
		}

		public void addCave(final Cave node) {
			nextCaves.add(node);
		}

		public List<Cave> getNextCaves() {
			return nextCaves;
		}

		@Override
		public String toString() {
			return getName();
		}
	}
}
