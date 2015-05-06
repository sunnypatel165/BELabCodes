//coded by sunny_patel
//Bayes Classification
import java.io.*;
class dataset
{
	String name;
	char g;
	double height;
	String op1,op2;
}


class Main
{
	public static void main(String atrgs[])throws IOException
	{
		dataset ds[]=new dataset[15];
		for(int i=0;i<15;i++)
		{
			ds[i]=new dataset();
			ds[i].name="A"+(char)i;
		}
		ds[0].g='F'; ds[0].height=1.6; ds[0].op1="short";
		ds[1].g='M'; ds[1].height=2.0; ds[1].op1="tall";
		ds[2].g='F'; ds[2].height=1.9; ds[2].op1="medium";
		ds[3].g='F'; ds[3].height=1.88; ds[3].op1="medium";
		ds[4].g='F'; ds[4].height=1.7; ds[4].op1="short";
		ds[5].g='M'; ds[5].height=1.85; ds[5].op1="medium";
		ds[6].g='F'; ds[6].height=1.6; ds[6].op1="short";
		ds[7].g='M'; ds[7].height=1.7; ds[7].op1="short";
		ds[8].g='M'; ds[8].height=2.2; ds[8].op1="tall";
		ds[9].g='M'; ds[9].height=2.1; ds[9].op1="tall";
		ds[10].g='F'; ds[10].height=1.8; ds[10].op1="medium";
		ds[11].g='M'; ds[11].height=1.95; ds[11].op1="medium";
		ds[12].g='F'; ds[12].height=1.9; ds[12].op1="medium";
		ds[13].g='F'; ds[13].height=1.8; ds[13].op1="medium";
		ds[14].g='F'; ds[14].height=1.75; ds[14].op1="medium";
	



		int count[][]=new int[2][3];
		int countc[][]=new int[6][3];

		double prob[][]=new double[2][3];
		double probc[][]=new double[6][3];
		
		for(int i=0;i<15;i++)
		{
			System.out.println(ds[i].op1+" "+ds[i].g);
			if(ds[i].op1.compareTo("short")==0 && ds[i].g=='M')
				count[0][0]++;
			if(ds[i].op1.compareTo("medium")==0 && ds[i].g=='M')
				count[0][1]++;
			if(ds[i].op1.compareTo("tall")==0 && ds[i].g=='M')
				count[0][2]++;
			
			if(ds[i].op1.compareTo("short")==0 && ds[i].g=='F')
				count[1][0]++;
			if(ds[i].op1.compareTo("medium")==0 && ds[i].g=='F')
				count[1][1]++;
			if(ds[i].op1.compareTo("tall")==0 && ds[i].g=='F')
				count[1][2]++;
		}
		
		int totalShort=count[0][0]+count[1][0];
		int totalMed=count[0][1]+count[1][1];
		int totalTall=count[0][2]+count[1][2];

		for(int i=0;i<2;i++)
			for(int  j=0;j<3;j++)
			{
				prob[i][j]=count[i][j]*1.0;
				if(j==0) prob[i][j]/=totalShort;
				if(j==1) prob[i][j]/=totalMed;
				if(j==2) prob[i][j]/=totalTall;
			}
		for(int i=0;i<15;i++)
		{
			if(ds[i].height>=0 && ds[i].height<=1.6)
			{
				if(ds[i].op1.compareTo("short")==0)  countc[0][0]++;
				if(ds[i].op1.compareTo("medium")==0)  countc[0][1]++;
				if(ds[i].op1.compareTo("tall")==0)  { System.out.println(i);countc[0][2]++;}
			}
			else if(ds[i].height>1.6 && ds[i].height<=1.7)
			{
				if(ds[i].op1.compareTo("short")==0)  countc[1][0]++;
				if(ds[i].op1.compareTo("medium")==0)  countc[1][1]++;
				if(ds[i].op1.compareTo("tall")==0)  countc[1][2]++;
			}
			else if(ds[i].height>1.7 && ds[i].height<=1.8)
			{
				if(ds[i].op1.compareTo("short")==0)  countc[2][0]++;
				if(ds[i].op1.compareTo("medium")==0)  countc[2][1]++;
				if(ds[i].op1.compareTo("tall")==0)  countc[2][2]++;
			}
			else if(ds[i].height>1.8 && ds[i].height<=1.9)
			{
				if(ds[i].op1.compareTo("short")==0)  countc[3][0]++;
				if(ds[i].op1.compareTo("medium")==0)  countc[3][1]++;
				if(ds[i].op1.compareTo("tall")==0)  countc[3][2]++;
			}
			else if(ds[i].height>1.9 && ds[i].height<=2.0)
			{
				if(ds[i].op1.compareTo("short")==0)  countc[4][0]++;
				if(ds[i].op1.compareTo("medium")==0)  countc[4][1]++;
				if(ds[i].op1.compareTo("tall")==0)  countc[4][2]++;
			}
			else if(ds[i].height>2.0)
			{
				if(ds[i].op1.compareTo("short")==0)  countc[5][0]++;
				if(ds[i].op1.compareTo("medium")==0)  countc[5][1]++;
				if(ds[i].op1.compareTo("tall")==0)  countc[5][2]++;
			}
		}
		for(int i=0;i<6;i++)
		{
			for(int j=0;j<3;j++)
			{
				if(j==0) probc[i][j]=countc[i][j]*1.0/totalShort;
				if(j==1) probc[i][j]=countc[i][j]*1.0/totalMed;
				if(j==2) probc[i][j]=countc[i][j]*1.0/totalTall;
			}
		}
		for(int i=0;i<6;i++)
		{
			for(int j=0;j<3;j++)
				System.out.print(probc[i][j]+"\t");
			System.out.println();
		}
		double h=1.95;
		char ge='M';
		double ps,pm,pt,ls,lm,lt;
		int index=0;
			if(h>=0 && h<=1.6) index=0;
			else if(h>1.6 && h<=1.7) index=1;
			else if(h>1.7 && h<=1.8) index=2;
			else if(h>1.8 && h<=1.9) index=3;
			else if(h>1.9 && h<=2.0) index=4;
			else if(h>2.0) index=5;
		if(ge=='M')
		{
			ps=prob[0][0]*probc[index][0];
			pm=prob[0][1]*probc[index][1];
			pt=prob[0][2]*probc[index][2];
		}
		else
		{
			ps=prob[0][0]*probc[index][0];
			pm=prob[0][1]*probc[index][1];
			pt=prob[0][2]*probc[index][2];
		}
		
			ls=ps*totalShort/15;
			lm=pm*totalMed/15;
			lt=pt*totalTall/15;
			
		double ptt=ls+lm+lt;
		double pst=ls/ptt;
		double pmt=lm/ptt;
		double ptta=lt/ptt;
		System.out.println(pst+" "+pmt+" "+ptta);
	}
}
