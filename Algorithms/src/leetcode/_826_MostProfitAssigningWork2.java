package leetcode;

import java.util.ArrayList;
import java.util.HashMap;

public class _826_MostProfitAssigningWork2 {
	//5 %Fast
	public static void main(String[] args) {


	}
	public static int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {

		int pro=0;
		// System.out.println(map.toString());

		for(int i=0;i<worker.length;i++)
		{
			int currentProfit=0;
			for(int j=0;j<difficulty.length;j++)
			{
				//System.out.println("map "+map.get(difficulty[j]).get(0));
				if(worker[i]>=difficulty[j] && profit[j]>currentProfit)
				{
					currentProfit=profit[j];
					//System.out.println("current "+currentProfit);
				}

			}
			pro+=currentProfit;
			//System.out.println("------------");

		}
		return pro;
	}



}
