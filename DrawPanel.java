import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class DrawPanel extends JPanel {

	MyShape[] shapes;
	int shapeCount,shapeType;
	MyShape currentShape;
	Color currentColor;
	boolean filledShape;
	JLabel statusLabel;

	public DrawPanel(JLabel label) {
		statusLabel = label;
		shapes = new MyShape[100];
		shapeCount = 0;
		shapeType = 0;
		currentShape = null;
		currentColor = Color.BLACK;
		setBackground(Color.WHITE);
		MouseHandler handler = new MouseHandler();
		addMouseListener(handler);
		addMouseMotionListener(handler);
	}

	public void setShapeType(int shapeType) {
		this.shapeType = shapeType;
	}

	public void setCurrentColor(Color currentColor) {
		this.currentColor = currentColor;
	}

	public void setFilledShape(boolean filledShape) {
		this.filledShape = filledShape;
	}

	public void clearLastShape() {
		if (shapeCount > 0)
			shapeCount--;
		repaint();
	}

	public void clearDrawing() {
		shapeCount = 0;
		repaint();
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (int i = 0; i < shapeCount; i++) {
			shapes[i].draw(g);
		}
		if (currentShape != null) {
			currentShape.draw(g);
		}
	}

	private class MouseHandler extends MouseAdapter implements MouseMotionListener {

		@Override
		public void mousePressed(MouseEvent e) {
			if (shapeType == 0) {
				currentShape = new MyLine(e.getX(), e.getY(), e.getX(), e.getY(), currentColor);
			} else if (shapeType == 1) {
				currentShape = new MyOval(e.getX(), e.getY(), e.getX(), e.getY(), currentColor, filledShape);
			} else if (shapeType == 2) {
				currentShape = new MyRectangle(e.getX(), e.getY(), e.getX(), e.getY(), currentColor, filledShape);
			} else if (shapeType == 3) {
				currentShape = new MyRoundRect(e.getX(), e.getY(), e.getX(), e.getY(), currentColor, filledShape);
			}

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			currentShape.setX2(e.getX());
			currentShape.setY2(e.getY());
			shapes[shapeCount] = currentShape;
			shapeCount++;
			currentShape = null;
			repaint();
		}

		@Override
		public void mouseDragged(MouseEvent e) {
			currentShape.setX2(e.getX());
			currentShape.setY2(e.getY());
			repaint();
			statusLabel.setText(String.format("%d: %d:", e.getX(), e.getY()));

		}


		@Override
		public void mouseMoved(MouseEvent e) {
			statusLabel.setText(String.format("%d: %d:", e.getX(), e.getY()));

		}

	}
}