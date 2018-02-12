/**
 * Copyright (c) 2018 Quincy Liang
 * Under the MIT license
 */

package com.github.deltaquincy.algorithms.string;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class LeastSignificantDigitFirstStringSortingTest {
  private String[] list = {
    "4PGC938",
    "2IYE230",
    "3CIO720",
    "1ICK750",
    "1OHV845",
    "4JZY524",
    "1ICK750",
    "3CIO720",
    "1OHV845",
    "1OHV845",
    "2RLA629",
    "2RLA629",
    "3ATW723"
  };

  private String[] check = {
    "1ICK750",
    "1ICK750",
    "1OHV845",
    "1OHV845",
    "1OHV845",
    "2IYE230",
    "2RLA629",
    "2RLA629",
    "3ATW723",
    "3CIO720",
    "3CIO720",
    "4JZY524",
    "4PGC938",    
  };

  @Test
  public void testStringSort() {
    LeastSignificantDigitFirstStringSorting.sort(list, 7);
    assertThat(list).isEqualTo(check);
  }
  
}
