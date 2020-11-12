package algoExpert;

import java.util.Stack;

public class BSTConstructionIterative {

	
	static class BST {
	    public int value;
	    public BST left;
	    public BST right;
	    
	    public BST(int value) {
	        this.value = value;
	      }
	    
	    // Time -(O)LogN , Space- (O)1
	    public BST insert(int value) {
	    	
	    	BST current=this;
	    	
	    	while(current!=null)
	    	{
	    		//System.out.println("current "+current.value+" value "+current.right.value);
	    		if(value>=current.value)
	    		{
	    			if(current.right==null)
		    		{
	    				//System.out.println("creating new at right ");
		    			current.right=new BST(value);
		    			break;
		    		}
	    			else
	    			{
	    			//System.out.println("going right");
	    			current=current.right;
	    			}
	    			
	    		}
	    		else
	    		{
	    			if( current.left==null)
		    		 {
		    			 current.left=new BST(value);
		    			 break;	
		    		 }
	    			else
	    			{
	    				//System.out.println("going left");
	    				current=current.left;
	    			}
	    		}
	    		 
	    	}
	    	 return this;
	    	
	    	
	    	
	    }
	    public boolean contains(int value) {
	    	BST current=this;
	    	
	    	while(current!=null)
	    	{
	    		if(current.value==value)
	    			return true;
	    		System.out.println("current "+current.value+" value "+value);
	    		if(value>=current.value)
	    		{
	    			current=current.right;
	    		}
	    		else if(value<current.value)
	    		{
	    		current=current.left;	
	    		}
	    		 
	    	}
	    	return false;
	      }
	    public BST remove(int value) {
	    	
		    	remove(value,null);
		    	return this;
	      }
	    public void remove(int value,BST parentNode)
	    {
	    	BST currentNode=this;
	    	while(currentNode!=null)
	    	{
		    	System.out.println("currentNode "+currentNode.value+" value "+value);
		    	if(parentNode!=null)
		    		System.out.println("parent "+parentNode.value);

	    	if(value<currentNode.value)
	    	{
	    		parentNode=currentNode;
	    		currentNode=currentNode.left;
	    	}
	    	else if(value>currentNode.value)
	    	{
	    		System.out.println("going right");
	    		parentNode=currentNode;
	    		currentNode=currentNode.right;
	    	}
	    	else
	    	{
	    		System.out.println("found");
	    		if(currentNode.left!=null && currentNode.right!=null)
	    		{
	    			System.out.println("both not null");
	    			int successor=this.findSuccessor(currentNode.right).value;
	    			currentNode.value=successor;
	    			System.out.println("currentNode "+currentNode.value);
	    			currentNode.right.remove(successor,currentNode);
	    		}
	    		// when parentNode is null
	    		else if(parentNode==null){
	    			System.out.println(" parent node is null");
	    			// when tree has only one node which is root node
	    			// and its parent node would be null 
	    				//or it has only one child either left or right
	    			
	    			if(currentNode.left!=null)
	    			{
	    				/*
	    				 * we are not doing current=current.left;
	    				 * because this will only change currentpointer not the root node value 
	    				 * current will become 5 	
	    				 *root node is still pointing to 10
	    				 */
	    				System.out.println("left child");
	    				 // when root node has only left child
	    				currentNode.value=currentNode.left.value;
	    				// this statement should comme first
	    				/*
	    				 * beacause if we do 
	    				 * currentNode.left=currentNode.left.left;
	    				 * here current.left is already changed hence it can give exception in next statement
	    				 * currentNode.right=currentNode.left.right;
	    				 * 
	    				 * Similarly for right child  applies
	    				 * 
	    				 */
	    				currentNode.right=currentNode.left.right;
	    				currentNode.left=currentNode.left.left;
	    				
	    				System.out.println("curre "+currentNode.value);
	    				
	    			}
	    			else if(currentNode.right!=null)
	    			{
	    				// when root node has only right child
	    				currentNode.value=currentNode.right.value;
	    				currentNode.left=currentNode.right.left;
	    				currentNode.right=currentNode.right.right;
	    				
	    				
	    			}else
	    			{
	    				currentNode=null;
	    			}
	    			
	    			
	    		}
	    		/*
	    		 * Cnditions for when parent is not null and 
	    		 * current node whjich is found has only one child 
	    		 * hence we have to find that current node is left child or right child of parent node
	    		 * so that we can upadate the pointer of left or right child of parent node
	    		 */
	    		else if(currentNode==parentNode.left)
	    		{
	    	
	    			
	    			System.out.println("left child of "+parentNode.value);
	    			if(currentNode.left!=null)
	    			{
	    				parentNode.left=currentNode.left;
	    			}
	    			else if(currentNode.right!=null)
	    			{
	    				parentNode.left=currentNode.right;
	    			}
	    			else
	    			{
	    				parentNode.left=null;
	    			}
	    		}
	    		else if(currentNode==parentNode.right)
	    		{
	    			System.out.println("right child of "+parentNode.value);
	    			if(currentNode.left!=null)
	    			{
	    				parentNode.right=currentNode.left;
	    			}
	    			else if(currentNode.right!=null)
	    			{
	    				parentNode.right=currentNode.right;
	    			}
	    			else
	    			{
	    				parentNode.right=null;
	    			}
	    		}
	    		
	    		break;
	    	
	    	}
	    	System.out.println("----------------------------");
	    }
	    }
	    public BST findSuccessor(BST node)
	    {
	    	while(node.left!=null)
	    	{
	    		node=node.left;
	    	}
	    	return node;
	    }
	    public void iterate(BST root)
	    {
	    	System.out.println(root.value);
	    	if(root.left!=null)
	    	{
	    		iterate(root.left);
	    	}
	    	
	    	if(root.right!=null)
	    	{	
	    		iterate(root.right);
	    	}
	    	
	    }
	 
	}
	
	public static void main(String[] args) {
		
		BST node=new BST(10);
		node.insert(5);
		node.insert(15);
		node.insert(2);
		node.insert(5);
		node.insert(13);
		node.insert(22);
		node.insert(1);
		node.insert(14);
		node.insert(12);
		
	
		System.out.println("_________________________________________");
		node.remove(5);
		System.out.println("_________________________________________");
		node.remove(5);
		System.out.println("_________________________________________");
		node.remove(12);
		System.out.println("_________________________________________");
		
		node.remove(13);
	//System.out.println(node.contains(15));
	System.out.println();
		System.out.println("iterating");
		node.iterate(node);
		//System.out.println("left "+node.left.left.value);
	}
}
