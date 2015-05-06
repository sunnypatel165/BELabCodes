//coded by sunny_patel
import java.io.*;
import java.util.*;

class DynKnap
{
	public static void main(String args[])throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

		System.out.println("enter the number of items");
		int n=Integer.parseInt(br.readLine());
		
		int wt[]=new int[n+1];
		int profit[]=new int[n+1];

		System.out.println("enter the profit and weight of items");
		for(int i=1;i<=n;i++)
		{
			profit[i]=Integer.parseInt(br.readLine());
			wt[i]=Integer.parseInt(br.readLine());
		}
		
		System.out.println("enter the capacity");
		int capacity=Integer.parseInt(br.readLine());

		int dp[][]=new int[n+1][capacity+1];
		boolean sol[][]=new boolean[n+1][capacity+1];
		for(int i=1;i<=n;i++)
		{
			for(int j=1;j<=capacity;j++)
			{
				if(wt[i] > j )
					dp[i][j]=dp[i-1][j];
				else{
					int o1=dp[i-1][j];
					int o2=profit[i]+dp[i-1][j-wt[i]];
					int replace=Math.max(o1,o2);
					dp[i][j]=replace;
					sol[i][j]=(o2 > o1);
					System.out.println(o2+ " "+ o1+ sol[i][j]);
				}
			}
		}
		

			System.out.println(dp[n][capacity]);

			boolean take[]=new boolean[n+1];
			for(int i=n,w=capacity;i>0 ;i--)
			{
				if(sol[i][w]) {take[i]=true; w-=wt[i];}
				else take[i]=false;
			}
			System.out.println(Arrays.toString(take));
	}
}