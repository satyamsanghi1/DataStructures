package graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class _589_N_aryTreePreOrderTraversal2 {
	
	//graph dfs using iterative
	public static void main(String[] args) {
		
	
		
	}
	  public List<Integer> preorder(Node root) {
	        
		  List<Integer>list=new ArrayList<Integer>();
	        if (root == null)
	            return list;
	       
	        Stack<Node>stack=new Stack<>();
	         while(root!=null)
			  {
	          list.add(root.val);
	         
	        for(int i=root.children.size()-1;i>=0;i--)
	        {
	            stack.push(root.children.get(i));
	        }
	          if(stack.isEmpty())
	              break;
	          
	          root=stack.pop();
			  }
	        
	        return list;
	    }
	 
	 
	  

}
