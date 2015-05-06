//coded by sunny_patel
//aoad-dijkstra
//enter all inouts in new line
import java.io.*;
import java.util.Arrays;
class Graph
{
	static int a[][];
	final static int IN=9999;
	static int n;
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	
	public static void create()throws IOException
	{
		String s;
		
		
		//System.out.println("enter the number of nodes");
		n=Integer.parseInt(br.readLine());
		a=new int[n][n];
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
				a[i][j]=IN;
		
		do{
			System.out.println("enter the edge");
			int i=Integer.parseInt(br.readLine());
			int j=Integer.parseInt(br.readLine());
			System.out.println("enter the cost");
			int cost=Integer.parseInt(br.readLine());
			a[i-1][j-1]=cost; a[j-1][i-1]=cost;
			
			System.out.println("enter more edges?");
			s=br.readLine();
		}while(s.charAt(0)=='y');
		System.out.println("adjecency");
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++)
				System.out.print(a[i][j]+" ");
			System.out.println();
		}
	}
	
	public static void prim(int s){
		int dist[]=new int[n];
		int prev[]=new int [n];
		boolean selected[]=new boolean[n];
		for(int i=0;i<n;i++) dist[i]=IN;
		
		dist[s]=0;
		prev[s]=-1;
		selected[s]=true;
		
		int count=1;
		while(count<a.length){
			int min=IN; int m=s;
			for(int i=0;i<a.length;i++)
			{
				int d= dist[s] + a[s][i];
				if(d<dist[i] && selected[i]==false)
				{
					dist[i]=d;
					prev[i]=s;
				}
			}
			
			for(int i=0;i<a.length;i++){
				if(dist[i]<min && selected[i]==false){
					min=dist[i];
					m=i;
				}
			}
			
			s=m;
			selected[s]=true;
			count++;
		System.out.println(Arrays.toString(dist));     
		}
	}
	
	public static void main(String args[])throws IOException{
		//Graph g;
		create();
		System.out.println("enter the source");
		int s=Integer.parseInt(br.readLine());
		prim(s-1);
	}
}

/*INPUT


7
1
6
10
y
1
2
28
y
2
7
14
y
2
3
16
y
3
4
12
y
7
4
18
y
4
5
22
y
5
6
25
y
7
5
24
n
1

*/