//coded by sunny_patel
import java.io.*;
class charCount
{
	public static void main(String args[])throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int frames;
		String temp,finalMessage="";
		System.out.println("enter the number of frames of data");
		frames=Integer.parseInt(br.readLine());
		for(int i=0;i<frames;i++)
		{
			System.out.println("Enter the frame data");
			temp=br.readLine();
			finalMessage=finalMessage+(temp.length()+1)+temp;
		}
		
		System.out.println(finalMessage);
	}
}
			