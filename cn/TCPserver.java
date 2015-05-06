//coded by sunny_patel
//Server Side TCP
import java.util.*;
import java.io.*;
import java.net.*;
class server
{
	public static void main(String args[])throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

		//create a socket of type server
		ServerSocket s=new ServerSocket(1234);

		//accept will block the server until client requests!! ie it puts the server into listen mode..
		Socket soc=s.accept();

		String fromServer;
		String replyToServer;
		System.out.println("Server side");
		
		//read the data written by the client (as a request) into the stream
		BufferedReader br1=new BufferedReader(new InputStreamReader(soc.getInputStream()));
		fromServer=br1.readLine();
		System.out.println("client: "+fromServer);
		replyToServer=fromServer.toUpperCase();

		//write the reply to the stream(server is expecting the reply)
		DataOutputStream d = new DataOutputStream(soc.getOutputStream());
		d.writeBytes(replyToServer);

		//close
		s.close();
		soc.close();
	}
}
