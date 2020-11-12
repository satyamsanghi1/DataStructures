package leetcode;




class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }
public class _988_SmallestStringStartingFromLeaf {
	//creating all possible string to from root to the leaf node
	static String ans="{";
	public static void main(String[] args) {
		
		TreeNode root=new TreeNode(0);
		root.left=new TreeNode(1);
	root.right=new TreeNode(2);
	
	root.left.left=new TreeNode(3);
	root.left.right=new TreeNode(4);
	
	root.right.right=new TreeNode(3);
	root.right.left=new TreeNode(4);
	
		System.out.println((char)123);
	String ans=smallestFromLeaf(root);
	System.out.println("ans "+ans);
		
	}
	 public static String smallestFromLeaf(TreeNode root) {
	        
	StringBuilder sb=new StringBuilder();
		 helper(root,sb);
		 	 return ans;
	    }
	
	 public static void helper(TreeNode root,StringBuilder sb)
	    {
		if(root==null)
			return;
		
		sb.append((char)(root.val+'a'));
		//System.out.println("sb "+sb);
		if(root.left==null && root.right==null)
		{
			sb.reverse();
			String s=sb.toString();
			if(s.compareTo(ans)<0)
			{
				System.out.println("here "+ans);
				ans=s;
			}
			 System.out.println("leaf "+s);
			 sb.reverse();
			 
		}
		 
		 
		 helper(root.left,sb);
		
		 helper(root.right,sb);
		 
		 sb.deleteCharAt(sb.length()-1);
		
	    }


}
