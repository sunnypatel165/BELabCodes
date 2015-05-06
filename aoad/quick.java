//coded by sunny_patel
import java.util.*;
class quick
{
	//static int a[];
	static int a[]={10,230,100,50,150};
	
	public static void quicksort(int low, int high)
	{
		if(low < high)
		{
			int pivot=partition(low,high);
			quicksort(low,pivot);	
			quicksort(pivot+1,high);
		}
	}

	public static int partition(int low, int high)
	{
		int pivot=a[low];
		while( low < high && high<a.length)
		{
			while(a[low] < pivot) low++;
			while(a[high]>pivot) high--;
			swap(low,high);
		}
	return low;
	}
	public static void swap(int i,int j)
	{
		int temp=a[i];
		a[i]=a[j];
		a[j]=temp;
	}

	public static void main(String args[])
	{
		//quick q=new quick(n);
		
		quicksort(0,a.length-1);
		System.out.println(Arrays.toString(a));
	}
}