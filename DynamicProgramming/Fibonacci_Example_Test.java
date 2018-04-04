import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests for Fibonacci_Example class.
 * 
 * Note: Import JUnit 4 in order to run these tests.
 * 
 * @author Rudolf
 *
 */
public class Fibonacci_Example_Test {
	
	private Fibonacci_Example example;
	
	@Before
	public void setUp() {
		example = new Fibonacci_Example();
	}
	
	@Test
	public void testBaseCase0() {
		Assert.assertEquals(0, example.fib(0));
	}
	
	@Test
	public void testBaseCase1() {
		Assert.assertEquals(1, example.fib(1));
	}
	
	@Test
	public void testFibonacciBruteForce() {
		Assert.assertEquals(55, example.fib(10));
	}
	
	@Test
	public void testFibonacciDP() {
		Assert.assertEquals(55, example.fib_DP(10));
	}
	
	@Test
	public void testFibonacciMemoization() {
		Assert.assertEquals(55, example.fib_MEMOIZATION(10));
	}
}
