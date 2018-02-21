/**
 * Copyright (c) 2018 Quincy Liang
 * Under the MIT license
 */

package com.github.deltaquincy.algorithms.collections;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class PriorityQueueTest {
  private PriorityQueue<Integer> queue;

  @Before
  public void setup() {
    queue = new PriorityQueue<Integer>();
  }

  @Test
  public void testInsert() {
    queue.insert(3);
    queue.insert(28);
    queue.insert(-92);
    assertEquals(queue.size(), 3);
  }

  @Test
  public void testDeleteMax() {
    queue.insert(28);
    queue.insert(-92);
    queue.insert(2);
    assertEquals(queue.deleteMax(), Integer.valueOf(28));
  }
}
