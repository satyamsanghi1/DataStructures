package interview;

class Node
{
	int x;
	Node next;
	
	public Node() {};
	
	public Node(int x)
	{
		this.x=x;
	}
}

class LinkedList
{
	Node head;
	Node current;
	public LinkedList()
	{
		
	}
	
	public void add(int i)
	{
		//when the linkedlist is empty
		if(head==null)
		{
			head=new Node(i);
			current=head;
		}
		else
		{
			current.next=new Node(i);
			current=current.next;
		}
	}
	public boolean remove(int obj)
	{
		if(head==null)
			return false;
		else if(head.x==obj)
		{
			head=head.next;
			return true;
		}
		Node temp=head;
		Node prev=head;
		while(temp!=null)
		{
			if(temp.x==obj)
			{
				prev.next=temp.next;
			}
			prev=temp;
			temp=temp.next;
		}
		return true;
		
	}
	public void iterate()
	{
		Node temp=head;
		while(temp!=null)
		{
			System.out.print(temp.x+" ");
			temp=temp.next;
		}
	}
}
public class DesignLinkedList {
	public static void main(String[] args) {
		
		LinkedList l=new LinkedList();
		
		l.add(1);
		l.add(2);
		l.add(3);
		l.add(4);
		l.add(5);
		
		
		l.iterate();
	}
}
