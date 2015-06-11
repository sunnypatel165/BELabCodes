//coded by sunny_patel
//Selective Repeat
import java.io.*;
class selRep
{
	static int frames,n,winsize,start,end,recstart,recend;
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	public static void sender()throws IOException
	{
		System.out.println("enter the total number of frames");
		frames=Integer.parseInt(br.readLine());
	
		System.out.println("enter the number of bits(value of n)");
		n=Integer.parseInt(br.readLine());
		
		winsize=((int)Math.pow(2,n))-1;//		winsize=winsize/2;

		recstart=0;start=0;end=winsize/2;recend=winsize/2;
		display(start,end,recstart,recend);
		
	}
public static void display(int wstart,int wend,int recs,int rece)
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
	
	System.out.print("\t\t\t\t\t|| ");
	for(int i=recs;i<=rece;i++){
		System.out.print(i%(winsize+1)+" ");
	}	
	System.out.println("||");
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
			recstart=(recstart+1);
			recend=(recend+1);
			display(start,end,recstart,recend);
			break;
		case 2:
			System.out.println("\ndata lost\n");
			System.out.println("NAK sent\n");
			display(start,end,recstart,recend);
			System.out.println("Retransmitting");
			break;
		case 3:
			count++;
			System.out.println("\ndata has erroes! to be solved at recievers end\n");
			start=start+1;
			end=end+1;
			recstart=(recstart+1);
			recend=(recend+1);
			display(start,end,recstart,recend);
			break;	
		case 4:
			recstart=(recstart+1);
			recend=(recend+1);
			display(start,end,recstart,recend);
			System.out.println("\nack lost, timeout, and retransmitting\n");
			
			recstart=(recstart-1);
			recend=(recend-1);
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
