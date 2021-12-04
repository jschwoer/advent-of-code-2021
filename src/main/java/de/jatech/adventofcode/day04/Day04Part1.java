package de.jatech.adventofcode.day04;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import de.jatech.adventofcode.common.Utils;

public class Day04Part1 {
	public static void main(final String[] args) throws IOException, URISyntaxException {
		final List<String> input = Utils.readLinesFromFile("day04/input.txt");

		final int result = solvePuzzle(input);

		System.out.println("Result: " + result);
	}

	static int solvePuzzle(final List<String> input) {
		final List<Integer> numbers = Day04Util.parseIntegerToList(input.get(0), ",");

		final List<BingoBoard> boards = new ArrayList<>();

		int currentInputIndex = 2;
		while (currentInputIndex < input.size()) {
			final BingoBoard board = new BingoBoard(input.subList(currentInputIndex, currentInputIndex + 5));
			boards.add(board);

			currentInputIndex += 6;
		}

		int winningNumber = 0;
		BingoBoard winningBoard = null;
		for (final int number : numbers) {
			for (final BingoBoard board : boards) {
				board.markNumber(number);

				if (board.hasWinningNumbers()) {
					winningNumber = number;
					winningBoard = board;
					break;
				}
			}
			if (winningBoard != null) {
				break;
			}
		}

		final int sumUnmarkedNumbers = winningBoard.sumUnmarkedNumbers();

		System.out.println("Winning number: " + winningNumber);
		System.out.println("Unmarked sum: " + sumUnmarkedNumbers);
		winningBoard.printBoard();

		return winningNumber * sumUnmarkedNumbers;
	}
}
