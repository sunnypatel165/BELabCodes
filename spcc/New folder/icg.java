import java.io.*;
import java.util.*;
class icg
{
	public static int prec(char a,char b)
	{	
		int ap=0,bp=0;
		switch(a)
		{
			case '+': ap=1; break;
			case '-': ap=1; break;
			case '*': ap=2; break;
			case '/': ap=2; break;
		}
		switch(b)
		{
			case '+': bp=1; break;
			case '-': bp=1; break;
			case '*': bp=2; break;
			case '/': bp=2; break;
		}
		return ap-bp;
	}
	public static void main(String args[])throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String infix=br.readLine();
		String ans="";
		Stack s=new Stack();
		for(int i=0;i<infix.length();i++)
		{
			char c=infix.charAt(i);
			if(c>='a' && c<='z')
				ans+=""+c;
			else if(s.empty() || c=='(')
				s.push(c);
			else if(c==')')
			{
				while(s.peek()!=(Character) ('('))
					ans+=s.pop();
				s.pop();
			}
			else
			{
				while( !s.empty() && prec(c,(Character)s.peek()) <=0)
					ans+=s.pop();
				s.push(c);
			}
		}
		while(!s.empty())
			ans+=s.pop();
		System.out.println(ans);
		
		int index=0;
		while(ans.length()!=1)
		{
			int i=0;
			while(true)
			{
				if(ans.charAt(i)=='+' || ans.charAt(i)=='-' || ans.charAt(i)=='*' || ans.charAt(i)=='/')
					break;
				else
					i++;
			}
			char op1=ans.charAt(i-2);
			char op2=ans.charAt(i-1);
			char op=ans.charAt(i);
			System.out.println((char)(index+'A') +" = "+op1+ " "+op +" "+op2);
			ans=ans.replace(ans.substring(i-2,i+1),""+(char)(index+'A'));
			index++;
		
		}
	}
}










