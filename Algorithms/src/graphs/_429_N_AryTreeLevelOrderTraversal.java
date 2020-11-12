package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _429_N_AryTreeLevelOrderTraversal {

	 public static List<List<Integer>> levelOrder(Node root) {
	     
		 
	        List<List<Integer>>ans=new ArrayList<>();
	        
	        if(root==null)
	            return ans;
		        Queue<Node>queue=new LinkedList<>();
	            queue.add(root);
	        
	        int size=0;
	        
	        while(!queue.isEmpty())
	        {
	        size=queue.size();
	            List<Integer>val=new ArrayList<>();
	            for(int i=0;i<size;i++)
	            {
	                Node a=queue.poll();    
	                    val.add(a.val);
	                
	                for(Node n:a.children)
	                queue.add(n);
	                

	            }
	            ans.add(val);
	          
	        
	        }
	        return ans;
	    }
}
