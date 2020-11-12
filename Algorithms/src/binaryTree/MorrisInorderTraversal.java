package binaryTree;

public class MorrisInorderTraversal {
	
	public static void main(String[] args) {
		
	Node node=new Node(10);
		
		node.left=new Node(5);
		
		
		node.right=new Node(15);
		
		
		node.left.left=new Node(3);
		
		node.left.right=new Node(7);
		//node.left.right.left=new Node(8);
		
		//node.right.left=new Node(5);
		node.right.right=new Node(18);
		
		morrisInorder(node);
	}
	
	
	public static void morrisInorder(Node root)
	{
		Node current=root;
		
		while(current!=null)
		{
			//System.out.println("current "+current.data);
			Node predecessor;
			if(current.left==null)
			{
				//visit node
				System.out.println(current.data);
				current=current.right;
			}
			else
			{
				// find inorder predecessor of current 
				 predecessor=current.left;
				
				while(predecessor.right!=null && predecessor.right!=current)
				{
					
					predecessor=predecessor.right;
					//System.out.println(predecessor.data);
				}
			
			//System.out.println("here "+predecessor.data);
			
			if(predecessor.right==null)
			{
				System.out.println("right null");
				predecessor.right=current;
				current=current.left;
			}
			else
			{
				predecessor.right=null;	
				System.out.println(current.data);
				current=current.right;
			}
			System.out.println();
			}	
		}
	}

}
