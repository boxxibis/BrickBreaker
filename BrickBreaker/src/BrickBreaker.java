import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

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
}

class DrawPanel extends JPanel {
	ArrayList bricks = new<Brick> ArrayList();

	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		for (int numBrick = 0; numBrick <= 20; numBrick++) {
			bricks.add(new Brick());
		}
		for (int numBrick = 0; numBrick < bricks.size(); numBrick++) {
			((Brick) bricks.get(numBrick)).setGraphics(g2d);
		}
		for (int numBrick = 0; numBrick < bricks.size(); numBrick++) {
			for (int y = 0; y <= 100; y += 20) {
				for (int x = 0; x <= 750; x += 50) {
					((Brick) bricks.get(numBrick)).drawMe(x, y);
				}
			}
		}
	}
}

class Brick {
	Graphics2D g2d;

	public void setGraphics(Graphics2D g) {
		g2d = g;
	}

	public void drawMe(int x, int y) {
		g2d.drawRect(x, y, 50, 20);
	}
}
