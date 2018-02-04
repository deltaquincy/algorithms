/**
 * Copyright (c) 2018 Quincy Liang
 * Under the GPL v3 license
 */

package com.github.deltaquincy.algorithms.graphs;

public class QuickUnionUF extends AbstractUF {
    public QuickUnionUF(int N) {
        super(N);
    }

    public int find(int p) {
        while (p != id[p]) p = id[p];
        return p;
    }

    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) return;
        id[pRoot] = qRoot;
        count--;
    }
}
