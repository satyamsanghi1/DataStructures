package algoExpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
class Item
{
	public int vertex;
	public int distance;
	
	public Item(int vertex, int distance) {
		super();
		this.vertex = vertex;
		this.distance = distance;
	}

	@Override
	public String toString() {
		return "Item [vertex=" + vertex + ", distance=" + distance + "]";
	}
	
}
public class DijkstraAlgorithmArrayMinHeap {
	
	public static void main(String[] args) {
		//ALGO EXPERT SOLUTION
	/*
	 * V-Vertex
	 * e-total edges in graph
	 * 
	 * Time-> VlogV + Elog V-> (V+E)LogV
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
		 List<Item>pairs=new ArrayList<>();
		 for(int i=0;i<numberOfEdges;i++)
		 {
			 pairs.add(new Item(i,Integer.MAX_VALUE));
		 }
		 System.out.println("data "+pairs.toString());
		 MinHeap heap=new MinHeap(pairs);
		 heap.update(start,0);
		 while(visited.size()!=numberOfEdges)//(O)V
		 {
			 Item getVertexData=heap.removeFromHeap();// (O)Log V
			 int currentMinDistance=getVertexData.distance;
			 System.out.println("currentMinDistance " +currentMinDistance);
			 int minDistanceVertex=getVertexData.vertex;
			
			 System.out.println("minDistanceVertex "+minDistanceVertex);
			 if(currentMinDistance==Integer.MAX_VALUE)
				 break;
			 
			 visited.add(minDistanceVertex);
			
			 for(int edge[]:edges[minDistanceVertex]) //(O)E
			 {
				 System.out.println("edge "+edge.length);
				 int destination=edge[0];
				 int distanceToDestination=edge[1];
				 
				 // visited contains vertex that has already shortest distance to that node
				 if(visited.contains(destination))
					 continue;
				 
				 int newPathDistance=distanceToDestination+currentMinDistance;
				 
				 if(newPathDistance<minDistance[destination])
				 {
					 minDistance[destination]=newPathDistance;
					 //also update the minHeap
					 heap.update(destination,newPathDistance); //(O) LOG V
				 }
				
			 }
			 System.out.println("----------");
		 }
		 // creating the final result
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
class MinHeap
{
	/*Map provides the mapping for vertex to index in heap because in heap , Item object containing vertex
	 * and distance can be shifted anywhere in the list according to the distance sorting , hence then it 
	 * would become difficult to find out item for a particular vertex in heap at index , it would requirs 
	 * (O) N operation . hence we use map so that we can perform this operation in constant time
	 * 
	 * KEY -> VERTEX
	 * VALUE -> INDEX  OF ITEM OBJECT IN HEAP DATA STRUCTURE
	 */
	static HashMap<Integer,Integer>vertexMap=new HashMap<>();
	static List<Item>heap=new ArrayList<>();
	
	public MinHeap(List<Item>array)
	{
		for(int i=0;i<array.size();i++)
		{
			Item item=array.get(i);
			vertexMap.put(item.vertex,item.vertex);
			heap.add(item);
		}
		
		buildHeap(heap);
	}
	 public static void buildHeap(List<Item>heap)
	 {
		 //call siftDown method for every parent node
		 int parentIdx=heap.size()-2/2;
		 
		 for(int i=parentIdx;i>=0;i--) 
		 {
			 siftDown( i,heap.size()-1);
		 }
	 }
	 public static void addInHeap(int value)
	 {
	
	 }
	 public boolean isEmpty()
	 {
		 return heap.size()==0;
	 }
	 public static void siftUp(int end)
	 {
		 int currentIdx=end;
		 int parentIdx=(currentIdx-1)/2;
		 while(currentIdx>0 && heap.get(parentIdx).distance>heap.get(currentIdx).distance)
		 {
			 swap(parentIdx, currentIdx); 
			 currentIdx=parentIdx;
			  parentIdx=(currentIdx-1)/2;
			
		 }
	 }
	 public static Item removeFromHeap()
	 {
		 Item valueToRemove=heap.get(0);
		 
		 swap(0,heap.size()-1);
		 heap.remove(heap.size()-1);
		 
		 siftDown(0,heap.size()-1);
		 
		 return valueToRemove;
	 }
	 public static void siftDown(int start,int end)
	 {
		 int childOneIdx=start*2+1;
		 
		 while(childOneIdx<=end)
		 {
			 int idxToBeSwapped;
			 int childTwoIdx=(start*2)+2<end?(start*2)+2:-1;
			 
			 if(childTwoIdx!=-1)
			 {
				idxToBeSwapped=heap.get(childOneIdx).distance<heap.get(childTwoIdx).distance?childOneIdx:childTwoIdx; 
			 }
			 else
			 {
				 idxToBeSwapped=childOneIdx; 
			 }
			 
			 if(heap.get(idxToBeSwapped).distance<heap.get(start).distance)
			 {
				 swap(idxToBeSwapped,start);
				 start=idxToBeSwapped;
				 childOneIdx=start*2+1;
			 }
			 else
				 break;
			 
			
		 }
	 }
	 public static void update(int vertex,int value) //(O)Log V (V->Vertex)
	 {
		 // get the index from vertex map of given vertex
		 int indexInHeap=vertexMap.get(vertex);
		 //setting the given value in the heap at the indexToHeap location 
		 heap.set(indexInHeap,new Item(vertex,value));
		 
		 //call siftUp so that minHeap property can be satisfied as we have updated the value
		 siftUp( indexInHeap);
	 }
	 public static void swap(int i,int j)
	 {
		 /*Whenever we need to swap , we also have to change the mapping in the vertex map 
		  */
		vertexMap.put(heap.get(i).vertex,j);
		vertexMap.put(heap.get(j).vertex,i);
		 Item temp=heap.get(i);
		 heap.set(i,heap.get(j));
		 heap.set(j,temp);
		 }
}