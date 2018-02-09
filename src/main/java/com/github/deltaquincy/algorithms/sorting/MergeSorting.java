/**
 * Copyright (c) 2018 Quincy Liang
 * Under the MIT license
 */

package com.github.deltaquincy.algorithms.sorting;

// TODO 这个程序没有摆脱 Comparable 类型的不安全使用

/**
 * 归并排序。
 * 
 * 该类包含一个静态方法，可对数组进行原地的归并排序。
 */
public class MergeSorting extends Sorting {
  /** 归并所需的辅助数组 */
  private static Comparable[] temp;
  
  /**
   * 对数组进行原地的归并排序。
   * 
   * @param <T> 数组元素的引用类型
   * @param a 将要排序的数组
   */
  public static void sort(Comparable[] a) {
    int n = a.length;
    temp = new Comparable[n];
    sort(a, 0, n-1);
  }
  
  private static void sort(Comparable[] a, int lo, int hi) {
    if (hi <= lo) {
      return;
    }
    int mid = lo + (hi - lo) / 2;
    sort(a, lo, mid);
    sort(a, mid+1, hi);
    merge(a, lo, mid, hi);
  }

  
  /**
   * 对数组进行原地归并。
   * 
   * @param <T> 数组元素的引用类型
   * @param a 将要排序的数组
   * @param lo 归并下限索引
   * @param mid 归并中位索引
   * @param hi 归并上限索引
   */
  public static void merge(Comparable[] a, int lo, int mid, int hi) {
    int i = lo;
    int j = mid + 1;

    for (int k = lo; k <= hi; k++) {
      temp[k] = a[k];
    }

    for (int k = lo; k <= hi; k++) {
      if (i > mid) a[k] = temp[j++];
      else if (j > hi) a[k] = temp[i++];
      else if (isLess(temp[j], temp[i])) a[k] = temp[j++];
      else a[k] = temp[i++];
    }
  }
}
