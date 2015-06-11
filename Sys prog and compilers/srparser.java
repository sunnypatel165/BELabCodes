//coded by sunny_patel
//doesnt report reduce reduce conflict. simply says accept or reject
///SR parseer
import java.io.*;
class srparser
{
	public static void main(String args[])throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the production rules");
		String g=br.readLine();
		String gram[]=g.split(";");
		String LHS[]=new String [100];
		String RHS[]=new String [100];
		int totalRhs=0;
		for(int i=0;i<gram.length;i++)
		{
			String lhs=gram[i].charAt(0)+"";
			String rhs=gram[i].substring(3,gram[i].length());
			String rhsofthisprod[]=rhs.split("/");
			for(int j=0;j<rhsofthisprod.length;j++)		//store all LHS and corrosponding RHSs,called handles i guess
			{
				LHS[totalRhs]=lhs;
				RHS[totalRhs]=rhsofthisprod[j];
				totalRhs++;
			}
			
		}

		String stack="$";
		System.out.println("Enter the string to be parsed:");
		String ip=br.readLine()+"$";
		System.out.println("STACK\t\tINPUT\t\tACTION");
		mainwhile:	while(ip.length()!=1 || !stack.equals("$"+LHS[0]) )
		{
			if(stack.length()==1 && ip.length()!=1)		//stack contains only $ and input is not yet empty the only option is to shift
			{
				stack+=ip.charAt(0);
				ip=ip.substring(1,ip.length());
				System.out.println(stack+"\t\t"+ip+"\t\t"+"SHIFT");
			}
			int flag=1,i=0;
			for(i = 0 ; i < totalRhs ; i++)
			{
				if(stack.contains(RHS[i]))		//check all RHSs to see if it is on stack then reduce
				{
					flag=0;
					break;
				}
			}
			if(flag==0)
			{
				stack=stack.replace(RHS[i],LHS[i]);		//reduce
				System.out.println(stack+"\t\t"+ip+"\t\t"+"Reduce "+LHS[i] + "->" + RHS[i]);
			}
			else						//if handle not found then shift
			{
				stack+=ip.charAt(0);
				ip=ip.substring(1,ip.length());
				System.out.println(stack+"\t\t"+ip+"\t\t"+"SHIFT");
			}
			
		}
		if(stack.equals("$"+LHS[0]) && ip.equals("$"))			//final condition for accept
			System.out.println("\n\nThe given string is accepted");
		else
			System.out.println("\n\nThe given string is rejected");
	}
}
/*
C:\Users\Sunny\Desktop\code\java\spcc>javac srparser.java

C:\Users\Sunny\Desktop\code\java\spcc>java srparser
Enter the production rules
E->E+E/E*E/a;
Enter the string to be parsed:
a+a*a
STACK           INPUT           ACTION
$a              +a*a$           SHIFT
$E              +a*a$           Reduce E->a
$E+             a*a$            SHIFT
$E+a            *a$             SHIFT
$E+E            *a$             Reduce E->a
$E              *a$             Reduce E->E+E
$E*             a$              SHIFT
$E*a            $               SHIFT
$E*E            $               Reduce E->a
$E              $               Reduce E->E*E


The given string is accepted
*/
