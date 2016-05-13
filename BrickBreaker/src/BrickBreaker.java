import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;

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
	Brick brick1 = new Brick();
	Brick brick2 = new Brick();
	Brick brick3 = new Brick();
	Brick brick4 = new Brick();
	Brick brick5 = new Brick();
	Brick brick6 = new Brick();
	Brick brick7 = new Brick();
	Brick brick8 = new Brick();
	Brick brick9 = new Brick();
	Brick brick10 = new Brick();
	Brick brick11 = new Brick();
	Brick brick12 = new Brick();
	Brick brick13 = new Brick();
	Brick brick14 = new Brick();
	Brick brick15 = new Brick();

	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		brick1.setGraphics(g2d);
		brick1.drawMe(0, 0);
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
