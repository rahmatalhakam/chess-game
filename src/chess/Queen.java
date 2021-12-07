package chess;

public class Queen {

	public boolean isAllowed(int xNow, int yNow, int xMove, int yMove, String[][] board) {
		boolean diagonalMoveResult = new MoveLogic().diagonalMove(xNow, yNow, xMove, yMove, board);
		boolean horizontalAndVertivalMoveResult = new MoveLogic().horizontalAndVerticalMove(xNow, yNow, xMove, yMove,
				board);
		if (diagonalMoveResult)
			return true;
		else if (horizontalAndVertivalMoveResult)
			return true;
		else
			return false;

	}
}
