//coded by sunny_patel
//this is related to project, but general logic remains the same
//follow the steps explained in class/textbook that itself is the logic!
//download "ip.txt" also
//Norm alized
import java.io.*;
class dataset
{
	String name;
	char g;
	int usage,age;
	String op1,op2;
}
class kmeansnor
{
	public static void main(String atrgs[])throws IOException
	{
		FileInputStream fstream = new FileInputStream("ip.txt");
		BufferedReader brf = new BufferedReader(new InputStreamReader(fstream));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
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
		brf.close();
		int agei[]=new int[z];
		double age[]=new double[z];
		double usage[]=new double[z];
		int usagei[]=new int[z];
		for(int i=0;i<z;i++)
		{
			agei[i]=ds[i].age;
			age[i]=(double)ds[i].age;
			usagei[i]=ds[i].usage;
			usage[i]=(double)ds[i].usage;
		}
		double dist[][]=new double[z][3];  //asuming k=2
		double meanprev[][]=new double[2][2];
		
		int maxage=-1,minage=11111,maxuse=0,minuse=11111;
		for(int i=0;i<z;i++)
		{
			if(agei[i]<minage) minage=(int)agei[i];
			if(agei[i]>maxage) maxage=(int)agei[i];			
			
			if(usagei[i]<minuse) minuse=(int)usagei[i];
			if(usagei[i]>maxuse) maxuse=(int)usagei[i];
		}
		for(int i=0;i<z;i++)
		{
			age[i]=1.0*(agei[i]-minage)/(maxage-minage);
			usage[i]=1.0*(usagei[i]-minuse)/(maxuse-minuse);
		}
		
		meanprev[0][0]=age[0]; meanprev[0][1]=usage[0];
		meanprev[1][0]=age[4]; meanprev[1][1]=usage[4];
		double mean[][]=new double[2][2];
		int c=0;
		while(true)
		{
			c++;
			for(int i=0;i<z;i++)
			{
				dist[i][0]=Math.abs(age[i]-meanprev[0][0]) + (double)Math.abs(usage[i]-meanprev[0][1]);
				dist[i][1]=Math.abs(age[i]-meanprev[1][0]) + (double)Math.abs(usage[i]-meanprev[1][1]);
				if(dist[i][0] < dist[i][1])
					dist[i][2]=1.0;
				else
					dist[i][2]=2.0;
				
			}
			int c1=0,c2=0;
			for(int i=0;i<z;i++)
			{
				if(dist[i][2]==1.0)
				{
					mean[0][0]+=age[i];
					mean[0][1]+=usage[i];
					c1++;
				}
				else
				{
					mean[1][0]+=age[i];
					mean[1][1]+=usage[i];
					c2++;
				}
			}
			mean[0][0]/=c1;
			mean[0][1]/=c1;
			mean[1][0]/=c2;
			mean[1][1]/=c2;
			if(mean[0][0]==meanprev[0][0] && mean[0][1]==meanprev[0][1] && mean[1][0]==meanprev[1][0] && mean[1][1]==meanprev[1][1])
				break;
			else
			{
				meanprev[0][0]=mean[0][0];
				meanprev[0][1]=mean[0][1];
				meanprev[1][0]=mean[1][0];
				meanprev[1][1]=mean[1][1];
				mean[0][0]=0;
				mean[0][1]=0;
				mean[1][0]=0;
				mean[1][1]=0;
			}
		}
		System.out.println("\nTotal number of iterations taken: "+c);
		System.out.println("\ncluster 1 mean(age,usage)\n ("+mean[0][0]+","+mean[0][1]+")\n");
		System.out.println("cluster 2 mean(age,usage)\n("+mean[1][0]+","+mean[1][1]+")\n");
	
		for(int i=0;i<z;i++)
		{
			System.out.println(agei[i]+ "\t" + usagei[i]+ "\tcluster " + dist[i][2]);
		}
	}
}
