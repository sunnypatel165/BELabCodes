//coded by sunny_patel

//Flood fill code


import java.awt.*;
import java.applet.Applet;
/*
 <applet code=FloodFill.class width=300 height=300></applet>
*/
public class FloodFill extends Applet
{
	//sw is the side of the square or width
	//xs,ys are start points
	int sw=75,xs=50,ys=50;
	int a[][]=new int[sw+1][sw+1]; //0=old , 1=new color , 2=other color
	public void paint(Graphics g)
	{
		//draw the region, boundry of differnet colors
		for(int i=0;i<=sw;i++)
		{
			g.setColor(Color.GREEN);
			g.drawString(".",(xs+i),(ys));
			a[0][i]=2;
			g.setColor(Color.ORANGE);
			g.drawString(".",(xs+i),(ys+sw));
			a[sw][i]=2;
			g.setColor(Color.BLUE);
			g.drawString(".",(xs),(ys+i));
			a[i][0]=2;
			g.setColor(Color.PINK);
			g.drawString(".",(xs+sw),(ys+i));
			a[i][sw]=2;	
		}
		g.setColor(Color.RED);
		try
		{
			//xs+21 , ys+41 lies inside the region so acts as a seed
			fill(xs+21,ys+41,g);
		}
		catch(Exception e)
		{}
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
				fill(x+1,y+1,g);
				fill(x+1,y-1,g);
				fill(x-1,y+1,g);
				fill(x-1,y-1,g);
			}
	}
}