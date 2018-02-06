/**
 * Copyright (c) 2018 quincy Liang
 * Under the GPL v3 license
 */

package com.github.deltaquincy.algorithms.graphs;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;

public class Graph {
  private final int V;
  private int E;
  private Bag<Integer>[] adj;

  public Graph(int V) {
    this.V = V;
    this.E = 0;
    adj = (Bag<Integer>[]) new Bag[V];
    for (int v = 0; v < V; v++) {
      adj[v] = new Bag<Integer>();
    }
  }

  public Graph(In in) {
    this(in.readInt());
    int E = in.readInt();
    for (int i = 0; i < E; i++) {
      int v = in.readInt();
      int w = in.readInt();
      addEdge(v, w);
    }
  }

  public int V() {
    return V;
  }

  public int E() {
    return E;
  }

  public void addEdge(int v, int w) {
    adj[v].add(w);
    adj[w].add(v);
    E++;
  }

  public Iterable<Integer> adj(int v) {  // 抽象等级选了 Iterable 而不是 Bag
    return adj[v];
  }

  public String toString() {
    String s = V + " vertices, " + E + " edges\n";
    for (int v = 0; v < V; v++) {
      s += v + ": ";
      for (int w : this.adj(v)) {
        s += w + " ";
      }
      s += "\n";
    }
    return s;
  }
}
