package binaryTree;

public class Practice {
	static int x=2;
	public static void main(String[] args) {
		
		Node node=new Node(1);
		node.left=new Node(2);
		node.right=new Node(3);
		
		node.left.left=new Node(4);
		node.left.right=new Node(5);
		
		node.right.left=new Node(6);
		node.right.right=new Node(7);
		
		node.left.right.left=new Node(8);
		node.left.right.right=new Node(9);
		
		
		System.out.println("TRAVERSING");
		
		levelOrder(node,1);
		
	}
	
	public static void levelOrder(Node node,int level)
	{
		
		
			if(level==x) 
			System.out.println(node.data);
		
		
		if(node.left!=null)
			levelOrder(node.left,level+1);
			if(node.right!=null)
			levelOrder(node.right,level+1);
	
		
		}
	}

