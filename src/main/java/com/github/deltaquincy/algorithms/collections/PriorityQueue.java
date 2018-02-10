/**
 * Copyright (c) 2018 Quincy Liang
 * Under the MIT license
 */

package com.github.deltaquincy.algorithms.collections;

/**
 * PriorityQueue
 */
public class PriorityQueue<T extends Comparable<T>> extends BinaryHeap<T> {

  public PriorityQueue() {
    super();
  }

  public PriorityQueue(int initialCapacity) {
    super(initialCapacity);
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
}
