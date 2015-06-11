//coded by sunny_patel

//AIM: to draw a fish


import java.awt.*;
import java.applet.*;
import java.awt.image.BufferedImage;

/*
<applet code="Fish.java" width=500 height=500>
</applet>
*/

public class Fish extends Applet {

	float ax = 0, ay = 0; //first control point
	float bx = 0, by = 0; // seyond control point
	float cx = 0, cy = 0; //third control point
	float dx = 0, dy = 0; //fourth control point


	public void paint(Graphics g) {
		ax = 100;
		ay = 100;
		bx = 50;
		by = 50;
		cx = 150;
		cy = 50;
		dx = 225;
		dy = 125;

		bezier(g, bx, by, cx, cy, dx, dy, 8);

		ax = 100;
		ay = 100;
		bx = 150;
		by = 150;
		cx = 150;
		cy = 150;
		dx = 225;
		dy = 75;

		bezier(g, bx, by, cx, cy, dx, dy, 8);

		ax = 225;
		ay = 75;
		bx = 225;
		by = 75;
		cx = 225;
		cy = 125;
		dx = 225;
		dy = 125;

		bezier(g, bx, by, cx, cy, dx, dy, 8);




	}




	//START POINT KEEPS ON CHANIGNG TO THE CURRENTLY DRAWN POINT.. IE (AX,AY) INTIALLY IS THE 1ST POINT THEN LATER CHANGES TO PREVIOUS LINE'S END POINT
	public void plotLine(float x, float y, Graphics g) {
		g.setColor(Color.BLACK);
		g.drawLine((int) ax, (int) ay, (int) x, (int) y);
		ax = x;
		ay = y;
	}



	public void bezier(Graphics g, float xb, float yb, float xc, float yc, float xd, float yd, int n) {

		//IF N=0 MEANS CURVE HAS BEEN DIVIDED INTO SMALL PARTS SO THAT IT CAN BE DRAWN AS A STRT LINE.. OTHERWISE DIVIDE THE REGION AGAIN AS GIVEN BELOW
		if (n != 0) {

			float xab = (ax + xb) / 2;
			float yab = (ay + yb) / 2;

			float xbc = (xb + xc) / 2;
			float ybc = (yb + yc) / 2;

			float xcd = (xc + xd) / 2;
			float ycd = (yc + yd) / 2;

			float xabc = (xab + xbc) / 2;
			float yabc = (yab + ybc) / 2;

			float xbcd = (xbc + xcd) / 2;
			float ybcd = (ybc + ycd) / 2;

			float xabcd = (xabc + xbcd) / 2;
			float yabcd = (yabc + ybcd) / 2;

			n--;

			//CURVE IS DIVIDED INTO 2 SECTIONS..

			bezier(g, xab, yab, xabc, yabc, xabcd, yabcd, n);
			bezier(g, xbcd, ybcd, xcd, ycd, xd, yd, n);
		} else {
			plotLine(xb, yb, g);
			plotLine(xc, yc, g);
			plotLine(xd, yd, g);
		}
	}


}