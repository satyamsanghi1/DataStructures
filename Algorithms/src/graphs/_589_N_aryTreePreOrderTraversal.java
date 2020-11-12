package graphs;

import java.util.ArrayList;
import java.util.List;


public class _589_N_aryTreePreOrderTraversal {
	
	//graph dfs using recursion
	public static void main(String[] args) {
		
		
		
	}
	  public List<Integer> preorder(Node root) {
	        
	        
	        List<Integer>list=new ArrayList<Integer>();
	        
	        if(root==null)
	            return list;
	        list.add(root.val);
	        for(Node i:root.children)
	        {
	            list.addAll(preorder(i));
	        }
	        
	        return list;
	    }

}
