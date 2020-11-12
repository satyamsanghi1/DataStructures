package binaryTree;

public class HeightOfBinaryTree {
	
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
		
		node.left.right.left=new Node(8);
		node.left.right.right=new Node(9);
		
		int height=findHeight(node);
		System.out.println("height "+height);
	}
	
	public static int findHeight(Node node)
	{
		
		System.out.println(node.data);
		
		if(node.right==null && node.left==null) {
			System.out.println("leaf node "+node.data);
				return 0;
		}
		
		int a = 0,b = 0;
		if(node.left!=null)
			a = findHeight(node.left);
		
		if(node.right!=null)
		 b=findHeight(node.right);
		
		
		return (a>b?a:b)+1;
	}

}
