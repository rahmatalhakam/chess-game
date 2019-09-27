package chessv1;

import java.util.ArrayList;

public class MoveLogic {

	public boolean diagonalMove(int xNow, int yNow, int xMove, int yMove, String[][] board) {
		if (xNow != xMove && yNow != yMove) {
			int maks = -1;
			int maks2 = -1;
			if ((xMove > xNow && yMove > yNow)) {
				int iteration = xMove - xNow;
				for (int i = 1; i <= iteration; i++) {
					maks = xNow + i;
					maks2 = yNow + i;
					if (board[xNow + i][yNow + i] != null) {
						break;
					}
				}
				if (xMove <= maks && yMove <= maks2) {
					return new Util().eatOrNot(board, xNow, yNow, xMove, yMove);
				} else
					return false;
			}
			if ((xMove < xNow && yMove < yNow)) {
				int iteration = xNow - xMove;
				for (int i = 1; i <= iteration; i++) {
					maks = xNow - i;
					maks2 = yNow - i;
					if (board[xNow - i][yNow - i] != null) {
						break;
					}
				}
				if (xMove >= maks && yMove >= maks2) {
					return new Util().eatOrNot(board, xNow, yNow, xMove, yMove);
				} else
					return false;
			}
			if (xMove > xNow && yMove < yNow) {
				int iteration = xMove - xNow;
				for (int i = 1; i <= iteration; i++) {
					maks = xNow + i;
					maks2 = yNow - i;
					if (board[xNow + i][yNow - i] != null) {
						break;
					}

				}
				if (xMove <= maks && yMove >= maks2) {
					return new Util().eatOrNot(board, xNow, yNow, xMove, yMove);
				} else
					return false;
			}
			if (xMove < xNow && yMove > yNow) {
				int iteration = yMove - yNow;
				for (int i = 1; i <= iteration; i++) {
					maks = xNow - i;
					maks2 = yNow + i;
					if (board[xNow - i][yNow + i] != null) {
						break;
					}
				}
				if (xMove >= maks && yMove <= maks2) {
					return new Util().eatOrNot(board, xNow, yNow, xMove, yMove);
				} else
					return false;
			} else
				return false;
		} else
			return false;
	}

	public boolean horizontalAndVerticalMove(int xNow, int yNow, int xMove, int yMove, String[][] board) {
		int maksX = -1;
		int maksY = -1;
		if (xNow == xMove || yNow == yMove) {
			if (xNow != xMove) {
				if (xNow > xMove) {
					for (int i = xNow - 1; i >= xMove; i--) {
						if (board[i][yMove] != null) {
							maksX = i;
							break;
						} else
							maksX = i;
					}
				} else {
					for (int i = xNow + 1; i <= xMove; i++) {
						if (board[i][yMove] != null) {
							maksX = i;
							break;
						} else
							maksX = i;
					}
				}
				if (xMove <= maksX) {
					return new Util().eatOrNot(board, xNow, yNow, xMove, yMove);
				} else
					return false;
			} else {
				if (yMove > yNow) {
					for (int i = yNow + 1; i <= yMove; i++) {
						if (board[xMove][i] != null) {
							maksY = i;
							break;
						} else
							maksY = i;
					}
				} else {
					for (int i = yNow - 1; i >= yMove; i--) {
						if (board[xMove][i] != null) {
							maksY = i;
							break;
						} else
							maksY = i;
					}
				}
				if (yMove <= maksY) {
					return new Util().eatOrNot(board, xNow, yNow, xMove, yMove);
				} else
					return false;
			}
		} else
			return false;
	}

	public boolean kingMove(int xNow, int yNow, int xMove, int yMove, String[][] board) {
		if (Math.abs(xMove - xNow) > 1 || Math.abs(yMove - yNow) > 1)
			return false;
		else
			return new Util().eatOrNot(board, xNow, yNow, xMove, yMove);
	}

