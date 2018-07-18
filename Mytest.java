import javax.swing.JFrame;

public class Mytest {

	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		Frame frame = new Frame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(0,0,600,600);
		
		frame.setVisible(true);
	}
}