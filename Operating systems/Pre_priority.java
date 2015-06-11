//coded by sunny_patel
import java.util.*;
class Pre_priority
{
	int burstTime,arrivalTime,process,pri,turnAroundTime,waitingTime,copy_of_burstTime;


	public static void main(String args[])
	{
	Scanner sc = new Scanner(System.in);
	System.out.println("enter no. of processes : ");
	int n=sc.nextInt();


	Pre_priority op[] = new Pre_priority[n+1];       // create array of objects


	for(int i=0;i<=n;i++)
		    op[i]= new Pre_priority();
	int sum=0;
	for(int m=1;m<=n;m++)
	{
		op[m].process=m;
		System.out.println("enter burst time,arrival time  and  priority of process "+m);
		op[m].burstTime=sc.nextInt();
		op[m].arrivalTime=sc.nextInt();
		op[m].pri=sc.nextInt();
		sum+=op[m].burstTime;
		op[m].copy_of_burstTime=op[m].burstTime;
	}
	int t=0;
	while(t<sum)
  		  {
    
   	 int min=9999,index=-1;    
    
    	for(int j=1;j<=n;j++)
       	 {
        
       	 if(op[j].arrivalTime<=t && op[j].pri<min && op[j].burstTime>0)
            {
            
            min=op[j].pri;
            index=j;
            
            }
        
        }
        
        op[index].burstTime-=1;
	System.out.print("  |  p"+index+" " + "(" + (t+1) +")" ); 
        
        if(op[index].burstTime==0)
            {
            op[index].turnAroundTime=t-op[index].arrivalTime+1;
            op[index].waitingTime=op[index].turnAroundTime-op[index].copy_of_burstTime;
            }
	t++;
    
    }
System.out.println();
int tot_turn=0,tot_wait=0;    
for(int i=1;i<=n;i++)
    {
    
    tot_turn+=op[i].turnAroundTime;
    tot_wait+=op[i].waitingTime;
    
    }
float avg_turn=(float)tot_turn/n;
float avg_wait=(float)tot_wait/n;


for(int m=1;m<=n;m++)
    {

    System.out.println("\nprocess "+op[m].process);
    System.out.print("turn around time : "+op[m].turnAroundTime);
    System.out.print("     waiting time : "+op[m].waitingTime);
    }
	System.out.println("\ntotal turn around time : "+tot_turn);
	System.out.println("total waiting time : "+tot_wait);    
	System.out.println("avg turn around time : "+avg_turn);
	System.out.println("avg waiting time : "+avg_wait);


	}


}
