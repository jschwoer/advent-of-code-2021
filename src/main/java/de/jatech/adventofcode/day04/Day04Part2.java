package de.jatech.adventofcode.day04;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import de.jatech.adventofcode.common.Utils;

public class Day04Part2 {
	public static void main(final String[] args) throws IOException, URISyntaxException {
		final List<String> input = Utils.readLinesFromFile("day04/input.txt");

		final int result = solvePuzzle(input);

		System.out.println("Result: " + result);
	}

	static int solvePuzzle(final List<String> input) {
		final List<Integer> numbers = Day04Util.parseIntegerToList(input.get(0), ",");

		List<BingoBoard> boards = new ArrayList<>();

		int currentInputIndex = 2;
		while (currentInputIndex < input.size()) {
			final BingoBoard board = new BingoBoard(input.subList(currentInputIndex, currentInputIndex + 5));
			boards.add(board);

			currentInputIndex += 6;
		}

		int lastWinningNumber = 0;
		BingoBoard lastWinningBoard = null;
		for (final int number : numbers) {
			boards.stream().forEach(b -> b.markNumber(number));

			final Optional<BingoBoard> first = boards.stream().filter(BingoBoard::hasWinningNumbers).findFirst();
			if (first.isPresent()) {
				lastWinningNumber = number;
				lastWinningBoard = first.get();
			}

			boards = boards.stream().filter(b -> !b.hasWinningNumbers()).collect(Collectors.toList());

			if (boards.isEmpty()) {
				break;
			}
		}

		final int sumUnmarkedNumbers = lastWinningBoard.sumUnmarkedNumbers();

		System.out.println("Winning number: " + lastWinningNumber);
		System.out.println("Unmarked sum: " + sumUnmarkedNumbers);
		lastWinningBoard.printBoard();

		return lastWinningNumber * sumUnmarkedNumbers;
	}
}