	public boolean pawnMove(int xNow, int yNow, int xMove, int yMove, Boolean isBlack, String[][] board) {
		Util util = new Util();
		if (isBlack) {
			if ((xMove == xNow + 1 && yMove == yNow + 1) || (xMove == xNow + 1 && yMove == yNow - 1)) {
				if (board[xMove][yMove] == null)
					return false;
				else {
					return util.eatOrNot(board, xNow, yNow, xMove, yMove);
				}
			} else if (xMove - xNow == 1 && yNow == yMove) {
				if (board[xMove][yMove] == null)
					return true;
				else
					return false;
			} else if (xMove - xNow == 2 && yNow == yMove) {
				if (xNow == 1) {
					if (board[xMove][yMove] == null)
						return true;
					else
						return false;
				} else
					return false;
			} else
				return false;
		} else {
			if (xMove - xNow == -1 && yNow == yMove) {
				if (board[xMove][yMove] == null)
					return true;
				else
					return false;
			} else if (xMove - xNow == -2 && yNow == yMove) {
				if (xNow == 6) {
					if (board[xMove][yMove] == null)
						return true;
					else
						return false;
				} else
					return false;
			} else if ((xMove == xNow - 1 && yMove == yNow - 1) || (xMove == xNow - 1 && yMove == yNow + 1)) {
				if (board[xMove][yMove] == null)
					return false;
				else {
					return util.eatOrNot(board, xNow, yNow, xMove, yMove);
				}
			} else
				return false;
		}
	}

	public boolean knightMove(int xNow, int yNow, int xMove, int yMove, String[][] board) {
		int checkXMove1 = xNow + 1;
		int checkXMove2 = xNow + 2;
		int checkXMove3 = xNow - 1;
		int checkXMove4 = xNow - 2;

		int checkYMove1 = yNow + 1;
		int checkYMove2 = yNow + 2;
		int checkYMove3 = yNow - 1;
		int checkYMove4 = yNow - 2;

		if (xMove == checkXMove1 && yMove == checkYMove2)
			return new Util().eatOrNot(board, xNow, yNow, xMove, yMove);
		else if (xMove == checkXMove2 && yMove == checkYMove1)
			return new Util().eatOrNot(board, xNow, yNow, xMove, yMove);
		else if (xMove == checkXMove2 && yMove == checkYMove3)
			return new Util().eatOrNot(board, xNow, yNow, xMove, yMove);
		else if (xMove == checkXMove1 && yMove == checkYMove4)
			return new Util().eatOrNot(board, xNow, yNow, xMove, yMove);
		else if (xMove == checkXMove3 && yMove == checkYMove4)
			return new Util().eatOrNot(board, xNow, yNow, xMove, yMove);
		else if (xMove == checkXMove4 && yMove == checkYMove3)
			return new Util().eatOrNot(board, xNow, yNow, xMove, yMove);
		else if (xMove == checkXMove4 && yMove == checkYMove1)
			return new Util().eatOrNot(board, xNow, yNow, xMove, yMove);
		else if (xMove == checkXMove3 && yMove == checkYMove2)
			return new Util().eatOrNot(board, xNow, yNow, xMove, yMove);
		else
			return false;

	}

