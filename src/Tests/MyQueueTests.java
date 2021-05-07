package Tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import utilities.MyQueue;

public class MyQueueTests {

	MyQueue<Object> queue;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception{
		
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception{
		
	}
	
	@Before
	public void setUp() throws Exception{
		queue = new MyQueue<Object>();
	}
	
	@After
	public void tearDown() throws Exception{
		queue = null;
	}
	
	@Test
	public void enqueueTest() throws Exception{
		queue.enqueue("dog");
		
		String actual = (String) queue.peek();
		String expected = "dog";
	
		assertEquals("enque method did not insert object correctly", expected, actual);
		
	}
	
	@Test
	public void dequeueTest() throws Exception{
		queue.enqueue("dog");
		queue.enqueue("cat");
		queue.enqueue("fish");
		
		String actual = (String) queue.dequeue();
		actual = (String) queue.dequeue();

		String expected = "cat";
	
		assertEquals("enque method did not insert object correctly", expected, actual);
		
	}
	
	@Test
	public void isEmptyTest() throws Exception{
		boolean actual = queue.isEmpty();
		boolean expected = true;
		assertEquals("isEmpty method is empty and isEmpty method worked incorrectly", expected, actual);
	}
	
	@Test
	public void isNotEmptyTest() throws Exception{
		queue.enqueue("Talha");
		boolean actual = queue.isEmpty();
		boolean expected = false;
		assertEquals("isNotEmpty method is not empty and isEmpty method worked incorrectly", expected, actual);
	}
	
	@Test
	public void equalsTest() throws Exception{
		queue.enqueue("cat");
		queue.enqueue("dog");
		
		MyQueue<Object> queue2 = new MyQueue<Object>();
		queue.enqueue("cat");
		queue.enqueue("dog");
		
		boolean actual = queue.equals(queue2);
		boolean expected = true;
		assertEquals("the two queues are equal and isequal method not working correctly", expected, actual);
		
	}


}
