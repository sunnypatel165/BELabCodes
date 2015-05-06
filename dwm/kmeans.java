//coded by sunny_patel
//K Means Clsutering
import java.io.*;
class kmeans
{
	public static void main(String aergs[])throws IOException
	{
		int age[]={12,18,15,16,20,25};
		int usage[]={1000,500,720,2200,1600,1200};
		int dist[][]=new int[8][3];  //asuming k=2
		int meanprev[][]=new int[2][2];
		meanprev[0][0]=12; meanprev[0][1]=1000;
		meanprev[1][0]=20; meanprev[1][1]=1600;

		int mean[][]=new int[2][2];
		while(true)
		{
			for(int i=0;i<6;i++)
			{
				dist[i][0]=Math.abs(age[i]-meanprev[0][0]) + Math.abs(usage[i]-meanprev[0][1]);
				dist[i][1]=Math.abs(age[i]-meanprev[1][0]) + Math.abs(usage[i]-meanprev[1][1]);
				if(dist[i][0] < dist[i][1])
					dist[i][2]=1;
				else
					dist[i][2]=2;
				
			}
			int c1=0,c2=0;
			for(int i=0;i<6;i++)
			{
				if(dist[i][2]==1)
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
		System.out.println("cluster 1 mean(age,usage) ("+mean[0][0]+","+mean[0][1]+")");
		System.out.println("cluster 2 mean(age,usage) ("+mean[1][0]+","+mean[1][1]+")");
		for(int i=0;i<6;i++)
		{
			System.out.println(age[i]+ " " + usage[i]+ " cluster" + dist[i][2]);
		}
	}
}
