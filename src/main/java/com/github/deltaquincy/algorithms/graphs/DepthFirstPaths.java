/**
 * Copyright (c) 2018 Quincy Liang
 * Under the MIT license
 */

package com.github.deltaquincy.algorithms.graphs;

import java.util.Stack;

public class DepthFirstPaths {
  private boolean[] marked;
  private int[] edgeTo;
  private final int s;

  public DepthFirstPaths(Graph graph, int s) {
    marked = new boolean[graph.vertex()];
    edgeTo = new int[graph.vertex()];
    this.s = s;
    dfs(graph, s);
  }

  private void dfs(Graph graph, int v) {
    marked[v] = true;
    for (int w : graph.connections(v)) {
      if (!marked[w]) {
        edgeTo[w] = v;
        dfs(graph, w);
      }
    }
  }

  public boolean hasPathTo(int v) {
    return marked[v];
  }

  public Iterable<Integer> pathTo(int v) {
    if (!hasPathTo(v)) {
      return null;
    }
    Stack<Integer> path = new Stack<Integer>();
    for (int x = v; x != s; x = edgeTo[x]) {
      path.push(x);
    }
    path.push(s);
    return path;
  }
}
