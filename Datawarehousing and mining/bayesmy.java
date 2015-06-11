//coded by sunny_patel
//this is related to project, but general logic remains the same
//follow the steps explained in class/textbook that itself is the logic!
//download "ip.txt" also
import java.io.*;
class dataset
{
	String name;
	char g;
	int usage,age;
	String op1,op2;
}


class Main
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


		int count[][]=new int[2][3];
		int countc[][]=new int[6][3];

		double prob[][]=new double[2][3];
		double probc[][]=new double[6][3];
		
		for(int i=0;i<z;i++)
		{
			if(ds[i].op1.compareTo("low")==0 && ds[i].g=='M')
				count[0][0]++;
			if(ds[i].op1.compareTo("medium")==0 && ds[i].g=='M')
				count[0][1]++;
			if(ds[i].op1.compareTo("high")==0 && ds[i].g=='M')
				count[0][2]++;
			
			if(ds[i].op1.compareTo("low")==0 && ds[i].g=='F')
				count[1][0]++;
			if(ds[i].op1.compareTo("medium")==0 && ds[i].g=='F')
				count[1][1]++;
			if(ds[i].op1.compareTo("high")==0 && ds[i].g=='F')
				count[1][2]++;
		}

		int totallow=count[0][0]+count[1][0]+1; // +1 otherwise NAN error
		int totalMed=count[0][1]+count[1][1]+1;
		int totalhigh=count[0][2]+count[1][2]+1;

		for(int i=0;i<2;i++)
			for(int  j=0;j<3;j++)
			{
				prob[i][j]=count[i][j]*1.0;
				if(j==0) prob[i][j]/=totallow;
				if(j==1) prob[i][j]/=totalMed;
				if(j==2) prob[i][j]/=totalhigh;
			}
		for(int i=0;i<z;i++)
		{
			if(ds[i].usage>=0 && ds[i].usage<=300)
			{
				if(ds[i].op1.compareTo("low")==0)  countc[0][0]++;
				if(ds[i].op1.compareTo("medium")==0)  countc[0][1]++;
				if(ds[i].op1.compareTo("high")==0)  {countc[0][2]++;}
			}
			else if(ds[i].usage>300 && ds[i].usage<=600)
			{
				if(ds[i].op1.compareTo("low")==0)  countc[1][0]++;
				if(ds[i].op1.compareTo("medium")==0)  countc[1][1]++;
				if(ds[i].op1.compareTo("high")==0)  countc[1][2]++;
			}
			else if(ds[i].usage>600 && ds[i].usage<=900)
			{
				if(ds[i].op1.compareTo("low")==0)  countc[2][0]++;
				if(ds[i].op1.compareTo("medium")==0)  countc[2][1]++;
				if(ds[i].op1.compareTo("high")==0)  countc[2][2]++;
			}
			else if(ds[i].usage>900 && ds[i].usage<=1200)
			{
				if(ds[i].op1.compareTo("low")==0)  countc[3][0]++;
				if(ds[i].op1.compareTo("medium")==0)  countc[3][1]++;
				if(ds[i].op1.compareTo("high")==0)  countc[3][2]++;
			}
			else if(ds[i].usage>1200 && ds[i].usage<=1500)
			{
				if(ds[i].op1.compareTo("low")==0)  countc[4][0]++;
				if(ds[i].op1.compareTo("medium")==0)  countc[4][1]++;
				if(ds[i].op1.compareTo("high")==0)  countc[4][2]++;
			}
			else if(ds[i].usage>1500)
			{
				if(ds[i].op1.compareTo("low")==0)  countc[5][0]++;
				if(ds[i].op1.compareTo("medium")==0)  countc[5][1]++;
				if(ds[i].op1.compareTo("high")==0)  countc[5][2]++;
			}
		}
		for(int i=0;i<6;i++)
		{
			for(int j=0;j<3;j++)
			{
				if(j==0) probc[i][j]=countc[i][j]*1.0/totallow;
				if(j==1) probc[i][j]=countc[i][j]*1.0/totalMed;
				if(j==2) probc[i][j]=countc[i][j]*1.0/totalhigh;
			}
		}
				
		System.out.println("Enter the new tuple to be classfied (name,gender,usage,age)");
		String namenew=br.readLine();
		char ge=br.readLine().charAt(0);
		int h=Integer.parseInt(br.readLine());
		int agenew=Integer.parseInt(br.readLine());
		double ps,pm,pt,ls,lm,lt;
		int index=0;
			if(h>=0 && h<=300) index=0;
			else if(h>300 && h<=600) index=1;
			else if(h>600 && h<=900) index=2;
			else if(h>900 && h<=1200) index=3;
			else if(h>1200 && h<=1500) index=4;
			else if(h>1500) index=5;
		if(ge=='M')
		{
			ps=prob[0][0]*probc[index][0];
			pm=prob[0][1]*probc[index][1];
			pt=prob[0][2]*probc[index][2];
		}
		else
		{
			ps=prob[1][0]*probc[index][0];
			pm=prob[1][1]*probc[index][1];
			pt=prob[1][2]*probc[index][2];
		}
		
			ls=ps*totallow/z;
			lm=pm*totalMed/z;
			lt=pt*totalhigh/z;
			
		double ptt=ls+lm+lt;
		double pst=ls/ptt;
		double pmt=lm/ptt;
		double ptta=lt/ptt;
		System.out.println("On the basis of Naive bayes classfication, the new tuple can be classified as:");
		if(pst>=pmt && pst>=ptta) System.out.println("Low");
		if(pmt>=pst && pmt>=ptta) System.out.println("Medium");
		if(ptta>=pst && ptta>=pmt) System.out.println("High");
	}
}