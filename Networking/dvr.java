//coded by sunny_patel
//Distance vector routing
import java.io.*;
import java.util.*;
class dvr
{
	public static void main(String args[])throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("enter the number of nodes");
		int n=Integer.parseInt(br.readLine());
		int adj[][]=new int[n+1][n+1];
		String ch;
		do
		{
			System.out.println("enter the name of the edge");
			String s=br.readLine();
			char a=s.charAt(0);
			char b=s.charAt(2);
			adj[a-'a'][b-'a']=1;
			adj[b-'a'][a-'a']=1;
			System.out.println("more edges?");
			ch=br.readLine();
		}while(ch.compareTo("y")==0);

		for(int i=0;i<=n;i++)
		{
			for(int j=0;j<=n;j++)
			{
				System.out.print(adj[i][j]+" ");
			}
			System.out.println();
		}

		System.out.println("select the source node");
		ch=br.readLine();
		int source=ch.charAt(0)-'a';
		
		int neighbours=0;
		int nei[]=new int[n+1];
		for(int i=0;i<n;i++)
		{
			if(adj[i][source]==1)
			{
				nei[neighbours]=i;
				neighbours++;
				System.out.print((char)(i+'a')+"\t");
			}
		}
		System.out.println();
		int table[][]=new int[n+1][neighbours+1];
		
		Random r=new Random();
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<neighbours;j++)
			{
				table[i][j]=r.nextInt(30)+1;
			}
		}
		for(int i=0;i<neighbours;i++)
			table[nei[i]][i]=0;
	
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<neighbours;j++)
			{
				System.out.print(table[i][j]+"\t");
			}
			System.out.println();
		}
	
		


		int mindis[]=new int[neighbours+1];
		System.out.println("enter minimum values of distance from neighbours");
		for(int i=0;i<neighbours;i++)
		{
			System.out.print((char)(nei[i]+'a')+":");
			mindis[i]=Integer.parseInt(br.readLine());
		}
		int val=0;
		int via=0;
		System.out.println("0 a");
		for(int i=1;i<n;i++)
		{
			val=210000;
			via=-1;
			for(int j=0;j<neighbours;j++)
			{
				if((mindis[j]+table[i][j])<val)
				{
					val=mindis[j]+table[i][j];
					via=(nei[j]+(int)'a');
				}
			}
			System.out.println(val+" "+(char)via);
		}
	}
}
