package ReverseNumber;

public class ReverseNumber
{
	public static void main(String args[])
    {
        ReverseNumber nr = new ReverseNumber();
        System.out.println("Result: "+nr.reverseNumber(17868));
        System.out.println("Result: "+nr.reverseNumber(123456789));
        System.out.println("Result: "+nr.reverseNumber(8008));

    }
		 
	/*
	 * General idea here is to make clever use of the properties of *10 %10
	 * when you divide by 10 you essentially move the number to the right
	 * so 14 / 10 = 1.4 and so 14 % 10 = 4 as % takes the remainder, right?
	 * meanwhile *10 moves a number to the left adding a 0
	 * 14 * 10 = 140, okay got it?
	 * 
	 * So if we take our reverse number and times it by 10 it creates an extra 0
	 * ( to begin with it does nothing as 0 * 0 = 0) and so if we then add our 
	 * modulated original number to reverse we are essentially adding the last
	 * digit of the original number to the 0 added by * 10. Repeat until there
	 * are no more digits in number and youll have fully reveresed the int.
 	 */
	
	public int reverseNumber(int number)
	{     
		int reverse = 0;
		while(number != 0)
		{
			reverse = (reverse*10)+(number%10);
			number = number/10;
		} 
		return reverse;
	}       
}
