//coded by sunny_patel
//should work on most cases! 
//this is single link only!

//Single link clustering
import java.io.*;
import java.util.*;
class hierarchical
{
	public static void main(String args[])throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		//System.out.println("Enter the number of nodes/items");
		//int n=Integer.parseInt(br.readLine());
		//int dist[][]=new int[n][n];
		//int distog[][]=new int[n][n];
		Vector<String> clusts=new Vector<String>();
		for(int i=0;i<5;i++)
			clusts.add(""+(char)('A'+i));

		System.out.println("Enter the distance matrix");
		/*for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				dist[i][j]=Integer.parseInt(br.readLine());
				distog[i][j]=dist[i][j];
			}
		}*/
		System.out.println("Iteration 0:--\nClusters:");
		for(int i =0;i<clusts.size();i++)
			System.out.println(clusts.get(i));

		int dist[][]={{0,1,2,2,3},{1,0,2,4,3},{2,2,0,1,5},{2,4,1,0,3},{3,3,5,3,0}};
		int distog[][]={{0,1,2,2,3},{1,0,2,4,3},{2,2,0,1,5},{2,4,1,0,3},{3,3,5,3,0}}; //never modify this
		int it=1;
		whilemain: while(true)
		{
		if(check(dist)==2) 
			break whilemain;
		System.out.println("----------------------------------\nIteration"+it++ +":--\n");
		int min=111111;
		int item1=-1,item2=-1;
		for(int i=0;i<clusts.size();i++)
		{
			for(int j=0;j<clusts.size();j++)
			{
				if(dist[i][j]!=0 && dist[i][j]<min)
				{
					min=dist[i][j];
					item1=i;
					item2=j;
				}
			}
		}
		System.out.println("Threshold: "+min+"\nClusters:\n");
		String i1=clusts.get(item1);
		String i2=clusts.get(item2);
		for(int i =0;i<clusts.size();i++)
		{
			String t=clusts.get(i);
			if(t.compareTo(i1)==0)
			{
				clusts.set(i,t+i2);
			}
			if(t.compareTo(i2)==0)
			{
				clusts.remove(i);
			}
		}
		for(int i =0;i<clusts.size();i++)
			System.out.println(clusts.get(i));
		if(clusts.size()==1) break whilemain;

		int newmat[][]=new int[clusts.size()][clusts.size()];
		for(int i=0;i<clusts.size();i++)
		{
			String t1=clusts.get(i);
			for(int j=i+1;j<clusts.size();j++)
			{
				int m=11111;
				String t2=clusts.get(j);
				for(int x=0;x<t1.length();x++)
				{
					for(int y=0;y<t2.length();y++)
					{
						int d=distog[t1.charAt(x)-'A'][t2.charAt(y)-'A'];
						if(d<m && d!=0) m=d;
					}
				}
				newmat[i][j]=newmat[j][i]=m;
			}
		}
		dist=newmat;
		for(int i =0;i<newmat.length;i++)
			{
				for(int j =0;j<newmat.length;j++)
					System.out.print(dist[i][j]+" ");
				System.out.println();
			}
		}
	}

	public static int check(int a[][])
	{
		int c=0;
		for(int i=0;i<a.length;i++)
		{
			for(int j=0;j<a.length;j++)
				if(a[i][j]!=0)
					c++;
		}
		return c;
	}
	
}
