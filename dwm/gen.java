//coded by sunny_patel
import java.io.*;
import java.util.*;
class gen
{
	public static void main(String args[])throws IOException
	{
		Random r=new Random();
		PrintWriter writer = new PrintWriter("ip2.txt", "UTF-8");

		for(int c=0;c<100;c++){

		String name="",op1="",op2="",name2="";
		char g;
		int age=0,usage=0;

		int namelen=r.nextInt(7)+5;
		for(int i =0;i<namelen;i++)
		{
			name+=(char)(97+r.nextInt(26));
		}

		int namelen2=r.nextInt(7)+5;
		for(int i =0;i<namelen2;i++)
		{
			name2+=(char)(97+r.nextInt(26));
		}
		int gen=r.nextInt(2)+1;
		if(gen==1) 
			g='M';
		else 
			g='F';
		age=r.nextInt(55)+9;
		usage=r.nextInt(2500);
		if(g=='M')
		{
			if(usage<=350){op1="low"; op2="low";}
			if(usage>350 && usage <=500){op1="low"; op2="low";}
			if(usage>500 && usage<=700){ op1="medium"; op2="low";}
			if(usage>700 && usage<=1000){ op1="medium"; op2="medium";}
			if(usage>1000 && usage<=1250){ op1="medium"; op2="high";}
			if(usage>1250) { op1="high"; op2="high";}
		}
		if(g=='F')
		{
			if(usage<=450){op1="low"; op2="low";}
			if(usage>450 && usage <=650){op1="low"; op2="low";}
			if(usage>650 && usage<=800){ op1="medium"; op2="low";}
			if(usage>800 && usage<=1000){ op1="medium"; op2="medium";}
			if(usage>1000 && usage<=1350){ op1="medium"; op2="high";}
			if(usage>1350) { op1="high"; op2="high";}
		}

		writer.println(name+","+g+","+age+","+usage+","+op1+","+op2+","+name2);
		}
		writer.close();
	}
}