/**
 * Copyright (c) 2018 Quincy Liang
 * Under the MIT license
 */

package com.github.deltaquincy.algorithms.string;

/**
 * LeastSignificantDigitFirstStringSorting
 */
public class LeastSignificantDigitFirstStringSorting {
  public static void sort(String[] a, int w) {  // w for digits
    int n = a.length;
    int r = 256;  // For ASCII
    String[] temp = new String[n];

    for (int d = w-1; d >= 0; d--) {
      int[] count = new int[r+1];
      
      for (int i = 0; i < n; i++) {
        count[a[i].charAt(d)+1]++;
      }

      for (int i = 0; i < r; i++) {
        count[i+1] += count[i];
      }

      for (int i = 0; i < n; i++) {
        temp[count[a[i].charAt(d)]++] = a[i];
      }

      for (int i = 0; i < n; i++) {
        a[i] = temp[i];
      }
    }
    
  }
}
