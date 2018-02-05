/**
 * Copyright (c) 2018 Quincy Liang
 * Under the GPL v3 license
 */

package com.github.deltaquincy.algorithms.utilities;

public class StopWatch {
  private final long start;

  public StopWatch() {
    start = System.currentTimeMillis();
  }

  public double elapsedTime() {
    long now = System.currentTimeMillis();
    return (now - start) / 1000.0;
  }
}
