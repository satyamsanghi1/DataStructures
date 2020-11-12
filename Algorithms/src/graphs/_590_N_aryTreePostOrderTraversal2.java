package graphs;

import java.util.ArrayList;
import java.util.List;


public class _590_N_aryTreePostOrderTraversal2 {
	//making list global will increase the speed
	//graph dfs using recursion
	public static void main(String[] args) {
		
		
		
	}
	  public List<Integer> postorder(Node root) {
	        
	        
	        List<Integer>list=new ArrayList<Integer>();
	        if(root==null)
	            return list;
	        for(Node n:root.children)
	        {
	        List l=postorder(n);
	                 list.addAll(l);
	            }
	        list.add(root.val);
	   
	        return list;
	    }

}
