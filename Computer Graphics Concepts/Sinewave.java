//coded by sunny_patel

//Aim: To make a circle roll on a sinewave!!


import java.applet.*;
import java.awt.*;

/*
<applet code="Sinewave.java" width=500 height=500>
</applet>
*/

public class Sinewave extends Applet implements Runnable
{
	public void init()
	{
		Thread t=new Thread(this);
		t.start();
	}
	int i=0; double y=0,factorx=0,factory=0;
	public void paint(Graphics g)
	{
		
		for(i=0;i<=700;i++)
		{
			
			y=100*Math.sin(Math.toRadians(i));
			g.drawString(".", (int)(i+50), (int)(y+200));
			
		}

		g.drawOval((int)(50+factorx),(int)(175+factory),30,30);
	}

	public void run()
	{
		for(int i=0;i<=700;i++)
		{
			factorx=i;
			factory=100*Math.sin(Math.toRadians(i));
			repaint();
			try{
				Thread.sleep(100);
			}catch(Exception e){}
		}
	}

}