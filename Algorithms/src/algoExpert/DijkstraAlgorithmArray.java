package algoExpert;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DijkstraAlgorithmArray {
	
	public static void main(String[] args) {
		//ALGO EXPERT SOLUTION
	/*
	 * V-Vertex
	 * e-total edges in graph
	 * 
	 * Time-> V^2 + E
	 * 
	 * 
	 */
		int [][][]edges=new int [][][] {
		    {{1, 7}},
		    {{2,6}, {3,20}, {4,3}},
		    {{3,14}},
		    {{4,2}},
		    {},
		    {}
		  };
				
		
		int ans[]=dijkstrasAlgorithm(0, edges);
		System.out.println("ans ");
		for(int i:ans)
		{
			System.out.print(i+" ");
		}
		
	}
	 public static int[] dijkstrasAlgorithm(int start, int[][][] edges) {
		    // Write your code here.
		 
		 int numberOfEdges=edges.length;
		 
		 System.out.println("number of edges "+numberOfEdges);
		 
		 int [] minDistance=new int [edges.length];
		 
		 Arrays.fill(minDistance,Integer.MAX_VALUE);
		 
		 Set<Integer>visited=new HashSet<>();
		 
		 minDistance[start]=0;
		 
		 while(visited.size()!=numberOfEdges)//(O)V
		 {
			 int []getVertexData=getVertexWithMinDistance(visited,minDistance); // (O)V
			 int currentMinDistance=getVertexData[1];
			 int minDistanceVertex=getVertexData[0];
			
			 System.out.println("minDistanceVertex "+minDistanceVertex);
			 if(currentMinDistance==Integer.MAX_VALUE)
				 break;
			 
			 visited.add(minDistanceVertex);
			 
			 //[[2,6],[3,20]]
			 //(O) E
			 /*this for loop is not in getVertexWithMinDistance methods
			  * hence time is not V^2.E  , it is V^2+E
			  * 
			  */
			 for(int edge[]:edges[minDistanceVertex]) 
			 {
				 System.out.println("edge "+edge.length);
				 int destination=edge[0];
				 int distanceToDestination=edge[1];
				 
				 // visited contains vertex that has already shortest distance to that node
				 if(visited.contains(destination))
					 continue;
				 
				 int newPathDistance=distanceToDestination+currentMinDistance;
				 
				 minDistance[destination]=Math.min(newPathDistance,minDistance[destination]);
			 }
		 }
		 int [] finalDistances=new int [minDistance.length];
		 
		 for(int i=0;i<minDistance.length;i++)
		 {
			 if(minDistance[i]==Integer.MAX_VALUE)
			 {
				 finalDistances[i]=-1;
			 }
			 else
			 {
				 finalDistances[i]=minDistance[i];
			 }
		 }
		return finalDistances;
		  }
	private static int[] getVertexWithMinDistance(Set<Integer> visited, int[] minDistance)
	{
		
		int min=Integer.MAX_VALUE;
		int minDistanceVertex=-1;
		for(int vertex=0;vertex<minDistance.length;vertex++)
		{
			if(!visited.contains(vertex))
			{
				if(minDistance[vertex]<min)
				{
					min=minDistance[vertex];
					minDistanceVertex=vertex;
				}
			}
		}
		return new int [] {minDistanceVertex,min};
	}
	 
	

}
