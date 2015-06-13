//coded by sunny_patel

//Various Graphical Transformations!


import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
/* <applet code="Transformation.class" width="700" height="700"></applet> */
public class Transformation extends Applet {
	double r[][];
	int tx = 31, ty = 16, cx = 350, cy = 350;
	double theta = (60 * 22) / (7 * 180), sx = 2, sy = 2, shx = 2, shy = 3;
	double c[][] = {
		{
			20, 50, 1
		}, {
			70, 100, 1
		}, {
			100, 30, 1
		}
	};
	double t[][] = {
		{
			1, 0, 0
		}, {
			0, 1, 0
		}, {
			tx, ty, 1
		}
	};
	double s[][] = {
		{
			sx, 0, 0
		}, {
			0, sy, 0
		}, {
			0, 0, 1
		}
	};
	double ro[][] = {
		{
			Math.cos(theta), Math.sin(theta), 0
		}, {
			-Math.sin(theta), Math.cos(theta), 0
		}, {
			0, 0, 1
		}
	};
	double ref[][] = {
		{
			-1, 0, 0
		}, {
			0, -1, 0
		}, {
			0, 0, 1
		}
	};
	double sh[][] = {
		{
			1, shy, 0
		}, {
			shx, 1, 0
		}, {
			0, 0, 1
		}
	};
	int x[] = new int[c[0].length];
	int y[] = new int[c[1].length];
	public void translate(Graphics g) {
		g.setColor(Color.green);
		g.drawString("Translation tx=" + tx + " ty=" + ty, 300, 14);
		x = new int[c[0].length];
		y = new int[c[1].length];
		r = mul(c, t, c.length, c.length, t.length, t.length);
		for (int i = 0; i < c[0].length; i++) {
			x[i] = (int)(r[i][0] + cx);
			y[i] = (int)(cy - r[i][1]);
		}
		g.drawPolygon(x, y, x.length);
		try {
			Thread.sleep(6000);
		} catch (InterruptedException ex) {}
		g.setColor(Color.white);
		g.drawPolygon(x, y, x.length);
		g.drawString("Translation tx=" + tx + " ty=" + ty, 300, 14);
		for (int i = 0; i <= 15000; i++);
	}
	public void scaling(Graphics g) {
		g.setColor(Color.red);
		g.drawString("Scaling sx=" + sx + " sy=" + sy, 300, 14);
		r = mul(c, s, c.length, c.length, s.length, s.length);
		for (int i = 0; i < c[0].length; i++) {
			x[i] = (int)(r[i][0] + cx);
			y[i] = (int)(cy - r[i][1]);
		}
		g.drawPolygon(x, y, x.length);
		try {
			Thread.sleep(6000);
		} catch (InterruptedException ex) {}
		g.setColor(Color.white);
		g.drawPolygon(x, y, x.length);
		g.drawString("Scaling sx=" + sx + " sy=" + sy, 300, 14);
		try {
			Thread.sleep(6000);
		} catch (InterruptedException ex) {}
	}
	public void rotate(Graphics g) {
		g.setColor(Color.blue);
		g.drawString("Rotate anticlockwise theta=" + (int)(theta * 180 * 7 / 22), 300, 14);
		x = new int[c[0].length];
		y = new int[c[1].length];
		r = mul(c, ro, c.length, c.length, ro.length, ro.length);
		for (int i = 0; i < c[0].length; i++) {
			x[i] = (int)(r[i][0] + cx);
			y[i] = (int)(cy - r[i][1]);
		}
		g.drawPolygon(x, y, x.length);
		try {
			Thread.sleep(6000);
		} catch (InterruptedException ex) {}
		g.setColor(Color.white);
		g.drawPolygon(x, y, x.length);
		g.drawString("Rotate anticlockwise theta=" + (int)(theta * 180 * 7 / 22), 300, 14);
		try {
			Thread.sleep(6000);
		} catch (InterruptedException ex) {}
	}
	public void reflect(Graphics g) {
		g.setColor(Color.cyan);
		g.drawString("Reflection about origin", 300, 14);
		x = new int[c[0].length];
		y = new int[c[1].length];
		r = mul(c, ref, c.length, c.length, ref.length, ref.length);
		for (int i = 0; i < c[0].length; i++) {
			x[i] = (int)(r[i][0] + cx);
			y[i] = (int)(cy - r[i][1]);
		}
		g.drawPolygon(x, y, x.length);
		try {
			Thread.sleep(6000);
		} catch (InterruptedException ex) {}
		g.setColor(Color.white);
		g.drawPolygon(x, y, x.length);
		g.drawString("Reflection about origin", 300, 14);
		try {
			Thread.sleep(6000);
		} catch (InterruptedException ex) {}
	}
	public void shear(Graphics g) {
		g.setColor(Color.orange);
		g.drawString("Shearing shx=" + shx + " shy=" + shy, 300, 14);
		x = new int[c[0].length];
		y = new int[c[1].length];
		r = mul(c, sh, c.length, c.length, sh.length, sh.length);
		for (int i = 0; i < c[0].length; i++) {
			x[i] = (int)(r[i][0] + cx);
			y[i] = (int)(cy - r[i][1]);
		}
		g.drawPolygon(x, y, x.length);
		try {
			Thread.sleep(6000);
		} catch (InterruptedException ex) {}
		g.setColor(Color.white);
		g.drawPolygon(x, y, x.length);
		g.drawString("Shearing shx=" + shx + " shy=" + shy, 300, 14);
		try {
			Thread.sleep(6000);
		} catch (InterruptedException ex) {}
	}
	public double[][] mul(double m1[][], double m2[][], int r1, int c1, int r2, int c2) {
		double cm[][] = new double[r1][c2];
		for (int i = 0; i < r1; i++)
		for (int j = 0; j < c2; j++) {
			cm[i][j] = 0;
			for (int k = 0; k < c1; k++)
			cm[i][j] += m1[i][k] * m2[k][j];
		}
		return cm;
	}
	public void paint(Graphics g) {
		g.drawString("Original ", 300, 14);
		g.drawLine(350, 0, 350, 700);
		g.drawLine(0, 350, 700, 350);
		for (int i = 0; i < c[0].length; i++) {
			x[i] = (int)(c[i][0] + cx);
			y[i] = (int)(cy - c[i][1]);
		}
		g.drawPolygon(x, y, x.length);
		try {
			Thread.sleep(6000);
		} catch (InterruptedException ex) {}
		g.setColor(Color.white);
		g.drawString("Original ", 300, 14);
		g.setColor(Color.black);
		translate(g);
		rotate(g);
		scaling(g);
		reflect(g);
		shear(g);
	}
}