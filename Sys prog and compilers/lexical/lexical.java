//coded by sunny_patel
//theres no logic as such, just observe the input and output, more of a hardcoded kind of a thing
import java.io.*;
import java.util.*;
class lexical
{
	public static void main(String args[])throws IOException
	{
		BufferedReader in = new BufferedReader(new FileReader("ip.txt")); 

		String key[]={"int","char","void","iostream.h","cout","cin","stdio.h"};

		PrintWriter op = new PrintWriter("op.txt", "UTF-8");
		PrintWriter kw = new PrintWriter("kw.txt", "UTF-8");
		PrintWriter id = new PrintWriter("id.txt", "UTF-8");
		PrintWriter lit = new PrintWriter("lit.txt", "UTF-8");
		PrintWriter term = new PrintWriter("term.txt", "UTF-8");

		String text=""; 
		while (in.ready()) 	
	     		text += in.readLine()+""; 

		//keywords

		for(int i=0;i<key.length;i++)
		{
			if(text.contains(key[i]))
			{
				kw.println(key[i]);
			int index= text.indexOf(key[i]);
			if(text.charAt(index+key[i].length()+2)=='=')
				id.println(text.charAt(index+key[i].length()+1));
			}
		}
		for(int i=0;i<text.length();i++)
		{
			//operators
			if(text.charAt(i)=='+' || text.charAt(i)=='-' ||text.charAt(i)=='*' ||text.charAt(i)=='/')
				op.println(text.charAt(i));


			// char and int literals(those appearing between '' and "" are litrals)
			else if(text.charAt(i)=='=' )
			{
				op.println(text.charAt(i));
				if(text.charAt(i+1)=='\'')
					lit.println(text.charAt(i+2));
				if(text.charAt(i+1)>='0' && text.charAt(i+1)<='9')
					lit.println(text.charAt(i+1));
			}

			if(text.charAt(i)<'a' || text.charAt(i)>'z') //if this not written numbers are also included which shudnt be
			{
				if(text.charAt(i)<'0' || text.charAt(i)>'9') 
					term.println(text.charAt(i));
			}
		}
		op.close();
		kw.close();
		id.close();
		lit.close();
		term.close();
	}
}