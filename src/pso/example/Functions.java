package pso.example;

import pso.core.Evaluation;

/**
 * A collection of example functions to be optimized.  
 */
public class Functions {
  
  public static class Sphere implements Evaluation {
    public double evaluate(double[] coordinate) {
      double value = 0;
      for (int i = 0; i < coordinate.length; ++i)
        value += coordinate[i] * coordinate[i];
      return -value;
    }
  }
  
  public static class Beale implements Evaluation {
    public double evaluate(double[] coordinate) {
      double x = coordinate[0];
      double y = coordinate[1];
      
      double v = x * y;
      double v1 = 1.5 - x + v;
      v *= y;
      double v2 = 2.25 - x + v;
      v *= y;
      double v3 = 2.625 - x + v;
      return -(v1 * v1 + v2 * v2 + v3 * v3);
    }
  }
  
  public static class StyblinskiTang implements Evaluation {
    public double evaluate(double[] coordinate) {
      double v = 0;
      for (int i = 0; i < coordinate.length; ++i) {
        double p = coordinate[i] * coordinate[i];
        v += p * p - 16 * p + 5 * coordinate[i];
      }
      return -(v / 2);
    }
  }
  
}
