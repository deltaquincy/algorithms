/**
 * Copyright (c) 2018 Quincy Liang
 * Under the MIT license
 */

package com.github.deltaquincy.algorithms.searching;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RedBlackTreeTest {
  private RedBlackTree<String, Integer> symbolTable = new RedBlackTree<String, Integer>(); 

  @Test
  public void testRBT() {
    symbolTable.put("N", 15);
    symbolTable.put("M", 20);
    assertEquals(symbolTable.size(), 2);
    assertEquals(symbolTable.get("M"), Integer.valueOf(20));
    assertEquals(symbolTable.get("K"), null);
    symbolTable.put("K", 105);
    assertEquals(symbolTable.get("K"), Integer.valueOf(105));
    symbolTable.put("M", -102);
    assertEquals(symbolTable.get("M"), Integer.valueOf(-102));
    symbolTable.put("P", 72);
    symbolTable.put("A", 86);
    symbolTable.put("Q", 34);
    assertEquals(symbolTable.get("P"), Integer.valueOf(72));
  }
  
}
