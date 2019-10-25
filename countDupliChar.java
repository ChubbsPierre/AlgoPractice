package countDuplicateChars;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class countDupliChar 
{	
	public static void main(String[] args)
	{
		countDupliChar dup = new countDupliChar();
		dup.countDuplicateCharacters("track a lackin");
	}
	
	/*
	 * Method to create a hash map, that uses a character as a key and 
	 * the number of occurrences as a value, then convert the passed String 
	 * to a character array. Then go through every character in the array 
	 * and check if it has been added to the hash map, if so then just add one
	 * to the value in the hash map with that character key if so then create
	 * a new element in the hash map with that key and an occurance of one
	 * 
	 * once the hash map is complete create a set out of all the keys in the 
	 * hash map. Then go through all the characters in the set and if their entry
	 * in the hash map has more than one occurances print it. 
	 */
	public void countDuplicateCharacters(String str)
	{
		Map<Character, Integer> dupMap = new HashMap<Character, Integer>();
		char[] charArray = str.toCharArray();
		for(Character ch: charArray) //for every character in the charArray
		{
			if(dupMap.containsKey(ch)) //if the char already exists as a key in the hashmap
			{
				dupMap.put(ch, dupMap.get(ch) + 1); //add one onto the value of the hash map entry with the key of the duplicate letter
			}
			else if(ch != ' ') //if the char isn't a space...
			{
				dupMap.put(ch, 1); //add it to the hash map with the char as key and value as 1
			}
		}
		Set<Character> keys = dupMap.keySet(); //create a set of all the keys which are all the characters that appear in the string
		for(Character ch: keys) //for all the characters in the keys set
		{
			if(dupMap.get(ch) > 1) //check if that characters entry in the hash map has a value greater than one...
			{
				System.out.println(ch + " ---> " + dupMap.get(ch)); //if so then the character has appeared more than once and so print it with its amount of occurances
			}
		}
	}
}
