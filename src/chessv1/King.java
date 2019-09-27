package chessv1;

public class King {
	private String name;

	public King(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isAllowed(int xNow, int yNow, int xMove, int yMove, String[][] board) {
		return new MoveLogic().kingMove(xNow, yNow, xMove, yMove, board);
	}
}
