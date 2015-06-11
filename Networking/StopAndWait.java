import java.io.*;
import java.util.*;
public class StopandWait extends Thread
{
	static Scanner sc=new Scanner(System.in);
	static int fno;
	static String f[];
	static int count;
	static void makeFrames()
	{
		System.out.println("Enter number of frames to transmit");
		fno=sc.nextInt();
		f=new String [fno];
		count=fno;
		for(int i=0;i<fno;i++)
		{
			System.out.println("Enter data for frame "+(i+1));
			f[i]=sc.next();
		}
		sender();
	}
	static void sender()
	{
		System.out.println("Transmit frame "+f[fno-count]);
		timer();
		receiver();	
	}
	static void receiver()
	{
		Random randomGenerator = new Random();
		int randomInt;
		randomInt = randomGenerator.nextInt(4);
		randomInt+=1;
		if(count!=0)
		{
		System.out.println("1.Data lost\n 2.Acknowledgement lost\n 3.Data received with error\n 4.Data received properly");
		System.out.println(randomInt);
		switch(randomInt)
		{
			case 1:
				System.out.println("Data is lost");
				sender();
				break;
			case 2:System.out.println("Acknowledgement is lost");
				sender();
				break;
			case 3:System.out.println("Data is received with error");
				count--;
				if(count!=0)
				sender();
				break;
			case 4:
				count--;
				System.out.println("Data received properly");
				if(count!=0)
				sender();
				break;
			
		}
		}
	}
	static void timer()
	{
		try
		{
			Thread.sleep(200);
		}
		
		catch(Exception e)
		{}	
	}
	public static void main(String args[])
	{
		makeFrames();
		receiver();
	}
}
