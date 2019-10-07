import java.util.Scanner;
public class Searches 
{
	public static void main(String[] args) throws InterruptedException
	{
		Searches search = new Searches();
		int[] ourArray = new int[1000];
		for(int counter = 0; counter < 1000; counter++)
		{
			ourArray[counter] = counter; 
		}
		int searchNumber = 0; 
		Scanner numberPrompt = new Scanner(System.in);
		while(searchNumber != -1)
		{
			System.out.println("Enter a number to search for");
			searchNumber = numberPrompt.nextInt();
			
			
			long startTime; 
			long endTime;
			long duration;
			
			startTime = System.nanoTime();
			search.linearSearch(ourArray, searchNumber);
			endTime = System.nanoTime();
			duration = (endTime - startTime) / 10000;
			System.out.println("Linear Search time taken: " + duration);

			System.out.println("");
			System.out.println("Waiting");
			System.out.println("");
			Thread.sleep(300);
			
			startTime = System.nanoTime();
			search.binarySearch(ourArray, searchNumber);
			endTime = System.nanoTime();
			duration = (endTime - startTime) / 10000;
			System.out.println("Binary Search time taken: " + duration);

			System.out.println("");
			System.out.println("Waiting");
			System.out.println("");
			Thread.sleep(5);
			
			startTime = System.nanoTime();
			search.interpolationSearch(ourArray, searchNumber);
			endTime = System.nanoTime();
			duration = (endTime - startTime) / 10000;
			System.out.println("Interpolation Search time taken: " + duration);
			System.out.println("");
		}
		numberPrompt.close();
		System.out.println("Exited");

		
	}
	
	public void linearSearch(int[] array, int searchNumber)
	{
		for(int counter = 0; counter < array.length - 1; counter++)
		{
			if(searchNumber == array[counter])
			{
				System.out.println(searchNumber + " was found at position " + counter);
				return;
			}
			
		}
		System.out.println("The number was not found in the array");
	}
	
	public void binarySearch(int[] array, int searchNumber)
	{
		int low = 0;
		int high = array.length - 1;
		int middle = 0;
		
		while(high >= low)
		{
			middle = low + (high - low) / 2;
			if(array[middle] == searchNumber)
			{
				System.out.println("The number " + searchNumber + " was found at position " + middle);
				return;
			}
			else if(searchNumber < array[middle])
			{
				high = middle - 1;
			}
			else if(searchNumber > array[middle])
			{
				low = middle + 1;
			}
			
		}
		System.out.println("The number was not found");
	}
	
	public void  interpolationSearch(int[] array, int searchNumber)
	{
		int low = 0;
		int middle = 0;
		int high = array.length - 1;
		
		while(middle < array.length - 1)
		{
			
			middle = low + ((high - low) / (array[high] - array[low])) * (searchNumber - array[low]);	
			try
			{
				if(array[middle] == searchNumber)
				{
					System.out.println("The number " + searchNumber + " was found at position " + array[middle]);
					return;
				}
			}
			catch(ArrayIndexOutOfBoundsException e)
			{
				System.out.println("Number not found");
				return;
			}
			
			if(array[middle] > searchNumber)
			{
				high = middle - 1;
			}
			else if(array[middle] < searchNumber)
			{
				low = middle + 1;
			}
		}
		System.out.println("Number was not found");
	}
}