/**
 * Copyright (c) 2018 Quincy Liang
 * Under the GPL v3 license
 */

package com.github.deltaquincy.algorithms.algebra;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MatrixTest {
  private double delta = 1e-6;

  private void assertMatrixEquals(double[][] actualResult, double[][] expectedResult) {
    assertEquals(expectedResult.length, actualResult.length);
    assertEquals(expectedResult[0].length, actualResult[0].length);
    for (int i = 0; i < expectedResult.length; i++) {
      assertArrayEquals(expectedResult[i], actualResult[i], delta);
    }
  }

  @Test
  public void testDot() {
    double[] x = {1, 2, 3};
    double[] y = {4, 5, 6};
    assertEquals(Matrix.dot(x, y), 32, delta);
  }

  @Test
  public void testMatrixAndMatrixMult() {
    double[][] a = {
      {1, 2, 3},
      {4, 5, 6},
      {7, 8, 9},
      {10, 11, 12}
    };
    double[][] b = {
      {0, 2, 3, 5, 7},
      {9, 4, 2, 1, 0},
      {4, 8, 3, 1, 2}
    };
    double[][] expectedResult = {
      { 30,  34,  16,  10,  13},
      { 69,  76,  40,  31,  40},
      {108, 118,  64,  52,  67},
      {147, 160,  88,  73,  94}
    };
    double[][] actualResult = Matrix.mult(a, b);
    assertMatrixEquals(actualResult, expectedResult);
  }

  @Test
  public void testTranspose() {
    double[][] a = {
      {1, 2, 3},
      {4, 5, 6},
      {7, 8, 9},
      {10, 11, 12}
    };
    double[][] expectedResult = {
      {1, 4, 7, 10},
      {2, 5, 8, 11},
      {3, 6, 9, 12}
    };
    double[][] actualResult = Matrix.transpose(a);
    assertMatrixEquals(actualResult, expectedResult);
  }

  @Test
  public void testMatrixAndVectorMult() {
    double[][] a = {
      {1, 2, 3},
      {4, 5, 6}
    };
    double[] x = {0, 1, 0};
    double[] expectedResult = {2, 5};
    assertArrayEquals(Matrix.mult(a, x), expectedResult, delta);
  }

  @Test
  public void testVectorAndMatrixMult() {
    double[][] a = {
      {1, 2, 3},
      {4, 5, 6},
      {7, 8, 9}
    };
    double[] y = {0, 1, 1};
    double[] expectedResult = {11, 13, 15};
    assertArrayEquals(Matrix.mult(y, a), expectedResult, delta);
  }
}
