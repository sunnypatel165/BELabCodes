import java.util.*;
class PageReplacement
{	
	Scanner sc=new Scanner(System.in);
	int array[],s,count;
	int page[],pgSize,hit;
	PageReplacement(int n, int size)
	{	
		s=n;
		array=new int[n];
		page=new int[size];
		count=0;
		hit=0;
		pgSize=size;
	}
	void read(int copy[])	
	{	
		System.arraycopy(copy,0,array,0,array.length);
		
		for(int j=0; j<pgSize;j++)
			page[j]=-1;
	}
	int exist(int x )
	{
		for(int i=0;i<pgSize;i++)
		if(x==page[i])
			return i;
		return -1;		
	}
	
	void print()
	{
		for(int j=0;j<pgSize;j++)
			System.out.print(page[j]+"\t");
		System.out.println();
	}
	
	int min(int temp[])
	{	
		int index=0;
		int min=temp[0];	
		for(int j=0;j<pgSize;j++)
		{	
			if(page[j]==-1)
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
	
	int dist(int i,int k)
        {
		int distance=0;
		for(int x=i+1;x<s;x++)
			if(array[x]!=page[k])
				distance++;
			else break;
		return distance;
	}

	void FIFO()
	{
		for(int i=0;i<s;i++)
		{
			if(exist(array[i])!=-1)
			{ 
				hit++;
				print();
				continue;
			}
			page[count]=array[i];
			if(count==(pgSize-1))
				count=0;
			else 
				count++;
			print();
		}
		System.out.println("The no of hit is:"+hit);	
	}

	void LRU()
	{	
		int index=0;
		int temp[]=new int[pgSize];
		for(int j=0; j<pgSize;j++)
			temp[j]=s;

		for(int i=0;i<s;i++)
		{
			int pos=exist(array[i]);
			if(pos!=-1)
			{ 
				hit++;
				temp[pos]=s;
				for(int j=0;j<pgSize && page[j]!=-1 ;j++)
					temp[j]-=1;
		
				print();
				continue;
			}
			index=min(temp);
			page[index]=array[i];
			temp[index]=s;			
			for(int j=0;j<pgSize && page[j]!=-1;j++)
				temp[j]-=1;
			
			print();			
		}
		System.out.println("The no of hit is:"+hit);	
	}
	
	void OPTIMAL()
		{
		int index1,index;
		for(int i=0;i<s;i++)
		{
			if(exist(array[i])!=-1)
			{ 
				hit++;
				print();
				continue;
			}
			index=0;
			for(int k=1;k<pgSize;k++)
			{	
				if(dist(i,index)<dist(i,k))
					index=k;
			}
			page[index]=array[i];
			print();
		}
		System.out.println("The no of hit is:"+hit);	
	}
	
	
	
	public static void main(String args[])
	{
		Scanner se=new Scanner(System.in);
		System.out.println("Enter the size of page frame : ");
		int frameSize=se.nextInt();
		System.out.println("Enter the input array size:");
		int n=se.nextInt();

		PageReplacement fifo_obj = new PageReplacement(n,frameSize);
		PageReplacement lru_obj = new PageReplacement(n,frameSize);
		PageReplacement optimal_obj = new PageReplacement(n,frameSize);
		
		int list[]=new int[n];
		System.out.println("Enter the list : ");
		for(int i=0;i<n;i++)
		{	
			System.out.print("Enter element " + (i+1) + " : ");
			list[i]=se.nextInt();
			
		}
		fifo_obj.read(list);
		lru_obj.read(list);
		optimal_obj.read(list);
		
		System.out.println("Output for FIFO:");
		fifo_obj.FIFO();
		System.out.println();
		
		System.out.println("Output for LRU:");
		lru_obj.LRU();
		System.out.println();
		
		System.out.println("Output for OPTIMAL:");
		optimal_obj.OPTIMAL();
	}
}