package RecursStringReverse;

public class ReverseString 
{
	String reversal = "";

	/*
	 * controller provides a space outside recursive calls to handle resetting of reversal
	 */
	public String controller(String str)
	{
		String output = reverseString(str);
		clear();
		return output;
	}
	
	private void clear()
	{
		reversal = "";
	}
	private String reverseString(String str)
	{
		if(str.length() == 1) //the string inputed is 1 character long and so already reversed of the last substring of our original string
		{
			return str; //break out of recursive calls
		}
		else
		{
			reversal += str.charAt(str.length() - 1) //add character at end of string to start of reversal varaible
						+ reverseString(str.substring(0, str.length() - 1)); //add last character in a substring of str missing the last character we added before
		} //each pass will add a new character from the end of the original string plus the last character from a new substring of the string it was part of sans the character just added up until the substring consists of only the first letter when the calls end and the final reversal varaible is a reversal of the original string 
		
		return reversal;
	}
	
}
