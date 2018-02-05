/**
 * Copyright (c) 2018 Quincy Liang
 * Under the GPL v3 license
 */

package com.github.deltaquincy.algorithms.graphs;

public class QuickFindUF extends AbstractUF {
  public QuickFindUF(int N) {
    super(N);
  }

  public int find(int p) {
    return id[p];
  }

  public void union(int p, int q) {
    int pId = find(p);
    int qId = find(q);
    if (pId == qId) return;
    for (int i = 0; i < id.length; i++) {
      if (id[i] == pId) id[i] = qId;
    }
    count--;
  }
}
