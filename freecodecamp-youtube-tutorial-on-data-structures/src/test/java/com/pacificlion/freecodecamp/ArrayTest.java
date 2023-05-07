package com.pacificlion.freecodecamp;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;

import org.junit.Test;


public class ArrayTest {

	//   @BeforeClass
	//   public static void setup() {
	//   }

	  @Test
	  public void testInsertion() {
		  
	    Array<String> givenArray = new Array<>(4);
		assertEquals(0, givenArray.size());
		givenArray.add("First");
		givenArray.add("Second");
		assertEquals(2, givenArray.size());
	  }

	  @Test
	  public void testRemoveAt() {
		  
	    Array<String> givenArray = new Array<>(4);
		givenArray.add("First");
		givenArray.add("Second");
		assertEquals(2, givenArray.size());

		String elementRemoved = givenArray.removeAt(1);
		assertEquals(1, givenArray.size());
		assertEquals("First", givenArray.get(0));
		assertEquals("Second", elementRemoved);
	  }
	  
	  @Test
	  public void testContains() {
		  
	    Array<String> givenArray = new Array<>(4);
		givenArray.add("First");
		givenArray.add("Second");
		assertEquals(2, givenArray.size());

		assertEquals(false, givenArray.contains("Third"));
		assertEquals(true, givenArray.contains("First"));
	  }


	  @Test
	  public void testIndexOf() {
		  
	    Array<String> givenArray = new Array<>(4);
		givenArray.add("First");
		givenArray.add("Second");
		assertEquals(2, givenArray.size());

		assertEquals(-1, givenArray.indexOf("Third"));
		assertEquals(0, givenArray.indexOf("First"));
	  }


	  @Test
	  public void testIterator() {
		  
	    Array<String> givenArray = new Array<>(4);
		givenArray.add("First");
		givenArray.add("Second");
		Iterator<String> itr = givenArray.iterator();
		assertEquals(2, givenArray.size());

		assertEquals(true, itr.hasNext());
		assertEquals("First",itr.next());
		assertEquals(true, itr.hasNext());
		assertEquals("Second",itr.next());
		assertEquals(false, itr.hasNext());
	  }

	  @Test
	  public void testRemove() {
		  
	    Array<String> givenArray = new Array<>(4);
		String elemToRemove = "First";
		givenArray.add(elemToRemove);
		givenArray.add("Second");
		assertEquals(2, givenArray.size());
		

		givenArray.remove(elemToRemove);
		assertEquals(1, givenArray.size());
		assertEquals("Second", givenArray.get(0));
	  }

	  @Test
	  public void testClear() {
		  
	    Array<String> givenArray = new Array<>(4);
		givenArray.add("First");
		givenArray.add("Second");
		assertEquals(2, givenArray.size());
		

		givenArray.clear();
		assertEquals(0, givenArray.size());
	  }
	  

}
