//Coded by sunny_patel

//Flood file 5 squares one by one

import java.applet.*;
import java.awt.*;
/*
<applet code="SquareFF.java" height=500 width=500>
</applet>
*/

public class SquareFF extends Applet
{
	int grid[][]=new int[250][250];
	public void paint(Graphics g)
	{
		paint(g,50,50,100,50);
		paint(g,100,50,100,100);
		paint(g,100,100,50,100);
		paint(g,50,100,50,50);

		paint(g,100,100,150,100);
		paint(g,100,100,100,150);
		paint(g,100,150,150,150);
		paint(g,150,150,150,100);
		
		paint(g,150,100,150,50);
		paint(g,150,50,200,50);
		paint(g,200,50,200,100);
		paint(g,200,100,150,100);

		paint(g,150,150,200,150);
		paint(g,200,150,200,200);
		paint(g,200,200,150,200);
		paint(g,150,200,150,150);

		paint(g,100,150,50,150);
		paint(g,50,150,50,200);
		paint(g,50,200,100,200);
		paint(g,100,200,100,150);

		g.setColor(Color.RED);
		try{		
		fill(75,75,g);
		}catch(Exception e){}


		g.setColor(Color.YELLOW);
		try{		
		fill(125,125,g);
		}catch(Exception e){}
	
		g.setColor(Color.BLACK);
		try{		
		fill(175,175,g);
		}catch(Exception e){}


		g.setColor(Color.CYAN);
		try{		
		fill(75,175,g);
		}catch(Exception e){}
		
		g.setColor(Color.ORANGE);
		try{		
		fill(175,75,g);
		}catch(Exception e){}
		
			
	}	

	public void fill(int x,int y,Graphics g)throws Exception
	{
		if(grid[y][x]!=1 && grid[y][x]!=2)
		{
			grid[y][x]=2;
			g.drawString(".",x,y);
			try{ Thread.sleep(1);} catch(Exception e){}
			fill(x+1,y,g);
			fill(x,y+1,g);
			fill(x-1,y,g);
			fill(x,y-1,g);
		}
	}


	public void paint(Graphics g, int xo, int yo, int xt, int yt)
	{
		double x1=xo,x2=xt,y1=yo,y2=yt,length,signx=1,signy=1,x,y;
		if(Math.abs(x2-x1)>=Math.abs(y2-y1))
		{
			length=Math.abs(x2-x1);
		}
		else
		{
			length= Math.abs(y2-y1);
		}
		double dx = (x2-x1)/length;
		double dy = (y2-y1)/length;
		if(dx<0)
		{
			signx=-1;
		}
		if(dy<0)
		{
			signy=-1;
		}
		x=x1+.5*signx;
		y=y1+.5*signy;
		int i=1;
		while(i<=length)
		{
			grid[(int)x][(int)y]=1;
			g.drawString(".",(int)(x),(int)y); 
			x=x+dx;
			y=y+dy;
			i++;
		}
		
	}
}