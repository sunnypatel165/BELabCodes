//coded by sunny_patel
//GoBackN
import java.io.*;
class goBack
{
	static int frames,n,winsize,start,end,recw;
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	public static void sender()throws IOException
	{
		System.out.println("enter the total number of frames");
		frames=Integer.parseInt(br.readLine());
	
		System.out.println("enter the number of bits(value of n)");
		n=Integer.parseInt(br.readLine());
		
		winsize=((int)Math.pow(2,n))-1;

		recw=0;start=0;end=winsize-1;
		display(start,end,recw);
		
	}
public static void display(int wstart,int wend,int rec)
{
	System.out.println("\n\nSender window \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t Receiver window(expected)");
	for(int i=0;i<frames;i++)
	{
		if(i==wstart)
			System.out.print(" || " + i%(winsize+1) +" ");
		else if(i==wend)
			System.out.print(" " + i%(winsize+1) + " || " );

		else
		System.out.print(i%(winsize+1)+" ");	
	}
	System.out.println("\t\t\t\t\t"+rec);
}


public static void receiver()throws IOException
{
	
	int count=0;
	do{
	System.out.println("\nEnter choice");
	System.out.println("\n1. for data receiver properly\n2. data lost\n 3. data recieved with errors\n4. acknowledgement lost" );
	int c=Integer.parseInt(br.readLine());
	switch(c)
	{
		case 1:
			count++;
			start=start+1;
			end=end+1;
			recw=(recw+1)%(winsize+1);
			display(start,end,recw);
			break;
		case 2:
			System.out.println("\ndata lost, timeout, and retransmitting\n");
			display(start,end,recw);
			System.out.println("Retransmitting");
			break;
		case 3:
			count++;
			System.out.println("\ndata has erroes! to be solved at recievers end\n");
			start=start+1;
			end=end+1;
			recw=(recw+1)%(winsize+1);
			display(start,end,recw);
			break;
		case 4:
			recw=recw+1;
			display(start,end,recw);
			System.out.println("\nack lost, timeout, and retransmitting\n");
			recw=recw-1;
			break;
	}
	}while(count!=frames);
}
public static void main(String args[])throws IOException
	{
		sender();
		receiver();
	}
}
