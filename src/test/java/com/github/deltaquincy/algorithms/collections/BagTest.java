/**
 * Copyright (c) 2018 Quincy Liang
 * Under the MIT license
 */

package com.github.deltaquincy.algorithms.collections;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

public class BagTest {
  private Bag<Integer> bag;

  @Before
  public void setup() {
    bag = new Bag<Integer>();
  }

  @Test
  public void testConstructWithAnArray() {
    Integer[] items = {1, 2, 3, 4, 5};
    bag = new Bag<Integer>(items);
    assertThat(bag.getSize()).isEqualTo(5);
  }
  
  @Test
  public void testAdd() {
    bag.add(0);
    bag.add(35);
    bag.add(-72);
    assertThat(bag.getSize()).isEqualTo(3);
  }
}
