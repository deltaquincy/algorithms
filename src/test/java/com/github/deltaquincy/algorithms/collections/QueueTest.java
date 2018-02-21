/**
 * Copyright (c) 2018 Quincy Liang
 * Under the MIT license
 */

package com.github.deltaquincy.algorithms.collections;

import static org.junit.Assert.assertEquals;

import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class QueueTest {
  private Queue<Integer> queue;

  @Rule
  public ExpectedException expectedException = ExpectedException.none();

  @Before
  public void setup() {
    queue = new Queue<Integer>();
  }

  @Test
  public void testConstructWithAnArray() {
    Integer[] items = {1, 2, 3, 4, 5};
    queue = new Queue<Integer>(items);
    assertEquals(queue.getSize(), 5);
  }
  
  @Test
  public void testEnqueue() {
    queue.enqueue(0);
    queue.enqueue(35);
    queue.enqueue(-72);
    assertEquals(queue.getSize(), 3);
  }

  @Test
  public void testDequeue() {
    queue.enqueue(92);
    queue.enqueue(37);
    assertEquals(queue.dequeue(), Integer.valueOf(92));
    assertEquals(queue.dequeue(), Integer.valueOf(37));
  }

  @Test
  public void testDequeueUnderflow() {
    expectedException.expect(NoSuchElementException.class);
    expectedException.expectMessage("The queue is empty.");
    queue.dequeue();
  }
}
