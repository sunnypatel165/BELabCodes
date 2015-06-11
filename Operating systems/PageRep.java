import java.util.*;

class PageRep
{
	int mem[], size, hits;
	int sequence[] , s;

	PageRep(int a ,int b, int c[])
	{
		size=a;
		s=b;
		mem=new int[size];
		sequence=new int[s];
		hits=0;
		for(int i=0;i<size;i++) mem[i]=-1;
		sequence=c;
	}
	
	int exists(int x)
	{
		for(int i=0;i<mem.length;i++)
			if(mem[i]==x)
				return 1;
		return -1;
	}

	public void print()
	{
		for(int i=0;i<mem.length;i++)
			System.out.print(mem[i]+"  ");
		System.out.println();
	}
	int min(int temp[])
	{	
		int index=0;
		int min=temp[0];	
		for(int j=0;j<mem.length;j++)
		{	
			if(mem[j]==-1)
			{
				index=j;
				break;
			}
			if(temp[j]<min)
			{
				min=temp[j];
				index=j;
			}	
		}			
		return index;
	}


	public int dist(int i, int j)
	{
		int distance=0;
		for(int x=i+1;x<sequence.length;x++)
		{
			if(sequence[x]!=mem[j]) distance++;
			else break;
		}
		return distance;
	}

	public void FIFO()
	{	
		int count=0;
		for(int i=0;i<sequence.length;i++)
		{
			if(exists(sequence[i])!=-1)
			{
				hits++;
				print();
				continue;
			}
			mem[count]=sequence[i];
			if(count==mem.length-1) count=0;
			else count++;
			print();
		}
		System.out.println("HITS: "+hits);
	}
	
	public void LRU()
	{
		int used[]=new int[mem.length];
		for(int i=0;i<used.length;i++)
			used[i]=sequence.length;

		for(int i=0;i<sequence.length;i++)
			{
			int pos=exists(sequence[i]);		
			if(pos!=-1)
			{
				hits++;
				for(int j=0;j<mem.length && mem[j]!=-1;j++)
					used[j]-=1;
				used[pos]=sequence.length;
				print();
				continue;
			}
		
			int index=min(used);
			mem[index]=sequence[i];
			used[index]=sequence.length;
			for(int j=0;j<mem.length && mem[j]!=-1;j++)
				 used[j]-=1;
				print();
		
	}
	System.out.println("HITS: "+hits);
}



	public void optimal()
	{

		int index=0;
		for(int i=0;i<sequence.length;i++)
		{
			if(exists(sequence[i])!=-1)
			{
				hits++;
				print();
				continue;
			}
			index=0;
			for(int j=1;j<mem.length;j++)
			{
				if(dist(i,index)< dist(i,j))
					index=j;
			}
			mem[index]=sequence[i];
			print();
		}
		System.out.println("HITS: "+hits);
	}



public static void main(String args[])
{
	Scanner sc=new Scanner(System.in);
	System.out.println("enter framesize");
	int frame=sc.nextInt();	
	System.out.println("enter the number of requests");
	int r=sc.nextInt();



		int list[]=new int[r];
		System.out.println("Enter the list : ");
		for(int i=0;i<r;i++)
		{	
			System.out.print("Enter element " + (i+1) + " : ");
			list[i]=sc.nextInt();
			
		}
	
	PageRep f=new PageRep(frame,r,list);
	f.FIFO();
	
	
	PageRep l=new PageRep(frame,r,list);
	l.LRU();
	
	PageRep o=new PageRep(frame,r,list);
	o.optimal();
}
}