/**
 * Copyright (c) 2018 Quincy Liang
 * Under the MIT license
 */

package com.github.deltaquincy.algorithms.string;

import com.github.deltaquincy.algorithms.sorting.InsertionSorting;

/**
 * MostSignificantStringSorting
 */
public class MostSignificantDigitFirstStringSorting {
  private static int r = 256;
  private static final int m = 10;
  private static String[] temp;

  private static int charAt(String s, int d) {
    return d < s.length() ? s.charAt(d) : -1;
  }

  public static void sort(String[] a) {
    int n = a.length;
    temp = new String[n];
    sort(a, 0, n-1, 0);
  }

  private static void sort(String[] a, int lo, int hi, int d) {
    if (hi <= lo + m) {
      InsertionSorting.sort(a, lo, hi, d);
      return;
    }

    int[] count = new int[r+2];

    for (int i = lo; i <= hi; i++) {
      count[charAt(a[i], d)+2]++;
    }

    for (int i = 0; i < r+1; i++) {
      count[i+1] += count[i];
    }

    for (int i = lo; i <= hi; i++) {
      temp[count[charAt(a[i], d)+1]++] = a[i];
    }

    for (int i = lo; i <= hi; i++) {
      a[i] = temp[i - lo];
    }

    for (int k = 0; k < r; k++) {
      sort(a, lo + count[k], lo + count[k+1] - 1, d + 1);
    }
  }
}
