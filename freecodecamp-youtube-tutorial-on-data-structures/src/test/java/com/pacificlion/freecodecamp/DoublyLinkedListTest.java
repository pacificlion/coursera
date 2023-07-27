package com.pacificlion.freecodecamp;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;

import org.junit.Test;


public class DoublyLinkedListTest {

	//   @BeforeClass
	//   public static void setup() {
	//   }

	  @Test
	  public void testInsertion() {
		  
	    DoublyLinkedList<String> givenList = new DoublyLinkedList<>();
		assertEquals(0, givenList.size());
		givenList.insertFirst("First");
		givenList.insertFirst("Second");
		assertEquals(2, givenList.size());
	  }

	  @Test
	  public void testRemoveAt() {

		DoublyLinkedList<String> givenList = new DoublyLinkedList<>();
		assertEquals(0, givenList.size());
		givenList.insertFirst("First");
		givenList.insertFirst("Second");
		  
	
		assertEquals(2, givenList.size());

		String elementRemoved = givenList.removeAt(1);
		assertEquals(1, givenList.size());
		assertEquals("First", elementRemoved);
	  }
	  
	  @Test
	  public void testContains() {
		  
	    DoublyLinkedList<String> givenList = new DoublyLinkedList<>();
		givenList.insertFirst("First");
		givenList.insertFirst("Second");
		assertEquals(2, givenList.size());

		assertEquals(false, givenList.contains("Third"));
		assertEquals(true, givenList.contains("First"));
	  }


	  @Test
	  public void testIndexOf() {
		  
		DoublyLinkedList<String> givenList = new DoublyLinkedList<>();
		givenList.insertFirst("First");
		givenList.insertFirst("Second");
		assertEquals(2, givenList.size());

		assertEquals(-1, givenList.indexOf("Third"));
		assertEquals(1, givenList.indexOf("First"));
	  }


	  @Test
	  public void testIterator() {
		  
		DoublyLinkedList<String> givenList = new DoublyLinkedList<>();
		givenList.insertFirst("First");
		givenList.insertLast("Second");
		Iterator<String> itr = givenList.iterator();
		assertEquals(2, givenList.size());

		assertEquals(true, itr.hasNext());
		assertEquals("First",itr.next());
		assertEquals(true, itr.hasNext());
		assertEquals("Second",itr.next());
		assertEquals(false, itr.hasNext());
	  }

	  @Test
	  public void testRemove() {
		  
		DoublyLinkedList<String> givenList = new DoublyLinkedList<>();
		String elemToRemove = "First";
		givenList.insertFirst(elemToRemove);
		givenList.insertLast("Second");
		assertEquals(2, givenList.size());
		

		givenList.remove(elemToRemove);
		assertEquals(1, givenList.size());
		assertEquals("Second", givenList.get(0));
	  }

	  @Test
	  public void testClear() {
		  
	    DoublyLinkedList<String> givenList = new DoublyLinkedList<>();
		givenList.insertFirst("First");
		givenList.insertFirst("Second");
		assertEquals(2, givenList.size());
		

		givenList.clear();
		assertEquals(0, givenList.size());
	  }
	  

}
