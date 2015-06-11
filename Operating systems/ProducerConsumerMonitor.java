import java.util.*;
/*


Main class - ProducerConsumerMonitor
within this class there are subclasses:
1.Producer - calls the insert method
2.Consumer - calls the remove method
3.Monitor:
Monitor contains the synchronized methods:
insert()
remove()

 
 */


class ProducerConsumerMonitor
 {
    static Monitor monitor;

    public ProducerConsumerMonitor(int maxSize)
    {
	monitor = new Monitor(maxSize);
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

   class Producer extends Thread
{
        public void run()
	 {
                try
                 {
                    monitor.insert();
                } catch (InterruptedException e) {}
        }
    }

    class Consumer extends Thread
{
        public void run()
	 {
                try
                {
                    monitor.remove();
                } catch (InterruptedException e) {}
        }
 }

    
 class Monitor
 {
          int n;
          int maxSize;

         public Monitor(int maxSize)
         {
             n=1;        //n=0;
             this.maxSize = maxSize;
         }

         //synchronized -- ensures that only one jave thread execeutes the object's synchronized method at a time

        synchronized void insert() throws InterruptedException 
        {
            if(n==maxSize+1)               //n==maxSize
	        { 
		  System.out.println("Cannot produce more items.");     
		  wait();
		}
           System.out.println("Producer: "+n++);
           if(n==2)                 //n==1
           	notify();
        }
        
	
        synchronized void remove() throws InterruptedException 
        {
            if(n==1)                //n==0
              {
 		System.out.println("Cannot consume more items"); 
		wait();	 
	}
            System.out.println("Consumer: "+(--n));            //n--
            if(n==maxSize)              //n==maxSize-1
               notify();
        }

   /*
         1) wait( ) -- tells the calling thread to give up the monitor and go to sleep until some other 
                       thread enters the same monitor and calls notify( ).
         2) notify( ) -- wakes up the first thread that called wait( ) on the same object.
         3) notifyAll( ) -- wakes up all the threads that called wait( ) on the same object. 
            The highest priority thread will run first.

       */

    }
 //wait and notifyall go hand in hand!!
 

 
     public static void main(String args[]) 
     {
 	
      ProducerConsumerMonitor pc = new ProducerConsumerMonitor(5);	// send buffer size
 
     }
 }

