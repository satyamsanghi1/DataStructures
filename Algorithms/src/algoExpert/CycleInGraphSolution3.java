package algoExpert;

public class CycleInGraphSolution3 {

	//AlgoExpert Solution2
	//Time (O)V+E
	public static void main(String[] args) {


	}
	public static boolean cycleInGraph(int[][] edges) {
		// Write your code here.
		
		int colors[]=new int[edges.length];
		/*
		 * 	0->not visited
		 * 	1->inStack
		 * 	2->visited(finished)
		 */
		
		for(int node=0;node<edges.length;node++)
		{
			//iterating over vertex
			if(colors[node]==2)
				continue;
			
			boolean containsCycle=dfs(node, edges,colors);
			if(containsCycle)
				return true;
			
		}
		return false;
	}
	public static boolean dfs(int node,int [][]edges,int []colors)
	{
		colors[node]=1;
		
		for(int children:edges[node])
		{
			//checking 1 and 2 before dfs call is important
			 if(colors[children]==1)
				return true;
			
			 if(colors[children]==2)
				 continue;
			
			
				boolean containsCycle=dfs(children, edges, colors);
				if(containsCycle)
					return true;
			
			
		}
		colors[node]=2;
		return false;
	}
}
