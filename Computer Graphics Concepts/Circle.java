//coded by sunny_patel
//Aim: to draw a circle revolving around a circle!

import java.applet.*;
import java.awt.*;
/*
<applet code="Circle.java" width=500 height=500>
</applet>
*/
public class Circle extends Applet implements Runnable
{

	int r=100, xc=300, yc=300;
	int rs=30, xs=430, ys=300;
	
	public void paint(Graphics g)
	{
	
		for(int i=0;i<=90;i++)
		{
			int x=(int)(r*(Math.cos(i*3.14/180)));
			int y=(int)(r*(Math.sin(i*3.14/180)));
			g.drawString(".",xc+x,yc+y);
			g.drawString(".",xc-x,yc-y);
			g.drawString(".",xc+x,yc-y);
			g.drawString(".",xc-x,yc+y);




			int x1=(int)(rs*(Math.cos(i*3.14/180)));
			int y1=(int)(rs*(Math.sin(i*3.14/180)));
			g.drawString(".",xs+x1,ys+y1);
			g.drawString(".",xs-x1,ys-y1);
			g.drawString(".",xs+x1,ys-y1);
			g.drawString(".",xs-x1,ys+y1);
		}
	}
	public void init()
	{
		Thread t=new Thread(this);
		t.start();
	}

	public void run()
	{
		while(true){
			for(int i=0;i<=360;i+=10)
			{
				int x=(int)(r*(Math.cos(i*3.14/180)));
				int y=(int)(r*(Math.sin(i*3.14/180)));
				int t1=(int)(rs*(Math.cos(i*3.14/180)));
				int t2=(int)(rs*(Math.sin(i*3.14/180)));
				
				xs=xc+x+t1;
				ys=yc+y+t2;
				repaint();
				try{
					Thread.sleep(300);
				}catch(Exception e){}
			}
		}
	}
}