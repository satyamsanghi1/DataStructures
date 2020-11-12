package algoExpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxPathSumInBinaryTree {

	static int max=Integer.MIN_VALUE;
	static class BinaryTree {
	    public int value;
	    public BinaryTree left;
	    public BinaryTree right;

	    public BinaryTree(int value) {
	      this.value = value;
	    }
	  }
	
	
	public  static void main(String[] args) {
		
		BinaryTree root=new BinaryTree(-2);
			root.left=new BinaryTree(-1);
		root.right=new BinaryTree(-3);
		
		/*root.left.left=new BinaryTree(4);
		root.left.right=new BinaryTree(5);
		
		root.right.right=new BinaryTree(6);
		root.right.left=new BinaryTree(7);
		*/
		int ans=maxPathSum(root);
		System.out.println("ans "+ans);
	}
	 public static int maxPathSum(BinaryTree tree) {
	/*SOLUTION 1 :
	 * 
	 * at a particular node : 
	 * to find max value : 
	 * Case 1 : when left subtree value+rightsubtree value + node is highest
	 * 
	 * Case 2 : when left subtree value + root node is maximum
	 * Case 3 : when right subtree value + root node is maximum
	 * Case 4 : when left subtree value or right subtree vlaue or root node is maximum
	 */
		 int a=helper1(tree).get(1);
	//	int a= helper(tree);
		System.out.println("a "+a);
		 return a;
	}
	 public static List<Integer> helper1(BinaryTree tree)
	 {	//using arraylist gives 5 % fast , using array[] gives 56% fast
			if(tree==null)
				return new ArrayList<Integer>(Arrays.asList(0,Integer.MIN_VALUE));
			
			System.out.println("current "+tree.value);
			List<Integer>leftMaxSumArray=helper1(tree.left);
			
			List<Integer>rightMaxSumArray=helper1(tree.right);
			
			int leftMaxSumAsBranch=leftMaxSumArray.get(0);
			int rightMaxSumAsBranch=rightMaxSumArray.get(0);
			System.out.println("LSB "+leftMaxSumAsBranch+" RSB "+rightMaxSumAsBranch);
			
			int leftMaxSum=leftMaxSumArray.get(1);
			int rightMaxSum=rightMaxSumArray.get(1);
			
			int maxChildSumAsBranch=Math.max(leftMaxSumAsBranch,rightMaxSumAsBranch);
			System.out.println("MCSB "+maxChildSumAsBranch);
			
			int maxSumAsBranch=Math.max(maxChildSumAsBranch+tree.value,tree.value);
			
			int maxSumAsRootNode=Math.max(maxSumAsBranch, leftMaxSumAsBranch+rightMaxSumAsBranch+tree.value);
			System.out.println("MSRT "+maxSumAsRootNode);
			
			int maxPathSum=Math.max(maxSumAsRootNode,Math.max(leftMaxSum, rightMaxSum));
			System.out.println("MSB "+maxSumAsBranch+" , maxPathSum "+maxPathSum);

			return new ArrayList<>(Arrays.asList(maxSumAsBranch,maxPathSum));
	 }
	 public static int helper(BinaryTree tree)
	 {
		 System.out.println("val "+tree.value);
		 int i=Integer.MIN_VALUE+10000;
		 int j=Integer.MIN_VALUE+10000;
		 if(tree.left==null && tree.right==null)
			 return tree.value;
		 
		 //applying cases
		 if(tree.left!=null)
		 {
		i=helper(tree.left);
		 }
		 
		 if(tree.right!=null)
		 {
		j=helper(tree.right);
		 }
		 
		 System.out.println("i "+i+" , j "+j+" : "+(i+j+tree.value));
		 if((i+j+tree.value)>max)
		 {
			 max=(i+j+tree.value);
			 System.out.println("<> "+max);
		 } if(i+tree.value>max)
		 {
			 System.out.println("i >");
			 max=i+tree.value;
		 }
		 if(j+tree.value>max)
		 {
			 System.out.println("j>");
			 max=j+tree.value;
		 }
		 
		 
			 System.out.println("here");
			 max=Math.max(max,Math.max(tree.value,Math.max(i,j)));
		 
		 System.out.println("max "+max);
		/*when returning value to finding max sum path
		 * we have 3 cases : 
		 * case 1 : path of root +left subtree
		 * case 2 : path of root + right subtree
		 * case 3: only root node
		 */
		 return Math.max(tree.value,Math.max(i+tree.value,j+tree.value));
	 }

	 
}
