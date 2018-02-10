/**
 * Copyright (c) 2018 Quincy Liang
 * Under the MIT license
 */

package com.github.deltaquincy.algorithms.searching;

/**
 * SymbolTable
 */
public interface SymbolTable<K extends Comparable<K>, V> {
  boolean isEmpty(K key);
  boolean contains(K key);
  int size();

  V get(K key);
  void put(K key, V value);
  void delete(K key);

  K max();
  K min();

  Iterable<K> keys();
}
