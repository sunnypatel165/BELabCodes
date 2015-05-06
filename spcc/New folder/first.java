import java.io.*;
import java.util.*;
class first
{
	public static void main(String args[])throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s=br.readLine();
		String p[]=s.split(";");
		char lhs[]=new char[p.length];
		String ans[]=new String[p.length];
		for(int i =0;i<p.length;i++)
		{
			lhs[i]=p[i].charAt(0);
			ans[i]="";
		}
		for(int i=p.length-1;i>=0;i--)
		{
			String st=p[i];
			st=st.substring(3,st.length());
			String rhs[]=st.split("/");
			for(int x=0;x<rhs.length;x++)
			{
				int pos=0;
				do
				{
					char c=rhs[x].charAt(pos);
					if(c>='A' && c<='Z')
					{
						int index=-1;
						for(int j=0;j<lhs.length;j++)
							if(lhs[j]==c)
							{
								index=j;
								break;
							}
						if(ans[index].contains("e"))
						{
							ans[i]+=ans[index].replaceAll("e","");
							if(pos==rhs[x].length()-1)
								ans[i]+="e";
							pos++;
						}
						else
						{
							ans[i]+=ans[index];
							pos=99999;
						}
					}
				else
				{
					ans[i]+=c;
					pos=9999;
				}
			}
			while(pos!=9999 && pos<rhs[x].length());
			}
		}char finalans[][]=new char[ans.length][];
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