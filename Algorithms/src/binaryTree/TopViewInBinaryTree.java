package binaryTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class TopViewInBinaryTree {
	
	
	// not working 
	public static void main(String[] args) {
		
		Node node=new Node(1);
		
		node.left=new Node(14);
		
		
		node.right=new Node(3);
		
		
		node.left.left=new Node(7);
		
		node.left.right=new Node(4);
		//node.left.right.left=new Node(8);
		
		node.right.left=new Node(5);
		node.right.right=new Node(15);
		
		
		node.left.left.left=new Node(6);
		node.left.left.right=new Node(13);
		
		node.left.right.left=new Node(10);
		node.left.right.right=new Node(11);
		
		node.right.left.left=new Node(2);
		node.right.left.right=new Node(12);
		
		node.right.right.left=new Node(8);
		node.right.right.right=new Node(9);
		
		
		 HashMap<Integer,Node>map=new HashMap<>();

	        top(node,0,map);
	        System.out.println("size of map "+map.size());
	        for(Map.Entry<Integer,Node>e:map.entrySet())
	        {
	            System.out.print(e.getValue().data+" ");
	        }
	}
	
	public static void top(Node root,int distance,HashMap<Integer,Node>map){

		 System.out.println(root.data+"dist "+distance);
		if(!map.containsKey(distance))
        {
            map.put(distance,root);
        }
		
        if(root.left!=null)
            {
                top(root.left,distance-1,map);
            }
        
        
        if(root.right!=null)
        {
            top(root.right,distance+1,map);
        }
       

    }
	
	 
				
	public static HashMap verticalTraverse(Node node,int distance,HashMap<Integer,ArrayList<Integer>>map)
	{
		System.out.println("node "+node.data+" distance "+distance);
	
		if(map.containsKey(distance))
		{
			ArrayList<Integer> arr=map.get(distance);
			arr.add(node.data);
			map.put(distance,arr);
			HashSet<Integer>set=new HashSet<Integer>();
			
		}
		else
		{
			ArrayList<Integer> arr=new ArrayList<>();
			arr.add(node.data);
			map.put(distance,arr);
			
		}
		
		if(node.left!=null)
		{
			verticalTraverse(node.left, distance-1,map);
		}
		
		
		if(node.right!=null)
		{
			verticalTraverse(node.right, distance+1,map);
		}
		
		
		
		return map;
		
	}

}
