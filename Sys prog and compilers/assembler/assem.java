//coded by sunny_patel
//theres no logic as such, just observe the input and output, more of a hardcoded kind of a thing

import java.io.*;
import java.util.*;
class assem
{
	public static void main(String aergs[])throws IOException
	{
		String [][] mot=new String[6][4];
		String [][] motans = new String[6][4];

		mot[0][0]="LOAD"; mot[0][1]="2"; mot[0][2]="1"; mot[0][3]="2";	 //just store all the MC ops, those values are actually instruction length etc,we can assume anything 0,1,2,786..
		mot[1][0]="STORE"; mot[1][1]="2"; mot[1][2]="1"; mot[1][3]="2";
		mot[2][0]="ADD"; mot[2][1]="2"; mot[2][2]="1"; mot[2][3]="2";
		mot[3][0]="DEC"; mot[3][1]="2"; mot[3][2]="1"; mot[3][3]="2";
		mot[4][0]="JNZ"; mot[4][1]="2"; mot[4][2]="1"; mot[4][3]="2";
		mot[5][0]="STOP"; mot[5][1]="2"; mot[5][2]="0"; mot[5][3]="1";


		String [][] pot = new String[5][2];
		String [][] potans=new String[5][2];

		pot[0][0]="START" ; pot[0][1]="0";	//just store all the psudo op, those values are actually instruction length etc,we can assume anything 0,1,2,786..
		pot[1][0]="ENDP" ; pot[1][1]="0";
		pot[2][0]="END" ; pot[2][1]="0";
		pot[3][0]="DD" ; pot[3][1]="1";
		pot[4][0]="DB" ; pot[4][1]="1";

		String lt [][]=new String[10][3]; int ltcnt=0;	//literal table
		String st[][]=new String[100][3]; int cnt=0;	//symbol table

		File f=new File("ip.txt");

		BufferedReader br = new BufferedReader(new FileReader(f));
		String line="";
		while( (line = br.readLine()) !=null )
		{
			String words[]=line.split(" ");
			int add = Integer.parseInt(words[0]);
			for(int z=1;z<words.length;z++)
			{
				String sym=words[z];
				int motfound=-1,potfound=-1,ltfound=-1;
				
				if(sym.contains("\'"))		//LITERAL TABLE ENTRY
				{
					lt[ltcnt][0]=sym;
					lt[ltcnt][1]="0";
					lt[ltcnt][2]=add+"";
					ltcnt++;
					ltfound=1;
				}
				for(int i =0;i<mot.length;i++)		//MOT ENTRY
				{
					if(mot[i][0].compareTo(sym)==0)
					{
						motans[i]=mot[i];
						motfound=1;
						break;
					}
				}
				if(motfound==-1)			//POT ENTRY
				{
					for(int i=0;i<pot.length;i++)
					{
						if(pot[i][0].compareTo(sym)==0)
						{
							potans[i]=pot[i];
							potfound=1;
							break;
						}
					}
				}
				if(potfound==-1 && motfound==-1 && ltfound==-1 && z==1) //SYMBOL TABLE ENTRY
				{
					st[cnt][0]=new String(sym);
					st[cnt][2]=add+"";
					if(sym.charAt(sym.length()-1) == ':')
					{
						st[cnt][1]="Label";
					}
					else
					{
						st[cnt][1]="VARIABLE";
					}
					cnt++;
				
				}
			}
		}
		PrintWriter m = new PrintWriter("m.txt", "UTF-8");
		for(int i=0;i<motans.length;i++)
			if(motans[i][0]!=null)
				m.println(Arrays.toString(motans[i]));

		PrintWriter p = new PrintWriter("p.txt", "UTF-8");
		for(int i=0;i<potans.length;i++)
			if(potans[i][0]!=null)
				p.println(Arrays.toString(potans[i]));

		PrintWriter l = new PrintWriter("l.txt", "UTF-8");
		for(int i=0;i<ltcnt;i++)
				l.println(Arrays.toString(lt[i]));

		PrintWriter s = new PrintWriter("s.txt", "UTF-8");
		for(int i=0;i<cnt;i++)
				s.println(Arrays.toString(st[i]));
		m.close();
		p.close();
		l.close();
		s.close();
	
	}
}