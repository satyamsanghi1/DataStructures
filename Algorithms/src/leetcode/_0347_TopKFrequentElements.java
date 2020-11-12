package leetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class _0347_TopKFrequentElements {
	
	public static void main(String[] args) {
		
		int nums[]= {1,1,1,2,2,3};
		int k=2;
		
		topKFrequent(nums, k);
	}
	public static int[] topKFrequent(int[] nums, int k) {
        
			
			HashMap<Integer,Integer>map=new HashMap<>();
			for(int c:nums)
				map.put(c,map.getOrDefault(c,0)+1);
			
			PriorityQueue<Entry<Integer,Integer>>pq=new PriorityQueue<>(new Comparator<Entry<Integer,Integer>>() {
	
				@Override
				public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
					
					if(o1.getValue()<o2.getValue())
						return 1;
					
					if(o1.getValue()>o2.getValue())
						return -1;
					return 0;
				}
			});
			
			pq.addAll(map.entrySet());
			
				int a[]=new int[k];
				for(int i=0;i<a.length;i++)
				{
					a[i]=pq.remove().getKey();
				}
		traverse(a);
		return null;
    }
	public static void traverse(int a[]) {
		
		System.out.println();
		for(int i:a)
			System.out.print(i+" ");
		System.out.println();
	}

}
