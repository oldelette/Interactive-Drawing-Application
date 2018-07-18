import java.awt.Color;
import java.awt.Graphics;

public class MyOval extends MyOwnShape {

	public MyOval(int x1, int y1, int x2, int y2, Color color, boolean filled) {
		super(x1, y1, x2, y2, color, filled);
	}

	public MyOval() {
		super();
	}

	
	@Override
	public void draw(Graphics g) {
		g.setColor(super.getColor());
		if (super.isFilled() == true)
			g.fillOval(getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight());
		else
			g.drawOval(getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight());
	}

}