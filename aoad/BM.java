//coded by sunny_patel
//Boyer Moore String matching algorithm
import java.io.*;
import java.util.*;
class BM
{
	public static void main(String args[])throws IOException{
		String s="ABCABAABABCDABCABCABCCAD";
		String p="ABC";

		int i=p.length()-1;
		int j=p.length()-1;
		boolean x=false;
		
		while(i<s.length())
		{
			if(s.charAt(i) == p.charAt(j))
			{
				if(j==0){
					x=true;
					break;
					}
				else{
				i--;
				j--;
				}
			}
			else
			{
				i=i+p.length()-Math.min(p.lastIndexOf(s.charAt(i)+1),j);
				j=p.length()-1;
			}
		}
		if(x==true)
			System.out.println("found at"+(i+1));
		else
			System.out.println("not found");
	}
}
