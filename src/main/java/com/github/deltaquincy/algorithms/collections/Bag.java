/**
 * Copyright (c) 2018 Quincy Liang
 * Under the MIT license
 */

package com.github.deltaquincy.algorithms.collections;

/**
 * 背包数据结构。
 * 
 * 背包仅支持加入元素，并可以对内中元素进行迭代，但不支持删除元素，且不考虑元素顺序。
 * 这个类使用了链表结构来实现背包。
 */
public class Bag<T> extends LinkedList<T> {
  
  /**
   * 背包的初始化构造器。
   * 
   * 该构造器将构造一个空背包。
   */
  public Bag() {
    first = null;
    size = 0;
  }
  
  /**
   * 接受一个初始元素数组的背包构造器。
   * 
   * 该构造器将把数组元素添加到新背包中。
   * 
   * @param items 背包的初始元素的数组
   */
  public Bag(T[] items) {
    first = null;
    size = 0;
    for (T i : items) {
      add(i);
    }
  }

  /**
   * 将元素添加到背包中
   * 
   * @param item 将要添加到背包的元素
   */
  public void add(T item) {
    first = new Node(item, first);
    size++;
  }
}
