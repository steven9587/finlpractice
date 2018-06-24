package snow;

import java.util.Random;

import snow.Snowframe.SnowCanvas;

public class Snow extends Thread {
	int x;
	int y;
	Random r = new Random();
	private SnowCanvas snowCanvas;

	public Snow(SnowCanvas snowCanvas) {
		this.snowCanvas=snowCanvas;
		x = r.nextInt(800);
		y = r.nextInt(600);
	}

	@Override
	public void run() {
		while (true) {
			y += 1;
			x += r.nextInt(3) - 1;
			snowCanvas.repaint();
			try {
				sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (y == 600) {
				y = 0;
			}
		}
	}
}
