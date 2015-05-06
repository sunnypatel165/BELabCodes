//coded by sunny_patel
//Selection sort
import java.util.*;
class selection
{
	public static void sel(int a[])
	{
		int n=a.length;
		int large,index;
		for(int i=0;i<n;i++)
		{
			large=a[i];
			index=i;
			for(int j =i;j<n;j++)
			{
				if(large < a[j])
				{
					large=a[j];
					index=j;
				}
			}
			a[index]=a[i];
			a[i]=large;
		}
		System.out.println(Arrays.toString(a));
	}

	public static void main(String args[])
	{
		int a[]={10,2,100,50,30};
		sel(a);
	}
}
