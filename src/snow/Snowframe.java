package snow;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Snowframe extends JFrame {
	SnowCanvas canvas = new SnowCanvas();

	public Snowframe() {
		setSize(850, 650);
		setLocation(300, 300);
		add(canvas);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	public class SnowCanvas extends JPanel{
		List<Snow> snows = new ArrayList<>();

		public SnowCanvas() {
			setBackground(Color.BLACK);
			for (int i = 0; i < 100; i++) {
				Snow snow = new Snow(this);
				snows.add(snow);
				snow.start();
			}
		}
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			for(int i=0;i<100;i++) {
				Snow snow = snows.get(i);
				g.setColor(Color.WHITE);
				g.fillOval(snow.x, snow.y, 10, 10);
			}
		}
	}

	public static void main(String[] args) {
		new Snowframe();
	}

}
