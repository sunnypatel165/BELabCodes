//coded by sunny_patel
import java.util.*;
class Roundrobin
{
	int burstTime,pr,tat,waitingTime,copy_of_burstTime,arrivalTime;
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("enter no. of processes : ");
		int n=sc.nextInt();
		System.out.println("enter time quantum : ");
		int timeQuantam=sc.nextInt();
		int sum=0;
		Roundrobin process[] = new Roundrobin[n+1];       // creatng array of objects
		for(int i=0;i<=n;i++)
		    process[i]= new Roundrobin();
		//INPUT
		for(int m=1;m<=n;m++)
		{
			process[m].pr=m;
			System.out.println("enter burst time of process "+m);
			process[m].burstTime=sc.nextInt();
			sum+=process[m].burstTime;
			process[m].copy_of_burstTime=process[m].burstTime;
		}

		for(int m=1;m<=n;m++)
		{

			System.out.println("enter arrival time of process "+m);
			process[m].arrivalTime=sc.nextInt();
		}

		for(int i=1;i<=n;i++) //sort according to arrival
		{
			for(int j=1;j<n;j++)
			{
				if(process[j].arrivalTime > process[j+1].arrivalTime)
				{
					Roundrobin temp=process[j];
					process[j]=process[j+1];	
					process[j+1]=temp;
				}
			}
		}

		int t=0;
		while(t<sum)
		{
			for(int j=1;j<=n;j++)
			    {
				if(process[j].burstTime>0 && t>=process[j].arrivalTime)
			     {
					if(process[j].burstTime>timeQuantam)
			                {
                				process[j].burstTime-=timeQuantam;
				                t+=timeQuantam;
				                System.out.print("P"+j+" ("+t+") | ");
                			}
					else
               				 {
                				t+=process[j].burstTime;
						System.out.print("P"+j+" ("+t+") | ");
                				process[j].burstTime=0;
                				process[j].tat=t-process[j].arrivalTime;
                				process[j].waitingTime=t-process[j].copy_of_burstTime-process[j].arrivalTime;
                			 }
           			}            
			    }
			}
		int totalTurnAround=0,totalWaiting=0;    
		for(int i=1;i<=n;i++)
   		 {
    			totalTurnAround+=process[i].tat;
   			 totalWaiting+=process[i].waitingTime;
		}
		float avg_turn=(float)totalTurnAround/n;
		float avg_wait=(float)totalWaiting/n;
		for(int m=1;m<=n;m++)
   		{
				System.out.println("\nprocess "+process[m].pr);
    			System.out.print("turn around time : "+process[m].tat);
    			System.out.print("     waiting time : "+process[m].waitingTime);
		}
		System.out.println("\ntotal turn around time : "+totalTurnAround);
		System.out.println("total waiting time : "+totalWaiting);    
		System.out.println("avg turn around time : "+avg_turn);
		System.out.println("avg waiting time : "+avg_wait);

		}
	}
