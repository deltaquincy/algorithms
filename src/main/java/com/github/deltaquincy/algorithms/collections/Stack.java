/**
 * Copyright (c) 2018 Quincy Liang
 * Under the MIT license
 */

package com.github.deltaquincy.algorithms.collections;

import java.util.NoSuchElementException;

/**
 * 栈数据结构。
 * 
 * 栈描述了一个后进先出（LIFO）的数据结构，包含压入元素（push）和弹出元素（pop）两个主要方法。
 * 这个类使用了链表结构来实现栈。
 */ 
public class Stack<T> extends LinkedList<T> {

  /**
   * 栈的初始化构造器。
   * 
   * 该构造器将构造一个空栈。
   */
  public Stack() {
    first = null;
    size = 0;
  }

  /**
   * 接受一个初始元素数组的栈构造器。
   * 
   * 该构造器将按照数组的迭代顺序将元素压入新栈中。
   * 
   * @param items 栈的初始元素的数组
   */
  public Stack(T[] items) {
    this();
    for (T i : items) {
      push(i);
    }
  }

  /**
   * 将元素压入栈。
   * 
   * @param item 将要压入栈的元素
   */
  public void push(T item) {
    first = new Node(item, first);
    size++;
  }

  /**
   * 弹出最近压入栈的元素。
   * 
   * @return 最近压入栈的元素
   * @throws NoSuchElementException 若对空栈进行弹栈操作，将导致下溢异常。
   */
  public T pop() throws NoSuchElementException {
    if (isEmpty()) {
      throw new NoSuchElementException("The stack is empty.");
    }
    T item = first.item;
    first = first.next;
    size--;
    return item;
  }
}
