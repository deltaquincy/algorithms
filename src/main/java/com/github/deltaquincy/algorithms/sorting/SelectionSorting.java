/**
 * Copyright (c) 2018 Quincy Liang
 * Under the MIT license
 */

package com.github.deltaquincy.algorithms.sorting;

/**
 * 选择排序。
 * 
 * 该类包含一个静态方法，可对数组进行原地的选择排序。
 */
public class SelectionSorting extends Sorting {
  /**
   * 对数组进行原地的选择排序。
   * 
   * @param <T> 数组元素的引用类型
   * @param a 将要排序的数组
   */
  public static <T extends Comparable<T>> void sort(T[] a) {
    int n = a.length;
    for (int i = 0; i < n; i++) {
      int min = i;
      for (int j = i+1; j < n; j++) {
        if (isLess(a[j], a[min])) min = j;
      }
      exchange(a, i, min);
    }
  }
}
