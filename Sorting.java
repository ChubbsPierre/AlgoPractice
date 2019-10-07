import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Sorting
{
	public static void main(String[] args) throws InterruptedException
	{
		Sorting sort = new Sorting();
		sort.goSort();
	}
	
	public void goSort() throws InterruptedException
	{
		int[] arrayToSortEasy = {5, 4, 3, 2, 1};
		int[] arrayToSortMedium = {14, 33, 27, 10, 35, 19, 42, 44};
		int[] arrayToSortHard = new int[100];
		arrayToSortHard = randomArray(arrayToSortHard);
		
		timeSorts(arrayToSortEasy, arrayToSortMedium, arrayToSortHard);
	}
	
	
	private int[] randomArray(int[] passedArray)
	{
		Random rand = new Random();
		int[] array = new int[passedArray.length];
		for(int counter = 0; counter < array.length; counter++)
		{
			array[counter] = rand.nextInt(101);
		}
		return array;
	}
	
	void bubbleSort(int[] passedArray)
	{
		int[] sortedArray = copyArray(passedArray); //copy the passed array into a fresh array to avoid changing the original
		
		System.out.println("Unsorted Array: " + Arrays.toString(sortedArray)); 
		int holder = 0; //this is the temp variable for the swap
		boolean swapped = false; 
		
		for(int counter = 0; counter < sortedArray.length - 1; counter++) //itterate through the entire array
		{
			swapped = false; //reset the swap value for the next itteration through the array
			for(int currentLoop = 0; currentLoop < sortedArray.length - 1; currentLoop++) //with the current number being checked itterate through the remaining elements
			{
				if(sortedArray[currentLoop] > sortedArray[currentLoop + 1]) //if the current element is large than the next...
				{
					holder = sortedArray[currentLoop + 1];
					sortedArray[currentLoop + 1] = sortedArray[currentLoop];
					sortedArray[currentLoop] = holder;
					swapped = true; //swap these two elements and continue
				} 
			} //The largest element is swapped to the back of the list eventually which will be its sorted position. 
			if(swapped == false) //if no changes are made then the array is sorted and so the algorithm can stop 
			{
				break;
			}
		}
		String output = "Sorted Array: " + Arrays.toString(sortedArray);
	}
	
	private void insertionSort(int[] passedArray)
	{
		int[] sortedArray = copyArray(passedArray);
		System.out.println("Unsorted Array: " + Arrays.toString(sortedArray));
		int holder = 0; //variable to hold the number being swapped temporarily 
		int holePosition = 0; //variable to hold where the current hole is in the subarray
		for(int counter = 0; counter < sortedArray.length - 1; counter++) //iterate through all the elements in the array...
		{
			if(sortedArray[counter] > sortedArray[counter + 1]) //if the current number is bigger than the next...
			{
				holePosition = counter; //make the current element's position the pivot for comparing with the already sorted array
				holder = sortedArray[counter];
				sortedArray[counter] = sortedArray[counter + 1];
				sortedArray[counter + 1] = holder; //swap the two numbers and then move on to position the swapped number in the correct place in the sup array
				while(holePosition > 0 && sortedArray[holePosition] < sortedArray[holePosition - 1]) //go through the entire sorted sub array
				{
					holder = sortedArray[holePosition]; 
					sortedArray[holePosition] = sortedArray[holePosition - 1];
					sortedArray[holePosition - 1] = holder; //swap the pivot number 
					holePosition -= 1; //move the pivot with the pivot number and continue till the pivot can be moved no further
				}
			}
		}
		System.out.println("Sorted Array: " + Arrays.toString(sortedArray));
	}
	
	void selectionSort(int[] passedArray)
	{
		int[] sortedArray = copyArray(passedArray);
		System.out.println("Unsorted Array: " + Arrays.toString(sortedArray));
		int holder = 0;
		int minimum = 0;
		for(int counter = 0; counter < sortedArray.length - 1; counter++) //set the low bounds of unsorted section of array
		{
			minimum = counter; //set the current minimum to the low bounds of unsorted array
			for(int innerCounter = counter + 1; innerCounter < sortedArray.length; innerCounter++) //find the minimum number starting with comparing the first two elements in the unsorted subarray
			{
				if(sortedArray[minimum] > sortedArray[innerCounter]) //if the current minimum is larger than the element being compared
				{
					minimum = innerCounter; //set the compared element as the new minimum
				}
			}
			if(sortedArray[counter] > sortedArray[minimum]) //should the new minimum be larger than the first element in the unsorted subarray....
			{
				holder = sortedArray[counter]; //el swapo
				sortedArray[counter] = sortedArray[minimum]; //those elementos
				sortedArray[minimum] = holder; //bro-o
			}
		}
		System.out.println("Sorted Array : " + Arrays.toString(sortedArray));
	}
	
	void mergeSort(int[] passedArray)
	{
		int[] sortedArray = copyArray(passedArray); //copy the array to a temp varaible 
		System.out.println("Unsorted Array: " + Arrays.toString(sortedArray)); 
		System.out.println("Sorted Array: " + Arrays.toString(atomise(sortedArray)));
	}
	
	/*
	 * method to split up an array into two halves and recursively call itself until only a 
	 * single element sorted array remains. Then call the merge() method in order to merge 
	 * all subarrays until the sortedArray is fully sorted
	 */
	private int[] atomise(int[] arrayToAtom)
	{
		if(arrayToAtom.length < 2) //an array consisting of only one element is sorted so return the single element sorted array
		{
			return arrayToAtom;
		}
		int middle = arrayToAtom.length / 2;
		int[] firstSplit = new int[middle]; //split the passed array in two down the middle 
		int[] secondSplit = new int[arrayToAtom.length - middle];
		int atomArrayCounter = 0;

		for(int counter = 0; counter < arrayToAtom.length / 2; counter++) //populate the first split array with the first half of the passed array
		{
			firstSplit[counter] = arrayToAtom[atomArrayCounter];
			atomArrayCounter++;
		}
		for(int counter = 0; atomArrayCounter < arrayToAtom.length; counter++) //populate the second split with the second half of the passed array
		{
			secondSplit[counter] = arrayToAtom[atomArrayCounter];
			atomArrayCounter++;
		}
		atomise(firstSplit); //call this method recursively in order to split the first sub array further
		atomise(secondSplit); //same for the 2nd sub array, continue till all sub arrays consist of one element
		
		return merge(firstSplit, secondSplit, arrayToAtom); //once recursive calls are complete each method will unpack and merge as it finishes
	}
	
	/*
	 * Method to merge subarrays and eventually the sorted array from mergeSort array
	 */
	private int[] merge(int[] firstSplit, int[] secondSplit, int[] mergedArray)
	{
		//int[] mergedArray = new int[firstSplit.length + secondSplit.length]; //create a new array to store the merged two sub arrays
		int mergedCounter = 0;
		int firstCounter = 0;
		int secondCounter = 0;
		while(firstCounter < firstSplit.length && secondCounter < secondSplit.length) //keep looping till one array is completed and no more comparisons between subarrays is needed
		{			
			if(firstSplit[firstCounter] <= secondSplit[secondCounter]) //add the smaller element to the next position in the merged array and move along in the array element snatched from
			{
				mergedArray[mergedCounter] = firstSplit[firstCounter];
				mergedCounter++;
				firstCounter++;
			}
			else
			{
				mergedArray[mergedCounter] = secondSplit[secondCounter];
				mergedCounter++;
				secondCounter++;
			}				
		}
		
		while(firstCounter < firstSplit.length) //once comparisons complete add the rest of the elements from one remaining sub array to sorted merged array
		{
			mergedArray[mergedCounter] = firstSplit[firstCounter];
			mergedCounter++;
			firstCounter++;
		}
		
		while(secondCounter < secondSplit.length)
		{
			mergedArray[mergedCounter] = secondSplit[secondCounter];
			mergedCounter++;
			secondCounter++;
		}
		
		return mergedArray; //return the newly merged array either to the an old recursive call or to the original mergeSort method call
	}
	
	private void coolDown() throws InterruptedException
	{
		System.out.println("");
		System.out.print("Cooling down");
		for(int counter = 0; counter < 4; counter++)
		{
			Thread.sleep(500);
			System.out.print(".");
		}
		System.out.println("");
		System.out.println("");
}
	
	private int[] copyArray(int[] passedArray)
	{
		int[] array = new int[passedArray.length];
		
		for(int counter = 0; counter < array.length; counter++)
		{
			array[counter] = passedArray[counter];
		}
		
		return array;
	}
	
	private void timeSorts(int[] arrayToSortEasy, int[] arrayToSortMedium, int[] arrayToSortHard) throws InterruptedException
	{		
		Scanner in = new Scanner(System.in);
		System.out.println("Please enter a difficulty to sort with 1 being easy, 2 being medium, 3 being hard and 4 being all: ");
		int searchNumber = in.nextInt();
		int[][] difficulties = {arrayToSortEasy, arrayToSortMedium, arrayToSortHard};

		if(searchNumber < 5)
		{
			if(searchNumber == 1)
			{
				runSorts(searchNumber - 1, difficulties);
			}
			else if(searchNumber == 2)
			{
				runSorts(searchNumber - 1, difficulties);
			}
			else if(searchNumber == 3)
			{
				runSorts(searchNumber - 1, difficulties);
			}
			else if(searchNumber == 4)
			{
				for(int counter = 0; counter < difficulties.length; counter++)
				{
					runSorts(counter, difficulties);
				}
			}
		}
		else
		{
			System.out.println("Bad input");
		}
	}
	
	private void runSorts(int difficulty, int[][] difficulties) throws InterruptedException
	{
		long startTime = 0;
		long finishTime = 0;
		long duration = 0;
		
		startTime = System.nanoTime();
		bubbleSort(difficulties[difficulty]);
		finishTime = System.nanoTime();
		duration = (finishTime - startTime) / 10000;
		System.out.println("Bubble sort duration: " + duration);
		
		coolDown();
				
		startTime = System.nanoTime();
		insertionSort(difficulties[difficulty]);
		finishTime = System.nanoTime();
		duration = (finishTime - startTime) / 10000;
		System.out.println("Insertion sort duration: " + duration);
		
		coolDown();
		
		startTime = System.nanoTime();
		selectionSort(difficulties[difficulty]);
		finishTime = System.nanoTime();
		duration = (finishTime - startTime) / 10000;
		System.out.println("Selection sort duration: " + duration);
		
		coolDown();
		
		startTime = System.nanoTime();
		mergeSort(difficulties[difficulty]);
		finishTime = System.nanoTime();
		duration = (finishTime - startTime) / 10000;
		System.out.println("merge sort duration: " + duration);
	}
}