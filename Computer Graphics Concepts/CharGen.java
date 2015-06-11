//Coded by sunny_patel

//Character Generation

import java.applet.*;
import java.awt.*;

/*
<applet code="CharGen.java" width=500 height=500>
</applet>
*/


public class CharGen extends Applet
{

	public void paint(Graphics g)
	{
		int a[][]={ {0,0,0,0,0,0,0,0,0,0,},
			    {0,1,1,1,1,1,1,1,1,1,},
			    {0,1,0,0,0,0,0,0,0,0,},
			    {0,1,0,0,0,0,0,0,0,0,},
			    {0,1,0,0,0,0,0,0,0,0,},
                            {0,1,0,0,0,0,0,0,0,0,},
			    {0,0,1,1,1,1,1,1,1,1,},
			    {0,0,0,0,0,0,0,0,0,1,},
			    {0,0,0,0,0,0,0,0,0,1,},
			    {0,0,0,0,0,0,0,0,0,1,},
			    {0,0,0,0,0,0,0,0,0,1,},
			    {0,0,0,0,0,0,0,0,1,0,},
			    {1,1,1,1,1,1,1,1,0,0,},
			    {0,0,0,0,0,0,0,0,0,0,},
			    {0,0,0,0,0,0,0,0,0,0,},
			    {0,0,0,0,0,0,0,0,0,0,},
			};

			for(int i=0;i<a.length;i++)
				for(int j=0;j<a[0].length;j++)
					if(a[i][j]==1)
						g.drawString(".", 50+j, 50+i);
	}
}

