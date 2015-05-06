//coded by sunny_patel
//Greedy Knapsack
import java.io.*;
class GreKnap
{
	int profit,weight;
	double pw;
	GreKnap(int a,int b)
	{
		profit=a;
		weight=b;
		pw=1.0*a/b;
	}
	
	public static void main(String args[])throws IOException
	{
		BufferedReader br=new BufferedReader( new InputStreamReader (System.in));
		System.out.println("enter number of elements");
		int n=Integer.parseInt(br.readLine());
		
		GreKnap g[]=new GreKnap[n];
		
		System.out.println("enter profit and weight of all items");
		for(int i=0;i<n;i++)
		{
			int p=Integer.parseInt(br.readLine());
			int w=Integer.parseInt(br.readLine());
			g[i]=new GreKnap(p,w);
		}
		System.out.println("enter capacity");
		int capacity=Integer.parseInt(br.readLine());
		
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n-1;j++)
			{
				if(g[j].pw < g[j+1].pw)
				{
					GreKnap temp=g[j];
					g[j]=g[j+1];
					g[j+1]=temp;
				}
			}
		}


		int selected=0;
		double maxpro=0;
		for(int i=0;i<n;i++)
		{
			if(selected + g[i].weight <= capacity)
			{
				maxpro+=g[i].profit;
				selected+=g[i].weight;
				if(selected==capacity) break;
			}
			else
			{
				maxpro+= (capacity - selected)* g[i].pw;
				break;
			}
		}
		System.out.println("max profit is: "+maxpro);
	}
}
