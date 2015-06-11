//coded by sunny_patel
// LIANG BARSKY
//best viewed in eclipse!!! 

import java.awt.*;
import java.applet.*;
/*
<applet code="Liang.java" width=500 height=500>
</applet>
*/
import java.util.Arrays;

public class Liang extends Applet
{
	int x1=100, y1=100;
	int x2=700, y2=700;
	int xwmin=150, ywmin=150;
	int xwmax=250, ywmax=250;
	int xf1,yf1, xf2,yf2;
	
	int dx=x2-x1, dy=y2-y1;
	boolean cantDraw=false;
	double t1=0.0,t2=1.0,temp;

	
	public void paint(Graphics g)//whats up??
	{
		g.setColor(Color.RED);
		g.drawRect(xwmin,ywmin,(xwmax-xwmin),(ywmax-ywmin)); //draw the clipping window
		
		g.setColor(Color.BLACK);//original line
		g.drawLine(x1,y1,x2,y2);

		//defining parameters
		int p[]=new int[5];
		int q[]=new int[5];
		p[1]= -(dx);
		p[2]= dx;
		p[3]= -(dy);
		p[4]= dy;
		

		q[1]=x1-xwmin;
		q[2]=xwmax-x1;
		q[3]=y1-ywmin;
		q[4]=ywmax-y1;


		//LOOP 1: to check if line is || to window edge
		for(int i=1;i<5;i++)
		{
			if(p[i]==0 && q[i]<0)
			{
				System.out.println("line is compeletely outside, discard it");
				cantDraw=true;
			}
			else if( p[i]==0 && q[i]>=0) //p=0 means parallel to one of the window edges
			{
				if(i==1 || i==2) // parallel to right-left window
				{
					if(y1 < ywmin)
						y1=ywmin;
					if(y2 > ywmax)
						y2=ywmax;
					g.setColor(Color.BLUE);
					g.drawLine(x1,y1,x2,y2);
					cantDraw=true;
				}
				else if(i==3 || i==4) // parallel to top-bottom window
				{
					if(x1 < xwmin)
						x1=xwmin;
					if( x2 > xwmax)
						x2=xwmax;
					g.setColor(Color.BLUE);
					g.drawLine(x1,y1,x2,y2);
					cantDraw=true;
				}
			}
		}
		
	if(cantDraw==false) //not parallel..  teda line :P
	{
		
		//LOOP 2: line isnt parallel
		for(int i=1;i<5;i++)
		{
			temp=Math.abs((1.0*q[i])/p[i]); // dont forget abs() gives WA otherwise :/
			if(p[i]<0)
			{
				if(t1<=temp)	t1=temp; //select maxmimum of all t with p<0 as t1
			}
			else
			{
				if(t2>temp) 	t2=temp;//select minimum of all t with p>0 as t2
			}
		}
		if(t1<t2)
		{
				xf1=x1+(int)(t1*dx);
				xf2=x1+(int)(t2*dx);
				yf1=y1+(int)(t1*dy);
				yf2=y1+(int)(t2*dy);
				
				g.setColor(Color.BLUE);
				g.drawLine(xf1,yf1,xf2,yf2);
		}
	
	}//end if of cantDraw
	}//end run
}// cya soon