package chess;

public class Rook {
	private String name;

	public Rook(String name) {
		this.setName(name);
	}

	public boolean isAllowed(int xNow, int yNow, int xMove, int yMove, String[][] board) {
		return new MoveLogic().horizontalAndVerticalMove(xNow, yNow, xMove, yMove, board);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
