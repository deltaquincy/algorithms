/*
 * Copyright 2018 Quincy Liang
 *
 * Project Algorithms. A repository of my algorithms learning.
 * Licensed under the MIT license.
 */

package com.github.deltaquincy.algorithms.searching;

import java.util.Arrays;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;
import edu.princeton.cs.algs4.In;

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

  @Test
  public void testWhiteList() {
    int[] whitelist = In.readInts("testdata/tinyW.txt");
    Arrays.sort(whitelist);
    In target = new In("testdata/tinyT.txt");
    int[] goldresult = {50, 99, 13};
    int[] result = new int[goldresult.length];
    for (int i = 0; !target.isEmpty(); ) {
      int key = target.readInt();
      if (BinarySearch.rank(key, whitelist) < 0) {
        result[i] = key;
        i++;
      }
    }
    assertArrayEquals(goldresult, result);
  }
}
