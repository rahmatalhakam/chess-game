package chessv1;

public class PieceModel {
	private String name;
	private Integer x, y;

	public PieceModel(String name, Integer x, Integer y) {
		// TODO Auto-generated constructor stub
		if (name == null || x == null || y == null)
			return;
		this.name = name;
		this.setX(x);
		this.setY(y);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getX() {
		return x;
	}

	public void setX(Integer x) {
		this.x = x;
	}

	public Integer getY() {
		return y;
	}

	public void setY(Integer y) {
		this.y = y;
	}

}
