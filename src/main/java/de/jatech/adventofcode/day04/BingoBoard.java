package de.jatech.adventofcode.day04;

import java.util.List;

public class BingoBoard {
	private static final int NUMBER_OF_ROWS_COLS = 5;
	private final BoardEntry[][] board;

	public BingoBoard(final List<String> list) {
		board = new BoardEntry[NUMBER_OF_ROWS_COLS][NUMBER_OF_ROWS_COLS];
		for (int row = 0; row < NUMBER_OF_ROWS_COLS; row++) {
			final List<Integer> rowNumbers = Day04Util.parseIntegerToList(list.get(row), "\\s+");

			for (int col = 0; col < NUMBER_OF_ROWS_COLS; col++) {
				board[row][col] = new BoardEntry(rowNumbers.get(col));
			}
		}
	}

	public void markNumber(final int number) {
		for (int row = 0; row < NUMBER_OF_ROWS_COLS; row++) {
			for (int col = 0; col < NUMBER_OF_ROWS_COLS; col++) {
				BoardEntry boardEntry = board[row][col];
				if (boardEntry.getNumber() == number) {
					boardEntry.setChecked(true);
				}
			}
		}
	}

	public boolean hasWinningNumbers() {
		return hasWinningRow() || hasWinningCol();
	}

	public int sumUnmarkedNumbers() {
		int result = 0;
		for (int row = 0; row < NUMBER_OF_ROWS_COLS; row++) {
			for (int col = 0; col < NUMBER_OF_ROWS_COLS; col++) {
				if (!board[row][col].isChecked()) {
					result += board[row][col].getNumber();
				}
			}
		}
		return result;
	}

	private boolean hasWinningRow() {
		for (int row = 0; row < NUMBER_OF_ROWS_COLS; row++) {
			boolean result = true;
			for (int col = 0; col < NUMBER_OF_ROWS_COLS; col++) {
				result = result && board[row][col].isChecked();
			}
			if (result) {
				return result;
			}
		}
		return false;
	}

	private boolean hasWinningCol() {
		for (int col = 0; col < NUMBER_OF_ROWS_COLS; col++) {
			boolean result = true;
			for (int row = 0; row < NUMBER_OF_ROWS_COLS; row++) {
				result = result && board[row][col].isChecked();
			}
			if (result) {
				return result;
			}
		}
		return false;
	}

	public void printBoard() {
		for (int row = 0; row < NUMBER_OF_ROWS_COLS; row++) {
			for (int col = 0; col < NUMBER_OF_ROWS_COLS; col++) {
				final BoardEntry boardEntry = board[row][col];
				System.out.print(String.format("%02d%s ", boardEntry.getNumber(), boardEntry.printChecked()));
			}
			System.out.println();
		}
	}

	static class BoardEntry {
		private final int number;
		private boolean checked;

		BoardEntry(final int number) {
			this.number = number;
		}

		public int getNumber() {
			return number;
		}

		public void setChecked(final boolean checked) {
			this.checked = checked;
		}

		public boolean isChecked() {
			return checked;
		}

		public String printChecked() {
			return isChecked() ? "*" : " ";
		}
	}
}
