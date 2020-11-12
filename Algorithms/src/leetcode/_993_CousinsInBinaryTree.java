package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import binaryTree.Node;

public class _993_CousinsInBinaryTree {
	
	public static void main(String[] args) {
		
		
		Node node=new Node(1);
		node.left=new Node(2);
		node.right=new Node(3);
		
		node.left.left=new Node(4);
		//node.left.right=new Node(5);
		
		//node.right.left=new Node(6);
		//node.right.right=new Node(7);
		
		//node.left.right.left=new Node(8);
		//node.left.right.right=new Node(9);
		
		Alter(node,3,4);
	}
	
		public static void Alter(Node root,int x,int y)
		{
			int levelx=level(root,0,x);
			int levely=level(root,0,y);
			
			System.out.println("x level "+levelx);
			System.out.println("y level "+levely);
			
			boolean isSibling=sibling(root, x, y);
			System.out.println("sibling " +isSibling);
			
			// if not sibling and level are same then cousins
		}
		public static boolean sibling(Node node,int x, int y)
		{
			if(node.left!=null && node.right!=null)
			if((node.left.data==x && node.right.data==y) ||(node.left.data==y && node.right.data==x) )
			{
				return true;//sibling
			}
			boolean a,b;
			if(node.left!=null) {
				 a=sibling(node.left,x,y);
				 if(a==true)
					 return a;
			}
			if(node.right!=null) {
				b=sibling(node.right,x,y);
			return b;
			}
			return false;
		}
		
		public static int level(Node node,int level,int val)
		{
			System.out.println("node "+node.data);
			if(node.data==val) {
				System.out.println("node found "+node.data+" level "+level);
				return level;
			}
			int a,b;
			if(node.left!=null) {
				 a=level(node.left,level+1,val);
				 if(a!=0)
					 return a;
			}
			if(node.right!=null) {
				b=level(node.right,level+1,val);
			if(b!=0)
				return b;
			}
			return 0;
		}
		public static boolean isCousins(Node root, int x, int y)
		{
			
			Queue<Node>queue=new LinkedList<>();
			List<Node>list2=new ArrayList<>();
		list2.add(root);
			queue.add(root.left);
			queue.add(root.right);
			int size=0;
			
			boolean flag=false;
			int count=0;
			
			List<Node>l=new ArrayList<>();
			//l.add(root);
			while(!queue.isEmpty())
			{
				size=queue.size();
				
				l=new ArrayList();
				for(int i=0;i<size;i++)
				{
					
					Node n=queue.poll();
					l.add(n);
					
					if(n.data==x || n.data==y)
					{
						count++;
					}
					System.out.println("data "+n.data);
					System.out.println("traversing parent");
					for(Node q:list2)
						System.out.print(q.data+" ");
					if(count==2)
					{
						for(Node o:list2)
						{
							System.out.println("o "+o.data);
							System.out.println("o.left "+o.left.data);
							System.out.println("o.right "+o.right.data);
							if(o.left!=null && o.right!=null)
							if((o.left.data==x && o.right.data==y)||(o.left.data==y && o.right.data==x))
							{
								System.out.println("not cousins");
								flag=true;
								break;
							}
							else
							{
								System.out.println("cousins");
							}
						}
						System.out.println("here");
						flag=true;
						break;
					}
					
					
					if(n.left!=null)
					{
						queue.add(n.left);
						//l.add(n.left);
						
					}
					if(n.right!=null)
					{
						queue.add(n.right);
						//l.add(n.right);
					}
					
				}
				if(count==1)
				{
					System.out.println("not cousins");
					break;
				}
				list2=l;
				for(Node q:l)
					System.out.print(q.data+" ");
				
				System.out.println();
				System.out.println("count "+count );
				count=0;
				System.out.println();
				if(flag==true)
					break;
				
			}
			
			System.out.println("after process");
			for(Node n:l)
				System.out.print(n.data+" ");
			
			
			return false;
		}

}
