package chessv1;

public class Board {

	// kurang checkmate

	private String[][] board = new String[8][8];
	private int xNow, yNow, xMove, yMove;
	private char prevTurn = 'w';
	private boolean firstTurn = true;
	private static String whiteGraveyard = "    .", blackGraveyard = "    .";
	static String description = "";
	static boolean isGameOver = false, checkedKing = false;

	Board b;

	public int getxNow() {
		return xNow;
	}

	public void setxNow(int xNow) {
		this.xNow = xNow;
	}

	public int getyNow() {
		return yNow;
	}

	public void setyNow(int yNow) {
		this.yNow = yNow;
	}

	public int getxMove() {
		return xMove;
	}

	public void setxMove(int xMove) {
		this.xMove = xMove;
	}

	public int getyMove() {
		return yMove;
	}

	public void setyMove(int yMove) {
		this.yMove = yMove;
	}

	public char getPrevTurn() {
		return prevTurn;
	}

	public void setPrevTurn(char prevTurn) {
		this.prevTurn = prevTurn;
	}

	public boolean isFirstTurn() {
		return firstTurn;
	}

	public void setFirstTurnExecuted(boolean firstTurn) {
		this.firstTurn = firstTurn;
	}

	public Board() {
	}

	public Board(int xNow, int yNow, int xMove, int yMove) {
		this.xNow = xNow;
		this.yNow = yNow;
		this.xMove = xMove;
		this.yMove = yMove;

	}

	public void initGame() {
		board[0][0] = "rook1b";
		board[0][1] = "knight1b";
		board[0][2] = "bishop1b";
		board[0][3] = "king1b";
		board[0][4] = "queen1b";
		board[0][5] = "bishop2b";
		board[0][6] = "knight2b";
		board[0][7] = "rook2b";
		board[1][0] = "pawn1b";
		board[1][1] = "pawn2b";
		board[1][2] = "pawn3b";
		board[1][3] = "pawn4b";
		board[1][4] = "pawn5b";
		board[1][5] = "pawn6b";
		board[1][6] = "pawn7b";
		board[1][7] = "pawn8b";

		board[6][0] = "pawn1w";
		board[6][1] = "pawn2w";
		board[6][2] = "pawn3w";
		board[6][3] = "pawn4w";
		board[6][4] = "pawn5w";
		board[6][5] = "pawn6w";
		board[6][6] = "pawn7w";
		board[6][7] = "pawn8w";
		board[7][0] = "rook1w";
		board[7][1] = "knight1w";
		board[7][2] = "bishop1w";
		board[7][3] = "king1w";
		board[7][4] = "queen1w";
		board[7][5] = "bishop2w";
		board[7][6] = "knight2w";
		board[7][7] = "rook2w";
//
//		board[2][0] = "";
//		board[2][1] = "";
//		board[2][2] = "";
//		board[2][3] = "";
//		board[2][4] = "";
//		board[2][5] = "";
//		board[2][6] = "";
//		board[2][7] = "";
//		board[3][0] = "";
//		board[3][1] = "";
//		board[3][2] = "";
//		board[3][3] = "";
//		board[3][4] = "";
//		board[3][5] = "";
//		board[3][6] = "";
//		board[3][7] = "";
//		board[4][0] = "";
//		board[4][1] = "";
//		board[4][2] = "";
//		board[4][3] = "";
//		board[4][4] = "";
//		board[4][5] = "";
//		board[4][6] = "";
//		board[4][7] = "";
//		board[5][0] = "";
//		board[5][1] = "";
//		board[5][2] = "";
//		board[5][3] = "";
//		board[5][4] = "";
//		board[5][5] = "";
//		board[5][6] = "";
//		board[5][7] = "";

	}

	public void move(int xNow, int yNow, int xMove, int yMove) {
		setxNow(xNow);
		setyNow(yNow);
		setxMove(xMove);
		setyMove(yMove);
		String nameString = getName(xNow, yNow);
//		int[] a = new Util().getKingCoordinate(nameString, board);
//		System.out.println(a);

		if (isCoordinateValid(xNow, yNow) && isCoordinateValid(xMove, yMove) && isMove()) {
			if (isCorrectTurn()) {
				if (piece(nameString)) {
					setNewLocation(nameString, xNow, yNow, xMove, yMove);
					int[] a = new Util().getKingCoordinate(new Util().changeColor(nameString), board);
					new MoveLogic().checkedKing(a[0], a[1], board);
					setNewLocation(nameString, xMove, yMove, xNow, yNow);
					if (checkedKing == false) {
						Util.addMoveDescription(new Util().getRealName(nameString), xNow, yNow, xMove, yMove);
						if (board[xMove][yMove] != null) {
							Util.addEatDescription(new Util().getRealName(board[xNow][yNow]),
									new Util().getRealName(board[xMove][yMove]));
							Util.addToGraveyard(board[xMove][yMove]);
						}
						setNewLocation(nameString, xNow, yNow, xMove, yMove);
						a = new Util().getKingCoordinate(nameString, board);
						new MoveLogic().checkedKing(a[0], a[1], board);
						getAllLocation();
					} else {
						if (getPrevTurn() == 'w') {
							setPrevTurn('b');
						} else {
							setPrevTurn('w');
						}
						System.out.println("=====================");
						System.out.println(
								"your move cannot be executed because of checked king. Try to protect the king!");
					}

				} else {
					if (getPrevTurn() == 'w') {
						setPrevTurn('b');
					} else {
						setPrevTurn('w');
					}
					System.out.println("=====================");
					System.out.println("your move cannot be executed!");
				}
			} else {
				System.out.println("=====================");
				System.out.println("it is not your turn, give the turn to your opponent!");
			}
		} else
			System.out.println("Wrong inputs!");
		if (whiteGraveyard.contains("K") || blackGraveyard.contains("K")) {
			System.out.println("Game Over, the winner is the");
			if (whiteGraveyard.contains("K")) {
				System.out.print(" BLACK TEAM! :)");
			} else {
				System.out.println(" WHITE TEAM! :)");
			}
			isGameOver = true;
		}
	}

