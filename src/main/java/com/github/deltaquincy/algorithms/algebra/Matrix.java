/**
 * Copyright (c) 2018 Quincy Liang
 * Under the MIT license
 */

package com.github.deltaquincy.algorithms.algebra;

/**
 * Exercise 1.1.33 - Matrix Library
 * 
 * @author Quincy Liang
 */
public class Matrix {

  /**
   * Returns product of two vectors.
   * 
   * @param x vector 1
   * @param y vector 2
   * @return product of two vectors
   * @throws IllegalArgumentException when lengths of two arrays are not equal.
   */
  public static double dot(double[] x, double[] y) throws IllegalArgumentException {
    if (x.length != y.length) {
      throw new IllegalArgumentException("Lengths of two arrays are not equal.");
    }
    double dotResult = 0;
    for (int i = 0; i < x.length; i++) {
      dotResult += x[i] * y[i];
    }
    return dotResult;
  }

  /**
   * Returns matrix multiplication of two 2D arrays.
   * 
   * @param a matrix 1
   * @param b matrix 2
   * @return matrix multiplication of two 2D arrays
   * @throws IllegalArgumentException when shapes are not appropriate.
   */
  public static double[][] mult(double[][] a, double[][] b) throws IllegalArgumentException {
    if (a[0].length != b.length) {
      throw new IllegalArgumentException("Shapes are not appropriate");
    }
    double[][] multResult = new double[a.length][b[0].length];
    for (int i = 0; i < a.length; i++) {
      for (int j = 0; j < b[0].length; j++) {
        for (int k = 0; k < a[0].length; k++) {
          multResult[i][j] += a[i][k] * b[k][j];
        }
      }
    }
    return multResult;
  }

  /**
   * Returns the transpose of a matrix.
   * 
   * @param a matrix
   * @return transpose of the matrix
   */
  public static double[][] transpose(double[][] a) {
    int n = a.length;
    int m = a[0].length;
    double[][] transposeResult = new double[m][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        transposeResult[j][i] = a[i][j];
      }
    }
    return transposeResult;
  }

  /**
   * Returns multiplication of a matrix and a vector.
   * 
   * @param a the matrix
   * @param x the vector
   * @return multiplication of a matrix and a vector
   * @throws IllegalArgumentException when shapes are not appropriate.
   */
  public static double[] mult(double[][] a, double[] x) throws IllegalArgumentException {
    if (a[0].length != x.length) {
      throw new IllegalArgumentException("Shapes are not appropriate");
    }
    double[][] xWrapped = {x};
    xWrapped = transpose(xWrapped);
    double[] multResult = transpose(mult(a, xWrapped))[0];
    return multResult;
  }
  
  /**
   * Returns multiplication of a vector and a matrix.
   * 
   * @param y the vector
   * @param a the matrix
   * @return multiplication of a matrix and a vector
   * @throws IllegalArgumentException when shapes are not appropriate.
   */
  public static double[] mult(double[] y, double[][] a) throws IllegalArgumentException {
    if (a.length != y.length) {
      throw new IllegalArgumentException("Shapes are not appropriate");
    }
    double[][] yWrapped = {y};
    double[] multResult = mult(yWrapped, a)[0];
    return multResult;
  }
}
