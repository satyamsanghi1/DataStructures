package graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;


public class _590_N_aryTreePostOrderTraversal {
	//making list global will increase the speed
	//graph dfs using recursion
	public static void main(String[] args) {
		
		
		
	}
	  public List<Integer> postorder(Node root) {
	        

	         List<Integer> list = new ArrayList<>();
	        if (root == null) return list;
	        
	        Stack<Node> stack = new Stack<>();
	        stack.add(root);
	        
	        while(!stack.isEmpty()) {
	            root = stack.pop();
	            list.add(root.val);
	            for(Node node: root.children)
	                stack.add(node);
	        }
	        Collections.reverse(list);
	        return list;
	      
	    }

}
