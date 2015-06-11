//coded by sunny_patel
//enter all inputs(2 nodes of the edge and weights) in new line..
import java.io.*;
import java.util.Vector;

class Edge
{
	int parent,child,w;
	Edge(int p, int c, int x)
	{
		parent=p;
		child=c;
		w=x;
	}
	public String toString(){
		return ((parent+1)+" "+(child+1)+" "+w);
	}
}
public class Graphs {
	static int a[][],n,IN=9999;
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	Vector<Edge> v=new Vector();
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
			//System.out.println("enter the edge");
			int i=Integer.parseInt(br.readLine());
			int j=Integer.parseInt(br.readLine());
			//System.out.println("enter the cost");
			int cost=Integer.parseInt(br.readLine());
			a[i-1][j-1]=cost; a[j-1][i-1]=cost;
			
			//System.out.println("enter more edges?");
			s=br.readLine();
		}while(s.charAt(0)=='y');
		System.out.println("adjecency");
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++)
				System.out.print(a[i][j]+" ");
			System.out.println();
		}
	}
	
	public static Vector<Edge> collectEdge(){
		Edge e;
		Vector<Edge> x= new Vector();
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				if(a[i][j]!=0){
					e=new Edge(i,j,a[i][j]);
					x.add(e);
				}
			}
		}
		return x;
	}
	
	
	public static void sortEdges(Vector<Edge> v){
		for(int i=0;i<v.size();i++){
			for(int j=0;j<v.size()-1;j++){
				if(v.get(j).w > v.get(j+1).w)
				{
					Edge t=v.get(j);
					v.set(j, v.get(j+1));
					v.set(j+1,t);
				}
			}
		}
		
			
	}
	public static void Kruskal()
	{
		Vector<Edge> v=collectEdge();
		sortEdges(v);
		int n=a.length;
		int parent[]=new int[a.length];
		int child[]=new int[a.length];
		for(int i=0;i<n;i++)
			{
			parent[i]=-1;
			child[i]=-1;
			}
		
		int count=0;
		for(int i=0;i<v.size() && count<n-1 ;i++)
		{
			int p=v.get(i).parent;
			int c=v.get(i).child;
			
			while(parent[p]!=-1)
				p=parent[p];
			
			while(parent[c]!=-1)
				c=parent[c];
			
			if(p!=c){
				parent[c]=p;
				count++;
				System.out.println(v.get(i));
			}
		}
		

	}
	public static void main(String args[])throws IOException{
		create();
		Kruskal();
		
	}
}


/* INPUt

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