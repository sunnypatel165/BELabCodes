//coded by sunny_patel
import java.io.*;
import java.util.Arrays;

class SumOfSubsets{
	static int W=31;
	static int weight[]={7,24,13,11};
	static int x[]={0,0,0,0};
	static int total=55;
	
public static boolean promising(int i, int currentW, int RemTotal){

//promising conditions.. ie current weight + next item <= required
//							current weight+ remaining all>=required
	if(currentW + RemTotal >= W && (currentW==W || weight[i+1]+currentW<=W))
		return true;

	return false;
	
}


public static void sumOfSubsets(int i, int currentW, int RemTotal){

	if(promising(i,currentW,RemTotal)==true){
		if(currentW==W){
			System.out.println(Arrays.toString(x));
		}
		else{
			if( i+1< weight.length){
				x[i+1]=1; //select (i+1)th object
				sumOfSubsets(i+1, currentW+weight[i+1] ,RemTotal-weight[i+1]);
				//deslect now.. for all combinations
				x[i+1]=0;
				sumOfSubsets(i+1, currentW ,RemTotal-weight[i+1]);//dont forget thus -w[i+1] last term
			}
		}

	}
}

public static void main(String args[]){
	Arrays.sort(weight);
	sumOfSubsets(-1,0,total);
}
}