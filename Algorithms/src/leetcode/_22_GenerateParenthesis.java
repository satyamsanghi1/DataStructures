package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _22_GenerateParenthesis {
	//backtracking
	//https://www.youtube.com/watch?v=sz1qaKt0KGQ
	public static void main(String[] args) {
		
		
		generateParenthesis(3);
	}
	 public static List<String> generateParenthesis(int n) {
	        
		 List<String>list=new ArrayList<>();
	        
	        helper(list,"",0,0,n);
	        return list;
	    }
	    
	 public static void helper(List<String>list,String current,int open ,int close ,int max)
	    {
	        
	        if(current.length()==max*2)
	        {
	            list.add(current);
	        }
	        
	        if(open<max)
	        {
	            helper(list,current+"(",open+1,close,max);
	        }
	        if(close<open)
	        {
	            helper(list,current+")",open,close+1,max);
	        }
	    }
}
