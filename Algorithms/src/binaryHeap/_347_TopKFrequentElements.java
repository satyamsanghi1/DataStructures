package binaryHeap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class _347_TopKFrequentElements {

	static List<Integer>heap=new ArrayList<>();
	public static void main(String[] args) {
		
		
		int []nums= {1,2};
		
		int a[]=topKFrequent(nums,2);
	
		System.out.println("ans");
		for(int x:a)
			System.out.print(x+" ");
	}
	

    public  static int[] topKFrequent(int[] nums, int k) {
        //82 % Fast
    	
    	//time 4N + kLogN
        HashMap<Integer,Integer>map=new HashMap<>();
        HashMap<Integer,List<Integer>>map1=new HashMap<>();
        
        for(int i=0;i<nums.length;i++)
        {
            int val=map.getOrDefault(nums[i],0)+1;
           map.put(nums[i],val);
           
        }
        traverseMap(map);
        
     System.out.println("map1");
        for(Entry<Integer,Integer>e:map.entrySet())
        {
        	List<Integer>list=map1.getOrDefault(e.getValue(),new ArrayList<>());
         	list.add(e.getKey());
        	map1.put(e.getValue(), list);
       
        	heap.add(e.getValue());
	
        }
        map1.forEach((t,v)->{
        	System.out.println("k "+t+ " v "+v);
        });
        System.out.println("heap "+heap);
     
        
        buildHeap();//(O)N
        System.out.println("after building heap "+heap.size());
        int x=0;
         int ans[]=new int [k];
        for(int i=0;i<k;i++)
        {
        	int val=remove();
        	//finding index from map1 
        	System.out.println("val "+val);
        	if(map1.containsKey(val))
        	{
        	List<Integer>list=map1.get(val);
        	map1.remove(val);
        	System.out.println("list "+list);
        	for(int q:list)
        	{
        		ans[x++]=q;
        	}
        	System.out.println("k "+k);
        	}
        }
        
        
        return ans;

    }
    public static void buildHeap()
    {
    //call shift donwn method	
    
    	for(int i=heap.size()-2;i>=0;i--)
    	{
    		shiftDown(i,heap.size()-1);
    	}
    	
    	
    }
    public static void shiftDown(int start,int end)
    {
    	int childOneIdx=start*2+1;
    	
    	while(childOneIdx<=end)
    	{
    		int childTwoIdx=(start*2+2)<=end?(start*2+2):-1;
    		int IdxToReplace=0;
    		if(childTwoIdx!=-1 && heap.get(childTwoIdx)>heap.get(childOneIdx))
    		{
    			IdxToReplace=childTwoIdx;
    		}
    		else
    		{
    			IdxToReplace=childOneIdx;
    		}
    		if(heap.get(IdxToReplace)>heap.get(start))
    		{
    			swap(start,IdxToReplace, heap);
    			start=IdxToReplace;
    			childOneIdx=start*2+1;
    		}
    		else
    		{
    			break;
    		}
    		
    	}
    }
    public static int remove()
    {
    	
    	int valueToRemove=heap.get(0);
    	swap(0,heap.size()-1, heap);
    	heap.remove(heap.size()-1);
    	
    	shiftDown( 0,heap.size()-1);
    	return valueToRemove;
    }
    public static void swap(int i,int j,List<Integer>heap)
    {
    	int temp=heap.get(i);
    	heap.set(i,heap.get(j));
    	heap.set(j,temp);
    }
    
    public static void traverseMap(HashMap<Integer,Integer>map)
    {
    	map.forEach((k,v)->{
    		
    		System.out.println("k "+k+ " v "+v);
    	});
    }
}
