package chessv1;

public class Pawn {
	private String name;

	public Pawn(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isAllowed(int xNow, int yNow, int xMove, int yMove, boolean isBlack, String[][] board) {
		return new MoveLogic().pawnMove(xNow, yNow, xMove, yMove, isBlack, board);
	}
}
