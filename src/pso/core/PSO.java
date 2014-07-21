package pso.core;

import java.util.Random;

/** Abstract base class for Particle Swarm OPtimization. */
public abstract class PSO {

  protected int dimension;
  protected int swarmSize;
  protected int maxIteration;
  
  protected Particle[] swarm;
  protected Point globalBest;
  protected double[][] bounds;

  protected Random random = new Random();
  
  public abstract Point optimize(Evaluation eval);
}
