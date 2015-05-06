//coded by sunny_patel
//Job Scheduling Algorithm
import java.io.*;
import java.util.*;
class Job
{
	public static void main(String args[])throws IOException{
	
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		//INPUT
		int deadline[]=new int[n];
		int profit[]=new int[n];
		int max=0;
		for(int i=0;i<n;i++)
		{
			deadline[i]=Integer.parseInt(br.readLine());
			profit[i]=Integer.parseInt(br.readLine());
			if(max < deadline[i]) max=deadline[i]; //maximum deadline
		}
		
		int timeline[]=new int [max+1];
		
		//sort according to profit deacreasing order
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n-1;j++)
			{
				if(profit[j] < profit[j+1])
				{
					int temp=profit[j]; 
					profit[j]=profit[j+1];
					profit[j+1]=temp;

					temp=deadline[j]; 
					deadline[j]=deadline[j+1];
					deadline[j+1]=temp;
				}
			}
		}
		
		int maxprofit=0;

		for(int i=0;i<n;i++)
		{
			int position=deadline[i];
			boolean done=false;
			//try to fit it in the position of its dealine.. if occupied checkk all positions before that if empty place.. else reject the job
			do{
			if(timeline[position]==0)
			{
				timeline[position]=profit[i];
				maxprofit+=profit[i];
				done=true;
			}
			else
			{
				position--;
			}
			
			}while(position!=0 && done!=true);
		}
		System.out.println("pro"+Arrays.toString(profit));
		System.out.println("dea"+Arrays.toString(deadline));
		System.out.println(Arrays.toString(timeline));
		System.out.println(maxprofit);
	}
}
