/**
 * Copyright (c) 2018 Quincy Liang
 * Under the GPL v3 license
 */

package com.github.deltaquincy.algorithms.graphs;

public class WeightedQuickUnionUF extends AbstractUF {
  private int[] sz;

  public WeightedQuickUnionUF(int N) {
    super(N);
    sz = new int[N];
    for (int i = 0; i < N; i++) {
      sz[i] = i;
    }
  }

  public int find(int p) {
    while (p != id[p]) p = id[p];
    return p;
  }

  public void union(int p, int q) {
    int i = find(p);
    int j = find(q);
    if (i == j) return;
    if (sz[i] < sz[j]) {
      id[i] = id[j];
      sz[j] += sz[i];
    } else {
      id[j] = id[i];
      sz[i] += sz[j];
    }
    count--;
  }
}
