//coded by sunny_patel

//Elipse drawing algorihtm 

import java.applet.*;
import java.awt.*;

/*
<applet code="el.java" height=500 width=500>
</applet>
*/

public class el extends Applet implements Runnable
{
	double xi=0,yi=0;
	int a=10, b=5, r=25;
	public void paint(Graphics g)
	{
		double theta=0.0;
		for(int i=0;i<=360;i++)
		{
			double x = 300 + a * r *Math.cos(Math.toRadians(i));
			double y = 300 + b * r *Math.sin(Math.toRadians(i));
			g.drawString(".", (int)x , (int)y);

		}
		g.drawOval((int)(xi),(int)(yi),30,30);
	}
	public void run()
	{
		//while(true){
		for(int i=0;i<=360;i++)
		{
			xi = 310 + a * r * Math.cos(Math.toRadians(i));
			yi = 300 + b * r * Math.sin(Math.toRadians(i));
		
		repaint();
		try{
			Thread.sleep(300);
		}catch(Exception e){}
		}
		//}
	}
	public void init()
	{
		Thread t=new Thread(this);
		t.start();
	}
}