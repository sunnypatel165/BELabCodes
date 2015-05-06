//coded by sunny_patel
//./HAmming code
import java.util.*;
class hamming_code
{
	//generalised function to check the parity!
	static int set_parity_bit(int a[])
	{
		int count=0; 			//........Initialising count to zero which will count the number of 1. 
		int l=a.length;
		for(int i=0;i<l;++i)
			if(a[i]==1)
				++count; 		//Incrementing count if value in array "a" is 1.

		if((count%2)==0)
			return 0;		//........Returning 0 if even number of 1  
		else
			return 1;		//........Returning 1 if odd number of 1
	}
	public static void main(String args[])
	{
			Scanner scr=new Scanner(System.in);
			System.out.println();
			System.out.println("Enter 4 data bits."); 
			int n=4;		 	//set number of data bits=4
			int d[]=new int[4]; 		//..........Array to accept data bits
			for(int i=n-1;i>=0;--i)
			{
				System.out.println("Enter the value of D"+(i+1));
				d[i]=scr.nextInt();
			}


			int k=3;
		              // k stands for number of parity bits.
		             //intialise k as 3 ie for a 4 bit messge 3 bits parity is used!


		int p[]=new int[k]; 		//..........Array to store parity bits
		int h[]=new int[n+k+1];	//.........Array to hold the hamming code.(n+k+1) as we start from pos 1. ie total 7 bits message but array size is 8

		// Initialising array h[] to -1 
		for(int i=0;i<7;++i)
			h[i]=-1;

		int count=0;
		int c=2; 		//to copy the D array into H! we need to copy indices 3,5,6,7 hence the following loop!
		while(count<4)
		{
			++c;
			if(c==4)
				continue;
		
			h[c]=d[count];
			++count;
		}
		System.out.println(Arrays.toString(h));

		int p1[]={h[1],h[3],h[5],h[7]};
		int p2[]={h[2],h[3],h[6],h[7]};
		int p3[]={h[4],h[5],h[6],h[7]};
		int parity[]=new int[3];

	//Setting the value of parity bit
		parity[0]=set_parity_bit(p1);
		parity[1]=set_parity_bit(p2);
		parity[2]=set_parity_bit(p3);

	//Inserting the parity bits in the hamming code
		h[1]=parity[0];
		h[2]=parity[1];
		h[4]=parity[2];

		System.out.println("\nSENDER:");
		System.out.print("\nThe data bits entered are: ");
		for(int i=3;i>=0;--i)
		System.out.print(d[i]+" ");

		System.out.println("\nThe Parity bits are: ");
		for(int i=2;i>=0;--i)
		System.out.println("Value of P"+(i+1)+" is "+parity[i]+" ");

		System.out.print("\nThe Hamming code is as follows ");
		for(int i=(n+k);i>0;--i)
		System.out.print(h[i]+" ");

		System.out.println();
		System.out.println("Enter the hamming code with error at any position(1-bit) of your choice.");
		for(int i=7;i>0;--i)
		h[i]=scr.nextInt();

		int p4[]={h[1],h[3],h[5],h[7]};
		int p5[]={h[2],h[3],h[6],h[7]};
		int p6[]={h[4],h[5],h[6],h[7]};

		parity[0]=set_parity_bit(p4);
		parity[1]=set_parity_bit(p5);
		parity[2]=set_parity_bit(p6);

		int position=(int)(parity[2]*Math.pow(2,2)+parity[1]*Math.pow(2,1)+parity[0]*Math.pow(2,0)); //convert binary to decimal
		System.out.println("\nRECEIVER:");
		if(position==0)
			System.out.println("No error");
		else
		{
			System.out.println("Error is detected at position "+position+" at the receiving end.");
			System.out.println("Correcting the error.... ");

			if(h[position]==1)
				h[position]=0;
			else
				h[position]=1;

		System.out.print("The correct code is ");
		for(int i=7;i>0;--i)
			System.out.print(h[i]+" ");
		}
	}
}

