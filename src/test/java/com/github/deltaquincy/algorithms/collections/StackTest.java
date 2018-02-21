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

public class StackTest {
  private Stack<Integer> stack;

  @Rule
  public ExpectedException expectedException = ExpectedException.none();

  @Before
  public void setup() {
    stack = new Stack<Integer>();
  }
  
  @Test
  public void testConstructWithAnArray() {
    Integer[] items = {1, 2, 3, 4, 5};
    stack = new Stack<Integer>(items);
    assertEquals(stack.getSize(), 5);
  }
  
  @Test
  public void testPush() {
    stack.push(0);
    stack.push(35);
    stack.push(-72);
    assertEquals(stack.getSize(), 3);
  }

  @Test
  public void testPop() {
    stack.push(92);
    stack.push(37);
    assertEquals(stack.pop(), Integer.valueOf(37));
    assertEquals(stack.pop(), Integer.valueOf(92));
  }

  @Test
  public void testPopUnderflow() {
    expectedException.expect(NoSuchElementException.class);
    expectedException.expectMessage("The stack is empty.");
    stack.pop();
  }

}
