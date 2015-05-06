//coded by sunny_patel
import java.io.*;
import java.net.*;
import java.util.*;
class client
{
	public static void main(String args[])throws IOException
	{
		String str;
		String str1;
		
		//create a socket
		Socket s=new Socket("localhost",1234);

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

		BufferedReader br1=new BufferedReader(new InputStreamReader(s.getInputStream()));

		//input to client
		System.out.println("enter message");
		str=br.readLine();
		
		//write the message to stream using dataoutputstream and server will read this mesage
		DataOutputStream d=new DataOutputStream(s.getOutputStream());
		d.writeBytes(str+'\n');
		System.out.println("sent");

		//server will write a reply to stream and client reads that messgae
		str1=br1.readLine();
		System.out.println("reply from server "+str1);

		//clsoe all
		s.close();
	}
}
		