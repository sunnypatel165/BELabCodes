//coded by sunny_patel
//theres no logic as such, just observe the input and output, more of a hardcoded kind of a thing
import java.io.*;
class macro
{
	public static void main(String args[])throws IOException
	{
		BufferedReader br=new BufferedReader(new FileReader("ip.txt"))	;

		PrintWriter mnt=new PrintWriter("mnt.txt","UTF-8");
		PrintWriter mdt=new PrintWriter("mdt.txt","UTF-8");
		PrintWriter pala=new PrintWriter("pala.txt","UTF-8"); //previous ALA
		PrintWriter cala=new PrintWriter("cala.txt","UTF-8"); //current ALA
		int mntc=1,mdtc=1,palac=1,calac=1;

		mnt.println("INDEX\tNAME\tINDEX");
		mdt.println("INDEX\tDEFINITION");
		pala.println("INDEX\tARGUMENT");
		cala.println("INDEX\tARGUMENT");
		while(br.ready())
		{
			String line=br.readLine();
			if(line.contains("macro"))
			{
				String t1[]=line.split(" ");
				mnt.println(mntc++ +"\t"+ t1[1] +"\t" + mdtc);

				String t2[]=t1[2].split(",");  //1st word is macro keyword, 2nd word is macro name and 3rd word is argument list

				for(int i=0;i<t2.length;i++)
					pala.println(palac++ +"\t"+ t2[i]);

				line=br.readLine();
				while(line.compareTo("mend")!=0) //till current macro ends
				{
					mdt.println(mdtc++ +"\t"+ line);
					line=br.readLine();
				}
				mdt.println(mdtc++ +"\tmend");
			}
			else  //for those parts which arent a part of any macro definition, which is nothing but macro calls(last 2 lines of ip.txt)
			{
				String t1[]=line.split(" ");
				String t2[]=t1[1].split(",");
				for(int i=0;i<t2.length;i++)
					cala.println(calac++ +"\t"+ t2[i]); 
			}
		}

		mnt.close();
		mdt.close();
		pala.close();
		cala.close();
	}
}