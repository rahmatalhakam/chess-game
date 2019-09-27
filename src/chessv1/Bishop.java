package chessv1;

public class Bishop {
	private String name;

	public Bishop(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isAllowed(int xNow, int yNow, int xMove, int yMove, String[][] board) {
		return new MoveLogic().diagonalMove(xNow, yNow, xMove, yMove, board);
	}

}
