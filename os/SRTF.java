//coded by sunny_patel
import java.io.*;
class SRTF
{
	int burstTime,copyOfBurstTime,arrivalTime,waitingTime,turnAroundTime;
	String id;

	public static void main(String args[])throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("enter the number of processes");
		int n=Integer.parseInt(br.readLine());
		SRTF process[]=new SRTF[n+1];
		int sum=0;
		
		for(int i=0;i<=n;i++)
			process[i]=new SRTF();
		System.out.println("enter the id, burstime and arrival times of all");//ip all in new lines
		for(int i=1;i<=n;i++)
		{
			process[i].id=br.readLine();
			process[i].burstTime=Integer.parseInt(br.readLine());
			process[i].arrivalTime=Integer.parseInt(br.readLine());
			process[i].copyOfBurstTime=process[i].burstTime;
			process[i].waitingTime=0;
			process[i].turnAroundTime=0;
			sum+=process[i].burstTime;
		}
		for(int i=1;i<=n;i++) //sort according to arrival
		{
			for(int j=1;j<n;j++)
			{
				if(process[j].arrivalTime > process[j+1].arrivalTime)
				{
					SRTF temp=process[j];
					process[j]=process[j+1];	
					process[j+1]=temp;
				}
			}
		}
		int t=0;
		while(t<sum)
		{
			int min=100000,index=-1;
			for(int i=1;i<=n;i++)
			{
				if(process[i].arrivalTime<=t && process[i].burstTime!=0 && process[i].burstTime < min)
				{
					index=i; 
					min=process[i].burstTime;
				}
			}
	
			System.out.print(process[index].id+" ("+(t+1)+") | ");
			process[index].burstTime-=1;
			if(process[index].burstTime==0)
				{
				process[index].turnAroundTime=t+1-process[index].arrivalTime;
                		process[index].waitingTime=t+1-process[index].copyOfBurstTime-process[index].arrivalTime;
				}
			t++;
		}
		System.out.println();
		double averageWaitingTime=0,averageTurnAroundTime=0;
		for(int i=1;i<=n;i++){
			System.out.println(process[i].id+" "+process[i].turnAroundTime+" "+process[i].waitingTime);
			averageWaitingTime+=process[i].waitingTime;
			averageTurnAroundTime+=process[i].turnAroundTime;
		}
		averageWaitingTime/=n; averageTurnAroundTime/=n;
		System.out.println("average waiting time: "+averageWaitingTime);
		System.out.println("average turn around time: "+averageTurnAroundTime);
	}
}
