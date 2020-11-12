package algoExpert;

import algoExpert.BSTConstructionIterative.BST;

public class BSTConstructionRecursive {

	// space - (O)LogN
	static class BST {
	    public int value;
	    public BST left;
	    public BST right;
	    
	    public BST(int value) {
	        this.value = value;
	      }
	    
	    public BST insert(int value) {
	    	//System.out.println("called "+this.value);
	    	
	    	if(this.left!=null && value<this.value)
	    	{
	    		return this.left.insert(value);
	    	}
	    	else if(value<this.value)
	    	{
	    		this.left=new BST(value);
	    		return this.left;
	    	}
	    	 if( this.right!=null && value>=this.value)
	    	{
	    		return this.right.insert(value);
	    	}
	    	else if(value>=this.value)
	    	{
	    		this.right=new BST(value);
	    		return this.right;
	    	}
	    	 return this;
	    	
	    	
	    	
	    }
	    public boolean contains(int value) {
	        
	    	if(value==this.value)
	    	{		
	    		return true;
	    	}
	    	if(this.left!=null && value<=this.value)
	    	{
	    		System.out.println("smal");
	    		return this.left.contains(value);
	  
	    	}
	    	else if( this.right!=null && value>this.value)
	    	{
	    		return this.right.contains(value);
	    	}
	    	return false;
	        
	      }
	   public BST remove(int value)
	   {
		   remove(value,null);
		   return this;
	   }
	    public BST remove(int value,BST parent) {
	    	
	   
	    	
	    	if(left!=null && value<this.value)
	    	{
	    		System.out.println("going left");
	    		//parent=this;
	    		this.left=this.left.remove(value,this);
	    	}
	    	else if(right!=null &&  value>this.value)
	    	{
	    		System.out.println("going right");
	    		
	    		this.right=this.right.remove(value,this);
	    	}
	    	else
	    	{
	    		System.out.println("found to be deleted "+this.value);
	    		if(left!=null && right!=null)
	    		{
	    			System.out.println("both npt null case");
	    			int successor=right.findSuccessor(right).value;
	    			System.out.println("successor "+successor );
	    			this.value=successor;
	    			right.remove(successor,this);
	    			
	    			
	    		}
	    		else if(parent==null)
	    		{
	    			// parent pointer is used for only this case
	    			System.out.println("no parent case");
	    			if(left!=null)
	    			{
	    				this.value=left.value;
	    				this.right=left.right;
	    				this.left=left.left;
	    			}
	    			else if(right!=null)
	    			{
	    				this.value=right.value;
	    				this.left=right.left;
	    				this.right=right.right;
	    			}
	    		}
	    		else if(left!=null)
	    		{
	    			System.out.println("left not null case");
	    			return left;
	    		}
	    		else if(right!=null)
	    		{
	    			return right;
	    		}
	    		else
	    		{
	    			System.out.println("leaf node "+this.value);
	    			return null;
	    		}
	    	}
	    	
	        
	    	
	        return this;
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
		
		node.remove(10);
		System.out.println("___________________________");
		
		System.out.println();
	
		System.out.println("iterating");
		node.iterate(node);
		//System.out.println("left "+node.left.left.value);
	}
}
