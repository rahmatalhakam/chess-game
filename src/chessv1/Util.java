package chessv1;

public class Util {
	public boolean isBlack(String name) {
		try {
			StringBuilder sBuilder = new StringBuilder(name);
			if (sBuilder.reverse().substring(0, 1).equals("b")) {
				return true;
			} else
				return false;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}

	}

	public String changeColor(String name) {
		if (name.equals("bishop1w"))
			return "bishop1b";
		else if (name.equals("bishop2w"))
			return "bishop2b";
		else if (name.equals("bishop1b"))
			return "bishop1w";
		else if (name.equals("bishop2b"))
			return "bishop2w";
		else if (isBlack(name))
			return name.replace("b", "w");
		else
			return name.replace("w", "b");

	}

	public int[] getKingCoordinate(String name, String[][] board) {
		int x = 0, y = 0;

		if (new Util().isBlack(name)) {
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					if (board[i][j] == null) {
						continue;
					}
					if (board[i][j].equals("king1w")) {
						x = i;
						y = j;
					}
				}
			}
		} else {
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					if (board[i][j] == null) {
						continue;
					}
					if (board[i][j].equals("king1b")) {
						x = i;
						y = j;
					}
				}
			}
		}
		int[] a = { x, y };
		return a;
	}

	public String getRealName(String name) {
		StringBuilder sBuilder = new StringBuilder(name);
		String newName = sBuilder.substring(0, name.length() - 2);

		return newName;
	}

	public boolean eatOrNot(String[][] board, int xNow, int yNow, int xMove, int yMove) {
		boolean resultNow = isBlack(board[xNow][yNow]);
		boolean resultMove = isBlack(board[xMove][yMove]);
		if (board[xMove][yMove] == null) {
			return true;
		}
		if (resultNow != resultMove) {
			return true;
		} else {
			return false;
		}
	}

	public static void addMoveDescription(String name, int xNow, int yNow, int xMove, int yMove) {
		Board.description += "The " + name + " went from [" + xNow + "][" + yNow + "] to [" + xMove + "][" + yMove
				+ "].\n";
	}

	public static void addEatDescription(String name1, String name2) {
		Board.description += "\nThe " + name2 + " was eaten by " + name1 + ".\n";
	}

	public static void addCheckedDescription() {
		Board.description += "\nChecked king.\n";
	}

	public static void addToGraveyard(String name) {
		Util util = new Util();
		if (util.isBlack(name)) {
			Board.setBlackGraveyard(new Board().chessStyle(name) + ".");
		} else {
			Board.setWhiteGraveyard(new Board().chessStyle(name) + ".");

		}
	}

	public String compareKingAndPieces(String kingName, String pieceName) {
		if (isBlack(kingName) && !isBlack(pieceName)) {
			return pieceName;
		} else if (!isBlack(kingName) && isBlack(pieceName)) {
			return pieceName;
		} else
			return null;
	}

}
