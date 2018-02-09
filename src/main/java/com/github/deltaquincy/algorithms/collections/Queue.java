/**
 * Copyright (c) 2018 Quincy Liang
 * Under the MIT license
 */

package com.github.deltaquincy.algorithms.collections;

import java.util.NoSuchElementException;

/**
 * 队列数据结构。
 * 
 * 栈描述了一个先进先出（FIFO）的数据结构，包含元素入列（push）和元素出列（pop）两个主要方法。
 * 这个类使用了链表结构来实现队列。
 */
public class Queue<T> extends LinkedList<T> {
  /** 队列结构需要指向队列末尾的指针。 */
  private Node last;
  
  /**
   * 队列的初始化构造器。
   * 
   * 该构造器将构造一个空队列。
   */
  public Queue() {
    first = null;
    last = null;
    size = 0;
  }
  
  /**
   * 接受一个初始元素数组的队列构造器。
   * 
   * 该构造器将按照数组的迭代顺序将元素入列到新队列中。
   * 
   * @param items 队列的初始元素的数组
   */
  public Queue(T[] items) {
    first = null;
    last = null;
    size = 0;
    for (T i : items) {
      enqueue(i);
    }
  }

  /**
   * 将元素入列。
   * 
   * @param item 将要加入队列的元素
   */
  public void enqueue(T item) {
    Node temp = last;
    last = new Node(item);
    // 注意在队列中有 first 和 last 两个指针，当队列仅有一个元素时，
    // 就要保持两个指针指向同一个节点。
    if (isEmpty()) {
      first = last;
    } else {
      temp.next = last;
    }
    size++;
  }

  /**
   * 将元素出列。
   * 
   * @return 最初加入队列的元素
   * @throws NoSuchElementException 若对空队列进行出列操作，将导致下溢异常。
   */
  public T dequeue() throws NoSuchElementException {
    if (isEmpty()) {
      throw new NoSuchElementException("The queue is empty.");
    }
    T item = first.item;
    first = first.next;
    size--;
    if (isEmpty()) {
      first = null;
      last = null;
    }
    return item;
  }
}
