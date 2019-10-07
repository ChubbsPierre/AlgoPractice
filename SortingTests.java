import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

class SortingTests 
{
	@Test
	void bubbleSortTest() 
	{
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
		Sorting testSort = new Sorting();
		int[] testArrayExpected = {10, 14, 19, 27, 33, 35, 42, 44};
		int[] testArray = {14, 33, 27, 10, 35, 19, 42, 44};
		testSort.bubbleSort(testArray);
		assertEquals("Sorted Array: " + Arrays.toString(testArrayExpected), outContent);
	}
}
