package binaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IterativeInorderTraversal {
	
	public static void main(String[] args) {
		
		Node node=new Node(1);
		
		//node.left=new Node(5);
		
		
		node.right=new Node(2);
		
		
		//node.left.left=new Node(7);
		
		//node.left.right=new Node(2);
		//node.left.right.left=new Node(8);
		
		node.right.left=new Node(5);
		//node.right.right=new Node(15);
		
		  //*/
        Stack<Node>stack=new Stack<Node>();
        List<Integer>list=new ArrayList<Integer>();
       
        
        traverse(node,stack,list);
        System.out.println(list);
	}
	
	public static void traverse(Node root,Stack<Node>stack,List<Integer>list)
    {
        while(true)
        {
            while(root!=null)
            {
                stack.push(root);
                root=root.left;
                System.out.println("here ");
            }
            if(stack.isEmpty())
                break;
            
           // System.out.println("size "+stack.size());
            root=stack.pop();
            System.out.println(root.data);
            list.add(root.data);
           // if(n.right!=null)
           root=root.right;
            
        }
    }

}
