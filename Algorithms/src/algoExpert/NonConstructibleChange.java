package algoExpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class NonConstructibleChange {
	//algoexpert solution
	public static void main(String[] args) {


		int []coins=new int[] {1,1,2,3,5,7,22};

		int ans=nonConstructibleChange(coins);
		System.out.println("ans "+ans);
	}
	public static int nonConstructibleChange(int[] coins) {

		/*
		 * reason for change+1
		 * 
		 * if we have 1 coin ,
		 * means change we can create at this time is 1 
		 * 
		 * next we need to create a change of 2 minimum,
		 * so we need either a coin of 2 or less 
		 * 
		 * our change was 1  , coin required is 2 or less ,
		 * if we are given 3  , then we wont be able to make change of 2
		 * 
		 * coin>change+1
		 * coin>1+1
		 * because ,there can be coin of 2 , in that case it will work
		 * 
		 * if coin is greater than 2 (change+1) , then it is problem
		 * we will not be able to create a change of 2 
		 */
		Arrays.sort(coins);
		int change=0;
		
		for(int i:coins)
		{
			if(i>(change+1))
			return (change+1);
			change+=i;
			System.out.println("current coin "+i+" change "+change);
		}
		
		return change+1;

	}

}
