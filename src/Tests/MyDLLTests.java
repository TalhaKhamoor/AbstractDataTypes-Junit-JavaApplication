package Tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import utilities.MyDLL;

/**
 * 
 * @author Talha Khamoor
 * @version completed Aug 26, 2020
 * Series of tests to see if my DLL ADT works as expected
 *
 */
public class MyDLLTests {

	MyDLL<Object> dll;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		dll = new MyDLL<Object>();
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void sizeTest() {
		dll.add("cat");
		dll.add("dog");
		dll.add("monkey");

		int actual = dll.size();
		int expected = 3;

		assertEquals("size method did not return proper number of elements", expected, actual);
	}

	//@Test
	public void clearTest() {
		dll.add("cat");
		dll.add("dog");
		dll.add("monkey");

		dll.clear();

		int actual = dll.size();
		int expected = 0;

		assertEquals("clear method did not rid of all elements", expected, actual);
	}
	
	@Test
	public void addTest() {
		dll.add("cat");
		dll.add("dog");
		dll.add("monkey");

		String actual = (String) dll.get(0);
		String expected = "cat";

		assertEquals("add method did not add object properly", expected, actual);
	}
	
	@Test
	public void addTest2() {
		
		dll.add("cat");
		dll.add("dog");
		dll.add(1, "monkey");
		
		String actual = (String) dll.get(0);
		String expected = "cat";

		assertEquals("add method did not add object properly", expected, actual);
	}
	
	@Test
	public void addAllTest() {
		
		MyDLL<Object> dll2 = new MyDLL<Object>();
		
		dll.add("cat");
		dll.add("dog");
		dll.add("monkey");
		
		dll2.addAll(dll);
		
		String actual = (String) dll2.get(2);
		String expected = "monkey";

		assertEquals("addAll method did not add all elements properly", expected, actual);
	}
	
	@Test
	public void getTest() {
		
		dll.add("cat");
		dll.add("dog");
		dll.add("monkey");
		
		String actual = (String) dll.get(1);
		String expected = "dog";
		
		assertEquals("get method did not return the proper element", expected, actual);
		
	}
	
	@Test
	public void removeTest() {
		
		dll.add("cat");
		dll.add("dog");
		dll.add("monkey");
		
		String actual = (String) dll.remove(1);
		String expected = "dog";
		
		assertEquals("remove method did not return the proper element", expected, actual);
		
	}
	
	@Test
	public void removeTest2() {
		
		dll.add("cat");
		dll.add("dog");
		dll.add("monkey");
		
		String actual = (String) dll.remove("dog");
		String expected = "dog";
		
		assertEquals("remove method did not return the proper element", expected, actual);
	}
	
	@Test
	public void setTest() {
		
		dll.add("cat");
		dll.add("dog");
		dll.add("monkey");
		
		dll.set(1, "monkey");
		
		String actual = (String) dll.remove(1);
		String expected = "monkey";
		
		assertEquals("set method did not over write the proper element", expected, actual);
		
	}
	
	@Test
	public void isEmptyTest() {
		
		dll.add("cat");
		dll.add("dog");
		dll.add("monkey");
		
		boolean actual = dll.isEmpty();
		boolean expected = false;
		
		assertEquals("is empty method wrongly identified the state of list", expected, actual);
		
	}
	
	@Test
	public void containsTest() {
		
		dll.add("cat");
		dll.add("dog");
		dll.add("monkey");
		
		boolean actual = dll.contains("dog");
		boolean expected = true;
		
		assertEquals("contains method failed to verify the insertion element", expected, actual);
	}
	
	@Test
	public void toArrayTest() {
		
		dll.add("cat");
		dll.add("dog");
		dll.add("monkey");
		
		Object[] array = (Object[]) dll.toArray();
		
		String actual = (String) array[1];
		String expected = "dog";
		
		assertEquals("toArray method failed to transfer elements properly to array", expected, actual);

	}
	
	@Test
	public void toArrayTest2() {
		
		dll.add("cat");
		dll.add("dog");
		dll.add("monkey");
		
		String[] toHold = new String[10];
		String[] array = (String[]) dll.toArray(toHold);
		
		String actual = (String) array[1];
		String expected = "dog";
		
		assertEquals("toArray method failed to transfer elements properly to array", expected, actual);		
	}
	

}
