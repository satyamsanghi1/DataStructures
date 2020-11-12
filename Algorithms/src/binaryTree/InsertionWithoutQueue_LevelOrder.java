package binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class InsertionWithoutQueue_LevelOrder {
	
public static void main(String[] args) {
	
	Node node=new Node(1);
	System.out.println("1st Node "+node);
	node.left=new Node(2);
	
	System.out.println("2nd Node "+node.left);
	node.right=new Node(3);
	
	System.out.println("3rd Node "+node.right);
	node.left.left=new Node(4);
	System.out.println("3rd Node "+node.right);
	node.left.right=new Node(5);
	System.out.println("3rd Node "+node.right);
	
	node.right.left=new Node(6);
	node.right.right=new Node(7);
	
	int height=calculateHeight(node);
//	System.out.println("HEGHT "+height);
	
	traverseToInsert(node,height,10);
	traverseToInsert(node,height,11);
	traverseToInsert(node,height,12);
	traverseToInsert(node,height,13);

	calculateHeight(node);
	

	System.out.println();
	System.out.println("TRAVERSING");
	System.out.println();
	for(int i=1;i<=4;i++) {
		bredthTraverse(node,i);	
		
	}
	///for this we need to know the height of the tree already 
	

}

	public static Node insert(Node node,int level,int val)
	{
		if(level==1)
		{
			System.out.println("data : "+ node.data);
			if(node.left==null)
			{
				System.out.println("called left");
				node.left=new Node(val);
				return node.left;
			}
			else if(node.right==null)
			{
				System.out.println("called right");
				node.right=new Node(val);
				return node.right;
			}
			else
			{
				System.out.println("called else");
				return null;
			}
			
		}
		else {
		if(node.left!=null) {
		Node node1=	insert(node.left,level-1,val);
		if(node1!=null)
		{
			System.out.println("called "+node1.data);
		return node1;
		}
		}
		if(node.right!=null) {
			System.out.println("called this");
		Node node2=	insert(node.right,level-1,val);
		return node2;
		}
		
		}
		return node;
	}

	public static void bredthTraverse(Node node,int level)
	{
		if(level==1)
		{
			System.out.println(node.data);
			
		}
		else 
		{
			if(node.left!=null)
			bredthTraverse(node.left,level-1);
		
			if(node.right!=null)
			bredthTraverse(node.right,level-1);
		
		}
	
	}
	public static void traverseToInsert(Node node,int height,int val)
	{
		System.out.println();
		System.out.println("-------------------------------------");
		System.out.println("INSERTING "+val+"  ");
		System.out.println();
		//for(int i=1;i<=height;i++) {
			//System.out.println("Iterating "+i+" Level ");
			Node node1=insert(node,3,val);
			if(node1!=null)
			System.out.println("returned Node "+node1.data);
		//}
	}
	
	public static int calculateHeight(Node node)
	{
		Queue<Node>queue=new LinkedList<>();
		
		int count=0;
		queue.add(node);
		
		
		
		while(!queue.isEmpty())
		{
			count++;
			int size=queue.size();
		
			for(int i=1;i<=size;i++)
			{	
				Node n=	queue.poll();
					if(n.left!=null)
					queue.add(n.left);
					
					if(n.right!=null)
					queue.add(n.right);
			}			
		}
		System.out.println("HEGHT "+count);
	return count;
	}



	
}
