package algoExpert;

import java.util.Arrays;
import java.util.Collections;

public class TandemBicycle {

	public static void main(String[] args) {


	}
	public int tandemBicycle(int[] redShirtSpeeds, int[] blueShirtSpeeds, boolean fastest) {
		// Write your code here.
		Arrays.sort(redShirtSpeeds);
		//Integer a[]=new Integer [];

		int totalSum=0;

		for(int i=0;i<redShirtSpeeds.length;i++)
		{
			if(fastest)
			{
				totalSum+=Math.max(redShirtSpeeds[i],blueShirtSpeeds[i]);
			}
			else
			{
				totalSum+=Math.min(redShirtSpeeds[i],blueShirtSpeeds[i]);
			}
		}
		return totalSum;
	}
}
