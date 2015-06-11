//coded by sunny_patel

import java.applet.*;
import java.awt.*;
import java.util.*;

/*
<applet code="DDA.class" width=500 height=500>
</applet>
*/

public class DDA extends Applet
{

	public void paint(Graphics g){
	int x1=300, y1=50;
	int x2=300, y2=200;
	dda(300, 50,300,200, g);
	dda(300,50,500,150,g);
	}

	public void dda(int x1, int y1, int x2, int y2, Graphics g)
	{
		int length,i=1;
	
	if(Math.abs(x2-x1)>=Math.abs(y2-y1))
		{
			length=Math.abs(x2-x1);
		}
		else
		{
			length=Math.abs(y2-y1);
		}
		double dx = (x2-x1)*1.0/length;
		double dy = (y2-y1)*1.0/length;

		int signx=1,signy=1;
		
		if(dx<0)
		{
			signx=-1;
		}
		if(dy<0)
		{
			signy=-1;
		}
		double x=x1+0.5*signx;
		double y=y1+0.5*signy;
		

		i=1;
		while(i<=length)
		{
			//for(int j=0;j<100;j++)
			g.drawString(".",(int)x, (int)y);
			g.drawString(".",(int)x+1, (int)y);
			g.drawString(".",(int)x, (int)y+1);
			g.drawString(".",(int)x-1, (int)y);
			g.drawString(".",(int)x, (int)y-1);
			g.drawString(".",(int)x+1, (int)y+1);
			g.drawString(".",(int)x-1, (int)y-1);
			x=x+dx;
			y=y+dy;
			i=i+1;
		}
	}


	
		

}
	