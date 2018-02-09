/**
 * Copyright (c) 2018 Quincy Liang
 * Under the MIT license
 */

package com.github.deltaquincy.algorithms.collections;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

public class LinkedListTest {
  // Using stack
  private Stack<Integer> stack;

  @Before
  public void setup() {
    stack = new Stack<Integer>();
    stack.push(30);
    stack.push(-53);
    stack.push(8992);
  }
  
  @Test
  public void testIteration() {
    int timer = 0;
    for (int item : stack) {
      timer++;
    }
    assertThat(timer).isEqualTo(3);
  }
}
