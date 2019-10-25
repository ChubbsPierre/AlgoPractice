package StackSorter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class StackSorter 
{
	public static void main(String[] args)
	{
		StackSorter s = new StackSorter();
		Stack<Integer> ourStack = new Stack<Integer>();
		Scanner in = new Scanner(System.in);
		System.out.println("Please input a number: ");
		while(in.hasNextInt() == true)
		{
			int temp = in.nextInt();
			ourStack.push(temp);
		}
		
		System.out.println(ourStack.toString());
		Stack<Integer> sortedStack = new Stack<Integer>();
		sortedStack = s.sortStack(ourStack);
		System.out.println(sortedStack.toString());
	}
	
	private Stack sortStack(Stack<Integer> orgStack)
	{
		Stack<Integer> sortedStack = new Stack<Integer>();
		int[] tempArray = new int[orgStack.size()];
	
		for(int i = 0; i < tempArray.length; i++)
		{
			tempArray[i] = orgStack.pop();
		}
		
		mergeSort m = new mergeSort();
		tempArray = m.sortThatArrayBaby(tempArray);
		
		for(int i = 0; i < tempArray.length; i++)
		{
			sortedStack.push(tempArray[i]);
		}
		
		return sortedStack;
	}
}
