//coded by sunny_patel
//should work on most valid inputs!
import java.io.*;
import java.util.*;
class IntermidiateCodeGen
{
	public static int prec(char a,char b)
	{
		int ap=0,bp=0;
		switch(a)
		{
			case '+': ap=1;break;
			case '-': ap=1;break;
			case '/': ap=2;break;
			case '*': ap=2;break;
		}
		switch(b)
		{
			case '+': bp=1;break;
			case '-': bp=1;break;
			case '/': bp=2;break;
			case '*': bp=2;break;
		}
		return (ap-bp);
	}
	public static void main(String args[])throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		Stack s=new Stack();
		
		//basic conversion of infix to postfix
		String ip=br.readLine();
		String ans="";
		for(int i=0;i<ip.length();i++)
		{
			char c=ip.charAt(i);
			if(c>='a' && c<='z')
				ans+=c+"";
			else if(s.empty() || c=='(')
				s.push(c);
			else if(c==')')
			{
				while(s.peek()!=(Character)'(')
					ans+=s.pop();
				s.pop();
			}	
			else
			{
				while(!s.empty() && prec(c,(Character)s.peek()) <=0)
					ans+=s.pop();
					s.push(c);
			}

		}
		while(!s.empty())
			ans+=s.pop();
		System.out.println("\nInfix Expression:\n"+ip);
		System.out.println("\nPostfix Expression:\n"+ans);
		

		//three address code generation
		int tacnum=0;
		while(ans.length()!=1)
		{
			int i=0;
			for(i=0;i<ans.length();i++)
			{
				if(ans.charAt(i)=='+' || ans.charAt(i)=='-' || ans.charAt(i)=='*' || ans.charAt(i)=='/')
					break;
			}
			//operator is i and operands at i-2 and i-1 in postfix expression
			char operator=ans.charAt(i);
			char op2=ans.charAt(i-1);
			char op1=ans.charAt(i-2);
			System.out.println((char)(tacnum+'A' )+ " = "+op1+operator+op2);
			ans=ans.replace(ans.substring(i-2,i+1) , (char)(tacnum+'A') +"");		//replace "op2op1operator" with TAC LHS
			tacnum++;
		}
	}
}