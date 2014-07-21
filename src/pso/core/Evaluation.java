package pso.core;

/** 
 * Any evaluation function should implement this interface. The return 
 * value of evaluate() is fitness and should be the bigger the better.
 */
public interface Evaluation {
  public double evaluate(double[] coordinate);
}
