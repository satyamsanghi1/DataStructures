package topologicalSort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class _207_CourseSchedule {
	//Time (O)V+E
	/*
	 * We can use cycle in graph algorithm to solve this question
	 * step1:convert the data into graph
	 * 		->numcourses-1 represent the vertices
	 * 		->key->vertex, value->[list of dependencies]
	 * 
	 * step2: Depth first Search on every vertex
	 * 		-> if current node have dependencies, then dfs on its dependencies
	 * 
	 * 
	 */
	
	public static void main(String[] args) {
		
		int numCourses=4;
		int[][] prerequisites={{0,1},{3,1},{1,3},{3,2}};
		
	boolean ans=	canFinish(numCourses, prerequisites);
	System.out.println("ans "+ans);
	}
	
	 public static boolean canFinish(int numCourses, int[][] prerequisites) {
	     
         HashMap<Integer,ArrayList<Integer>>map=new HashMap<>();
	        boolean []visited=new boolean[numCourses];
            boolean []inStack=new boolean[numCourses];
        
	        for(int []pre:prerequisites)
	        {
	            ArrayList<Integer>list=map.getOrDefault(pre[0],new ArrayList<Integer>());
	            list.add(pre[1]);
	            map.put(pre[0],list);
	            
	        }
	        
	        for(int i=0;i<numCourses;i++)
	        {
	            if(!visited[i] && map.containsKey(i)){
                boolean containsCycle=dfs(i,visited,inStack,map);
                    if(containsCycle)
                        return false;
                
                }
	        }
	        return true;
       
    }
    public static boolean dfs(int node,boolean []visited,boolean[]inStack, HashMap<Integer,ArrayList<Integer>>map)
    {
        
        visited[node]=true;
        inStack[node]=true;
        if(map.containsKey(node))
        for(int depend:map.get(node))
        {
            if(!visited[depend])
            {
                boolean containsCycle=dfs(depend,visited,inStack,map);
                if(containsCycle)
                    return true;
            }
            else if(inStack[depend])
                return true;
        }
        inStack[node]=false;
        return false;
    }
}
