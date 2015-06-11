import java.io.*;
class ass
{
	public static void main(String args[])throws IOException
	{
		BufferedReader br=new BufferedReader(new FileReader("ip.txt"));
		
		PrintWriter sw=new PrintWriter("s.txt","UTF-8");
		PrintWriter lw=new PrintWriter("l.txt","UTF-8");
		PrintWriter motw=new PrintWriter("mot.txt","UTF-8");
		PrintWriter potw=new PrintWriter("pot.txt","UTF-8");
		int sc=0,lc=0,mc=0,pc=0;
		
		String mot[][]=new String[6][4];
		String motans[][]=new String[6][4];
		mot[0][0]="LOAD";
		mot[1][0]="STORE";
		mot[2][0]="DEC";
		mot[3][0]="ADD";
		mot[4][0]="JNZ";		
		mot[5][0]="STOP";

		String pot[][]=new String[5][2];
		String potans[][]=new String[5][2];

		pot[0][0]="START";
		pot[1][0]="END";
		pot[2][0]="ENDP";
		pot[3][0]="DD";
		pot[4][0]="DB";

		String st[]=new String[100];
		String lit[]=new String[100];
		while(br.ready())
		{
			String line=br.readLine();
			String words[]=line.split(" ");	
			String add=words[0];
			for(int i=1;i<words.length;i++)
			{
				int motfound=-1,potfound=-1,ltfound=-1;
				if(words[i].contains("\'"))
				{
					lit[lc++]=words[i]+" , 0 , "+add;
					ltfound=1;
				}
				
				for(int j=0;j<mot.length;j++)
				{
					if(mot[j][0].compareTo(words[i])==0)
					{
						motans[j]=mot[j];
						motfound=1;
						break;
					}
				}
				if(motfound==-1)
				{
					for(int j=0;j<pot.length;j++)
					{
						if(pot[j][0].compareTo(words[i])==0)
						{
							potans[j]=pot[j];
							potfound=1;
							break;
						}
					}
				}
				if(motfound==-1 && potfound==-1 && ltfound==-1 && i==1)
				{
					if(words[i].charAt(words[i].length()-1) == ':')
					{
						st[sc++]=words[1]+" label "+add;
					}
					else
						st[sc++]=words[1]+" variable "+add;
			
				}
			}
		}

		for(int i=0;i<6;i++)
			if(motans[i][0]!=null)
				motw.println(motans[i][0]);
		for(int i=0;i<5;i++)
			if(potans[i][0]!=null)
				potw.println(potans[i][0]);
		for(int i=0;i<lc;i++)
			lw.println(lit[i]);
		for(int i=0;i<sc;i++)
			sw.println(st[i]);

	
		sw.close();
		lw.close();
		motw.close();
		potw.close();
	}
}