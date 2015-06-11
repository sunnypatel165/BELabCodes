//Coded by sunny_patel

//AIM: To implement Cohen- Southerland code
import java.applet.*;
import java.awt.*;

/*
<applet code="Cohen.java" width=500 height=500>
</applet>
*/


class Points {
	int xwmin = 100;
	int ywmin = 150;
	int xwmax = 200;
	int ywmax = 250;
	int x, y;
	int regionCode[] = new int[4];

	Points() {}

	Points(int a, int b) {
		x = a;
		y = b;

		if (y < ywmin) //ie to top
		regionCode[0] = 1;
		else regionCode[0] = 0;

		if (y > ywmax) //ie to bottom
		regionCode[1] = 1;
		else regionCode[1] = 0;


		if (x > xwmax) //ie to right
		regionCode[2] = 1;
		else regionCode[2] = 0;

		if (x < xwmin) //ie to left
		regionCode[3] = 1;
		else regionCode[3] = 0;

	}

}

public class Cohen extends Applet {
	int x1 = 120;
	int y1 = 50;
	int x2 = 250;
	int y2 = 300;
	int xwmin = 100;
	int ywmin = 150;
	int xwmax = 200;
	int ywmax = 250;


	public void paint(Graphics g) {
		Points p1 = new Points(x1, y1);
		Points p2 = new Points(x2, y2);

		//CLIPPING WINDOW

		g.setColor(Color.BLUE);
		g.drawRect(100, 150, 100, 100);
		g.setColor(Color.GREEN);
		g.drawLine(x1, y1, x2, y2);
		int v = visibility(p1, p2);
		switch (v) {
			case 0:
				System.out.println("line completely visible");
				g.drawLine(x1, y1, x2, y2);
				break;
			case 1:
				System.out.println("Line completely invisible");
				break;
			case 2:
				System.out.println("applying cohen");
				p1 = findNewPoints(p1, p2);
				p2 = findNewPoints(p2, p1);
				g.setColor(Color.RED);
				g.drawLine(p1.x, p1.y, p2.x, p2.y);
				break;
		}
	}


	public int visibility(Points p1, Points p2) {
		int flag = 0;
		for (int i = 0; i < 4; i++) {
			if (p1.regionCode[i] != 0 || p2.regionCode[i] != 0) {
				flag = 1;
				break;
			}
		}
		if (flag == 0) return 0;
		//logical and
		flag = 0;
		for (int i = 0; i < 4; i++)
		if (p1.regionCode[i] == p2.regionCode[i] && p1.regionCode[i] == 1) {
			flag = 1;
			break;
		}
		if (flag == 1) return 1;
		else return 2;
	}

	public Points findNewPoints(Points r1, Points r2) {
		Points temp = new Points();
		int x = 0, y = 0;
		double m = 0, k = 0;

		//check if left or right
		if (r1.regionCode[3] == 1) x = xwmin;
		else if (r1.regionCode[2] == 1) x = xwmax;

		if (r1.regionCode[2] == 1 || r1.regionCode[3] == 1) {
			m = (double)(r2.y - r1.y) / (r2.x - r1.x);
			k = r1.y + m * (x - r1.x);
			temp.y = (int) k;
			temp.x = x;
			for (int i = 0; i < 4; i++) {
				temp.regionCode[i] = r1.regionCode[i];
			}
			if (temp.y <= ywmax && temp.y >= ywmin)
			/* ie y already lies within window so no cahnge hence return*/
			return temp;
		}

		if (r1.regionCode[0] == 1) //ie to top
		y = ywmin;
		else if (r1.regionCode[1] == 1) //ie to bottom
		y = ywmax;

		if (r1.regionCode[0] == 1 || r1.regionCode[1] == 1) {
			m = (double)(r2.y - r1.y) / (r2.x - r1.x);
			k = (r1.x + (double)(y - r1.y) / m);
			temp.x = (int) k;
			temp.y = y;
			for (int i = 0; i < 4; i++) {
				temp.regionCode[i] = r1.regionCode[i];
			}
			return temp;
		} else return r1;
	}


}