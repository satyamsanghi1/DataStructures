package algoExpert;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUCacheRunner {

	public static void main(String[] args) {

		
		LRUCache lru=new LRUCache(4);
		
		lru.insertKeyValuePair("a",1);
		lru.insertKeyValuePair("b",2);
		lru.insertKeyValuePair("c",3);
		lru.insertKeyValuePair("d",4);
		lru.iterate();
		System.out.println(lru.getValueFromKey("a").value);
		lru.iterate();
		
		lru.insertKeyValuePair("e",5);
		lru.iterate();
	}

	static class LRUCache
	{
		int maxSize;
		int currentSize =0;
		HashMap<String,DoublyLinkedListNode>cache=new HashMap<>();
		DoublyLinkedList listOfMostRecent=new DoublyLinkedList();

		public LRUCache(int maxSize) {
			this.maxSize = maxSize > 1 ? maxSize : 1;
		}

		public void insertKeyValuePair(String key, int value) {
			// Write your code here.
			if(cache.containsKey(key))
			{
				replaceKey(key, value);
			}
			else
			{
				if(currentSize==maxSize)
				{
					System.out.println("maxSize reached");
					evictLeastRecent();
				}
				else
				{
				currentSize++;
				}
				cache.put(key,new DoublyLinkedListNode(key, value));
			}
			updateMostRecent(cache.get(key));
		}

		public void evictLeastRecent()
		{
			String keyToRemove=listOfMostRecent.tail.key;
			System.out.println("evicting least Recent: "+keyToRemove);
			listOfMostRecent.removeTail();
			cache.remove(keyToRemove);
			iterate();
		}
		
		public void replaceKey(String key,int value)
		{
			DoublyLinkedListNode node=cache.get(key);
			node.value=value;
			cache.put(key,node);
		}

		public LRUResult getValueFromKey(String key) {
			if(!cache.containsKey(key))
				return new LRUResult(true,-1);

			DoublyLinkedListNode node=cache.get(key);
			updateMostRecent(node);
			// Write your code here.
			return new LRUResult(true,node.value);
		}
		public void updateMostRecent(DoublyLinkedListNode node)
		{
			listOfMostRecent.setHeadTo(node);
		}
		public String getMostRecentKey() {

			if(listOfMostRecent.head==null)
				return "";
			return listOfMostRecent.head.key;
		}
		
		public void iterate()
		{
			DoublyLinkedListNode temp=listOfMostRecent.head;
			while(temp!=null)
			{
				System.out.print(temp.key+":"+temp.value+"  ");
				temp=temp.next;
			}
			System.out.println();
		}

	}



	static class DoublyLinkedList
	{
		DoublyLinkedListNode head;
		DoublyLinkedListNode tail;

		public void setHeadTo(DoublyLinkedListNode node)
		{
			if(head==node)
			{
				return ;
			}
			else if(head==null)
			{
				head=node;
				tail=node;
			}
			//when there is only one node
			else if(head==tail)
			{
				tail.prev=node;
				head=node;
				head.next=tail;
			}
			//doubly linked list has more than 1 node
			else
			{
				//if the given node is last node of doublylinkedlist
				if(tail==node)
				{
					//remove that last node as it has to be move to front 
					removeTail();
				}
				//isolate this node
				node.removeBindings();
				//logic to add node to the front of the doubly linked list
				head.prev=node;
				node.next=head;
				head=node;

			}
		}
		public void removeTail()
		{
			if(tail==null)
				return ;

			if(tail==head)
			{
				tail=null;
				head=null;
				return ;
			}
			tail=tail.prev;
			tail.next=null;

		}
	
	}
	static class DoublyLinkedListNode
	{
		String key;
		Integer value;

		DoublyLinkedListNode next;
		DoublyLinkedListNode prev;     

		public DoublyLinkedListNode(String key,Integer value) {
			this.key=key;
			this.value=value;
			// TODO Auto-generated constructor stub
		}

		//remove bindings of any middle node
		//isolating it from between of the doubly linked list 
		public void removeBindings()
		{
			if(prev!=null)
				prev.next=next;

			if(next!=null)
				next.prev=prev;

			prev=null;
			next=null;
		}
	}
	static class LRUResult {
		boolean found;
		int value;

		public LRUResult(boolean found, int value) {
			this.found = found;
			this.value = value;
		}
	}

}
