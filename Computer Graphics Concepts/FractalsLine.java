//coded by sunny_patel

//Fractal of a Line!

/*
 <html>
 <body>
 <applet height="800" width="800" code="FractalsLine.class"></applet>
 </body>
 </html>
 */
import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;

public class FractalsLine extends Applet {
	int x1 = 100, x2 = 600;

	public void paint(Graphics g) {
		g.setColor(Color.BLACK);
		g.drawLine(100, 99, 600, 99);
		g.drawLine(100, 100, 600, 100);
		g.drawLine(100, 101, 600, 101);
		fractals(0, x1, 100, x2, 100, g);
	}
	private void fractals(int n, int x1, int y1, int x2, int y2, Graphics g) {
		if (n < 5) {
			int dx = (x2 - x1) * 2 / 5;
			int lx = x1 + dx;
			int rx = x2 - dx;
			g.setColor(Color.WHITE);
			g.drawLine(lx, y1 - 1, rx, y2 - 1);
			g.drawLine(lx, y1, rx, y2);
			g.drawLine(lx, y1 + 1, rx, y2 + 1);
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {}
			fractals(n + 1, x1, y1, lx, y2, g);
			fractals(n + 1, rx, y1, x2, y2, g);
		}

	}
}