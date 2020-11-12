package binaryTree;

public class CompleteBinaryTreeOrNot {
	
	public static void main(String[] args) {
		
		Node node=new Node(97);
		
		node.left=new Node(46);
		
	
		node.right=new Node(37);
		
		
		node.left.left=new Node(12);
		
		node.left.right=new Node(3);
		
		
		node.right.left=new Node(7);
		node.right.right=new Node(31);
		
		node.left.right.left=new Node(6);
		node.left.right.right=new Node(9);
		
		int nodeCount=countNodes(node);
		
		System.out.println("node count "+nodeCount );
		boolean ans=isCompleteBinaryTree(node, nodeCount,1);
		
		System.out.println("ans "+ans);
		
	}
	
	public static boolean isCompleteBinaryTree(Node node,int count,int i)
	{
		
		System.out.println("i "+i);
		if(i>count)
			return false;
		
		
		if(node.left!=null)
		{
			boolean a=isCompleteBinaryTree(node.left,count,2*i);
			if(a==false)
				return false;
		}
		if(node.right!=null)
		{
			boolean b=isCompleteBinaryTree(node.right,count,2*i+1);
			return b;
		}
		
		return true;
		
	}
	
	public static int countNodes(Node node)
	{
		System.out.println(node.data);
		
		if(node.left==null && node.right==null)
			return 1;
		
		int a=0;
		int b=0;
		if(node.left!=null)
		{
			a=countNodes(node.left);
		}
		if(node.right!=null)
		{
			b=countNodes(node.right);
		}
		System.out.println("a "+a);
		System.out.println("b "+b);
		System.out.println("no "+node.data);
		
		return (a+b)+1;
		
	}

}
