//coded by sunny_patel
//sjf non preemptive with arrival times
import java.io.*;

class Process{
	int burstTime,arrivalTime,turnAroundTime=0,waitingTime=0,copy_of_burstTime;
	String id;
	
	Process(int Atime, int Btime, String s){
		arrivalTime=Atime;
		burstTime=Btime;
		copy_of_burstTime=Btime;
		id=s;
	}
}
//Non preemtive SJF
public class SJF {
static int sum=0;
	
	public static void main(String ags[])throws IOException{
		
		BufferedReader br=new BufferedReader ( new InputStreamReader(System.in));
		System.out.println("enter the total number of processes");
		int n=Integer.parseInt(br.readLine());
		
		Process p[]=new Process[n];
		for(int i=0;i<n;i++){
			System.out.println("enter the process Id, arrival time and Burst time for "+(i+1)+"th process");
			String s=br.readLine();
			int a=Integer.parseInt(br.readLine());
			int b=Integer.parseInt(br.readLine());
			sum+=b;
			p[i]=new Process(a,b,s);
		}
		

		sjf(p);
	
			
	}

public static void sjf(Process op[]){
	double avgWaitingTime=0.0,avgTurnAroundTime=0.0;
for(int t=0;t<sum;)
    {
    
    int min=9999,index=0;    
    
    for(int j=0;j<op.length;j++)
        {
        
        if(op[j].arrivalTime<=t && op[j].burstTime < min && op[j].burstTime>0)
            {
            
            min=op[j].burstTime;
            index=j;
            
            }
        
        }
        //System.out.println(index);
        op[index].burstTime=0;
    	t+=op[index].copy_of_burstTime; 
	System.out.print("  |  "+op[index].id+" " + "(" + (t) +")" ); 
        
        
            op[index].turnAroundTime=t-op[index].arrivalTime;
            op[index].waitingTime=op[index].turnAroundTime-op[index].copy_of_burstTime;
            
	
    
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


/*OUTPUT

example 1:
C:\Users\Sunny\Desktop\code\java\os>javac SJF.java

C:\Users\Sunny\Desktop\code\java\os>java SJF
enter the total number of processes
4
enter the process Id, arrival time and Burst time for 1th process
p1
0
5
enter the process Id, arrival time and Burst time for 2th process
p2
1
15
enter the process Id, arrival time and Burst time for 3th process
p3
2
12
enter the process Id, arrival time and Burst time for 4th process
p4
3
25
GANTT CHART:
|  p1(5)  |  p3(17)  |  p2(32)  |  p4(57)  |
Waiting times:
p1: 0
p3: 3
p2: 16
p4: 29
Average waiting time: 12.0
Turn Around times:
p1: 5
p3: 15
p2: 31
p4: 54
Average turn around time:26.25


example 2:

enter the total number of processes
5
enter the process Id, arrival time and Burst time for 1th process
a
0
3
enter the process Id, arrival time and Burst time for 2th process
b
1
5
enter the process Id, arrival time and Burst time for 3th process
c
3
2
enter the process Id, arrival time and Burst time for 4th process
d
9
5
enter the process Id, arrival time and Burst time for 5th process
e
12
5
  |  a (3)  |  c (5)  |  b (10)  |  d (15)  |  e (20)
0  3
4  9
0  2
1  6
3  8
average waiting time: 1.6
average turnaround time: 5.6

*/
