package graphs;

import java.util.ArrayList;
import java.util.List;

public class _797_AllPathsFromSourceToTarget {
    List<List<Integer>>paths=new ArrayList<>();

	
	public static void main(String[] args) {
		
		
	}
	
	 public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
	        
	       // List<List<Integer>>paths=new ArrayList<>();
	        
	        List<Integer>current=new ArrayList<>();
	      
	            current.add(0);
	            
	        dfs(graph,current,0);
	        
	        return paths;
	    }
	    
	    public void dfs(int [][]graph,List<Integer>current,int idx)
	    {
	        
	        if(idx==graph.length-1)
	        {
	            paths.add(new ArrayList<Integer>(current));
	        }
	        for(int i:graph[idx])
	        {
	         current.add(i);
	        dfs(graph,current,i);
	        current.remove((Integer)i);
	        }
	        
	        
	    }
}
