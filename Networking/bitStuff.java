//coded by sunny_patel
import java.io.*;
class bitStuff
{
	public static void main(String args[])throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String message="";
		String flag="0111111";
		String finalMessage=flag;
		System.out.println("enter the message");
		message=br.readLine();
		int count=0;
		for(int i=0;i<message.length();i++)
		{
			
			if(message.charAt(i)=='0') count=0;
			else count++;
			if(count==5)
			{	
				System.out.println("A bit Stuffed at:"+(i+1));
				finalMessage+=message.charAt(i)+"0";
				count=0;
			}
			else
			finalMessage+=message.charAt(i)+"";
		}
		finalMessage+=flag;
		System.out.println(finalMessage);
			
	 	}
}