//coded by sunny_patel
import java.util.*;
class KMP
{
	public static void main(String args[]){
		String s="ABCABAABABCDABCABCABCCAD";
		String p="BCABCAB";
		
		int i=0,j=1,done=0;
		int t[]=new int[p.length()];
		t[i]=0;
		while(j!=p.length())
		{
			if(p.charAt(i)==p.charAt(j))
			{
				t[j]=i+1;
				i++; j++;
			}
			else
			{
				if(i>0) i=t[i-1];
				else j=j+1;
			}
		}
		System.out.println(Arrays.toString(t));
		
		i=0;j=0;
		while(j!=p.length() && i!=s.length()){
			
			
				
			if(s.charAt(i)==p.charAt(j))
			{
				i+=1;
				j+=1;
			}
			else
			{
				if(j>0)
					j=t[j-1];
				else
					i=i+1;
						
			}
		}
			if(j==p.length()){
					System.out.println("found at "+(i-j));
				
					}
			if(i==s.length()){
				System.out.println("not found");
			
				}
		
	
	}
}