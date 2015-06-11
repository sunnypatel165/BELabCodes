//coded by sunny_patel

// To revolve a circle around diamond!

import java.awt.*;
import java.applet.*;

/*
<applet code="Diamond.java" width=500 height=500>
</applet>
*/

public class Diamond extends Applet implements Runnable
{
	int xc=400, yc=150, r=30;
	public void paint(Graphics g)
	{

		g.drawLine(300,300,400,200);
		g.drawLine(400,200,500,300);
		g.drawLine(500,300,400,400);
		g.drawLine(400,400,300,300);

		g.drawOval(xc,yc,r,r);
		System.out.println(xc+" "+yc);
		
	}
	public void init()
	{
		Thread t=new Thread(this);
		t.start();
	}
	public void run()
	{
		while(true){
		if(xc>=400 && xc<520 && yc>=150 && yc<320)
			{
			xc+=2;
			yc+=2;	
			}
			
		else if(xc>=400 && xc<=520)
			{
			xc-=2;
			yc+=2;	
			}
	
		if(xc<=400 && xc>=280 && yc<=440 && yc>=280)
			{
			xc-=2;
			yc-=2;	
			}
		if(xc>=278 && xc<=400 && yc<=316 && yc>=120)
		{
			xc+=2;
			yc-=2;
		}
			
			repaint();
			try{
				Thread.sleep(200);
				}catch(Exception e){}
		}
	}

		
}