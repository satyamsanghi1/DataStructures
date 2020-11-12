package algoExpert;



public class RightSiblingTree {
	
	public static void main(String[] args) {
		
		BinaryTree root=new BinaryTree(1);
		root.left=new BinaryTree(2);
		
		root.left.left=new BinaryTree(4);
		root.left.right=new BinaryTree(5);
	
		root.left.left.left=new BinaryTree(8);
		root.left.left.right=new BinaryTree(9);
		
		root.left.right.right=new BinaryTree(10);	
		
		root.right=new BinaryTree(3);
		
		root.right.right=new BinaryTree(7);
		root.right.left=new BinaryTree(6);
		
		root.right.left.left=new BinaryTree(11);
		root.right.left.left.left=new BinaryTree(14);
		
		root.right.right.left=new BinaryTree(12);
		root.right.right.right=new BinaryTree(13);
		rightSiblingTree(root);
		
	}
	  public static BinaryTree rightSiblingTree(BinaryTree root) {
		
		    return root;
		  }
	  public static BinaryTree mutate(BinaryTree root,boolean isleftBinaryTree,BinaryTree parent) {
		  
			//depth first search
			if(root==null)
				return null;
		
		
			BinaryTree left=root.left;
			BinaryTree right=root.right;
			
			mutate(left,true,root);
			
			if(parent==null)
			{
				root.right=null;
			}
			else if(isleftBinaryTree==true)
			{
				root.right=parent.right;
			}
			else
			{
				if(parent.right!=null)
				{
					root.right=parent.right.left;
				}
				else
				{
					root.right=null;
				}
		
			}
			mutate(right,false,root);
			return root;
			
		}
	
	
	  
		

}
