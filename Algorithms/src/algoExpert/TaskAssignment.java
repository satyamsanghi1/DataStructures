package algoExpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TaskAssignment {
	
	public static void main(String[] args) {


		int k=3;
		ArrayList<Integer>tasks=new ArrayList<Integer>();
		tasks.add(1);
		tasks.add(3);
		tasks.add(5);
		tasks.add(3);
		tasks.add(1);
		tasks.add(4);

		ArrayList<ArrayList<Integer>>ans =taskAssignment(k, tasks);

		System.out.println("ans "+ans);
	}
	public static ArrayList<ArrayList<Integer>> taskAssignment(int k, ArrayList<Integer> tasks) {
		// Write your code here.
	
		HashSet<Integer>set=new HashSet<>();
		ArrayList<ArrayList<Integer>>ans=new ArrayList<>();


		while(set.size()!=tasks.size())
		{
			
			int a[]=findMaxMin(tasks, set);
			ArrayList temp=new ArrayList<>();
			temp.add(a[0]);
			temp.add(a[1]);
			ans.add(temp);
			System.out.println("size "+set.size());
			System.out.println("---------------");
		}
		return ans;
	}
	public static int [] findMaxMin(ArrayList<Integer>list,HashSet<Integer>set)
	{
		int maxIdx=0;
		int minIdx=0;
		for(int i=0;i<list.size();i++) {
			if(list.get(i)!=-1)
			{
				 maxIdx=i;
				 minIdx=i;
				 break;
			}
		}

		for(int i=0;i<list.size();i++)
		{
			if(set.contains(i))
				continue;

			maxIdx=list.get(i)>list.get(maxIdx)?i:maxIdx;
			minIdx=list.get(i)<=list.get(minIdx)?i:minIdx;

		}
		System.out.println("max "+maxIdx+" min "+minIdx);
		set.add(minIdx);
		set.add(maxIdx);
		list.set(minIdx,-1);
		list.set(maxIdx,-1);
		System.out.println("set "+set);
		System.out.println("list "+list);
		return new int [] {maxIdx,minIdx};
	}

}
