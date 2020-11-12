package algoExpert;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//graph
public class RiverSizes {
	//leetcode 200
	
	/*
	 * Algo :1) using visited boolean matrix to store which node is visited and which is not
	 * 
	 */
	public static void main(String[] args) {
		
		int [][] matrix= {
				{1,0,0,1,0},
				{1,0,1,0,0},
				{0,0,1,0,1},
				{1,0,1,0,1},
				{1,0,1,1,0}
				
		};
		
		riverSizes(matrix);
	}
	
	
	  public static List<Integer> riverSizes(int[][] matrix) {
			List<Integer>riverSize=new ArrayList<>();
			boolean visited[][]=new boolean[matrix.length][matrix[0].length];
			//iterating through the matrix
			for(int i=0;i<matrix.length;i++)
			{
			for(int j=0;j<matrix[0].length;j++)
			{
	//if node is not visited before , then we can traverse from this node
			if(!visited[i][j])
			{
			traverse(i,j,matrix,visited,riverSize);
			
			}
			
			}
			}
			System.out.println(riverSize);
	    return  riverSize;
	  }
	  public static void traverse(int i,int j,int [][]matrix,boolean [][]visited,List<Integer>sizes)
		{
			int size=0;
			//applying iterative depth First Search
			Stack<Integer[]>stack=new Stack<>();
			stack.push(new Integer[]{i,j});
			
			while(!stack.isEmpty())
			{
				Integer[]currentNode=stack.pop();
				 i=currentNode[0];
				 j=currentNode[1];
				
				 /*At this point we may think why we are again checking for visted node
				  * as the stack only contains unvisted nodes, because we are adding unvisited nodes obly
				  * 
				  * But for eg : 1,1,1,1
				  * 			 1,1,1,1
				  * 
				  * A[0,1]  is added to stack , and its neighbours are also added
				  *  next node is A[1][0] , some how we visit neighbour of A[0,1] because it may be 
				  *  neighbour of other node  and make it visited
				  *  but the same node (neighbour of A[0,1]) is still in stack
				  *  hence we check for the visited node even in the while loop
				  * 
				  * 
				  */
				if(visited[i][j])//imp condition
					continue;
				
				// marking the node visited
					visited[i] [j]=true;
				//if it is land then ignore
				if(matrix[i] [j]==0)
					continue;
				
				size++;	//increase the size of the river 
				//finding the neighbours of this node
				List<Integer[]>neighbours=findNeighbours(i,j,matrix,visited);
				//adding the neighbours to the stack
				for(Integer[]neighbour:neighbours)
				{
				stack.add(neighbour);
				}
				}
			if(size>0)
				sizes.add(size);
			
		}
		public static List<Integer[]> findNeighbours(int i,int j,int [][]matrix,boolean [][]visited)
		{
			/*only add neighbours which are not visited ( max 4 neighbours of a node 
			 * at any point of time)
			 * 
			 */
			List<Integer[]>neighbours=new ArrayList<>();
			if(i>0 && !visited[i-1][j])//up
				{
					neighbours.add(new Integer[]{i-1,j});
				}
				if(i+1<matrix.length && !visited[i+1][j] )//down
				{
				neighbours.add(new Integer[]{i+1,j});
				}
				if(j-1>=0 && !visited[i][j-1])//left
				{
					neighbours.add(new Integer[]{i,j-1});
				}
				if(j+1<matrix[0].length && !visited[i][j+1])
				{

				neighbours.add(new Integer[]{i,j+1});
				}
		
			return neighbours;
		}
		public static void print(List<Integer[]>a) {
			
			for(Integer[]x:a)
			{
				System.out.println(x[0]+" , "+x[1]);
			}
		}
}
