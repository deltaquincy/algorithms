/**
 * Copyright (c) 2018 Quincy Liang
 * Under the MIT license
 */

package com.github.deltaquincy.algorithms.sorting;

/**
 * The {@code Selection} class implements selection sorting algorithm.
 * 
 * @author Quincy Liang 
 */
public class Selection extends AbstractSorting {
  public static void sort(Comparable[] a) {
    int N = a.length;
    for (int i = 0; i < a.length; i++) {
      int min = i;
      for (int j = i+1; j < N; j++)
        if (less(a[j], a[min])) min = j;
    }
  }
}
