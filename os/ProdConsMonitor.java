import java.util.*;

class ProdConsMonitor
{
	static Monitor monitor;
	ProdConsMonitor(int maxsize)
	{
		monitor=new Monitor(maxsize);
		int ch;       
	Scanner sc=new Scanner(System.in);
	do
	{
	System.out.println("Enter 1 to produce 2 to consume and 3 to exit");
	ch=sc.nextInt();
	switch(ch)
	{
	case 1: new Producer().start(); // Producer is called with parenthesis!!
		break;
	case 2:new Consumer().start();
		break;  
	//case 3: break;
	}
	}while (ch!=3);	
    }

	class Monitor
	{
		int maxsize,n;
		Monitor(int m)
		{
			n=1;
			maxsize=m;
		}
		
		synchronized void insert() throws InterruptedException
		{
			if(n==maxsize+1)
			{
				System.out.println("can not produce more");
				wait();
			}
			System.out.println("producer: "+ ( n++ ));
			if(n==2)
				notify();
		}


		synchronized void remove() throws InterruptedException
		{
			if(n==1)
			{
				System.out.println("can not consume more");
				wait();
			}
			System.out.println("producer: "+ ( --n ));
			if(n==maxsize)
				notify();
		}
	
	}

	class Producer extends Thread
	{
		public void run()
		{
			try
			{
				monitor.insert();
			}catch(Exception e){}
		}
	}
	
	class Consumer extends Thread
	{
		public void run()
		{
			try
			{
				monitor.remove();
			}catch(Exception e){}
		}
	}

	public static void main(String args[])
	{
		ProdConsMonitor p=new ProdConsMonitor(5);
	}
}