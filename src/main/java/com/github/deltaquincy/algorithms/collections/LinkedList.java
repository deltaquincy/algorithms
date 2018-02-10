/**
 * Copyright (c) 2018 Quincy Liang
 * Under the MiT license
 */

package com.github.deltaquincy.algorithms.collections;

import java.util.Iterator;

/**
 * 可迭代的泛型链表数据结构。
 * 
 * 主要是为栈、背包、队列等数据结构的实现提供基础。它包含一个链表节点的嵌套类，
 * 实现了获取链表大小、判断链表是否为空的方法，并且实现了 {@code Iterable} 接口。
 * 但它不提供任何可以改变链表内容的接口，而由以它为基础的数据结构提供。
 */
class LinkedList<T> implements Iterable<T> {
  /** 链表的首节点 */
  Node first;
  /** 链表的大小 */
  int size;

  /** 该实现省略了链表构造器，不允许外部直接实例化该类，由以它为基础的数据结构提供链表功能。*/
  LinkedList() {}
  
  /**
   * 链表节点嵌套类。
   * 
   * 这个嵌套类表示了链表中的节点，每个节点都包含着一个内容对象和一个指向另一个节点的指针。
   */
  class Node {
    T item;
    Node next;

    /** 空链表节点构造器，得到的是内容和指针均为空的链表节点。 */
    Node() {
      item = null;
      next = null;
    }

    /**
     * 链表节点的构造器，得到的是包含内容对象以及一个空指针的链表节点。
     * 
     * @param item 新链表节点的内容对象
     */
    Node(T item) {
      this.item = item;
      this.next = null;
    }
    
    /**
     * 链表节点的构造器，得到的是包含内容对象以及一个指针的链表节点。
     * 
     * @param item 新链表节点的内容对象
     * @param next 改节点所要指向的节点
     */
    Node(T item, Node next) {
      this.item = item;
      this.next = next;
    }
  }

  /** 
   * 取得链表的大小。
   * 
   * @return 链表的大小
   */
  public int getSize() {
    return size;
  }

  /**
   * 判断链表是否为空。
   * 
   * @return 链表为空则返回 {@code true}，否则返回 {@code false}
   */
  public boolean isEmpty() {
    return size == 0;
  }

  /** 
   * 实现了 Iterable 接口，返回一个从表头到表尾的迭代器。
   * 
   * @see java.lang.Iterable
   * @see java.util.Iterator
   * 
   * @return 从表头到表尾的链表迭代器
   */
  public Iterator<T> iterator() {
    return new LinkedListIterator();
  }

  // 链表迭代器嵌套类，实现 Iterator 接口
  private class LinkedListIterator implements Iterator<T> {
    private Node current = first;

    public boolean hasNext() {
      return current != null;
    }

    // 该迭代器省略了 remove 方法，以防迭代过程中对对象内容作出更改。
    public void remove() {}

    public T next() {
      T item = current.item;
      current = current.next;
      return item;
    }
  }
}
