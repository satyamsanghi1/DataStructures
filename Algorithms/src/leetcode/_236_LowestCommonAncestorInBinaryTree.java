package leetcode;

import binaryTree.Node;

public class _236_LowestCommonAncestorInBinaryTree {

	
	public static void main(String[] args) {
		

		Node node=new Node(6);
		
		node.left=new Node(2);
		
		node.right=new Node(8);
	
		node.left.left=new Node(0);
		node.left.right=new Node(4);
		
		node.right.left=new Node(7);
		node.right.right=new Node(9);
		
		node.left.right.left=new Node(3);
		node.left.right.right=new Node(5);
		
		
		Node p=new Node(3);
		Node q=new Node(5);
		
		Node ancestor=lowestCommonAncestor(node, p, q);
		System.out.println("Ancestor "+ancestor.data);
	}

public static Node lowestCommonAncestor(Node root, Node p, Node q) {
    
	System.out.println(root.data);
	if(root.data==p.data)
		return root;
	
	if(root.data==q.data)
		return root;
	
	Node n1=null;
	Node n2=null;
	if(root.left!=null) {
		n1=lowestCommonAncestor(root.left,p,q);
		
	/*	if(n1!=null)
		{
			if(n1.right!=null)
			//if(n1.right.data==q.data)
			//	System.out.println("ancestor "+n1.data);
			System.out.println("here p "+n1.data);
		}*/
	}
	if(root.right!=null) {
	n2=lowestCommonAncestor(root.right,p,q);
	/*if(n2!=null)	
	System.out.println("here q "+n2.data);
*/
	}
	if(n1 !=null && n2!=null) {
		System.out.println("parent "+root.data);
		return root;
		
	}
	if(n1!=null )
		return n1;
	if(n2!=null)
		return n2;
	
    return null;
}
}
