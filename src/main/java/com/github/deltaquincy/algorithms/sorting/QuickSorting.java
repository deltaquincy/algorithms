/**
 * Copyright (c) 2018 Quincy Liang
 * Under the MIT license
 */

package com.github.deltaquincy.algorithms.sorting;

// TODO 这个程序没有摆脱 Comparable 类型的不安全使用

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 快速排序。
 * 
 * 该类包含一个静态方法，可对数组进行原地的快速排序。
 */
public class QuickSorting extends Sorting {
  private static <T> void shuffle(T[] a) {
    List<T> temp = new ArrayList<T>(Arrays.asList(a));
    Collections.shuffle(temp);
    a = (T[]) temp.toArray();
  }

  private static <T extends Comparable<T>> int partition(T[] a, int lo, int hi) {
    int i = lo;
    int j = hi + 1;
    T v = a[lo];
    while (true) {
      while (isLess(a[++i], v)) if (i == hi) break;
      while (isLess(v, a[--j])) if (j == lo) break;
      if (i >= j) break;
      exchange(a, i, j);
    }
    exchange(a, lo, j);
    return j;
  }
  
  /**
   * 对数组进行原地的快速排序。
   * 
   * @param <T> 数组元素的引用类型
   * @param a 将要排序的数组
   */
  public static <T extends Comparable<T>> void sort(T[] a) {
    shuffle(a);
    sort(a, 0, a.length-1);
  }

  private static <T extends Comparable<T>> void sort(T[] a, int lo, int hi) {
    if (hi <= lo) {
      return;
    }
    int j = partition(a, lo, hi);
    sort(a, lo, j-1);
    sort(a, j+1, hi);
  }
}
