package algoExpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinRewards4 {
	//https://leetcode.com/problems/candy/discuss/42770/One-pass-constant-space-Java-solution
	
	//visual Representation 
	//http://www.allenlipeng47.com/blog/index.php/2016/07/21/candy/
	public static void main(String[] args) {
		
		//int scores[]= {1, 2, 3 ,4, 5, 3 ,2 ,1, 2, 6, 5, 4, 3 ,3, 2, 1, 1, 3, 3, 3, 4 ,2};
		
		//int scores[]= {8,4,2,1,3,6,7,9,5};
		int scores[]= {4,10,8,6,4,2,8};
		minRewards(scores);
		
	}

	public static int minRewards(int[] ratings) {
	
		int down=0;
		int total=1;
		int up=1;
		for(int i=1;i<ratings.length;i++)
		{
			System.out.println("up "+up);
			System.out.println("here at "+ratings[i]);
			if(ratings[i]>=ratings[i-1])
			{
				if(down>0)
				{
					
					System.out.println("down "+down);
					total+=down*(down+1)/2;
					if (down >= up) //is like the max condition in prev solutions
					{
						System.out.println("in at "+ratings[i]+" down "+down+" total "+total);
						total += down - up + 1;
					}
					down=0;
					up=1;
				}
			
				up = ratings[i] == ratings[i-1] ? 1 : up+1;
				System.out.println("up "+up+ "at "+ratings[i]);
				total+=up; 	

			}
			else
			{
				down++;
			}
			System.out.println("total "+total);
			System.out.println("------------------");
		}
		//if we end going down
		if(down>0)
		{
			total+=down*(down+1)/2;
			
			if (down >= up) total += down - up + 1;
		}
		
		System.out.println("ans "+total);
		return total;
	}
	

	public static void traverse(int[] a)
	{
		for(int i:a)
			System.out.print(i+" ");
		System.out.println();
	}

}
