package binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderSpiralTraversal {
	
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
	
	
	
	for(int i=1;i<=3;i++)
	bredthTraverse(node,i);
	
	///for this we need to know the height of the tree already 

}
	public static void bredthTraverse(Node node,int level)
	{
		if(level==1)
		{
			System.out.println(node.data);
		}
		else 
		{
			if(level%2==0) {
			bredthTraverse(node.left,level-1);
			bredthTraverse(node.right,level-1);
			}
			else
			{
				bredthTraverse(node.right,level-1);
				bredthTraverse(node.left,level-1);
			}
			}
			
	}


	
}
