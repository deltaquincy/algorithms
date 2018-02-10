/**
 * Copyright (c) 2018 Quincy Liang
 * Under the MIT license
 */

package com.github.deltaquincy.algorithms.collections;

import java.util.ArrayList;

/**
 * BinaryHeap
 */
public class BinaryHeap<T extends Comparable<T>> {
  private ArrayList<T> heap;
  private int size = 0;

  public BinaryHeap() {
    this(10);
  }
  
  public BinaryHeap(int initialCapacity) {
    heap = new ArrayList<T>(initialCapacity);
    heap.add(0, null);
  }
  
  public boolean isEmpty() {
    return size == 0;
  }

  public int size() {
    return size;
  }

  public void insert(T item) {
    heap.add(item);
    swim(++size);
  }

  public T deleteMax() {
    T maxItem = heap.get(1);
    exchange(1, size--);
    heap.set(size+1, null);
    sink(1);
    return maxItem;
  }

  private void swim(int k) {
    while (k > 1 && isLess(k/2, k)) {
      exchange(k/2, k);
      k /= 2;
    }
  }

  private void sink(int k) {
    while (2 * k <= size) {
      int j = 2 * k;
      if (j < size && isLess(j, j+1)) {
        j++;
      }
      if (!isLess(k, j)) {
        break;
      }
      exchange(k, j);
      k = j;
    }
  }

  private boolean isLess(int i, int j) {
    return heap.get(i).compareTo(heap.get(j)) < 0;
  }

  private void exchange(int i, int j) {
    T temp = heap.get(i);
    heap.set(i, heap.get(j));
    heap.set(j, temp);
  }
}
