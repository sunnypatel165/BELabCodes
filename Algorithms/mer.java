//coded by sunny_patel

//Merge Sort
import java.io.*;
import java.util.*;
class Mer
{
 public int[ ] A;
 public Mer(int MAX)
  {
   A=new int[MAX];
  }

/*
 This function is to split the list into sublists
*/
public void MergeSort(int low,int high)
{
  int mid;
   if(low < high)
   {
     mid=(low+high)/2;//split the list at mid
	
     MergeSort(low,mid);//first sublist
	System.out.println(Arrays.toString(A));
     MergeSort(mid+1,high);//second sublist
     Combine(low,mid,high);//merging of two sublists
   }
}
/* This function is for merging the two sublists
*/
public void Combine(int low,int mid,int high)
{
  int i,j,k;
  int[] temp;
   temp=new int[10];
  k=low;
  i=low;
  j=mid+1;
 while(i <= mid && j <= high)
  {
     if(A[i]<=A[j])			
      {
         temp[k]=A[i];
         i++;
         k++;
       }
     else
      {
          temp[k]=A[j];
          j++;
          k++;
       }
 }
 while(i<=mid)
  {
    temp[k]=A[i];
    i++;
    k++;
  }
  while(j<=high)
  {
    temp[k]=A[j];
    j++;
   k++;
 }
//copy the elements from temp array to A
 for(k=low;k<=high;k++)
  A[k]=temp[k];
}
/*
-----------------------------------------------------------------	
display : function for displaying the elements
-----------------------------------------------------------------
*/
  public void display(int n)
  {
     for(int i=0;i<n;i++)
         System.out.println(A[i]);
   }
}
class MergeSrtDemo
{ 
 public static void main(String[] args)throws IOException
 {
	 BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    Mer obj=new Mer(10);
    int n;
    System.out.println("\n\t Program for Merge Sort    ");
    System.out.println("\n How many elements are there?");
    n=Integer.parseInt(br.readLine());
    System.out.println("\n Enter the elements ");
   for(int i=0;i<n;i++)
    obj.A[i]=Integer.parseInt(br.readLine());
  System.out.println("\n The Elements are...");
  obj.display(n);
  int low=0;
  int high=n-1;
  obj.MergeSort(low,high);
  System.out.println("\n The Sorted Elements are...");
  obj.display(n);
 }//end of main

}//end of class 
