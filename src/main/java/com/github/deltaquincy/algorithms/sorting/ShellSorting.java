/**
 * Copyright (c) 2018 Quincy Liang
 * Under the MIT license
 */

package com.github.deltaquincy.algorithms.sorting;

/**
 * Shell 排序。
 * 
 * 该类包含一个静态方法，可对数组进行原地的 Shell 排序。
 */
public class ShellSorting extends Sorting {
  /**
   * 对数组进行原地的 Shell 排序。
   * 
   * @param <T> 数组元素的引用类型
   * @param a 将要排序的数组
   */
  public static <T extends Comparable<T>> void sort(T[] a) {
    int n = a.length;
    
    // 构造 Shell 排序的递增序列
    int h = 1;
    while (h < n/3) {
      h = 3*h + 1;
    }
    
    // 逐步进行子数组的插入排序，达到排序整个数组的目的
    while (h >= 1) {
      for (int i = h; i < n; i++) {  // STAR
        for (int j = i; j >= h && isLess(a[j], a[j-h]); j -= h) {
          exchange(a, j, j-h);
        }
      }
      h /= 3;
    }
  }
}
