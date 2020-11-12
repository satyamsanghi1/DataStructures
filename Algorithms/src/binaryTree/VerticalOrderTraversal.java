package binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.TreeMap;

class Pair
{
	int dist;
	Node node;
	
	public Pair() {}
	
	 Pair(int dist,Node node)
	{
		this.dist=dist;
		this.node=node;
	}
}
public class VerticalOrderTraversal {
	
	public static void main(String[] args) 
	{
		
		/*Node node=new Node(1);
	
		node.left=new Node(2);
		
		
		node.right=new Node(3);
		
		
		node.left.left=new Node(4);
		
		node.left.right=new Node(5);
		//node.left.right.left=new Node(8);
		
		node.right.left=new Node(6);
		node.right.right=new Node(7);
		*/
	Node node=new Node(1);
		
		node.left=new Node(14);
		
		
		node.right=new Node(3);
		
		
		node.left.left=new Node(7);
		
		node.left.right=new Node(4);
		//node.left.right.left=new Node(8);
		
		node.right.left=new Node(5);
		node.right.right=new Node(15);
		
		
		node.left.left.left=new Node(6);
		node.left.left.right=new Node(13);
		
		node.left.right.left=new Node(10);
		node.left.right.right=new Node(11);
		
		node.right.left.left=new Node(2);
		node.right.left.right=new Node(12);
		
		node.right.right.left=new Node(8);
		node.right.right.right=new Node(9);
		//node.left.right.left=new Node(8);
		//node.left.right.right=new Node(9);
		TreeMap<Integer,ArrayList<Integer>>map=new TreeMap<>();
		verticalTraverse(node,map);
	
		for(Entry<Integer,ArrayList<Integer>>e:map.entrySet())
		{
			System.out.println(e.getValue());
		}
		
		System.out.println();
		
		
	
		
	}
	
	public static void verticalTraverse(Node node,TreeMap<Integer,ArrayList<Integer>>map)
	{
	
		Queue<Pair>queue=new LinkedList<>();
		
		queue.add(new Pair(0,node));
				
			
			
			while(!queue.isEmpty())
			{
				int size=queue.size();
				
				for(int i=0;i<size;i++)
				{
					
				Pair p=queue.poll();
				int hd=p.dist;
				Node n=p.node;
				System.out.print(n.data+" :dist  "+hd+" , ");
				
				if(map.containsKey(hd))
				{
					
					ArrayList<Integer> a=map.get(hd);
					a.add(n.data);
					map.put(hd,a);
				}
				else
				{
					System.out.println("not contains");
					ArrayList<Integer> a=new ArrayList<Integer>();
					a.add(n.data);
					map.put(hd,a);
				}
				
				if(n.left!=null)
				{
					queue.add(new Pair(hd-1,p.node.left));
				}
				if(n.right!=null)
				{
					queue.add(new Pair(hd+1,p.node.right));
				}
				}
				System.out.println();
				
			}
		
	
		
	}
}
