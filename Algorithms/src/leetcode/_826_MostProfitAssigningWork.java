package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


class Pair1
{
	Integer key;
	Integer value;


	public Pair1(Integer key, Integer value) {
		super();
		this.key = key;
		this.value = value;
	}

	public Integer getKey() {
		return key;
	}
	public void setKey(int key) {
		this.key = key;
	}
	public Integer getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}


}
public class _826_MostProfitAssigningWork {

	public static void main(String[] args) {


		int []difficulty=new int [] {49,49,76,88,100};
		int []profit=   new int []  {5,  8,75,89,94};

		int []worker=new int [] {98,72,16,27,76};

		int po=	maxProfitAssignment(difficulty, profit, worker);

		System.out.println("profit "+po);
	}
	public static int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {


		// bind difficulty and profit together using Pair class
		// because we need to sort difficulty and profit are bind to difficulty using same index


		List<Pair1>list=new ArrayList<>();

		for(int i=0;i<difficulty.length;i++)
		{
			list.add(new Pair1(difficulty[i],profit[i]));
		}
		Collections.sort(list,new Comparator<Pair1>() {

			@Override
			public int compare(Pair1 o1, Pair1 o2) {

				return o1.getKey().compareTo(o2.getKey());
			}

		});
		
		int ans[]=new int [worker.length];
		int j=0;
		for(int i=0;i<worker.length;i++)
		{
			
		
			while(j<list.size())
			{
				if(worker[i] >= list.get(j).getKey())
				{
					ans[i]=Math.max(ans[i],list.get(j).getValue());
					j++;
				}
				else
					break;
				
			}
		}

		return 0;
	}

}
