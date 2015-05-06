//coded by sunny_patel
//open in eclipse for better view! :)
import java.io.*;
import java.util.Arrays;
public class Banker {

	static int safe[];
	
	public static boolean safety(int available[], int allocation[][], int need[][],int process, int resources)
	{
		int n=process;
		int m=resources;
		int nd[][]=new int[process][resources];
		int max[][]=new int[process][resources];
		int work[]=new int[resources];
		int all[][]=new int[process][resources];
		//copying everything into other matrices to save original data
		for(int i=0;i<n;i++)
			for(int j=0;j<m;j++)
				all[i][j]=allocation[i][j];
		
		for(int i=0;i<n;i++)
			for(int j=0;j<m;j++)
				nd[i][j]=need[i][j];
		
		
		for(int i=0;i<m;i++)
			work[i]=available[i];
		
		boolean done[]=new boolean[n];
		safe=new int[n];
		int processDone=0,check=0;
		
		do
		{
			for(int i=0;i<n;i++)
			{
				boolean flag=true;
				if(done[i]==false)
				{
					for(int j=0;j<m;j++)
					{
						if(work[j]<need[i][j]){
							flag=false;
							break;
						}
					}
					if(flag==true)//work can be done
						{
						for(int j=0;j<m;j++){
					        work[j]+=all[i][j];
					      // all[i][j]=0;
					        
						}
						safe[processDone]=i+1;
				        processDone+=1;
						done[i]=true;
						
					}
						
				}
			}
			check++;
		}while(processDone<n && check<n);
		
		boolean fdone=true;
		for(int i=0;i<done.length;i++)
			if(done[i]==false){ fdone=false; break;}
		if(fdone==true) return true;
		return false;
		
	}
	
	public static boolean resourceRequest(int available[],int allocation[][],int need[][],int request[],int pid,int process, int resources){
		int n=process;
		int m=resources;
		int avail[]=new int[resources];
		int all[][]=new int[process][resources];
		int nd[][]=new int [process][resources];
		int req[]=new int[resources];
		int r=pid;
		//copying into other matrices to save original data
		for(int i=0;i<m;i++)
			avail[i]=available[i];
		
		for(int i=0;i<m;i++)
			req[i]=request[i];
		
		for(int i=0;i<n;i++)
			for(int j=0;j<m;j++)
				all[i][j]=allocation[i][j];
		
		for(int i=0;i<n;i++)
			for(int j=0;j<m;j++)
				nd[i][j]=need[i][j];
		boolean flag=true;
		
		for(int i=0;i<m;i++){
			if(nd[r][i] < req[i]) //requested is greater then need.. cant give 
				{flag=false; break;}
		}
		
		if(flag==false){ System.out.println("exceeding limit"); return false;}
		if(flag==true){
			for(int i=0;i<m;i++){
				if(avail[i] < req[i]) //available is less then request.. cant give
				{
					flag=false;
					break;
				}
			}
			if(flag==false){ System.out.println("wait"); return false;}
			
			if(flag==true){
				for(int i=0;i<m;i++)
			    {
			    all[r][i]+=req[i];
			    nd[r][i]-=req[i];
			    avail[i]-=req[i];
			    }
				
				if(safety(avail,all,nd,n,m))
				    return true;
				else
					{System.out.println("it leads to deadlock");return false;}
			}
		}
		return false;
		
		
	}
	
	
	
	public static void main(String args[])throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("enter the number of processes");
		int processes=Integer.parseInt(br.readLine());//int processes=5;
		
		System.out.println("enter the number of resources");
		int resources=Integer.parseInt(br.readLine());//int resources=3;
		
		int allocation[][]=new int[processes][resources];
		int maximum[][]=new int[processes][resources];
		int available[]=new int[resources];
		
		
		System.out.println("enter the allocation matrix");
		for(int i=0;i<processes;i++)
		{
			for(int j=0;j<resources;j++){
				allocation[i][j]=Integer.parseInt(br.readLine());
				
			}
		}
		
		System.out.println("enter the maximum matrix");
		for(int i=0;i<processes;i++)
		{
			for(int j=0;j<resources;j++){
				maximum[i][j]=Integer.parseInt(br.readLine());
				
			}
		}
		
		System.out.println("enter the available vector");
		for(int i=0;i<resources;i++)
			available[i]=Integer.parseInt(br.readLine());
		
		int need[][]=new int[processes][resources];
		for(int i=0; i< processes; i++)
			for(int j=0;j<resources; j++)
				need[i][j]=maximum[i][j]-allocation[i][j];
		
		boolean b=safety(available,allocation,need,processes,resources);
		if(b==true){
			System.out.println("system is in safe sequence");
			System.out.println(Arrays.toString(safe));
			
			System.out.println("resoruce request");
			System.out.println("enter the process");
			int pid=Integer.parseInt(br.readLine());
			int req[]=new int[resources];
			for(int i=0;i<resources;i++)
				req[i]=Integer.parseInt(br.readLine());
			if(resourceRequest(available,allocation,need,req,pid,processes,resources))
			{
				System.out.println("can be granted");
				for(int i=0;i<resources;i++)
				{
					allocation[pid][i]+=req[i];
					need[pid][i]-=req[i];
					available[i]-=req[i];
				}
				if(safety(available,allocation,need,processes,resources))
				{
					System.out.println("system is in safe mode");
					System.out.println(Arrays.toString(safe));
				}
				else
					System.out.println("unsafe");
			}
					
			
		}
		else
			System.out.println("Unsafe state (DEADLOCK)");
		
	}

}
