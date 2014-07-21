package pso.example;

import pso.core.Point;
import pso.core.TVPSO;

/** An example of how to use PSO for optimization */
public class Example {
  public static void main(String args[]) {
    long t1 = System.currentTimeMillis();
    TVPSO pso = new TVPSO(-5, 5, 2, 200, 2000);
    Point optimal = pso.optimize(new Functions.Beale());
    long t2 = System.currentTimeMillis();

    System.out.println("Minimum: " + optimal.getOptimal(true) + "\nPositions:");
    for (int i = 0; i < optimal.getPosition().length; ++i) 
      System.out.println(optimal.getPosition()[i]);
    System.out.println("Time used " + (t2 - t1) + " ms.");
  }

}
