/**
 * Copyright (c) 2018 Quincy Liang
 * Under the MIT license
 */

package com.github.deltaquincy.algorithms.collections;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

public class BinaryHeapTest {
  private BinaryHeap<Integer> heap;

  @Before
  public void setup() {
    heap = new BinaryHeap<Integer>(20);
  }

  @Test
  public void testInsert() {
    heap.insert(3);
    heap.insert(28);
    heap.insert(-92);
    assertThat(heap.size()).isEqualTo(3);
  }

  @Test
  public void testDeleteMax() {
    heap.insert(28);
    heap.insert(-92);
    heap.insert(2);
    assertThat(heap.deleteMax()).isEqualTo(28);
  }
}