	public boolean isThereAnyKnight(int xNow, int yNow, String[][] board) {
		Util util = new Util();
		ArrayList<PieceModel> pieceModels = new ArrayList<PieceModel>();

		boolean checkCoordinate = new Board().isCoordinateValid(xNow, yNow);
		if (!checkCoordinate) {
			return false;
		}
		int checkXMove1 = xNow + 1;
		int checkXMove2 = xNow + 2;
		int checkXMove3 = xNow - 1;
		int checkXMove4 = xNow - 2;

		int checkYMove1 = yNow + 1;
		int checkYMove2 = yNow + 2;
		int checkYMove3 = yNow - 1;
		int checkYMove4 = yNow - 2;

		boolean check1 = new Board().isCoordinateValid(checkXMove1, checkYMove2);
		boolean check2 = new Board().isCoordinateValid(checkXMove2, checkYMove1);
		boolean check3 = new Board().isCoordinateValid(checkXMove2, checkYMove3);
		boolean check4 = new Board().isCoordinateValid(checkXMove1, checkYMove4);
		boolean check5 = new Board().isCoordinateValid(checkXMove3, checkYMove4);
		boolean check6 = new Board().isCoordinateValid(checkXMove4, checkYMove3);
		boolean check7 = new Board().isCoordinateValid(checkXMove4, checkYMove1);
		boolean check8 = new Board().isCoordinateValid(checkXMove3, checkYMove2);
		try {

			if (check1)
				if (board[checkXMove1][checkYMove2] != null)
					if (board[checkXMove1][checkYMove2].contains("knight")) {
						String okei = util.compareKingAndPieces(board[xNow][yNow], board[checkXMove1][checkYMove2]);
						if (okei != null) {
							pieceModels.add(new PieceModel(board[checkXMove1][checkYMove2], checkXMove1, checkYMove2));
						}
					}
			if (check2)
				if (board[checkXMove2][checkYMove1] != null)
					if (board[checkXMove2][checkYMove1].contains("knight")) {
						String okei = util.compareKingAndPieces(board[xNow][yNow], board[checkXMove2][checkYMove1]);
						if (okei != null) {
							pieceModels.add(new PieceModel(board[checkXMove2][checkYMove1], checkXMove2, checkYMove1));
						}
					}
			if (check3)
				if (board[checkXMove2][checkYMove3] != null)
					if (board[checkXMove2][checkYMove3].contains("knight")) {
						String okei = util.compareKingAndPieces(board[xNow][yNow], board[checkXMove2][checkYMove3]);
						if (okei != null) {
							pieceModels.add(new PieceModel(board[checkXMove2][checkYMove3], checkXMove2, checkYMove3));
						}
					}
			if (check4)
				if (board[checkXMove1][checkYMove4] != null)
					if (board[checkXMove1][checkYMove4].contains("knight")) {
						String okei = util.compareKingAndPieces(board[xNow][yNow], board[checkXMove1][checkYMove4]);
						if (okei != null) {
							pieceModels.add(new PieceModel(board[checkXMove1][checkYMove4], checkXMove1, checkYMove4));
						}
					}
			if (check5)
				if (board[checkXMove3][checkYMove4] != null)
					if (board[checkXMove3][checkYMove4].contains("knight")) {
						String okei = util.compareKingAndPieces(board[xNow][yNow], board[checkXMove3][checkYMove4]);
						if (okei != null) {
							pieceModels.add(new PieceModel(board[checkXMove3][checkYMove4], checkXMove4, checkYMove3));
						}
					}
			if (check6)
				if (board[checkXMove4][checkYMove3] != null)
					if (board[checkXMove4][checkYMove3].contains("knight")) {
						String okei = util.compareKingAndPieces(board[xNow][yNow], board[checkXMove4][checkYMove3]);
						if (okei != null) {
							pieceModels.add(new PieceModel(board[checkXMove4][checkYMove3], checkXMove4, checkYMove3));
						}
					}
			if (check7)
				if (board[checkXMove4][checkYMove1] != null)
					if (board[checkXMove4][checkYMove1].contains("knight")) {
						String okei = util.compareKingAndPieces(board[xNow][yNow], board[checkXMove4][checkYMove1]);
						if (okei != null) {
							pieceModels.add(new PieceModel(board[checkXMove4][checkYMove1], checkXMove4, checkYMove1));
						}
					}
			if (check8)
				if (board[checkXMove3][checkYMove2] != null)
					if (board[checkXMove3][checkYMove2].contains("knight")) {
						String okei = util.compareKingAndPieces(board[xNow][yNow], board[checkXMove3][checkYMove2]);
						if (okei != null) {
							pieceModels.add(new PieceModel(board[checkXMove3][checkYMove2], checkXMove3, checkYMove2));
						}
					}
			boolean result = isCheckedByOpponent(pieceModels, xNow, yNow, board);
			return result;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			e.printStackTrace();
			return false;
		}

	}

