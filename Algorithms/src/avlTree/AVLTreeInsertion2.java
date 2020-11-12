package avlTree;

public class AVLTreeInsertion2 {
	
	public static void main(String[] args) {
		
		
		Tree root=null;
		
		root=insert(root,30);
		Tree head=root;
	System.out.println();
	System.out.println();
	
		
		  insert(head,20); traverse(head); System.out.println(); System.out.println();
		 
		
		
		  insert(head,40); traverse(head); System.out.println(); System.out.println();
		 
		
		
		head=insert(head,10);
		traverse(head);
		System.out.println();
		System.out.println();
		
		
		head=insert(head,5);
		traverse(head);
		System.out.println();
		System.out.println();
		
		head=insert(head,3);
		traverse(head);
		System.out.println();
		System.out.println();
		
		/*head=insert(head,4);
		traverse(head);
		System.out.println();
		System.out.println();
		
		head=insert(head,50);
		traverse(head);
		System.out.println();
		System.out.println();
		
		head=insert(head,60);
		traverse(head);
		System.out.println();
		System.out.println();
		

		head=insert(head,70);
		traverse(head);
		System.out.println();
		System.out.println();
		


		head=insert(head,65);
		traverse(head);
		System.out.println();
		System.out.println();
		/*head=insert(head,9);//return new root of tree 
		System.out.println("traversing");
*/
		traverse(head);
		System.out.println();
		System.out.println();
		/*insert(head,3);
		traverse(head);
		System.out.println();
		System.out.println();
		

		insert(head,18);
		traverse(head);
		*/
		//traverse(head);
		
		
		
	}
	
	public static Tree insert(Tree node,int value)
	{
		
	
		if(node==null)
		{
			System.out.println("creating node ");
			node=new Tree(value);

			return node;
		}
		
		
		System.out.println("node "+node.data);
		
		if(value<=node.data )
		{
			System.out.println("going left");
			node.left=insert(node.left,value);
		}
		
		
		
		if(value >node.data )
		{
			System.out.println("going right");
			node.right=insert(node.right,value);
		}
	
				
				
		int balanceFactor=balanceFactor(node);
		if(balanceFactor>=2 || balanceFactor <-1)
			System.out.println("Rotation required at node  "+node.data);
		System.out.println("balance factor of node "+node.data+" : "+balanceFactor);
		int h=calculateHeight(node);
		System.out.println("calculated height of node  "+node.data+" : "+h);
		node.height=h;
		
		//Rotation conditions 
		if(balanceFactor>1)
		{	
			// Left 
			
		if( calculateHeight(node.left.left)>=calculateHeight(node.left.right))
		{
			// LEFt
	
			System.out.print("LEFT LEFT Condition : ");

			Tree RightRotatedNode=rightRotate(node);
		
			node=RightRotatedNode;
		
		
		}
		
		if( calculateHeight(node.left.right)>calculateHeight(node.left.left))
		{
			//RIGHT
	
			//System.out.println("node right "+node.right.data );
			System.out.println("LEFT RIGHT Condition");
			Tree unbalancedNode=node;
			//left Rotating left child of unbalanced Node 
			unbalancedNode.left=leftRotate(unbalancedNode.left);
			
			//right rotating unbalanced Node
			unbalancedNode=rightRotate(unbalancedNode);
			
			node=unbalancedNode;
		}
		}
		if(balanceFactor<-1) {
			System.out.println("node.right.right "+ calculateHeight(node.right.right));
			System.out.println("node.right.left "+calculateHeight(node.right.left));
			//RIGHT
		if( calculateHeight(node.right.right) > calculateHeight(node.right.left))
		{
			System.out.println();
			System.out.println("RIGHT RIGHT Condition");
			Tree LeftRotatedNode=leftRotate(node);
			node=LeftRotatedNode;
		}
		if( calculateHeight(node.right.left)> calculateHeight(node.right.right))
		{
			System.out.println();
			System.out.println("RIGHT LEFT Condition");
			Tree unbalancedNode=node;
			//right Rotating right child of unbalanced Node 
			unbalancedNode.right=rightRotate(unbalancedNode.right);
			
			//left rotating unbalanced Node
			unbalancedNode=leftRotate(unbalancedNode);
			
			node=unbalancedNode;
		}
		}
		
		
		
		System.out.println("passed");
		return node;
	}
	
	public static Tree leftRotate(Tree unbalancedNode)
	{
		Tree newRoot=unbalancedNode.right;
		
		unbalancedNode.right=unbalancedNode.right.left;
		
		newRoot.left=unbalancedNode;
		
		unbalancedNode.height=calculateHeight(unbalancedNode);
		newRoot.height=calculateHeight(newRoot);
		
		return newRoot;
	}
	
	public static Tree rightRotate(Tree unbalancedNode)
	{
		Tree newRoot=unbalancedNode.left;
		
		unbalancedNode.left=unbalancedNode.left.right;
		
		newRoot.right=unbalancedNode;
		
		unbalancedNode.height=calculateHeight(unbalancedNode);
		newRoot.height=calculateHeight(newRoot);
		
		return newRoot ;
		
	}
	public static int calculateHeight(Tree node)
	{
		if(node==null)
			return -1;
		//System.out.println("calculating height of node "+node.data);
		if(node.left ==null && node.right==null)
			return 0;
		
		else
			return max(node.left,node.right)+1;
	
	}
	
	public static int max(Tree left ,Tree right)
	{
		
		
		if(left==null && right!=null)
		{
			return right.height;
		}
		else if(left!=null && right==null)
			return left.height;
		else
			return left.height>right.height?left.height:right.height;
		
	}
	
	public static int balanceFactor(Tree node)
	{
		int left=calculateHeight(node.left);
		int right=calculateHeight(node.right);
		
		return left-right;
		
	}
	public static void traverse(Tree node)
	{
		
		System.out.println("node "+ node.data+"  height "+node.height);
		
		if(node.left !=null)
		{
			traverse(node.left);
		}
		if(node.right!=null)
		{
			traverse(node.right);
		}
	}
	

}
