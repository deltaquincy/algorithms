/**
 * Copyright (c) 2018 Quincy Liang
 * Under the GPL v3 license
 */

package com.github.deltaquincy.algorithms.collections;

import java.util.Iterator;

/**
 * The <code>Stack</code> class is a <i>LIFO</i> data structure. In this
 * version, the implementation uses linked list to realize variable length
 * mechanism.
 *
 * @author Quincy Liang
 */
public class Stack<Item> implements Iterable<Item> {
  private Node first;  // Top of the stack.
  private int N;       // Length of the stack.

  // Linked list helper class.
  private class Node {
    Item item;
    Node next;
  }

  /**
   * Check if the stack is empty.
   *
   * @return true if the stack is empty, in other words, its length is 0
   */
  public boolean isEmpty() {
    return first == null;
  }

  /**
   * Get the current size of the stack.
   *
   * @return the current size, or length, of the stack
   */
  public int size() {
    return N;
  }

  /**
   * Push an item into top of the stack. This would add <code>1</code> to the
   * stack length.
   *
   * @param item the item to push into the stack
   */
  public void push(Item item) {
    Node oldfirst = first;
    first = new Node();
    first.item = item;
    first.next = oldfirst;
    N++;
  }

  /**
   * Pop an item from top of the stack. This would delete the item from the
   * stack and minus <code>1</code> to the stack length.
   *
   * @return the item just poped from the stack
   */
  public Item pop() {
    Item item = first.item;
    first = first.next;
    N--;
    return item;
  }

  /**
   * Implement the iterable interface. For <code>Stack</code>, the iteration
   * would be from the top to the bottom of the stack, corresponding to the
   * <i>LIFO</i> logic.
   *
   * @return an appropriate iterator
   *
   * @see java.lang.Iterable
   * @see java.util.Iterator
   */
  public Iterator<Item> iterator() {
    return new LinkedListStackIterator();
  }

  // Iterator helper class.
  private class LinkedListStackIterator implements Iterator<Item> {
    private Node current = first;

    public boolean hasNext() {
      return current != null;
    }

    public void remove() {}

    public Item next() {
      Item item = current.item;
      current = current.next;
      return item;
    }
  }
}
