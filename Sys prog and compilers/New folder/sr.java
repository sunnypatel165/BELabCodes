import java.io.*;
class sr
{
	public static void main(String args[])throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String st=br.readLine();
		String g[]=st.split(";");

		String lhs[]=new String[100];
		String rhs[]=new String[100];
		int trhs=0;

		for(int i=0;i<g.length;i++)
		{
			char l=g[i].charAt(0);
			String r=g[i].substring(3,g[i].length());
			String rthis[]=r.split("/");
			for(int j=0;j<rthis.length;j++)
			{
				lhs[trhs]=""+l;
				rhs[trhs]=rthis[j];
				trhs++;
			}
		}

		for(int i=0;i<trhs;i++)
			System.out.println(lhs[i]+" "+rhs[i]);
		System.out.println("enter the string to be parsed");
		String s=br.readLine()+"$";
		String stack="$";
		while( s.length()!=1 || !stack.equals("$"+lhs[0]) )
		{
			if(stack.length()==1 && s.length()!=1)
			{
				stack+=s.charAt(0);
				s=s.substring(1,s.length());
				System.out.println(stack+"\t\t"+s+"\t\t"+"SHIFT");
			}
			else
			{
				int flag=0;
				for(int i=0;i<trhs;i++)
				{
					if(stack.contains(rhs[i]))
					{
						stack=stack.replace(rhs[i],lhs[i]);	
						System.out.println(stack+"\t\t"+s+"\t\tREDUCE "+lhs[i]+"->"+rhs[i]);
						flag=1;
						break;
					}
				}
				if(flag!=1)
				{
					stack+=s.charAt(0);
					s=s.substring(1,s.length());
					System.out.println(stack+"\t\t"+s+"\t\t"+"SHIFT");
				}
			}
		}
		if(stack.equals("$"+lhs[0]) && s.length()==1)
			System.out.println("accept");
		else
			System.out.println("reject");
	}
}