package com.pacificlion.freecodecamp;


import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class QueueTest {

  private List<Queue<Integer>> queues = new ArrayList<>();

  @Before
  public void setup() {
    queues.add(new LinkedQueue<Integer>());
  }

  @Test
  public void testEmptyQueue() {
    for (Queue queue : queues) {
      assertTrue(queue.isEmpty());
      assertEquals(0,queue.size());
    }
  }

  @Test(expected = Exception.class)
  public void testPollOnEmpty() {
    for (Queue queue : queues) {
      queue.poll();
    }
  }

  @Test(expected = Exception.class)
  public void testPeekOnEmpty() {
    for (Queue queue : queues) {
      queue.peek();
    }
  }

  @Test
  public void testOffer() {
    for (Queue<Integer> queue : queues) {
      queue.offer(2);
      assertEquals(1,queue.size());
    }
  }

  @Test
  public void testPeek() {
    for (Queue<Integer> queue : queues) {
      queue.offer(2);
      assertEquals(2,(int) queue.peek());
      assertEquals(1,queue.size());
    }
  }

  @Test
  public void testPoll() {
    for (Queue<Integer> queue : queues) {
      queue.offer(2);
      assertEquals(2,(int) queue.poll());
      assertEquals(0,queue.size());
    }
  }

  @Test
  public void testExhaustively() {
    for (Queue<Integer> queue : queues) {
      assertTrue(queue.isEmpty());
      queue.offer(1);
      assertFalse(queue.isEmpty());
      queue.offer(2);
      assertEquals(2,queue.size());
      assertEquals(1,(int) queue.peek());
      assertEquals(2,queue.size());
      assertEquals(1,(int) queue.poll());
      assertEquals(1,queue.size());
      assertEquals(2,(int) queue.peek());
      assertEquals(1,queue.size());
      assertEquals(2,(int) queue.poll());
      assertEquals(0,queue.size());
      assertTrue(queue.isEmpty());
    }
  }
}