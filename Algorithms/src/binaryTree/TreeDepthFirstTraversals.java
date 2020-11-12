package binaryTree;



public class TreeDepthFirstTraversals {
	
	static int count=0;
	
	public static void main(String[] args) {
		
	
		
		Node node=new Node(1);
		System.out.println("1st Node "+node);
		node.left=new Node(2);
		System.out.println("2nd Node "+node.left);
		node.right=new Node(3);
		System.out.println("3rd Node "+node.right);
		node.left.left=new Node(4);
		node.left.right=new Node(5);
		
		node.right.left=new Node(6);
		node.right.right=new Node(7);
		
		System.out.println();
		System.out.println("Traversing ");
		System.out.println();
		//1 2 3 4 5 
		
	//	System.out.println(	node.left.right.data);
		traverse(node);
		
	}
	
	public static void traverse(Node node)
	{
	
	
		if(node.left!=null)
		{
			traverse(node.left);
		}

		if(node.right!=null)
		{
			traverse(node.right);
		}
		System.out.println(node.data+"address "+node);
		count++;
		System.out.println("count "+count );
		
	}
	
	public void insert(int data,Node node)
	{
		if(node.data==0)
		{
			node.data=data;
		}
		
	}

}
