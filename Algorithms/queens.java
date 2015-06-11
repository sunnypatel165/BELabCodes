//coded by sunny_patel

//N Queens with N=10 default
import java.util.*;
class queen
{
	static int a[]=new int[10],count=0;
	public static boolean place(int r)
	{
		for(int i=0;i<r;i++)
		{
			if(a[i]==a[r] || (Math.abs(r-i)==Math.abs(a[r]-a[i])))
				return false;
		}
		return true;
	}
	public static void nqueen(int r)
	{
		for(int i=0;i<a.length;i++)
		{
			a[r]=i;
			if(place(r))
			{
				if(r+1 < a.length)
					nqueen(r+1);
				else
					{
					count++;
					System.out.println(Arrays.toString(a));
					}
			}
		}
	}
	public static void main(String args[])
	{
		nqueen(0);
		System.out.println(count);
	}
}
