package binaryTree;

import java.util.ArrayList;
import java.util.List;

public class CreatingBinaryTreeUsingInsertion {
	
public static void main(String[] args) {
	
	//Node node=new Node(1);
	/*System.out.println("1st Node "+node);
	node.left=new Node(2);
	
	System.out.println("2nd Node "+node.left);
	node.right=new Node(3);
	
	System.out.println("3rd Node "+node.right);
	node.left.left=new Node(4);
	System.out.println("3rd Node "+node.right);
	node.left.right=new Node(5);
	System.out.println("3rd Node "+node.right);
	
	node.right.left=new Node(6);
	node.right.right=new Node(7);
	*/
	
	Node node=new Node(6);
	int arr[]= {1,2,4,3,4,5,6};
	int b[]= {1,0,1,0,1,0,1};
	
	int c[]= {1,0,1,0,1,1,0,1,0,0,0,1,0,0,0,0,1,1,0,9,1,0,9,1,1,1,1,9,0,9,9,9,9,9,9,1,9,0,9,9,9,9,9,0,1,1,0,0,0,0,9,9,9,0,9,9,9,0,9,0,9,9,9,9,1,9,9,0,0,0,9,9,9,1,9,9,9,0,0,9,9,9,9,9,0,9,9,9,9,1,9,9,9,0,1,9,0};
	
	arr=c;
	for(int i:arr)
	{
		traverseToInsert(node,100,i);
		System.out.println();
		System.out.println("TRAVERSING");
		System.out.println();
		
		
		for(int j=1;j<=100;j++) {
			bredthTraverse(node,j);	
			
		}
		
	}
	System.out.println();
	System.out.println("CALCULATING");
	System.out.println();
	
	StringBuilder sb=new StringBuilder();
	List<String>list=new ArrayList<String>();
	
		calculate(node,0,list);
	System.out.println("OUTPUT VALUE "+sb);
	
	System.out.println("LIST");
	int sum=0;
	for(String q:list) {
		System.out.println(q);
		sum+=Integer.parseInt(q,2);

	}
	System.out.println("SUM "+sum);

}


public static void traverseToInsert(Node node,int height,int val)
{
	System.out.println();
	System.out.println("-------------------------------------");
	System.out.println("INSERTING "+val+"  ");
	System.out.println();
	for(int i=1;i<=height;i++) {
		System.out.println("Iterating "+i+" Level ");
		Node node1=insert(node,i,val);
		if(node1!=null) {
		System.out.println("returned Node "+node1.data);
		break;
		}
	}
}


	public static Node insert(Node node,int level,int val)
	{
		
		
		if(node.data==6)
		{
			System.out.println("data empty");
			node.data=val;
			return node;
		}
		if(level==1)
		{
			System.out.println("data : "+ node.data);
			if(node.left==null)
			{
				System.out.println("called left");
				node.left=new Node(val);
				return node.left;
			}
			else if(node.right==null)
			{
				System.out.println("called right");
				node.right=new Node(val);
				return node.right;
			}
			else
			{
				System.out.println("called else");
				return null;
			}
			
		}
		else {
		if(node.left!=null) {
		Node node1=	insert(node.left,level-1,val);
		if(node1!=null)
		{
			System.out.println("called "+node1.data);
		return node1;
		}
		}
		if(node.right!=null) {
			System.out.println("called this");
		Node node2=	insert(node.right,level-1,val);
		return node2;
		}
		
		}
		return node;
	}

	public static void bredthTraverse(Node node,int level)
	{
	
		
		if(level==1)
		{
			System.out.println(node.data);
			
		}
		else 
		{
			if(node.left!=null)
			bredthTraverse(node.left,level-1);
		
			if(node.right!=null)
			bredthTraverse(node.right,level-1);
		
		}
	
	}
	public static void calculate(Node node,int value,List list)
	{
		if(node.data==0 || node.data==1) {
		value=value*10+node.data;
		System.out.println("value " +value);
		}
		int q=Integer.parseInt(value+"",2);
		System.out.println("converted value "+q);
		int a=0;
		int b=0;
		
		 if(node.left!=null)
	        {
	            calculate(node.left,value,list);
	        }
	         if(node.right!=null)
	        {
	             calculate(node.right,value,list);
	        }
		
		if(node.left==null && node.right==null)
		{
			System.out.println("both leaf are null");
		
			list.add(Integer.toString(value));
		}
		
	
	}


	
}
