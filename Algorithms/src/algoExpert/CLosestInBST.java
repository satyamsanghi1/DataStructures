package algoExpert;

import binaryTree.Node;

public class CLosestInBST {
	
	// in notebook
	
	// intially declare a closest node that is infinity and then compare each node
	// this closest node is near or current node is near 
	public static void main(String[] args) {
		
		
	}
	public static double helper(Node root,double target,double closest)
    {
        //if(root==null)
        //return 0;
        
        //System.out.println("at "+root.data+"close "+closest);
            double x=Math.abs(closest-target);
            double y=Math.abs(root.data-target);
            if(y<x)
            {
                closest=root.data;
               // System.out.println("closest "+closest);
            }
            
            if(root.left!=null && target<root.data)
            {
            double a=  helper(root.left,target,closest);
            //System.out.println("a "+a);
            return a;
            }
            
            if( root.right!=null && target>root.data)
            {
             double b=  helper(root.right,target,closest);
             //System.out.println("b "+b);
             return b;
             
            }
            return closest;
    }

}
