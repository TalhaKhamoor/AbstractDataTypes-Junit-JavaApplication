package Tests;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import utilities.ListADT;
import utilities.MyArrayList;

/**
 * 
 * @author Talha Khamoor
 *  @version completed Aug 26, 2020
 * Series of tests to see if my ArrayList ADT works as expected
 *
 */
public class MyArrayListTests {
	
	//Test object(s)
	MyArrayList<Object> list;
	
	

	/** 
	 * @BeforeClass  - This method will execute once before all tests. Can be used
	 * 					to perform time insensitive tasks such as connecting to a
	 * 					database.
	 * 
	 * @throws Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @AfterClass - This method will execute once after all tests. Can be used to
	 * 					to perform clean up activities such as closing a database.
	 * @throws Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @Before - Will execute once before each method. Can be used to set up a predefined
	 * 				Environment before running a test. Such as reading input or initializing
	 * 				a class.
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		list = new MyArrayList<Object>();
	}

	/**
	 * @After - This method will execute after every test. Can be used to clean up the testing
	 * 				environment by deleting temporary data or restoring default data.
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		list = null;
	}

	/**
	 * Test method for {@link utilities.ListADT#size()}.
	 */
	@Test
	public void sizeTest() {
		
		list.add("cat");
		list.add("dog");
		
		int actual = list.size();
		int expected = 2;
		assertEquals("size method did no return proper size", expected, actual);

	}
	
	/**
	 * Test method for {@link utilities.ListADT#clear()}.
	 */
	@Test
	public void clearTest() {
		
		list.add("cat");
		list.add("dog");
		
		list.clear();
		
		int actual = list.size();
		int expected = 0;
		assertEquals("size method did no return proper size of 0", expected, actual);
	}
	
	/**
	 * Test method for {@link utilities.ListADT#add(int, Object)}.
	 * @throws NullPointerException
	 * @throws IndexOutOfBoundsException
	 */
	@Test
	public void addTest() throws NullPointerException, IndexOutOfBoundsException{
		
		list.add("cat");
		list.add("dog");
		
		list.add(2, "chicken");
		
		String actual = (String) list.get(2);
		String expected = "chicken";
		
		assertEquals("add method did not add object properly", expected, actual);
		
	}
	
	/**
	 * Test method for {@link utilities.ListADT#add(Object)}.
	 * @throws NullPointerException
	 * @throws IndexOutOfBoundsException
	 */
	@Test
	public void addTest2() throws NullPointerException, IndexOutOfBoundsException{

		list.add("cat");
		list.add("dog");		
		list.add("chicken");
		list.add("hen");
		
		String actual = (String) list.get(2);
		String expected = "chicken";
		
		assertEquals("add method did not add object properly", expected, actual);
		
	}
	
	/**
	 * Test method for {@link utilities.ListADT#addAll(ListADT)}.
	 * @throws NullPointerException
	 */
	@Test
	public void addAllTest() throws NullPointerException {
		
		MyArrayList<Object> list2 = new MyArrayList<Object>();
		
		list.add("cat");
		list.add("dog");
		
		list2.addAll(list);
		
		String actual = (String) list2.get(1);
		String expected = "dog";
		
		assertEquals("add all method did not add over objects properly", expected, actual);
	}
	
	/**
	 * Test method for {@link utilities.ListADT#get(int)}.
	 * @throws IndexOutOfBoundsException
	 */
	@Test
	public void getTest() throws IndexOutOfBoundsException{
		
		list.add("cat");
		String actual = (String) list.get(0);
		String expected = "cat";
		
		assertEquals("get method did not return the proper object", expected, actual);
	}
	
	/**
	 * Test method for {@link utilities.ListADT#remove(int)}.
	 * @throws IndexOutOfBoundsException
	 */
	@Test
	public void  removeTest() throws IndexOutOfBoundsException{
		
		list.add("cat");
		
		String actual = (String) list.remove(0);
		String expected = "cat";
		
		assertEquals("remove method did not return the proper object", expected, actual);
	}
	
	/**
	 * Test method for {@link utilities.ListADT#remove(Object)}.
	 * @throws NullPointerException
	 */
	@Test
	public void removeTest2() throws NullPointerException{
		list.add("cat");
		
		String actual = (String) list.remove("cat");
		String expected = "cat";
		
		assertEquals("remove method did not return the proper object", expected, actual);
	}
	
	/**
	 * Test method for {@link utilities.ListADT#set(int, Object)}.
	 * @throws NullPointerException
	 * @throws IndexOutOfBoundsException
	 */
	@Test
	public void setTest() throws NullPointerException, IndexOutOfBoundsException {
		
		list.add("bobcat");
		list.set(0, "cat");
		
		
		String actual = (String) list.get(0);
		String expected = "cat";
		
		assertEquals("set method did not properly assign an object at proper sequence", expected, actual);
	}
	
	/**
	 * Test method for {@link utilities.ListADT#isEmpty()}.
	 */
	@Test
	public void isEmptyTest() {
		
		list.add("cat");
		
		boolean actual = false;
		boolean expected = list.isEmpty();
		
		assertEquals("isEmpty method is returning a wrong boolean value", expected, actual);
		
	}
	
	/**
	 * Test method for {@link utilities.ListADT#contains(Object)}.
	 * @throws NullPointerException
	 */
	@Test
	public void containsTest() throws NullPointerException {
		
		list.add("cat");
		list.add("dog");
		
		boolean actual = true;
		boolean expected = list.contains("cat");
		
		assertEquals("contains method returning a incorrect boolean value", expected, actual);

	}
	
	/**
	 * Test method for {@link utilities.ListADT#toArray()}.
	 * @throws NullPointerException
	 */
	@Test
	public void toArrayTest()  throws NullPointerException{
		
		list.add("cat");
		list.add("dog");
		
		String[] toHold = new String[10];
		String[] array = (String[]) list.toArray(toHold);
		
		String expected = "cat";
		String actual = array[0];
		
		
		assertEquals("toArray method did not transer over elements to array properly", expected, actual);
	}
	
	/**
	 * Test method for {@link utilities.ListADT#toArray(Object[])}.
	 */
	@Test
	public void toArrayTest2() {
		
		Cat leo = new Cat("leo");
		Cat meow = new Cat("meow");
		list.add(leo);
		list.add(meow);
		
		
		Object[] array = (Object[]) list.toArray();
		
		Cat test = (Cat) array[0];
		String actual = "leo";
		String expected = test.getName();
		
		assertEquals("toArray method did not transer over objects to array properly", expected, actual);
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
	
}
