package algoExpert;

import java.util.LinkedList;

public class LRUCache {
	
	public static void main(String[] args) {
		
		LinkedList<Integer>list=new LinkedList<>();
		
	}
	
	
	
	static class DoublyLinkedList
	{
		DoublyLinkedListNode head;
		DoublyLinkedListNode tail;
		
		public void setHeadTo(DoublyLinkedListNode node)
		{
			
		}
		public void removeTail()
		{
			if(tail==null)
				return ;
			
		}
	}
	static class DoublyLinkedListNode
	{
		String key;
		String value;
		
		DoublyLinkedListNode next;
		DoublyLinkedListNode prev;     
		
		public DoublyLinkedListNode(String key,String value) {
			this.key=key;
			this.value=value;
			// TODO Auto-generated constructor stub
		}
	}

}
