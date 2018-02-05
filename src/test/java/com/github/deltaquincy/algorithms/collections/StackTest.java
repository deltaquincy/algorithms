/**
 * Copyright (c) 2018 Quincy Liang
 * Under the CPL v3 license
 */

package com.github.deltaquincy.algorithms.collections;

import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

public class StackTest {
  private Stack<Integer> stack = new Stack<Integer>();

  @Test
  public void testInitializeStack() {
    assertTrue(stack.isEmpty());
  }

  @Test
  public void testPushAndPopItems() {
    int itemToPush = 1996;
    stack.push(itemToPush);
    int itemPoped = stack.pop();
    assertEquals(itemToPush, itemPoped);
  }

  @Test
  public void testIteration() {
    int[] itemsToPush = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    for (int itemToPush : itemsToPush) {
      stack.push(itemToPush);
    }
    assertEquals(stack.size(), 10);
    for (int itemToPop : stack) {
      int itemPoped  = stack.pop();
      assertEquals(itemToPop, itemPoped);
    }
    assertTrue(stack.isEmpty());
  }
}
