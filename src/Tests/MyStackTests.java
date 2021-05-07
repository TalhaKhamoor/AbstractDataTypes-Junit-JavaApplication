package Tests;

import static org.junit.Assert.*;

import java.util.EmptyStackException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import utilities.MyStack;

/**
 * 
 * @author Talha Khamoor
 * @version completed Aug 26, 2020
 * Series of tests to see if my Stack ADT works as expected.
 *
 */
public class MyStackTests {
	
	//Test object
	MyStack<Object> stack;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		stack = new MyStack<Object>();
	}

	@After
	public void tearDown() throws Exception {
		stack = null;
	}
	/**
	 * Test method for {@link utilities.StackADT#push(Object)}.
	 * @throws NullPointerException
	 */
	@Test
	public void pushTest() throws NullPointerException{
		stack.push("cat");
		
		String actual = (String) stack.pop();
		String expected = "cat";
		
		assertEquals("Push method did not insert object correctly", expected, actual);
	}
	
	/**
	 * Test method for {@link utilities.StackADT#pop()}.
	 * @throws EmptyStackException
	 */
	@Test
	public void popTest() throws EmptyStackException{
		stack.push("cat");
		stack.push("dog");
		String actual = (String) stack.pop();
		String expected = "dog";
		
		assertEquals("pop method did not get object correctly", expected, actual);
	}
	
	/**
	 * Test method for {@link utilities.StackADT#peek()}.
	 * @throws EmptyStackException
	 */
	@Test
	public void peekTest() throws EmptyStackException{
		stack.push("cat");
		stack.push("dog");
		String actual = (String) stack.peek();
		String expected = "dog";
		
		assertEquals("pop method did not get object correctly", expected, actual);
	}
	
	/**
	 * Test method for {@link utilities.StackADT#clear()}.
	 */
	@Test
	public void clearTest() {
		stack.push("dog");
		stack.push("cat");
		
		stack.clear();
		
		int actual = stack.size();
		int expected = 0;
		
		assertEquals("clear method did not get rid of stacks elements", expected, actual);
	}
	
	/**
	 * Test method for {@link utilities.StackADT#isEmpty()}.
	 */
	@Test
	public void isEmpty() {
		stack.push("dog");
		stack.push("cat");
		
		stack.clear();
		
		boolean actual = stack.isEmpty();
		boolean expected = true;
		
		assertEquals("isEmpty method is return an incorrect boolean value", expected, actual);
	}

	/**
	 * Test method for {@link utilities.StackADT#toArray()}.
	 */
	@Test
	public void toArrayTest() {
		stack.push("dog");
		stack.push("cat");
		
		Object[] array = (Object[]) stack.toArray();
		
		String expected = "cat";
		String actual = (String) array[1];
		
		assertEquals("The transfer of elements to an array was not successfull", expected, actual);
		
	}
	/**
	 * Test method for {@link utilities.StackADT#toArray(Object[])}.
	 * @throws NullPointerException
	 */
	@Test
	public void toArrayTest2() throws NullPointerException{
		Cat leo = new Cat("leo");
		Cat meow = new Cat("meow");
		stack.push(leo);
		stack.push(meow);
		
		Cat[] holder = new Cat[10];
		Cat[] array = (Cat[]) stack.toArray(holder);
		
		Cat cat = array[0];
		String actual = cat.getName();
		String expected = "leo"; 
		
		assertEquals("The transfer of elements to an array was not successfull", expected, actual);
		
	}
	
	public class Cat{
		String name;
		
		public Cat(String name) {
			this.name = name;
		}
		
		public String getName() {
			return name;
		}
	}
	
	/**
	 * Test method for {@link utilities.StackADT#contains(Object)}.
	 * @throws NullPointerException
	 */
	@Test
	public void containsTest() throws NullPointerException{
		
		stack.push("cat");
		stack.push("dog");
		
		boolean expected = true;
		boolean actual = stack.contains("dog");
		
		assertEquals("The contains method does not return the expected boolean value", expected, actual);
				
	}
	
	/**
	 * Test method for {@link utilities.StackADT#search(Object)}.
	 */
	@Test
	public void search() {
		
		stack.push("cat");
		stack.push("dog");
		
		int actual = stack.search("dog");
		int expected = 1;
		
		assertEquals("The search method does not return expected index of object in stack", expected, actual);		
	}
	
	/**
	 * Test method for {@link utilities.StackADT#equals(Object)}.
	 */
	@Test
	public void equals() {
		
		stack.push("cat");
		stack.push("dog");
		
		MyStack<Object> stack2 = new MyStack<Object>();
		stack2.push("cat");
		stack2.push("dog");
		
		boolean expected = true;
		boolean actual = stack.equals(stack2);
		
		assertEquals("The equals method does not return the expected boolean value of true", expected, actual);		
		
	}
	
	/**
	 * Test method for {@link utilities.StackADT#size()}.
	 */
	@Test
	public void sizeTest() {
		stack.push("cat");
		stack.push("dog");
		
		int actual = stack.size();
		int expected = 2;
		
		assertEquals("The equals method does not return the expected boolean value of true", expected, actual);		
		
	}

}
