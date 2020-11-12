package algoExpert;

import java.util.ArrayList;
import java.util.List;

public class PermutationsAlter {

public static void main(String[] args) {
		
		int nums[]= {1,2,3};
		List<List<Integer>>perms=new ArrayList<>();
		List<Integer>perm=new ArrayList<Integer>();
		//using a boolean array to keep check which element is used
		boolean used[]=new boolean[nums.length];
		helper(nums, used, perm, perms);
		System.out.println(perms);
	}
	public static void helper(int nums[],boolean[] used,List<Integer>perm,List<List<Integer>>perms)
	{
		if(perm.size()==nums.length)
		{
			perms.add(new ArrayList<Integer>(perm));
		}
		else
		{
			for(int i=0;i<nums.length;i++)
			{
				// if current element is used than we simply skip it 
				if(used[i])
					continue;
				//if not used then add it to current perm and mark it as true
				perm.add(nums[i]);
				used[i]=true;
				helper(nums, used, perm, perms);
				// when coming back mark the element as false and remove the element 
				// to the previous state , so that we can form new permutations from that state
				perm.remove(perm.size()-1);
				used[i]=false;
			}
		}
}
}
