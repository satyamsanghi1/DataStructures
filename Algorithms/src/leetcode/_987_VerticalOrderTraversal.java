package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import binaryTree.Node;

class Cor implements Comparable<Cor>
{
	int value=0;
	int distance=0;
	int height=0;
	@Override
	public int compareTo(Cor o) {
		if(this.distance!=o.distance)
		{
		return	Integer.compare(this.distance,o.distance);
		}
		else if(this.height!=o.height)
		{
		return	Integer.compare(this.height,o.height);
		}
		else
		{
		return	Integer.compare(this.value,o.value);
		}
	}
}
public class _987_VerticalOrderTraversal {
	
	static List<Cor>list=new ArrayList<>();
	
	public static void main(String[] args) {
		
		Node node=new Node(1);
		
		node.left=new Node(2);
		
		
		node.right=new Node(3);
		
		
		node.left.left=new Node(4);
		
		node.left.right=new Node(5);
	
		
		node.right.left=new Node(6);
		node.right.right=new Node(7);
		
		HashMap<Node,Cor>map=new HashMap<>();
		verticalTraverse(node,0,0);
		
		Collections.sort(list);
		
		for(int i=0;i<list.size();i++)
		{
			
			Cor c=list.get(i);
			
			System.out.println("key "+c.value);
			System.out.println("distance "+c.distance);
			System.out.println("height "+c.height);
			
			System.out.println();
			
		}
		
		List<List<Integer>>l=new ArrayList<>();
			int prevHeight=list.get(0).distance;
			
			
			l.add(new ArrayList<Integer>());
	
		for(int i=0;i<list.size();i++)
		{
		
			if(prevHeight!=list.get(i).distance)
			{
				
				prevHeight=list.get(i).distance;
				l.add(new ArrayList<Integer>());
			}
			l.get(l.size()-1).add(list.get(i).value);
			
			
			System.out.println("prev "+prevHeight );
			
		}
		List q=l.get(l.size()-1);
		
		System.out.println("ans "+l);
		
		
		
	
	
		
	}
	
	public static  void verticalTraverse(Node node,int distance,int height)
	{
		System.out.println("node "+node.data+" d "+distance+" h "+height);
	
		Cor c=new Cor();
		c.distance=distance;
		c.height=height;
		c.value=node.data;
		
		list.add(c);
	
		if(node.left!=null)
		{
		verticalTraverse(node.left, distance-1,height+1);
		
		}
		
		if(node.right!=null)
		{
		verticalTraverse(node.right, distance+1,height+1);
		}
	

		
		
	}

}
