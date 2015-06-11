//coded by sunny_patel


import java.applet.*;
import java.awt.*;
/*
<applet code="Circle2.java" width=500 height=500>
</applet>
*/
public class Circle2 extends Applet
{

	int r=100, xc=300, yc=300;
	int rs=30, xs=430, ys=300;
	int a[][]=new int[xc+r+1][yc+1+r];
	
	public void paint(Graphics g)
	{
	
		for(int i=0;i<=360;i++)
		{
			int x=(int)( r* Math.cos(Math.toRadians(i)));
			int y=(int)(r*Math.sin(Math.toRadians(i)));
			g.drawString(".", (x+xc) , (y+yc));
			a[x+xc][y+yc]=2;
			
			
		}
		g.drawString("--",xc+2, yc+2);
		g.setColor(Color.RED);
		try
		{
			fill(xc+2,yc+2,g);
		}catch(Exception e){}
		
	}

	public void fill(int x,int y,Graphics g) throws Exception
	{
			if(a[y-ys][x-xs]==0)
			{
				a[y-ys][x-xs]=1;
				g.drawString(".",x,y);
				Thread.sleep(5);
				fill(x+1,y,g);
				fill(x-1,y,g);
                		fill(x,y+1,g);
				fill(x,y-1,g);
				
			}
	}
}