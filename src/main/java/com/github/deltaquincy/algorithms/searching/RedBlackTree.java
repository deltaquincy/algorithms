/**
 * Copyright (c) 2018 Quincy Liang
 * Under the MIT license
 */

package com.github.deltaquincy.algorithms.searching;

/**
 * RedBlackTree
 */
public class RedBlackTree<K extends Comparable<K>, V> /* implements SymbolTable<K, V> */ {
  private static final boolean RED = true;
  private static final boolean BLACK = false;

  private Node root;

  private class Node {
    K key;
    V value;
    boolean color;
    int size = 1;
    Node left = null;
    Node right = null;

    Node(K k, V v, boolean c) {
      key = k;
      value = v;
      color = c;
    }
  }

  private boolean isRed(Node x) {
    if (x == null) {
      return false;
    } else {
      return x.color == RED;
    }
  }

  public int size() {
    return size(root);
  }

  private int size(Node x) {
    if (x == null) {
      return 0;
    } else {
      return x.size;
    }
  }

  private Node rotateLeft(Node x) {
    Node y = x.right;
    x.right = x.left;
    y.left = x;
    y.color = x.color;
    x.color = RED;
    y.size = x.size;
    x.size = size(x.left) + size(x.right) + 1;
    return y;
  }

  private Node rotateRight(Node x) {
    Node y = x.left;
    x.left = y.right;
    y.right = x;
    y.color = x.color;
    x.color = RED;
    y.size = x.size;
    x.size = size(x.left) + size(x.right) + 1;
    return y;
  }

  private void flipColors(Node x) {
    x.color = RED;
    x.left.color = BLACK;
    x.right.color = BLACK;
  }

  public V get(K key) {
    return get(root, key);
  }

  private V get(Node x, K key) {
    if (x == null) {
      return null;
    }
    int compareValue = key.compareTo(x.key);
    if (compareValue < 0) {
      return get(x.left, key);
    } else if (compareValue > 0) {
      return get(x.right, key);
    } else {
      return x.value;
    }
  }

  public void put(K key, V value) {
    root = put(root, key, value);
    root.color = BLACK;
  }

  private Node put(Node x, K key, V value) {
    if (x == null) {
      return new Node(key, value, RED);
    }
    int compareValue = key.compareTo(x.key);
    if (compareValue < 0) {
      x.left = put(x.left, key, value);
    } else if (compareValue > 0) {
      x.right = put(x.right, key, value);
    } else {
      x.value = value;
    }
    if (isRed(x.right) && !isRed(x.left)) {
      x = rotateLeft(x);
    }
    if (isRed(x.left) && isRed(x.left.left)) {
      x = rotateRight(x);
    }
    if (isRed(x.left) && isRed(x.right)) {
      flipColors(x);
    }
    x.size = size(x.left) + size(x.right) + 1;
    return x;
  }
}
