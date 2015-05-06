//coded by sunny_patel
import java.io.*;
import java.util.*;

class Process
{
	String id;
	int burstTime,priority,arrivalTime,turnAroundTime,waitingTime;
	Process(String a,int b,int c, int d)
	{
		id=a;
		burstTime=b;
		priority=c;
		arrivalTime=d;
	}

}

class PrioNonPre{
	public static void main(String args[])throws IOException{

	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

	System.out.println("enter the number of processes");
	int n=Integer.parseInt(br.readLine());
	
	Process op[]=new Process[n];
	int sum=0;

	for(int i=0;i<n;i++)
	{
		System.out.println("Enter ID, Bursttime, priority and arrival time for "+ (i+1) +"th process: ");
		String a=br.readLine();
		int b=Integer.parseInt(br.readLine());
		int c=Integer.parseInt(br.readLine());	
		int d=Integer.parseInt(br.readLine());
		op[i]=new Process(a,b,c,d);
		sum+=b;
	}





	double avgWaitingTime=0.0,avgTurnAroundTime=0.0;
	for(int t=0;t<sum;)
  	  {
    
   	 int min=9999,index=0,minburst=9999;    
    
    	for(int j=0;j<op.length;j++)
       	 {
        
        	if(op[j].arrivalTime <= t && op[j].priority<min && op[j].burstTime!=0)
           	 {
            
           	 	minburst=op[j].burstTime;
           	 	min=op[j].priority;
            	index=j;
            	}
        
       	 }
       	t+=op[index].burstTime; 
       	System.out.print("  |  "+op[index].id+" " + "(" + (t) +")" ); 
        op[index].turnAroundTime=t-op[index].arrivalTime;
        op[index].waitingTime=op[index].turnAroundTime-op[index].burstTime;
        op[index].burstTime=0;
	}
	
	System.out.println();
	for(int i=0;i<op.length;i++)
	{
		System.out.println(op[i].waitingTime+"  "+op[i].turnAroundTime);
		avgWaitingTime+=op[i].waitingTime;
		avgTurnAroundTime+=op[i].turnAroundTime;
	}
	System.out.println("average waiting time: "+(avgWaitingTime/op.length));
	System.out.println("average turnaround time: "+(avgTurnAroundTime/op.length));
	}
}