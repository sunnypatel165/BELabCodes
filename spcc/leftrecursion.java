//coded by sunny_patel
//does not consider indirect left recrsion

//Removal of left recursion
import java.io.*;
import java.util.*;
class leftrecursion
{
	public static void main(String args[])throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the productions separated with semicolons(;)");
		String ip=br.readLine();
		String l[]=ip.split(";");
		int n=l.length;
		for(int p=0;p<n;p++){
			String s=l[p];
			char sym=s.charAt(0);
			s=s.substring(3,s.length());
			String prod[]=s.split("/");
			boolean flag=true;
			for(int i=0;i<prod.length;i++)
			 if(prod[i].charAt(0)==sym) flag=false; //to check if leftrec exists at all

			if(flag==false){		//if exists
				flag=true;
				for(int i=0;i<prod.length;i++){
					if(prod[i].charAt(0)!=sym)
					{
						if(prod[i].charAt(0)!='e')
							System.out.println(sym+"->"+prod[i]+sym+"'");		//procedure to remove left rectusion
						else
							System.out.println(sym+"->"+sym+"'");
					}
					else
					{
						if(flag==true) flag=false;
						System.out.println(sym+"'->"+prod[i].substring(1,prod[i].length())+sym+"'");
					}
				}
				if(flag==false)System.out.println(sym+"'->e");
			}
			else //no left rec
			{	
				System.out.println(sym+"->"+s);
			}
		}
	}
}
