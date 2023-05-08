package com.pacificlion.freecodecamp;



import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class StackTest {

  private List<Stack<Integer>> stacks = new ArrayList<>();

  @Before
  public void setup() {
    stacks.add(new ListStack<Integer>());
  }

  @Test
  public void testEmptyStack() {
    for (Stack stack : stacks) {

      assertTrue(stack.isEmpty());
      assertEquals(0,stack.size());
    }
  }

  @Test(expected = Exception.class)
  public void testPopOnEmpty() {
    for (Stack stack : stacks) {
      stack.pop();
    }
  }

  @Test(expected = Exception.class)
  public void testPeekOnEmpty() {
    for (Stack stack : stacks) {
      stack.peek();
    }
  }

  @Test
  public void testPush() {
    for (Stack<Integer> stack : stacks) {
      stack.push(2);
      assertEquals(1,stack.size());
    }
  }

  @Test
  public void testPeek() {
    for (Stack<Integer> stack : stacks) {
      stack.push(2);

      assertEquals(2,(int) stack.peek());
      assertEquals(1,stack.size());
    }
  }

  @Test
  public void testPop() {
    for (Stack<Integer> stack : stacks) {
      stack.push(2);
      assertEquals(2,(int) stack.pop());
      assertEquals(0,stack.size());
    }
  }

  @Test
  public void testExhaustively() {
    for (Stack<Integer> stack : stacks) {
      assertTrue(stack.isEmpty());
      stack.push(1);
      assertFalse(stack.isEmpty());
      stack.push(2);
      assertEquals(2,stack.size());
      assertEquals(2,(int) stack.peek());
      assertEquals(2,stack.size());
      assertEquals(2,(int) stack.pop());
      assertEquals(1,stack.size());
      assertEquals(1,(int) stack.peek());
      assertEquals(1,stack.size());
      assertEquals(1,(int) stack.pop());
      assertEquals(0,stack.size());
    }
  }
}