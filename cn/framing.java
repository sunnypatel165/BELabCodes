import java.io.*;
class framing
{
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
 	public static void ccsender()throws IOException
	{
		String finalMessage="";
		System.out.println("enter the number of frames");
		int n=Integer.parseInt(br.readLine());
		for(int i=0;i<n;i++)
		{
			System.out.println("enter the frame data");
			String s=br.readLine();
			finalMessage+=(s.length()+1)+s;
		}
		System.out.println(finalMessage);
	}
	public static void ccrec()throws IOException
	{
		System.out.println("enter the receieved message");
		String recMessage=br.readLine();
		int len=0,currentFrame=0;	
		try{
		while(true)
		{
			currentFrame=recMessage.charAt(len)-'0';
			System.out.println(recMessage.substring(len+1,len+currentFrame));
			len+=currentFrame;
			if(len>recMessage.length()-1) break;
			//currentFrame=recMessage.charAt(len)-'0'-1;
		}
		}
		catch(Exception e)
		{
			System.out.println("invalid");
		}
	}
	public static void bysender()throws IOException
	{
		String flag="#",esc="$";
		System.out.println("enter the number of frames");
		int n = Integer.parseInt(br.readLine());
		for(int i=0;i<n;i++)
		{
			
			String finalMessage=flag+"";
			System.out.println("enter the message");
			String message=br.readLine();
			for(int j=0;j<message.length();j++)
			{
				if(message.charAt(j)=='#' || message.charAt(j)=='$')
					finalMessage+=esc+message.charAt(j);
				else
					finalMessage+=message.charAt(j);
			}
		
				finalMessage+=flag+"";
		System.out.println(finalMessage);
		}
	}
	public static void byrec()throws IOException
	{
		System.out.println("enter the mesage");
		String mes=br.readLine();
		mes=mes.substring(1,mes.length()-1);
		mes=mes.replace("$$","$");
		mes=mes.replace("$#","#");
		System.out.println(mes);
	}

	public static void bisender()throws IOException
	{
		String flag="01111110",finalMessage="";
		System.out.println("enter the message");
		String s=br.readLine();
		int count=0;
		for(int  i=0;i<s.length();i++)
		{
			if(s.charAt(i)=='1') count++;
			else count=0;
			finalMessage+=s.charAt(i);
			if(count==5){
			finalMessage+='0';
			System.out.println("byte stuffed at "+i);
			count=0;}
		}
		//finalMessage+=flag;
		System.out.println(finalMessage);
	}
	public static void birec()throws IOException
	{
		System.out.println("enter the message");
		String s=br.readLine();
		s=s.replace("111110","11111");
		System.out.println(s);
	}


	public static void main(String arg[])throws IOException
	{
		//ccsender();
		//ccrec();
		//bysender();
		//byrec();
		bisender();
		birec();

	}
}