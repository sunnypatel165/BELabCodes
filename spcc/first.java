//coded by sunny_patel
//this is not HIGHLY generlized but should work in 90% cases(if the input is valid)
import java.io.*;
import java.util.*;
class first
{
	public static void main(String args[])throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s=br.readLine();
		String prod[]=s.split(";");
		String ans[]=new String[prod.length];
		for(int i=0;i<ans.length;i++) ans[i]="";

		char lhs[]=new char[prod.length];
		for(int i=0;i<prod.length;i++)
			lhs[i]=prod[i].charAt(0); 		//storing LHS of each side(ie the non terminals)
		
		int x=0;
		for(int i=prod.length-1;i>=0;i--) 		//bottom up
		{
			x=i; 				//which nonterminal's first is being found currently
			String t=prod[i];
			t=t.substring(3,t.length());		//to remove first three chars eg "E->"
			String rhs[]=t.split("/");
			int pos=0;
			for(int j=0;j<rhs.length ;j++) 
			{	pos=0;			//pos=9999 means get the next rule on rhs current one is done
				one: do
				{
				char c=rhs[j].charAt(pos);
				 if(c>='A' && c<='Z')        	 //non terminal? then those rules
				{
					int index=-1;
					for(int l=0;l<lhs.length;l++) 		// find which non terminal it is, store it in "index"
						if(lhs[l]==c){ index=l; break;}

					if(ans[index].contains("e") == false) 	// if it does not contain e
					{	     
						ans[x]+=ans[index];
						pos=9999;
						break one;
					}
					else	
					{
						String te=ans[index];
						te=te.replaceAll("e","");
						ans[x]+=te;
						if(pos==rhs[j].length()-1) ans[x]+="e"; //if it is last production then add e(refer rules of first(G))
						pos++;
					}
				}
				else  //terminal? no rule, just add this terminal to first of x and no need to check further
				{
					pos=9999;
					ans[x]+=c;
					break one;
				}
			}while(pos!=9999 && pos<rhs[j].length());
		}
	}
		//this part is just to remove duplicates, can be skipped,only some chars will be repeated
		char finalans[][]=new char[ans.length][];
		for(int i=0;i<ans.length;i++)
		{
			finalans[i]=ans[i].toCharArray();
			Arrays.sort(finalans[i]);
			for(int j=0;j<finalans[i].length-1;j++)
			{
				if(finalans[i][j]==finalans[i][j+1])
					finalans[i][j]='#';
			}
			ans[i]=new String(finalans[i]);
			ans[i]=ans[i].replaceAll("#","");
		}

		//print all answers!
		for(int i=0;i<ans.length;i++)
			System.out.println("first("+lhs[i]+")="+ans[i]);
	}
}