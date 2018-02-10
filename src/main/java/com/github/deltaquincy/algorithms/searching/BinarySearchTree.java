/**
 * Copyright (c) 2018 Quincy Liang
 * Under the MIT license
 */

package com.github.deltaquincy.algorithms.searching;

/**
 * BinarySearchTree
 */
public class BinarySearchTree<K extends Comparable<K>, V> /* implements SymbolTable<K, V> */ {
  private Node root;

  private class Node {
    K key;
    V value;
    int size = 1;
    Node left = null;
    Node right = null;

    Node(K k, V v) {
      key = k;
      value = v;
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
  }

  private Node put(Node x, K key, V value) {
    if (x == null) {
      return new Node(key, value);
    }
    int compareValue = key.compareTo(x.key);
    if (compareValue < 0) {
      x.left = put(x.left, key, value);
    } else if (compareValue > 0) {
      x.right = put(x.right, key, value);
    } else {
      x.value = value;
    }
    x.size = size(x.left) + size(x.right);
    return x;
  }
}
