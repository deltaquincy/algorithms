/**
 * Copyright (c) 2018 Quincy Liang
 * Under the MIT license
 */

package com.github.deltaquincy.algorithms.sorting;

/**
 * 基于数组的排序类模版。
 * 
 * 该类包含了一系列基于比较的排序方法所必需的工具，包括比较元素、交换元素、判断数组是否已有序，
 * 并且提供了一个未实现的排序方法，将在表示不同排序算法的各个子类中实现。
 */
public class Sorting {
  /**
   * 未实现的排序方法，将在表示不同排序算法的各个子类中实现。
   * 
   * @param <T> 数组元素的引用类型
   * @param a 将要排序的数组
   */
  public static <T extends Comparable<T>> void sort(T[] a) {}

  /**
   * 比较两个元素。是为了提高可读性对 {@code compareTo} 方法的简单封装。
   * 
   * @see java.lang.Comparable
   * 
   * @param <T> 数组元素的引用类型
   * @param v 将要比较的第一个元素
   * @param w 将要比较的第二个元素
   * @return 若 {@code v < w} 则返回 {@code true}，否则返回 {@code false}
   */
  protected static <T extends Comparable<T>> boolean isLess(T v, T w) {
    return v.compareTo(w) < 0;
  }

  /**
   * 原地交换数组当中的两个元素。
   * 
   * @param <T> 数组元素的引用类型
   * @param a 将要交换元素的数组
   * @param i 将要交换的第一个元素索引
   * @param j 将要交换的第二个元素索引
   */
  protected static <T extends Comparable<T>> void exchange(T[] a, int i, int j) {
    T t = a[i];
    a[i] = a[j];
    a[j] = t;
  }

  /**
   * 判断数组是否已由小到大有序
   * 
   * @param <T> 数组元素的引用类型
   * @param a 将要判断是否有序的数组
   * @return 若数组已有序则返回 {@code true}，否则返回 {@code false}
   */
  public static <T extends Comparable<T>> boolean isSorted(T[] a) {
    for (int i = 1; i < a.length; i++) {
      if (isLess(a[i], a[i-1])) {
        return false;
      }
    }
    return true;
  }
}
