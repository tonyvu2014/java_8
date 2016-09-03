package stream;

import org.junit.*;
import static org.junit.Assert.*;
import java.util.stream.IntStream;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import java.util.Arrays;

@RunWith(Parameterized.class)
public class IntStreamTest {
	private int start, end, result;
	
	
    @Parameters
    public static Iterable<Object[]> data()  {
         return Arrays.asList(new Object[][] {
            {1, 1, 1},
            {1, 3, 6},
            {2, 4, 9},
			{2, 1, 0}	
         });
    }
	
	public IntStreamTest(int start, int end, int result) {
		this.start = start;
		this.end = end;
		this.result = result;
	} 
	
	@Test
	public void testReduce() {
		int total = IntStream.rangeClosed(start, end).reduce(0, (x,y)->x+y);
		assertEquals(total, result);
	}
	
	@Test
	public void testSum() {
		int sum = IntStream.rangeClosed(start,end).sum();
		assertEquals(sum, result);
	}
	
}