import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Frame extends JFrame {

	private JButton bottom1;
	private JButton bottom2;
	private JComboBox<String> combobox1;
	private JComboBox<String> combobox2;
	private JCheckBox Checkfilled;
	private JLabel statusLabel;
	private JPanel Menu;

	private final static String[] shapes = { "Line", "Oval", "Rectangle" ,"RoundRect"};
	private final static String[] colorNames = { "Black", "White", "Green", "Dark Gray", "Gray", "Cyan", "Light Gray",
			"Magneta", "Orange", "Pink", "Red", "Blue", "Yellow" };
	private final static Color[] colors = { Color.BLACK,Color.WHITE,Color.GREEN,Color.DARK_GRAY, Color.GRAY,
			Color.CYAN,Color.LIGHT_GRAY,Color.MAGENTA,Color.ORANGE,Color.PINK,Color.RED,Color.BLUE, Color.YELLOW };

	public Frame() {

		super("Java Drawings");

		statusLabel = new JLabel("0: 0:");
		DrawPanel panel = new DrawPanel(statusLabel);


		Menu = new JPanel(new FlowLayout());


		bottom1 = new JButton("Undo");
		bottom1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				panel.clearLastShape();

			}
		});


		bottom2 = new JButton("Clear");
		bottom2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				panel.clearDrawing();

			}
		});


		combobox1 = new JComboBox<>(colorNames);
		combobox1.setMaximumRowCount(3);
		combobox1.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				panel.setCurrentColor(colors[combobox1.getSelectedIndex()]);

			}
		});


		combobox2 = new JComboBox<>(shapes);
		combobox2.setMaximumRowCount(4);
		combobox2.addItemListener(
				new ItemListener() {
					
					@Override
					public void itemStateChanged(ItemEvent e) {
						if (combobox2.getSelectedIndex() == 0){
							panel.setShapeType(0);
						}else if (combobox2.getSelectedIndex() == 1){
							panel.setShapeType(1);
						}else if (combobox2.getSelectedIndex() == 2){
							panel.setShapeType(2);
						}else if (combobox2.getSelectedIndex() == 3){
							panel.setShapeType(3);
						}
					}
				});


		Checkfilled = new JCheckBox("Filled");
		Checkfilled.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (Checkfilled.isSelected()) {
					panel.setFilledShape(true);
				} else
					panel.setFilledShape(false);

			}
		});


		Menu.add(bottom1);
		Menu.add(bottom2);
		Menu.add(combobox1);
		Menu.add(combobox2);
		Menu.add(Checkfilled);


		add(Menu, BorderLayout.NORTH);
		add(panel, BorderLayout.CENTER);
		add(statusLabel, BorderLayout.SOUTH);
	}
}