//coded by sunny_patel

//AIM: DRAW A COCONUT TREE USING BEZIER CURVE

import java.awt.*;
import java.applet.*;

/*
<applet code="Coconut.java" width=500 height=500>
</applet>
*/

public class Coconut extends Applet {

	float ax = 0, ay = 0; //first control point
	float bx = 0, by = 0; // seyond control point
	float cx = 0, cy = 0; //third control point
	float dx = 0, dy = 0; //fourth control point


	public void paint(Graphics g) {



		//TWO VERTICAL LINES FOR DRUNK TRUNK
		g.drawLine(250, 200, 220, 450);
		g.drawLine(310, 200, 280, 450);

		//LEFT BOTTOM LEAF
		dx = 250;
		dy = 200;
		cx = 175;
		cy = 150;
		bx = 125;
		by = 300;
		ax = 100;
		ay = 325;
		bezier(g, bx, by, cx, cy, dx, dy, 8);

		//RIGHT BOTTOM LEAF
		dx = 310;
		dy = 200;
		cx = 385;
		cy = 150;
		bx = 435;
		by = 300;
		ax = 460;
		ay = 325;
		bezier(g, bx, by, cx, cy, dx, dy, 8);

		//LEFT MIDDLE LEAF
		dx = 250;
		dy = 200;
		cx = 175;
		cy = 75;
		bx = 125;
		by = 225;
		ax = 100;
		ay = 250;
		bezier(g, bx, by, cx, cy, dx, dy, 8);

		//RIGHT MIDDLE LEAF
		dx = 310;
		dy = 200;
		cx = 385;
		cy = 75;
		bx = 435;
		by = 225;
		ax = 460;
		ay = 250;
		bezier(g, bx, by, cx, cy, dx, dy, 8);

		//LEFT UPPER LEAF
		dx = 280;
		dy = 190;
		cx = 140;
		cy = 45;
		bx = 95;
		by = 180;
		ax = 70;
		ay = 200;
		bezier(g, bx, by, cx, cy, dx, dy, 8);

		//RIGHT UPPER LEAF
		dx = 300;
		dy = 190;
		cx = 275;
		cy = 45;
		bx = 450;
		by = 180;
		ax = 500;
		ay = 200;
		bezier(g, bx, by, cx, cy, dx, dy, 8);

		//YOU CAN ADD MORE LEAFS.. ONLY IF U HAVE LOTS OF TIME TO WASTE! :P

		//DUMB COCONUTS HANGING
		g.setColor(Color.ORANGE);
		g.fillOval(200, 190, 30, 30);
		g.setColor(Color.ORANGE);
		g.fillOval(300, 190, 30, 30);




	}




	//START POINT KEEPS ON CHANIGNG TO THE CURRENTLY DRAWN POINT.. ie (AX,AY) INTIALLY IS THE 1ST POINT THEN LATER CHANGES TO PREVIOUS LINE'S END POINT.. 
	//iNSHORT THIS FUNCTION PRINTS THE ACTUAL CURVE AND HELPS RECURSION.

	public void plotLine(float x, float y, Graphics g) {
		g.setColor(Color.GREEN);
		g.drawLine((int) ax, (int) ay, (int) x, (int) y);
		ax = x;
		ay = y;
	}

	//MAIN BEZIER FUNCTION!!!! RECURSIVE ONE.

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

			//CURVE IS DIVIDED INTO 2 SECTIONS.. CALL THE FUNCTION ON BOTH NOW

			bezier(g, xab, yab, xabc, yabc, xabcd, yabcd, n);
			bezier(g, xbcd, ybcd, xcd, ycd, xd, yd, n);
		} else {
			plotLine(xb, yb, g);
			plotLine(xc, yc, g);
			plotLine(xd, yd, g);
		}
	}

}