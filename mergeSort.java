package StackSorter;
import java.util.Arrays;

public class mergeSort 
{	
	public int[] sortThatArrayBaby(int[] inputArray)
	{
		return atomise(inputArray);
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
}
