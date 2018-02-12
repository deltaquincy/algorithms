/**
 * Copyright (c) 2018 Quincy Liang
 * Under the MIT license
 */

package com.github.deltaquincy.algorithms.string;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class MostSignificantDigitFirstStringSortingTest {
  private String[] list = {
    "she",
    "sells",
    "seashells",
    "by",
    "the",
    "sea",
    "shore",
    "the",
    "shells",
    "she",
    "sells",
    "are",
    "surely",
    "seashells"
  };

  private String[] check = {
    "are",
    "by",
    "sea",
    "seashells",
    "seashells",
    "sells",
    "sells",
    "she",
    "she",
    "shells",
    "shore",
    "surely",
    "the",
    "the"    
  };

  @Test
  public void testStringSort() {
    MostSignificantDigitFirstStringSorting.sort(list);
    assertThat(list).isEqualTo(check);
  }
  
}
