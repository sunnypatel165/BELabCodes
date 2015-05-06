//coded by sunny_patel
//this is related to project, but general logic remains the same
//follow the steps explained in class/textbook that itself is the logic!
//download "ip.txt" also

import java.io.*;
import java.util.*;
class dataset
{
	String name;
	char g;
	int usage,age;
	String op1,op2;
}
class knn
{
	public static void main(String atrgs[])throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	
		FileInputStream fstream = new FileInputStream("ip.txt");
		BufferedReader brf = new BufferedReader(new InputStreamReader(fstream));
		String line;
		dataset ds[]=new dataset[10000];
		for(int i=0;i<10000;i++)
		{
			ds[i]=new dataset();
		}
		int z=0;
		while ((line = brf.readLine()) != null) {
  			ds[z].name=line.split(",")[0];
  			ds[z].g=line.split(",")[1].charAt(0);
			ds[z].age=Integer.parseInt(line.split(",")[2]);
			ds[z].usage=Integer.parseInt(line.split(",")[3]);
			ds[z].op1=line.split(",")[4];
			ds[z].op2=line.split(",")[5];
			z++;
		}
		System.out.println(z);
		brf.close();

		int la=99999,ha=0,lm=99999,hm=0;
		for(int i=0;i<z;i++)
		{
			if(ds[i].age<la) la=ds[i].age;
			if(ds[i].age>ha) ha=ds[i].age;
			if(ds[i].usage<lm) lm=ds[i].usage;
			if(ds[i].usage>hm)hm=ds[i].usage;
		}
		double na[]=new double[z];
		double nm[]=new double[z];
		int da=ha-la;
		int dm=hm-lm;
		for(int i=0;i<z;i++)
		{
			na[i]=1.0*(ds[i].age-la)/(1.0*da);
			nm[i]=1.0*(ds[i].usage-lm)/(1.0*dm);	
		}
		System.out.println("Enter the new tupple(name,gender, age,usage");
		String nnew;
		int minsnew,agenew;
		char gnew;

		nnew=br.readLine();
		gnew=br.readLine().charAt(0);
		agenew=Integer.parseInt(br.readLine());
		minsnew=Integer.parseInt(br.readLine());

		double nanew=1.0*(agenew-la)/da;
		double nmnew=1.0*(minsnew-lm)/dm;

		
		double dist[]=new double[z];
		int index[]=new int[z];
		for(int i =0;i<z;i++)
		{
			index[i]=i;
			dist[i]=(na[i]-nanew)*(na[i]-nanew);
			dist[i]+=(nm[i]-nmnew)*(nm[i]-nmnew);
			dist[i]=Math.sqrt(dist[i]);
		}
		for(int i=0;i<z-1;i++)
		{
			for(int j=0;j<z-1;j++)
			{
				if(dist[j]>dist[j+1])
				{
					double temp=dist[j];
					dist[j]=dist[j+1];
					dist[j+1]=temp;
					
					int x=index[j];
					index[j]=index[j+1];
					index[j+1]=x;
				}
			}
		}	
		int ch=0,cm=0,cl=0,k=3;
		
		for(int c=0;c<k;c++)
		{
			for(int i=0;i<k;i++)
			{
				if((ds[index[i]].op1).compareTo("high")==0) ch++;
				if(ds[index[i]].op1.compareTo("medium")==0) cm++;
				if(ds[index[i]].op1.compareTo("low")==0)cl++;
			}
			if(ch==cl || cl==cm || ch==cm && k<z-3 && ch!=0 && cm!=0 && cl!=0)  k+=2;
			else
			{
				System.out.println("K = "+k);
				System.out.println("On the basis of k nearest neighbours the new tuple can be classified as:");
				if(cl>ch && cl>cm) System.out.println("Low");
				if(cm>ch && cm>cl)System.out.println("Medium");
				if(ch>cl && ch>cm)System.out.println("High");
				break;
			}
		}
	}
}