	public boolean addThereAnyHorAndVerPiece(int xNow, int yNow, String[][] board) {
		Util util = new Util();
		ArrayList<PieceModel> pieceModels = new ArrayList<PieceModel>();

		// for ke bawah
		for (int i = 1; i < 8; i++) {
			if (xNow + i > 7)
				break;
			else {
				if (board[xNow + i][yNow] != null) {
					String okei = util.compareKingAndPieces(board[xNow][yNow], board[xNow + i][yNow]);
					if (okei != null) {
						pieceModels.add(new PieceModel(board[xNow + i][yNow], xNow + i, yNow));
					}
					break;

				}
			}
		}
		// for ke atas
		for (int i = 1; i < 8; i++) {
			if (xNow - i < 0)
				break;
			else {
				if (board[xNow - i][yNow] != null) {
					String okei = util.compareKingAndPieces(board[xNow][yNow], board[xNow - i][yNow]);
					if (okei != null) {
						pieceModels.add(new PieceModel(board[xNow - i][yNow], xNow - i, yNow));
					}
					break;
				}
			}
		}
		// for ke kanan
		for (int i = 1; i < 8; i++) {
			if (yNow + i > 7)
				break;
			else {
				if (board[xNow][yNow + i] != null) {
					String okei = util.compareKingAndPieces(board[xNow][yNow], board[xNow][yNow + i]);
					if (okei != null) {
						pieceModels.add(new PieceModel(board[xNow][yNow + i], xNow, yNow + i));
					}
					break;
				}
			}
		}
		// for ke kiri
		for (int i = 1; i < 8; i++) {
			if (yNow - i < 0)
				break;
			else {
				if (board[xNow][yNow - i] != null) {
					String okei = util.compareKingAndPieces(board[xNow][yNow], board[xNow][yNow - i]);
					if (okei != null) {
						pieceModels.add(new PieceModel(board[xNow][yNow - i], xNow, yNow - i));
					}
					break;
				}
			}
		}
		// for ke diagonal kanan atas
		for (int i = 1; i < 8; i++) {
			if (yNow + i > 7 || xNow - i < 0)
				break;
			else {
				if (board[xNow - i][yNow + i] != null) {
					String okeiString = util.compareKingAndPieces(board[xNow][yNow], board[xNow - i][yNow + i]);
					if (okeiString != null) {
						pieceModels.add(new PieceModel(board[xNow - i][yNow + i], xNow - i, yNow + i));
					}
					break;
				}
			}
		}
		// for ke diagonal kanan bawah
		for (int i = 1; i < 8; i++) {
			if (yNow + i > 7 || xNow + i > 7)
				break;
			else {
				if (board[xNow + i][yNow + i] != null) {
					String okeiString = util.compareKingAndPieces(board[xNow][yNow], board[xNow + i][yNow + i]);
					if (okeiString != null) {
						pieceModels.add(new PieceModel(board[xNow + i][yNow + i], xNow + i, yNow + i));
					}
					break;
				}
			}
		}
		// for ke diagonal kiri atas
		for (int i = 1; i < 8; i++) {
			if (yNow - i < 0 || xNow - i < 0)
				break;
			else {
				if (board[xNow - i][yNow - i] != null) {
					String okeiString = util.compareKingAndPieces(board[xNow][yNow], board[xNow - i][yNow - i]);
					if (okeiString != null) {
						pieceModels.add(new PieceModel(board[xNow - i][yNow - i], xNow - i, yNow - i));
					}
					break;
				}
			}
		}
		// for ke diagonal kiri bawah
		for (int i = 1; i < 8; i++) {
			if (xNow + i > 7 || yNow - i < 0)
				break;
			else {
				if (board[xNow + i][yNow - i] != null) {
					String okeiString = util.compareKingAndPieces(board[xNow][yNow], board[xNow + i][yNow - i]);
					if (okeiString != null) {
						pieceModels.add(new PieceModel(board[xNow + i][yNow - i], xNow + i, yNow - i));
					}
					break;
				}
			}
		}
		boolean result = isCheckedByOpponent(pieceModels, xNow, yNow, board);
		return result;
	}

	public boolean isCheckedByOpponent(ArrayList<PieceModel> pieceModels, int xKing, int yKing, String[][] board) {
		for (PieceModel pieceModel : pieceModels) {
			System.out.println(pieceModel.getName());
			boolean result = checkPiece(pieceModel.getName(), pieceModel.getX(), pieceModel.getY(), xKing, yKing,
					board);
			if (result) {
				return true;
			}
		}
		return false;
	}

	public boolean checkPiece(String name, int xNow, int yNow, int xMove, int yMove, String[][] board) {
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
			} else
				return false;
		} catch (Exception e) {
			return false;
		}
	}

	public void checkedKing(int xNow, int yNow, String[][] board) {
		if (isThereAnyKnight(xNow, yNow, board) || addThereAnyHorAndVerPiece(xNow, yNow, board)) {
			Util.addCheckedDescription();
			Board.checkedKing = true;
		} else {
			Board.checkedKing = false;
		}

	}
}
