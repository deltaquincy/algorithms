/*
 * Copyright 2018 Quincy Liang
 *
 * Project Algorithms. A repository of my algorithms learning.
 * Licensed under the MIT license.
 */

package com.github.deltaquincy.algorithms;

import org.junit.Test;
import static org.junit.Assert.assertTrue;

import com.github.deltaquincy.algorithms.Main;

public class MainTest {
  @Test
  public void testMainIsReadyForTesting() {
    assertTrue("Main class should be ready for testing.",
    Main.readyForTesting());
  }
}
