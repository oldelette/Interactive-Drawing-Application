import java.awt.Color;

public abstract class MyOwnShape extends MyShape {

	private boolean filled;

	public MyOwnShape(int x1, int y1, int x2, int y2, Color color, boolean filled) {
		super(x1, y1, x2, y2, color);
		setFilled(filled);
	}

	public MyOwnShape() {
		this(0, 0, 0, 0, Color.BLACK, false);
	}

	public boolean isFilled() {
		return filled;
	}

	public void setFilled(boolean filled) {
		this.filled = filled;
	}

	public int getUpperLeftX() {
		return Math.min(super.getX1(), super.getX2());
	}

	public int getUpperLeftY() {
		return Math.min(super.getY1(), super.getY2());
	}

	public int getWidth() {
		return Math.abs(super.getX1() - super.getX2());
	}

	public int getHeight() {
		return Math.abs(super.getY1() - super.getY2());
	}

}