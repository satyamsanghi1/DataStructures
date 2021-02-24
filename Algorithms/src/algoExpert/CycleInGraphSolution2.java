package algoExpert;

public class CycleInGraphSolution2 {

	//AlgoExpert Solution1
	//Time (O)V+E
	//V space
	public static void main(String[] args) {


	}
	public static boolean cycleInGraph(int[][] edges) {
		// Write your code here.
		
		boolean []visited=new boolean[edges.length];
		boolean [] inStack=new boolean[edges.length];
		
		
		for(int node=0;node<edges.length;node++)
		{
			//iterating over vertex
			if(visited[node])
				continue;
			
			boolean containsCycle=dfs(node, edges, visited, inStack);
			if(containsCycle)
				return true;
			
		}
		return false;
	}
	public static boolean dfs(int node,int [][]edges,boolean []visited,boolean []inStack)
	{
		
		visited[node]=true;
		inStack[node]=true;
		for(int children:edges[node])
		{
			if(!visited[children])
			{
			boolean containsCycle=dfs(children, edges, visited, inStack);
			if(containsCycle)
				return true;
			}
			else if(inStack[children])
				return true;
			
		}
		inStack[node]=false;
		return false;
	}
}
