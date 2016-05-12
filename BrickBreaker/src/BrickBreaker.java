import java.awt.BorderLayout;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class BrickBreaker {
	JFrame frame;
	DrawPanel drawPanel;
	boolean up = false;
	boolean down = false;

	public static void main(String[] args) {
		new BrickBreaker().makePanel();
	}

	public void makePanel() {
		frame = new JFrame("Brick Breaker");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		drawPanel = new DrawPanel();
		frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setSize(800, 800);
		frame.setLocation(375, 55);
		startGame();
	}

	public void startGame() {

	}

	class DrawPanel extends JPanel {

		public void paintComponent(Graphics g) {

		}
	}

}