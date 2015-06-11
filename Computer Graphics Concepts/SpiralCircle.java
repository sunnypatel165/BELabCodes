//Coded by sunny_patel

//AIM: to make a circle move around a spiral 

import java.awt.*;
import java.applet.*;
/*
 *<applet code = "SpiralCircle.class" height="500" width="500"></applet>
 **/
public class SpiralCircle extends Applet implements Runnable{
    
    Thread t;
    int i=0;
    public void init() {
        t=new Thread(this);
    }

    public void paint(Graphics g) {
    	double x,y,xc=300,yc=300,r=30,theta=0,theta1=0,n=0;
    	while(n<4)
    	{
    		while(theta<360)
    		{
    			theta1=Math.toRadians(theta);
    			x=r*Math.cos(theta1);
    			y=r*Math.sin(theta1);
    			g.drawString(".",(int)(x+xc),(int)(y+yc));
    			g.drawString(".",(int)(x+xc),(int)(y+yc+1));
    			g.drawString(".",(int)(x+xc+1),(int)(y+yc));
    			g.drawString(".",(int)(x+xc),(int)(y+yc-1));
    			g.drawString(".",(int)(x+xc-1),(int)(y+yc));
    			theta+=1;
    			r+=.1;
    		}
    		theta=0;
    		n++;
    	}
    	theta=0;
    	r=30;
    	n=0;
    	while(n<4)
    	{
    		while(theta<360)
    		{
    			theta1=Math.toRadians(theta);
    			x=r*Math.cos(theta1);
    			y=r*Math.sin(theta1);
    			g.setColor(Color.RED);
    			if(theta<=90)
    				g.fillOval((int)(x+xc+5),(int)(y+yc+5),5,5);
    			else if(theta>90 && theta <=180)
    				g.fillOval((int)(x+xc-5),(int)(y+yc+5),5,5);	
    			else if(theta>180 && theta <=270)
    				g.fillOval((int)(x+xc-5),(int)(y+yc-8),5,5);
    			else
    				g.fillOval((int)(x+xc+5),(int)(y+yc-8),5,5);
    			g.setColor(Color.WHITE);
    			try
    			{
    				Thread.sleep(10);
    			}
    			catch(Exception e)
    			{
    			}
    			if(theta<=90)
    				g.fillOval((int)(x+xc+5),(int)(y+yc+5),5,5);
    			else if(theta>90 && theta <=180)
    				g.fillOval((int)(x+xc-5),(int)(y+yc+5),5,5);	
    			else if(theta>180 && theta <=270)
    				g.fillOval((int)(x+xc-5),(int)(y+yc-8),5,5);
    			else
    				g.fillOval((int)(x+xc+5),(int)(y+yc-8),5,5);		
    			theta+=1;
    			r+=.1;
    			try
    			{
    				Thread.sleep(10);
    			}
    			catch(Exception e)
    			{
    			}
    		}
    		theta=0;
    		n++;
    	}
        
    }
    public void run()
    {
    	while(true)
    	{
    		i=(i+1)%getWidth();
    		repaint();
    		try
    		{
    			Thread.sleep(20);
    		}
    		catch(Exception e)
    		{
    		}
    	}
    }
}