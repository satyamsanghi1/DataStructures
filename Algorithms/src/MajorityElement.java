import java.util.HashMap;
import java.util.Map.Entry;

public class MajorityElement 
{
	public static void main(String[] args) {
		
		
		int []nums= {3,2,3};
		
		 HashMap<Integer,Integer>map=new HashMap<Integer,Integer>();
	        int val=0;
	        for(int i=0;i<nums.length;i++)
	        {
	            if(map.containsKey(nums[i]))
	            {
	            	val=map.get(nums[i]);
	                map.put(nums[i],++val);
	            }
	            else
	            {
	            	map.put(nums[i],1);
	            }
	            if(map.get(nums[i])>nums.length/2)
	            {
	            	System.out.println("found");
	            	System.out.println(nums[i]);
	            }
	        }
	        
		/*
		 * System.out.println("Iterating Hashmap");
		 * 
		 * for(Entry<Integer,Integer>e:map.entrySet()) {
		 * System.out.println(e.getKey()+" "+e.getValue());
		 * 
		 * if(e.getValue()>nums.length/2) { System.out.println("found"+e.getValue()); }
		 * }
		 */
	       
	}
}
