package leetcode;

import binaryTree.Node;

public class _0938_RangeSumBST {
	static int sum=0;
	
	public static void main(String[] args) {
		
		Node node=new Node(10);
		node.left=new Node(5);

		node.right=new Node(15);


		node.left.left=new Node(3);

		node.left.right=new Node(7);
		//node.left.right.left=new Node(8);

		//node.right.left=new Node(5);
		node.right.right=new Node(18);


	//	node.left.left.left=new Node(3);
	//	node.left.left.right=new Node(-2);
		rangeSumBST(node,7,15); // 32
		System.out.println();
		System.out.println("sum "+sum);
	}
	public static int rangeSumBST(Node root, int L, int R) {

		if(root==null)
			return 0;

		alter(root,L,R);
		int x=sum;
		//sum=0;
		return x;
	}
	   public static void alter(Node root, int L, int R) {
		    
           if(root==null)
               return ;
           System.out.println("val "+root.data);
       
             if(root.data>=L && root.data<=R)
               sum+=root.data;
             
             if(root.data>=L )
         alter(root.left,L,R);
             
             if(root.data<R)
         alter(root.right,L,R);
     
     
     }

}
