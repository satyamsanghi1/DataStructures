package binaryTree;

public class MinimumHeightOfBinaryTree {
	
	public static void main(String[] args) {
		
		Node node=new Node(1);
	
		node.left=new Node(2);
		
		node.left.left=new Node(3);
		
		node.left.left.left=new Node(4);
		/*
		 * System.out.println("2nd Node "+node.left); node.right=new Node(3);
		 * 
		 * System.out.println("3rd Node "+node.right); node.left.left=new Node(4);
		 * System.out.println("3rd Node "+node.right); node.left.right=new Node(5);
		 * System.out.println("3rd Node "+node.right);
		 * 
		 * node.right.left=new Node(6); node.right.right=new Node(7);
		 * 
		 * node.left.right.left=new Node(8); node.left.right.right=new Node(9);
		 */
		
		//int height=findDepth(node);
		int height=findDepth(node);
		System.out.println("minimum height "+height);
	}
		public static int alterfindMinDepth(Node node)
		{
			   if(node.left ==null && node.right==null)
		        {
		            return 1;
		        }
			   if(node.left==null)
			   {
				   return alterfindMinDepth(node.right)+1;
			   }
			   else if(node.right==null)
			   {
				   return alterfindMinDepth(node.left)+1;
			   }
			   
			   int a=0;
		        int b=0;
		        
			   if(node.left !=null)
		        {
		           a= findDepth(node.left);
		        }
			   if(node.right!=null)
		        {
		           b= findDepth(node.right);
		        }   
			   return (a<b?a:b)+1;
		}
	
	   public static int findDepth(Node node)
	    {

	        int a=0;
	        int b=0;
	        if(node.left !=null)
	        {
	           a= findDepth(node.left);
	        }
	          else 
	         a=-1;
	        if(node.right!=null)
	        {
	           b= findDepth(node.right);
	        }         
	          else
	              b=-1;
	          if(node.left ==null && node.right==null)
	        {
	            return 1;
	        }
	        if(b!=-1 && a!=-1)
	        return (a<b?a:b)+1;
	         else if(b==-1)
	        return a+=1;
	         else
	             return b+=1;
	    
	    }

}
