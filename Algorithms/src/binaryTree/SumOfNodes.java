package binaryTree;

public class SumOfNodes {
	
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
		
		System.out.println(sum(node));
	}
	
	public static int sum(Node node)
	{
		System.out.println("data "+node.data);
		System.out.println();
		int a=0;
		int b=0;
		
		if(node.left==null && node.right==null)
		{
			return node.data;
		}
		
		if(node.left!=null)
		{
			 a=sum(node.left);
			 
			 System.out.println("a "+a);
		}
		
		if(node.right!=null)
		{
			b=sum(node.right);
			 System.out.println("b "+b);
		}
		
		System.out.println("returned value "+(a+b));
		System.out.println();
		return a+b;
		
	}

}
