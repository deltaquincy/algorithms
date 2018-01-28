/*
 * Copyright 2018 Quincy Liang
 *
 * Project Algorithms. A repository of my algorithms learning.
 * Licensed under the MIT license.
 */

package com.github.deltaquincy.algorithms.searching;

import java.util.Arrays;

import org.junit.Test;
import static org.junit.Assert.*;

import com.github.deltaquincy.algorithms.searching.BinarySearch;

public class BinarySearchTest {
  @Test
  public void testSearchInAnIntegerArray() {
    int[] testArray = {58, 72, 3, 90, 15, 8, 23, 18, 42};
    Arrays.sort(testArray);
    assertEquals(BinarySearch.rank(15, testArray), 2);
  }

  @Test
  public void testSearchANonExistIntegerInAnIntegerArray() {
    int[] testArray = {58, 72, 3, 90, 15, 8, 23, 18, 42};
    Arrays.sort(testArray);
    assertEquals(BinarySearch.rank(70, testArray), -1);
  }
}
