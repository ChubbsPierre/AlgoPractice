package LinkedListPractice;

public class LinkedListTest 
{
	public static LinkedList linkedList;
	
	public static void main(String[] args)
	{
		linkedList = new LinkedList();
		String adder = "a";
		for(int i = 0; i < 20; i++)
		{
			linkedList.add(adder);
			adder += "a";
		}
		System.out.println("Print linked list: " + linkedList);

		System.out.println(linkedList.reverse());
			
	}
}
