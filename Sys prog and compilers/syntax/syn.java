//coded by sunny_patel
//theres no logic as such, just observe the input and output, more of a hardcoded kind of a thing
import java.io.*;
class syn
{
	public static void main(String args[])throws IOException
	{
		FileInputStream fstream = new FileInputStream("ip.txt");
		BufferedReader brf = new BufferedReader(new InputStreamReader(fstream));
		String line;
		int z=0;
		String kw[]={"void","int","double","float","if","for","else","{","}","do","while"};	//store all keywords
		int c=0,curlop=0,curlclo=0;
		while ((line = brf.readLine()) != null) 
		{
			z++;
			if(z==1) //1st line is header
			{
				if(line.compareTo("#include<iostream.h>")!=0)
					System.out.println("invalid header");
			}
			else{
					//to check keywords
					// keywords always come as first word of line except for(int i...)
				int noe=0;		//flag to check if error is found
				line=line.trim();
				String words[]=line.split(" ");
				if(words[0].compareTo("for")==0)
				{
					if(words[2].compareTo("int")!=0 && words[2].compareTo("long")!=0 && words[2].compareTo("double")!=0)
					System.out.println("invalid iterator "+words[2]);
				}
				else
				{ 
					for(int i=0;i<kw.length;i++)
						if(words[0].compareTo(kw[i])==0)  //compare 1st word with keywords
						{
							noe=1;break;
						}
					if(noe==0) 
						System.out.println("can not find symbol "+words[0] +" at "+z);
				}
				if(line.charAt(line.length()-1)!=';') //check semicolons
				{
					noe=0;
					if(line.contains("for (")) noe=1;
					else if(line.contains("if (")) noe=1;
					else if(line.contains("while (")) noe=1;
					else if(line.contains("else")) noe=1;
					else if(line.compareTo("{")==0) noe=1;
					else if(line.compareTo("}")==0) noe=1;
					else if(line.contains("int ") && line.contains("(") && line.contains(")")) noe=1;
					else if(line.contains("void ") && line.contains("(") && line.contains(")")) noe=1;
					else if(line.contains("double ")&&line.contains("(")&&line.contains(")")) noe=1;
					else if(line.contains("float ") && line.contains("(") && line.contains(")")) noe=1;
					if(noe==0) System.out.println(";  missing at "+z);
				}
				int op=0,clo=0;		//to check parentheses()
				for(int i=0;i<line.length();i++)
				{
					if(line.charAt(i)=='(') op++;
					if(line.charAt(i)==')') clo++;
					if(line.charAt(i)=='{') curlop++;
					if(line.charAt(i)=='}') curlclo++;
				}
				if(op!=clo)	System.out.println("missing parentheses at line "+z);
			}
			
		}
		if(curlop!=curlclo)	System.out.println("missing brackets");
		brf.close();
	}
}