	public boolean piece(String name) {
		try {
			if (name.contains("pawn")) {
				Pawn pawn = new Pawn(name);
				boolean isBlack = new Util().isBlack(name);
				if (pawn.isAllowed(xNow, yNow, xMove, yMove, isBlack, board))
					return true;
				else
					return false;
			} else if (name.contains("rook")) {
				Rook rook = new Rook(name);
				if (rook.isAllowed(xNow, yNow, xMove, yMove, board))
					return true;
				return false;
			} else if (name.contains("knight")) {
				Knight knight = new Knight(name);
				if (knight.isAllowed(xNow, yNow, xMove, yMove, board))
					return true;
				return false;

			} else if (name.contains("bishop")) {
				Bishop bishop = new Bishop(name);
				if (bishop.isAllowed(xNow, yNow, xMove, yMove, board))
					return true;
				return false;
			} else if (name.contains("queen")) {
				Queen queen = new Queen();
				if (queen.isAllowed(xNow, yNow, xMove, yMove, board))
					return true;
				else
					return false;
			} else if (name.contains("king")) {
				King king = new King(name);
				if (king.isAllowed(xNow, yNow, xMove, yMove, board))
					return true;
				return false;
			} else
				return false;
		} catch (Exception e) {
			return false;
		}

	}

	public String chessStyle(String pieceName) {
		if (pieceName == null)
			return " ";
		else if (pieceName.contains("rook"))
			return "R";
		else if (pieceName.contains("knight"))
			return "H";
		else if (pieceName.contains("bishop"))
			return "B";
		else if (pieceName.contains("queen"))
			return "Q";
		else if (pieceName.contains("king"))
			return "K";
		else
			return "P";

	}

	public void getAllLocation() {
		System.out.println("=====================");
		System.out.println("          BLACK      ");
		System.out.println();
		System.out.println("     0.1.2.3.4.5.6.7.");
		System.out.println();
		if (whiteGraveyard.length() > 5)
			System.out.println(whiteGraveyard);

		System.out.println("    .................");
		for (int i = 0; i < board.length; i++) {
			System.out.print(i + "   ");
			for (int j = 0; j < board.length; j++) {
				System.out.print("." + chessStyle(board[i][j]));
			}
			System.out.print(".");
			System.out.println();
		}
		System.out.println("    .................");
		if (blackGraveyard.length() != 5)
			System.out.println(blackGraveyard);
		System.out.println();
		System.out.println("          WHITE      ");
		System.out.println();
		System.out.println(description);
		System.out.println("=====================");
	}

	public void setNewLocation(String name, int xNow, int yNow, int xMove, int yMove) {
		board[xMove][yMove] = name;
		board[xNow][yNow] = null;
	}

	public boolean isCoordinateValid(int x, int y) {
		if (x >= 0 && x <= 7 && y >= 0 && y <= 7)
			return true;
		else
			return false;
	}

	public boolean isMove() {
		if (xMove == xNow && yMove == yNow)
			return false;
		return true;
	}

	public boolean isCorrectTurn() {
		boolean isBlack = new Util().isBlack(board[getxNow()][getyNow()]);
		if (isFirstTurn()) {
			if (!isBlack) {
				setFirstTurnExecuted(false);
				return true;
			} else
				return false;
		} else if (getPrevTurn() == 'w') {
			if (isBlack) {
				setPrevTurn('b');
				return true;
			} else
				return false;
		} else if (getPrevTurn() == 'b') {
			if (!isBlack) {
				setPrevTurn('w');
				return true;
			} else
				return false;
		} else
			return false;
	}

	public String getName(int x, int y) {
		return board[x][y];
	}

	public static String getWhiteGraveyard() {
		return whiteGraveyard;
	}

	public static void setWhiteGraveyard(String whiteGraveyard) {
		Board.whiteGraveyard += whiteGraveyard;
	}

	public static String getBlackGraveyard() {
		return blackGraveyard;
	}

	public static void setBlackGraveyard(String blackGraveyard) {
		Board.blackGraveyard += blackGraveyard;
	}

}
