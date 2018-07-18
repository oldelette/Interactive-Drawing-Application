import java.awt.Color;
import java.awt.Graphics;

public class MyLine extends MyShape{
	

	public MyLine(int x1, int y1, int x2, int y2, Color color) {
		super(x1, y1, x2, y2, color);
	}
	

	public MyLine(){
		super();
	}


	@Override
	public void draw(Graphics g) {
		g.setColor(super.getColor());
		g.drawLine(super.getX1(), super.getY1(), super.getX2(), super.getY2());
	}
} 