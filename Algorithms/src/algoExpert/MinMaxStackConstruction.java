package algoExpert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinMaxStackConstruction {
	
	public static void main(String[] args) {
		
		System.out.println(Character.isAlphabetic('{'));
		/*MinStack a=new MinStack();
		a.push(-2);
		System.out.println();
		a.push(0);
		System.out.println();
		a.push(-3);
		System.out.println(a.getMin());
		
		
		a.pop();	
		System.out.println(a.top());
		System.out.println(a.getMin());*/
		
		MinMaxStack s=new MinMaxStack();
		s.push(5);
		System.out.println(s.getMin());
		System.out.println(s.getMax());
		System.out.println(s.peek());

	}
	//ALGOEXPERT
	static class MinMaxStack {
		 List<Integer>l=new ArrayList<Integer>();
	  List<Map<String,Integer>>minMax=new ArrayList<>();
		
		public int peek() {
		if(!l.isEmpty())
		{
			return l.get(l.size()-1);
		}
			return -1;	
		}

		public int pop() {
			if(!l.isEmpty())
			{
				minMax.remove(minMax.size()-1);
				return l.remove(l.size()-1);
			}
			return -1;
		}

		public void push(Integer number) {
			if(!minMax.isEmpty())
			{
		Map<String,Integer>m=minMax.get(minMax.size()-1);
			
				Map<String,Integer>newMap=new HashMap<String,Integer>();
				if(number<m.get("min"))
				{
					newMap.put("min",number);
				}
				else
				newMap.put("min",m.get("min"));
				if(number>m.get("max"))
				{
					newMap.put("max",number);
				}
				else
				newMap.put("max",m.get("max"));
				minMax.add(newMap);
				l.add(number);
		}
				else
				{
					Map<String,Integer>newMap=new HashMap<String,Integer>();
					newMap.put("max",number);
					newMap.put("min",number);
					minMax.add(newMap);
					
					l.add(number);
				}
		}

		public int getMin() {
			if(!minMax.isEmpty())
			return minMax.get(minMax.size()-1).get("min");
			return -1;
		}

		public int getMax() {
			if(!minMax.isEmpty())
			return minMax.get(minMax.size()-1).get("max");
			return -1;
		}
	}
	
	
	//LEETCODE
	static class MinStack {
		//93% Fast	Leetcode
		/*
		 * Keep track of minimum element at each  index 
		 */
	    /** initialize your data structure here. */
	
	        List<Integer>l=new ArrayList<Integer>();
	        // we are not using extra space as these two list have space complexity (o)2N
	        // (O)N , as this space would be required to store elements in stack 
	        
	        /*
	         * but any point of time min operation takes (O)1 Time and (O)1 Space 
	         */
	        List<Integer>min=new ArrayList<Integer>();
	      
	    public MinStack() { 
	    }
	    
	    public void push(int x) {
	    	
			   l.add(x);
			   if(min.size()>=1)
			   {
				 
				   if(min.get(min.size()-1)<x)
				   {
					   min.add(min.get(min.size()-1));
				   }
				   else
					   min.add(x);
			   }
			   else
			   {
				   min.add(x);
			   }
			   System.out.println(min+" size "+min.size());
			   
	    }
	    
	    public void pop() {
	    	
	    	if(!l.isEmpty())
	    	{
	    		l.remove(l.size()-1);
	    		min.remove(min.size()-1);
	    	}
	    }
	     
	    
	    public int top() {
	    
	    if(!l.isEmpty())
	    	return l.get(l.size()-1);
	    
	    return -1;
	    }
	    
	    public int getMin() {
	     
	    	if(!min.isEmpty())
	    	{
	    		return min.get(min.size()-1);
	    	}
	    	return -1;
	    }
	}
	
	
	/* static class MinMaxStack {
		 // 45 % Fast
		 
		 public  MinMaxStack()
		 {
			
		 }
		 PriorityQueue<Integer>pq=new PriorityQueue<Integer>();
		 List<Integer>l=new ArrayList<Integer>();
		 
		    public int peek() {
		    
			    	if(!l.isEmpty())
			    		return l.get(l.size()-1);
			    	
			     return -1;
		    }

		    public int pop() {
			    	if(!pq.isEmpty())
			    	{
			    		int x=l.remove(l.size()-1);
			    		pq.remove(x);
			    	
			    	}
		      // Write your code here.
		      return -1;
		    }

		    public void push(Integer number) {
		    	pq.add(number);
		    	l.add(number);
		      // Write your code here.
		    }

		    public int getMin() {
		    	if(!pq.isEmpty())
		    		return pq.peek();
		    	
		     return -1;
		    }

		    public int getMax() {
		    	if(!pq.isEmpty())
		    		return pq.peek();
		    	
		     return -1;
		    }
		  }*/
	 
}
