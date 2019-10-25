package LinkedListPractice;

/*
 * Class to create a Node. The most atomised element of a linked list
 * next: the next Node in the linked list
 * data: the data stored in the Node
 */
public class Node 
{
	Node next;
	Object data;
	
	public Node(Object data)
	{
		next = null; //when added to the end of the list there is no next node to point to
		this.data = data;
	}
	
	public Node(Node nextValue, Object data)
	{
		this.next = nextValue; //when added between two nodes the next element must be pointed to keep the list correct
		this.data = data;
	}
	
	public Object getData()
	{
		return data;
	}
	
	public void setData(Object newData)
	{
		data = newData;
	}
	
	public Node getNext()
	{
		return next;
	}
	
	public void setNext(Node newNext)
	{
		next = newNext;
	}
}
