/**
 * Copyright (c) 2018 Quincy Liang
 * Under the MIT license
 */

package com.github.deltaquincy.algorithms.searching;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class RedBlackTreeTest {
  private RedBlackTree<String, Integer> symbolTable = new RedBlackTree<String, Integer>(); 

  @Test
  public void testRBT() {
    symbolTable.put("N", 15);
    symbolTable.put("M", 20);
    assertThat(symbolTable.size()).isEqualTo(2);
    assertThat(symbolTable.get("M")).isEqualTo(20);
    assertThat(symbolTable.get("K")).isEqualTo(null);
    symbolTable.put("K", 105);
    assertThat(symbolTable.get("K")).isEqualTo(105);
    symbolTable.put("M", -102);
    assertThat(symbolTable.get("M")).isEqualTo(-102);
    symbolTable.put("P", 72);
    symbolTable.put("A", 86);
    symbolTable.put("Q", 34);
    assertThat(symbolTable.get("P")).isEqualTo(72);
  }
  
}
