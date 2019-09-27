package chessv1;

public class Knight {
	private String name;

	public Knight(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isAllowed(int xNow, int yNow, int xMove, int yMove, String[][] board) {
		return new MoveLogic().knightMove(xNow, yNow, xMove, yMove, board);

	}

}
