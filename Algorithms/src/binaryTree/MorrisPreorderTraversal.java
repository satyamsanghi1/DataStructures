package binaryTree;

public class MorrisPreorderTraversal {

	//ROOT->LEFT->RIGHT
	public static void main(String[] args) {
		
		Node node=new Node(10);
		
		node.left=new Node(5);
		
		
		node.right=new Node(15);
		
		
		node.left.left=new Node(3);
		
		node.left.right=new Node(7);
		//node.left.right.left=new Node(8);
		
		//node.right.left=new Node(5);
		node.right.right=new Node(18);
		
		morrisPreorder(node);
		
		
	}
	
	public static void morrisPreorder(Node root)
	{
		Node current=root;
		int x=0;
		while(current!=null)
		{
			x++;
			//System.out.println(x);
		if(current.left==null)
		{
			System.out.println(current.data);
			current=current.right;
		}
		else
		{
			//find predecessor 
			Node predecessor=current.left;
			
			while(predecessor.right!=null && predecessor.right!=current)
			{
				predecessor=predecessor.right;
			}
			
			if(predecessor.right==null)
			{
				//System.out.println("pre of "+current.data+" is "+predecessor.data);
				//establishing connection between predecssor of current to come back 
				predecessor.right=current;
				System.out.println(current.data);
				current=current.left;
			}
			else
			{
				
				predecessor.right=null;
				current=current.right;
			}
		}

		}
	}
}
