package algoExpert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import binaryTree.TreeNode;

public class FindNodesDistanceK {
	
	static class Pair
	{
		TreeNode node;
		int distance;
		public Pair(TreeNode node, int distance) {
			super();
			this.node = node;
			this.distance = distance;
		}
		
		
	}

	public static void main(String[] args) {

		/*
		 * TreeNode root=new TreeNode(1);
		root.left=new TreeNode(2);
		root.right=new TreeNode(3);

		root.left.left=new TreeNode(4);
		
		root.left.right=new TreeNode(5);

		root.right.right=new TreeNode(6);
		root.right.right.left=new TreeNode(7);
		root.right.right.right=new TreeNode(8);

		 */
		TreeNode root=new TreeNode(1);
		root.left=new TreeNode(2);
		root.right=new TreeNode(3);

		root.left.left=new TreeNode(4);
		root.left.right=new TreeNode(5);
	
		root.right.left=new TreeNode(6);
		root.right.right=new TreeNode(7);
	

		distanceK(root,1,2);
	}
	public static List<Integer> distanceK(TreeNode root, int target, int K) {
		/*
		 * Step1 : create a map having parent Node of each node value
		 * {node.val:parentNode obj}
		 * because from parent we can go above also -> (O)V+E (Edges less than nodes)->(O)E
		 * 
		 * Step2 :
		 * 
		 * 	->Doing BFS using a queue like a graph traversal
		 * 	->add parent, left ,right child in queue having distance+1 than current
		 *  ->As we find a node having distance 2 , break the while
		 *  	because we know that when popped node has distance 2 , means we have 
		 *  	nodes reamingin with distance 2 in queue
		 *	
		 * 
		 */

		List<Integer>list=new ArrayList<>();
		HashMap<Integer,TreeNode>map=new HashMap<>();

		helper(root,null, map);
		
		map.forEach((k,v)->{
			
			if(v!=null)
			System.out.println("node "+k+" parent "+v.val);
		});
		
		List<Integer>ans=bfs(root,map, target,2);
		
		System.out.println("ans "+ans);
		return list;
	}
	
	public static List<Integer> bfs(TreeNode root,HashMap<Integer,TreeNode>map,int target,int k)
	{
		Queue<Pair>queue=new LinkedList<Pair>();
		
		TreeNode parent=map.get(target);
		TreeNode current=findChild(root,map, target);
		
		
		Pair p=new Pair(current,0);
		
		queue.add(p);
		Set<Integer>seen=new HashSet<>();
		
		while(!queue.isEmpty())
		{	
			
			//queue contains only those nodes having distance k
			if(queue.peek().distance==k)
				break;
			Pair item=queue.poll();
			
			int dist=item.distance;
		
			TreeNode node=item.node;
			seen.add(node.val);
			
			System.out.println("current node "+node.val+" dist "+dist);
			//adding parent
			if(map.containsKey(node.val))
			{
				System.out.println("inside "+map.get(node.val).val);
			if( !seen.contains(map.get(node.val).val))
			queue.add(new Pair(map.get(node.val),dist+1));
			}
			
			if(node.left!=null && !seen.contains(node.left.val))
			queue.add(new Pair(node.left,dist+1));
			
			if(node.right!=null && !seen.contains(node.right.val))
			queue.add(new Pair(node.right,dist+1));
			
			queue.forEach(( x)->{
				
				System.out.print(x.node.val+" ");
			});
			System.out.println("----------------");
			
		}
		//reaming elements in queue has only nodes with distance k to target node
		List<Integer>ans=new ArrayList<>();
		while(!queue.isEmpty())
		{
			ans.add(queue.poll().node.val);
		}
		
		return ans;
	}
	
	public static TreeNode findChild(TreeNode root,HashMap<Integer,TreeNode>map,int val)
	{
		//target node can be root node
		if(root.val==val)
			return root;
		
		TreeNode parent=map.get(val);
		
		if(parent.left!=null && parent.left.val==val)
		return parent.left;
		return parent.right;
	}
	public static void helper(TreeNode root,TreeNode parent,HashMap<Integer,TreeNode>map)
	{
		if(root==null)
			return ;
			
		if(parent!=null)
		map.put(root.val, parent);
		helper(root.left,root,map);
		helper(root.right,root,map);

	}

}
