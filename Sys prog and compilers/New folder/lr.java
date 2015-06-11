import java.io.*;
class lr
{
	public static void main(String args[])throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s=br.readLine();
		String g[]=s.split(";");
		for(int m=0;m<g.length;m++)
		{
			String prod=g[m];
			char sym=prod.charAt(0);
			boolean found=false;	
			prod=prod.substring(3,prod.length());
			String p[]=prod.split("/");
			for(int i=0;i<p.length;i++)
			{
				if(p[i].charAt(0)==sym)
				{
					found=true;
					break;
				}
			}

			if(found)
			{
				for(int i =0;i<p.length;i++)
				{
					if(p[i].charAt(0)!=sym)
					{
						if(p[i].charAt(0)=='e')
							System.out.println(sym+"->"+sym+"'");
						else
							System.out.println(sym+"->"+p[i]+sym+"'");
					}
					else
					{
						System.out.println(sym+"'->"+p[i].substring(1,p[i].length())+sym+"'");
					}
				}
				System.out.println(sym+"'->e");
			}
			else
			{
				System.out.println(g[m]);
			}

		}
	}
}









