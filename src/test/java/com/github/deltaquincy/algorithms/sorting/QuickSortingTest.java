/**
 * Copyright (c) 2018 Quincy Liang
 * Under the MIT license
 */

package com.github.deltaquincy.algorithms.sorting;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class QuickSortingTest {
  private Integer[] array = {9, 23, -6, 72, 1, 18, 301, 41, 72, 58, 69, 1, 9};

  @Test
  public void testSort() {
    QuickSorting.sort(array);
    assertThat(QuickSorting.isSorted(array)).isTrue();
  }
}
