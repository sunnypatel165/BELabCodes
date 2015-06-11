//coded by sunny_patel
//Bresenhem's Algo
import java.applet.*;
import java.awt.*;

/*
<applet code="Bresenhem.class" width=500 height=500>
</applet>
*/

public class Bresenhem extends Applet {
	public void paint(Graphics g) {
		int x1 = 20, y1 = 100;
		int x2 = 70, y2 = 20;

		int dx = x2 - x1;
		int dy = y2 - y1;
		double m = dy * 1.0 / dx;

		int x = x1, y = y1;

		int i = 1;
		if (Math.abs(m) <= 1) {
			System.out.println("1");
			double p = 2 * dy - dx;

			while (i < dx) {
				g.drawString(".", (int) x, (int) y);
				if (p <= 0) {
					p = p + 2 * dy;
					x = x + 1;
				} else {
					p = p + 2 * dy - 2 * dx;
					x = x + 1;
					y = y + 1;
				}
				i++;
			}
		} else {

			System.out.println("2");
			int p = 2 * dx - dy;

			while (i < dx) {
				g.drawString(".", (int) x, (int) y);
				if (p <= 0) {
					p = p + 2 * dx;
					y = y + 1;
				} else {
					p = p + 2 * dx - 2 * dy;
					x = x + 1;
					y = y + 1;
				}
				i++;
			}
		}




	}
}