//coded by sunny_patel
//to make generlised, take input of number of ttransactions,items and transaction matrix!! and also add thsoe many items
//might not work on 100% inputs! tried to keep it simple
import java.io.*;
import java.util.*;
class apriori
{
	public static void main(String args[])throws IOException
	{
		//any of the following 2 will work!! these are examples given in classs
		/*int trans[][]={ 
				{1,0,1,1,0} ,
				{0,1,1,0,1}, 
				{1,1,1,0,1},
				{0,1,0,0,1}
			 };*/
		int trans[][]={ 
				{0,1,1,0,1} ,
				{0,1,0,0,1}, 
				{0,1,0,1,0},
				{1,1,0,0,0},
				{1,0,0,1,0}
			 };
		
		int minsup=2;
		Vector<String> v=new Vector<String>();
		Vector<String> L=new Vector<String>();
		Vector<Integer> sup=new Vector<Integer>();
		v.add("A");
		v.add("B");
		v.add("C");
		v.add("D");
		v.add("E");
		int it=1;
		//int c=0;
while(true){
		it+=1;
		for(int i=0;i<v.size();i++)
			sup.add(0);
		for(int i=0;i<v.size();i++)
		{
			String t=v.get(i);
			boolean found=true;
			int tempcnt=0;
			for(int k=0;k<trans.length;k++)
			{
				boolean innerfound=true;
				for(int j=0;j<t.length();j++)
				{
					if(trans[k][t.charAt(j)-'A']!=1) { innerfound=false;break;}
				}
				if(innerfound)
				{
					tempcnt++;
				}
			}
				int temp=sup.get(i);
				sup.set(i,(temp+tempcnt));

		}
		System.out.println("\nCANDIDATE SET:\n");
		for(int i=0;i<v.size();i++)
			System.out.println(v.get(i)+"\t"+sup.get(i));
		
		for(int i =0;i<v.size();i++)
		{
			if(sup.get(i)>=minsup)
			{
				L.add(v.get(i));
			}
		}
		System.out.println("\nLARGE ITEM SET:\n");
		if(L.size()==1)
		{
			System.out.println(L.get(0));	
			break;
		}

		v.removeAllElements();
		sup.removeAllElements();
		for(int i =0;i<L.size();i++)
			System.out.println(L.get(i));

		for(int i=0;i<L.size();i++)
		{
			for(int j=i+1;j<L.size();j++)
			{
				String t1=L.get(i);
				String t2=L.get(j);
				String t=t1+t2;
				char temp[]=t.toCharArray();
				for(int x=0;x<t.length();x++)
					for(int y=x+1;y<t.length();y++)
						if(temp[x]==temp[y])
							temp[y]='#';
				t=new String(temp);
				t=t.replaceAll("#","");
				temp=t.toCharArray();
				Arrays.sort(temp);
				if(t.length()==it)
				{
					boolean already=false;
					char tempnew[];
					for(int x=0;x<v.size();x++)
					{
						String curr=v.get(x);
						tempnew=curr.toCharArray();
						Arrays.sort(tempnew);
						if(new String(tempnew).compareTo(new String(temp))==0)
							{already=true;
							break;}
					}
					if(!already)
					v.add(t);
				}
				
			}
		}
		L.removeAllElements();
		}

		//uncomment following if you want association rules!!! 
		//for pracs they are considering allowing not to print them! but not sure yet!!

		/*
		String t=L.get(0);	//assumption :only 1 item remains, for generalising, run a loop :/
		int num=sup.get(v.indexOf(t));
		
		doit(""+t.charAt(0),trans,t,num);
		doit(""+t.charAt(1),trans,t,num);
		if(t.length()==3)
		{
			doit(""+t.charAt(2),trans,t,num);
			doit(""+t.charAt(0)+t.charAt(1),trans,t,num);
			doit(""+t.charAt(1)+t.charAt(2),trans,t,num);
			doit(""+t.charAt(0)+t.charAt(2),trans,t,num);
		}
		*/
		
		
	}
	/*
	public static void doit(String s,int trans[][],String t,int num)		//uncomment if you want ass rules
	{
		int minconf=75;
		boolean found=true;
		int tempcnt=0;
		for(int k=0;k<trans.length;k++)
		{
			boolean innerfound=true;
			for(int j=0;j<s.length();j++)
			{
				if(trans[k][s.charAt(j)-'A']!=1) { innerfound=false;break;}
			}
			if(innerfound)
				tempcnt++;
		}	
		if((num/tempcnt)*100 >=75)
			System.out.println(s+" -> "+t.replaceAll(s,""));
	}
	*/
}
