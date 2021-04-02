package algoExpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class NonConstructibleChange2 {
	//mysolution working
	public static void main(String[] args) {


		int []coins=new int[] {1,1,1,1,1};

		int ans=nonConstructibleChange(coins);
		System.out.println("ans "+ans);
	}
	public static int nonConstructibleChange(int[] coins) {


		ArrayList<Integer>list=new ArrayList<>();
		Set<Integer>set=new HashSet<Integer>();

		Arrays.sort(coins);
		int count=1;
		int sum=0;
		for(int i=0;i<coins.length;i++)
		{
			sum+=coins[i];
			System.out.println("coin "+coins[i]);

			int size=0;


			size=list.size();
			list.add(coins[i]);

			int lastAdded=list.get(list.size()-1);
			if(set.add(lastAdded))
			{
				if( count!=lastAdded)
					return count;
				count++;
				System.out.println("count in set before "+count);
			}
			for(int z=0;z<size;z++)
			{
				list.add(list.get(z)+coins[i]);
				 lastAdded=list.get(list.size()-1);

				if(set.add(lastAdded))
				{
					System.out.println("last added "+lastAdded);
					if( count!=lastAdded)
						return lastAdded;
					count++;
					System.out.println("count in set "+count);
				}


				// System.out.println("current "+current);
			}
			System.out.println("outside for");

			System.out.println(list);
			System.out.println("----------");
		}
		return sum+1;

	}

}
