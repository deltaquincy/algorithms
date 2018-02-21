/**
 * Copyright (c) 2018 Quincy Liang
 * Under the MIT license
 */

package com.github.deltaquincy.algorithms.graphs;

import com.github.deltaquincy.algorithms.collections.Queue;
import com.github.deltaquincy.algorithms.collections.Stack;

public class BreadthFirstPaths {
  private boolean[] marked;
  private int[] edgeTo;
  private final int s;

  public BreadthFirstPaths(Graph graph, int s) {
    marked = new boolean[graph.vertex()];
    edgeTo = new int[graph.vertex()];
    this.s = s;
    bfs(graph, s);
  }

  private void bfs(Graph graph, int s) {
    Queue<Integer> queue = new Queue<Integer>();
    marked[s] = true;
    while (!queue.isEmpty()) {
      int v = queue.dequeue();
      for (int w : graph.connections(v)) {
        if (!marked[w]) {
          edgeTo[w] = v;
          marked[w] = true;
          queue.enqueue(w);
        }
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
