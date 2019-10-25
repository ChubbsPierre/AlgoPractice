package LinkedListPractice;
import java.util.Stack;

/*
 * Class to create a linked list from scratch
 * counter: counts how many Nodes make up the list not counting the head Node
 * head: Points to the first Node in the list
 */
public class LinkedList 
{
	private static int counter;
	private Node head = null;
	
	public LinkedList()
	{
	}
	
	public void add(Object data)
	{
		if(head == null) //if the Node is being added to a new list
		{
			head = new Node(data); //create a new head to point to the new Node
		} //note the lack of increment of the counter
		
		Node tempNode = new Node(data); //temp node to hold our data while we work
		Node currentNode = head; //the current node being looked at will start at the start of the list
		
		if(currentNode != null) //if the currentNode contains an actual node 
		{
			while(currentNode.getNext() != null) //while the next node from currentNode isn't empty
			{ 
				currentNode = currentNode.getNext(); //make current node the next node in the list, essentially moving through the list to the end 
			}
			
			currentNode.setNext(tempNode); //when the end is met we break out of the loop and set the next Node to be our newNode in tempNode
		}
		incrementCounter(); //as a new node has been added increment counter, again not that even if head was created during this call it only incrments once.
	}
	
	public int getCounter()
	{
		return counter;
	}
	
	public static void incrementCounter()
	{
		counter++;
	}
	
	public static void deincrementCounter()
	{
		counter--;
	}
	
	/*
	 * Method to add a list Node between two existing Nodes
	 * data: data to be contained in the Node
	 * index: the index the Node should be added to within the list
	 */
	public void add(Object data, int index)
	{
		Node tempNode = new Node(data);
		Node currentNode = head;
		
		if(currentNode != null)
		{
			for(int i = 0; i < index && currentNode.getNext() != null; i++) //move to the Node before our desired index
			{
				currentNode = currentNode.getNext(); 
			}
		}
		tempNode.setNext(currentNode.getNext()); //make the tempNode containing our added Node point to the Node at the desired index
		currentNode.setNext(tempNode); //set the current node to point to the tempNode instead of the Node tempNode now points to.
		incrementCounter(); //increment the counter to reflect tempNode being slotted between the currentNode the Node it used to point to 
	}
	
	/*
	 * get the Object stored within the desired Node
	 * index: the index of the node desired
	 */
	public Object get(int index)
	{
		if(index < 0) 
		{
			return null;
		}
		
		Node currentNode = null; //Initialise the currentNode and set to null
		
		if(head != null) //make sure the head and therefore the list exists
		{
			currentNode = head.getNext(); //set the currentNode to the first element in the list which the head points to 
			for(int i = 0; i < index; i++) //iterate through the list
			{
				if(currentNode.getNext() == null) //if you hit the end of the list 
				{
					return null; 
				}
				currentNode = currentNode.getNext(); //as you iterate i move through the Nodes to match i as the index
			}
			return currentNode.getData(); //once you are at the desired index return the data in that element
		}
		return currentNode; //if the list does not exist return null
	}
	
	public boolean remove(int index)
	{
		if(index < 0 || index > size())
		{
			return false;
		}
		
		Node currentNode = head;
		if(head != null)
		{
			for(int i = 0; i < index; i++) //move through the list of Nodes until you get to the Node before the desired index
			{
				if(currentNode.getNext() == null) //if you hit the end of the list somehow...
				{
					return false; 
				}
				currentNode = currentNode.getNext(); //set the currentNode to be the next Node in the list 
			}
			currentNode.setNext(currentNode.getNext().getNext()); //once the Node before the index is hit make it point to the Node after the desired index
			deincrementCounter(); //with nothing pointing to our Node we have removed it from the list so deincrement the size counter 
			return true; //return confirmation
		}
		return false;
	}
	
	public int size()
	{
		return getCounter();
	}
	
	public String reverse()
	{
		Stack<Object> temp = new Stack<Object>();
		LinkedList reversedList = new LinkedList();

		for(int i = 0; i < size(); i++)
		{
			temp.push(get(i));
		}
		
		while(temp.isEmpty() == false)
		{
			reversedList.add(temp.pop());
		}
		return reversedList.toString();
	}
	
	public String toString()
	{
		String output = "";
		
		if(head != null)
		{
			Node currentNode = head.getNext();
			while(currentNode != null)
			{
				output += "[" + currentNode.getData().toString() + "] ";
				currentNode = currentNode.getNext();
			}
		}
		return output;
	}
}
