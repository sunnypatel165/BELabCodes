import java.io.*;
class mac
{
	public static void main(String args[])throws IOException
	{
		BufferedReader br=new BufferedReader(new FileReader("ip.txt"));
		
		PrintWriter mnt=new PrintWriter("mnt.txt","UTF-8");
		PrintWriter mdt=new PrintWriter("mdt.txt","UTF-8");
		PrintWriter pala=new PrintWriter("pala.txt","UTF-8");
		PrintWriter nala=new PrintWriter("nala.txt","UTF-8");
		int mdtc=1,mntc=1,palac=1,nalac=1;
		
		while(br.ready())
		{
			String line=br.readLine();
			if(line.contains("macro"))
			{
				String l[]=line.split(" ");
				mnt.println(mntc++ + "\t" +l[1]+"\t"+mdtc);
				String ar[]=l[2].split(",");
				for(int i=0;i<ar.length;i++)
					pala.println(palac++ +"\t" +ar[i]);
				
				line=br.readLine();
				while(!line.equals("mend"))
				{
					mdt.println(mdtc++ +"\t"+line);
					line=br.readLine();
				}
					mdt.println(mdtc++ +"\tmend");
			}
			else
			{
				String l[]=line.split(" ");
				String ar[]=l[1].split(",");
			
				for(int i=0;i<ar.length;i++)
					nala.println(nalac++ +"\t" +ar[i]);
			}
		}
		mnt.close();
		mdt.close();
		pala.close();
		nala.close();
	
	}
}