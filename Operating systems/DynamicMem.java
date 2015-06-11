//coded by sunny_patel
//this is memory allocation using Link list..coob has using arrays! 

import java.io.*;
import java.util.*;
//size is the size of the chunk/ memory partition
//used is already allocated
//id is the process holding that block
class Node
{
	int size;
	int used;
	String id;
	boolean isFull=false;
	Node next;
	
	Node(String a, int s, int u){
		id=a;
		size=s;
		used=u;
		next=null;
		if(used==size) isFull=true; // if full keep true
	}
}
	public class DynamicMem{
		
		// this class will have first and last pointers to LL nodes
		// previous will be used for next fit
		// 3 methods obviously for FF, NF and BF
		//insert=insert end of LL
		// 
	Node first=null,last=null,previous=null;
	public void insert(String s, int n, int u)
	{
		
		Node newNode=new Node(s,n,u);
		if(n==u){
			newNode.isFull=true;
		}
		if(first==null)
		{
			first=newNode;
			last=newNode;
			previous=newNode;
		}
		else
		{
			last.next=newNode;
			newNode.next=null;
			last=newNode;
		}
	}
	
	public void display(){
		Node temp=first;
		while(temp!=null){
			System.out.println(temp.id+" "+temp.size+" "+temp.used+" "+temp.isFull);
			temp=temp.next;
		}
	}
	
	//split does this: a=b+c
	// a is original! b will be the minimum required of a and c is remaining of a
	//which is the index of the node to be splie
	public void split(String name,int s, int which){
		
		Node temp=first;
		while(which!=0) // reach to the node to be split
		{
			temp=temp.next;
			which--;
		}
		
		Node n=new Node(name,temp.size-temp.used,s);
		temp.size=temp.used; // minimum of a ie give only the required
		temp.isFull=true; //   -------"-------------
		
		n.next=temp.next; //acts as insert pos of DSF
		temp.next=n;    // ----------"---------
		
		previous=temp; //imp for nf
	}
	
	public void firstFit()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the process name and size required");
		String name=sc.next();
		int req=sc.nextInt();
		Node temp=first;
		boolean flag=false;
		int c=0;
		//traverse the whole list till youe find the position where it can fit(FF def)
		while(temp!=null){
			if(temp.isFull==true || (temp.size-temp.used) < req)
				temp=temp.next;
			else
			{
				split(name,req,c); //split
				flag=true;
				break;
			}
			c++;// to take care of the position! we need to pass the position while splitting
		}
		if(flag==true)
			display();
		else
			System.out.println("cant find place");
		
	}
	
	public void bestFit()
	{
		//find the smallest hole possible
		//so traverse the whole list and find the smallest hole that can accommodate the process
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the process name and size required");
		String name=sc.next();
		int req=sc.nextInt();
		
		Node temp=first;
		boolean flag=false;
		int c=0,best=100000,pos=-1;
		
		while(temp.next!=null){//traverse list
			
			if(temp.isFull==true) //cant allot
				temp=temp.next;
			else if(temp.size - temp.used < req) ///cant allot
				temp=temp.next;
			
			else if(temp.size - temp.used >= req) //can allot
			{
				if((temp.size-temp.used) < best){ // if smaller then previous
					best=temp.size-temp.used;
					pos=c;
				flag=true;
				
				}
				temp=temp.next;
			}
			c++;
		}
		System.out.println(flag);
		if(flag==false) System.out.println("sorry no place");
		else
		{
			System.out.println(pos);
			split(name,req,pos);
			temp=first;
			while(pos!=0){ 
				temp=temp.next;
				pos--;
			}
			
			if(temp.used==temp.size) temp.isFull=true;
			display();
					
		}
	}
	
	public void nextFit()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the process name and size required");
		String name=sc.next();
		int req=sc.nextInt();
		Node temp=first;
		boolean flag=false;
		int c=0;
		System.out.println(previous.id);
		while(temp!=previous){ c++; temp=temp.next;}
		//c++; temp=temp.next;
		if(temp.next!=null)
			{temp=temp.next;}
		else {c=0;temp=first;}
		
		one:while(temp!=previous)
		{
			if(temp==null){c=0;
				temp=first;}
			else if(temp.size - temp.used >= req)
			{
				split(name,req,c+1);
				
				if(temp.used==temp.size) temp.isFull=true;
				flag=true;
				break one;
			}
			else {c++;temp=temp.next;}
		}
		if(flag==false)
			System.out.println("no place");
		else display();
		}
		
		
	
public static void main(String argd[]){
	DynamicMem d=new DynamicMem();
	Scanner sc=new Scanner(System.in);
	System.out.println("enter the number of chunks");
	int n=sc.nextInt();
	System.out.println("enter all id, size, used");
	for(int i=0;i<n;i++)
	{
	
		String s=sc.next();
		int si=sc.nextInt();
		int u=sc.nextInt();
		d.insert(s,si,u);
	}
	
	d.firstFit();
	d.bestFit();
	d.nextFit();
	}
	
	
}


