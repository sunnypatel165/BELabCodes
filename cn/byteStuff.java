//coded by sunny_patel
import java.io.*;
class byteStuff
{
	public static void main(String args[])throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String esc="#";
		String flag="$";
		System.out.println("enter the number of frames");
		int frames=Integer.parseInt(br.readLine());
		for(int s=0;s<frames;s++)
		{

			String finalMessage="$";
			String message;
		
			System.out.println("enter the data");
			message=br.readLine();
			for(int i=0;i<message.length();i++)
			{
				if(message.charAt(i)=='#' || message.charAt(i)=='$')
					finalMessage+=esc+message.charAt(i);
				else
					finalMessage+=message.charAt(i);
			}
			finalMessage+="$";
			System.out.println(finalMessage);
		}
	}
}