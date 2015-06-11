//coded  by sunny_patel

//Fractal of a Triangle

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
/*
 <html>
 <body>
 <applet height="1500" width="1500" code="FractalsT.class"></applet>
 </body>
 </html>
 */
public class FractalsTriangle extends Applet {

	static int x[] = new int[3];
	static int y[] = new int[3];



	public void paint(Graphics g) {

		x[0] = 150;
		x[1] = 300;
		x[2] = 450;
		y[0] = 450;
		y[1] = 150;
		y[2] = 450;
		g.setColor(Color.BLACK);
		g.fillPolygon(x, y, 3);

		fractals(g, 0, x[0], y[0], x[1], y[1], x[2], y[2]);
	}
	public void fractals(Graphics g, int n, int x1, int y1, int x2, int y2, int x3, int y3) {
		int x4[] = new int[3];
		int y4[] = new int[3];
		if (n < 5) {
			x4[0] = (x1 + x2) / 2;
			y4[0] = (y1 + y2) / 2;
			x4[1] = (x2 + x3) / 2;
			y4[1] = (y2 + y3) / 2;
			x4[2] = (x3 + x1) / 2;
			y4[2] = (y3 + y1) / 2;
			g.setColor(Color.WHITE);
			g.fillPolygon(x4, y4, 3);
			g.setColor(Color.BLACK);
			fractals(g, n + 1, x1, y1, x4[0], y4[0], x4[2], y4[2]);
			fractals(g, n + 1, x4[0], y4[0], x2, y2, x4[1], y4[1]);
			fractals(g, n + 1, x4[2], y4[2], x4[1], y4[1], x3, y3);
		}
	}

}