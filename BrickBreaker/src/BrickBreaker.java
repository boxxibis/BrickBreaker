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
	boolean down = true;
	public int k = 400;
	public int l = 675;
	boolean right = true;
	boolean left = false;

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

	class DrawPanel extends JPanel {
		ArrayList<Brick> bricks = new ArrayList<Brick>();
		Ball puck = new Ball();

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
			puck.setGraphics(g2d);
			puck.drawMe(k, l);
			while (true) {
				for (int numBrick = 0; numBrick < bricks.size(); numBrick++) {

					if (((Brick) bricks.get(numBrick)).isHit()) {
						bricks.remove(numBrick);
					}
				}
			}


		}
	}

	class Brick {
		Graphics2D g2d;
		int cox;
		int coy;

		public void setGraphics(Graphics2D g) {
			g2d = g;
		}

		public void drawMe(int x, int y) {
			g2d.drawRect(x, y, 50, 20);
			cox = x;
			coy = y;
		}

		public boolean isHit() {
			if ((k >= cox && k <= cox + 50) && (l >= coy && l <= coy + 20)) {
				return true;
			} else {
				return false;
			}
		}
	}

	class Ball {
		Graphics2D g2d;

		public void setGraphics(Graphics2D g) {
			g2d = g;
		}

		public void drawMe(int x, int y) {
			g2d.fillOval(x, y, 20, 20);
		}
	}

	public void startGame() {
		while (true) {
			if (l >= 700) {
				up = true;
				down = false;
			}

			if (l <= 0) {
				down = true;
				up = false;
			}

			if (k <= 0) {
				right = true;
				left = false;
			}

			if (k >= 800) {
				right = false;
				left = true;
			}

			if (up) {
				l--;
			}

			if (down) {
				l++;
			}

			if (left) {
				k--;
			}

			if (right) {
				k++;
			}

			try {
				Thread.sleep(10);
				frame.repaint();

			} catch (Exception exc) {

			}

		}
	}
}
