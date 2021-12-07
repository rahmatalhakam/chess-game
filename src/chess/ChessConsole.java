package chess;

import java.util.Scanner;

public class ChessConsole {
	public static void main(String[] args) {

		int xNow, yNow, xMove, yMove;
		String input;
		char[] splitResult;
		Board board = new Board(0, 0, 0, 0);
		board.initGame();
		board.getAllLocation();
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		while (!Board.isGameOver) {
			System.out.println(
					"Input cell to be moved (x Now, y Now) and move to (x Move, y Move) => format(xNow, yNow, xMove, yMove)");
			try {
				input = scanner.nextLine();
				splitResult = input.toCharArray();
				if (splitResult.length != 4)
					throw new Exception();
				xNow = Character.getNumericValue(splitResult[0]);
				yNow = Character.getNumericValue(splitResult[1]);
				xMove = Character.getNumericValue(splitResult[2]);
				yMove = Character.getNumericValue(splitResult[3]);
				board.move(xNow, yNow, xMove, yMove);
			} catch (Exception e) {
				System.out.println("wrong input! try again");
				System.out.println(e.getMessage());
				e.printStackTrace();
				System.exit(0);
			}

		}
	}
}