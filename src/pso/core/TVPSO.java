package pso.core;

/**
 * Time variant particle swarm optimization.
 */
public class TVPSO extends PSO {

  private TVConf tvconf;

  private double c1;
  private double c2;
  private double w;

  private TVPSO(int dimension, int swarmSize, int maxIteration) {
    this.dimension = dimension;
    this.swarmSize = swarmSize;
    this.maxIteration = maxIteration;

    swarm = new Particle[swarmSize];
    for (int i = 0; i < swarmSize; ++i)
      swarm[i] = new Particle(dimension);
    globalBest = new Point(dimension);
    
    tvconf = new TVConf();
  }

  public TVPSO(double lowerBound, double upperBound, 
               int dimension, int swarmSize, int maxIteration) {
    this(dimension, swarmSize, maxIteration);
    bounds = new double[dimension][2];
    for (int i = 0; i < dimension; ++i) {
      bounds[i][0] = lowerBound;
      bounds[i][1] = upperBound;
    }
  }
  
  public TVPSO(double[][] bounds, int dimension, int swarmSize, int maxIter) {
    this(dimension, swarmSize, maxIter);
    this.bounds = new double[dimension][2];
    for (int i = 0; i < dimension; ++i) {
      this.bounds[i][0] = bounds[i][0];
      this.bounds[i][1] = bounds[i][1];
    }
  }
  
  /** Initialization of swarm */
  private void initialize(Evaluation eval) {
    int gbest = 0;
    for (int i = 0; i < swarmSize; ++i) {
      for (int j = 0; j < dimension; ++j) {
        double width = bounds[j][1] - bounds[j][0];
        swarm[i].position[j] = width * random.nextDouble() + bounds[j][0];
        double minVel = bounds[j][0] - swarm[i].position[j];
        double maxVel = bounds[j][1] - swarm[i].position[j];
        swarm[i].velocity[j] = (maxVel - minVel) * random.nextDouble() + minVel;
      }
      swarm[i].fitness = eval.evaluate(swarm[i].position);
      swarm[i].localBest.copyFrom(swarm[i].position, swarm[i].fitness);
      if (swarm[i].fitness > swarm[gbest].fitness)
        gbest = i;
    }
    globalBest.copyFrom(swarm[gbest]);
  }

  /** Update PSO coefficients with iteration. */
  private void updateParams(int iteration) {
    c1 = (tvconf.C1_E - tvconf.C1_B) * iteration / maxIteration + tvconf.C1_B;
    c2 = (tvconf.C2_E - tvconf.C2_B) * iteration / maxIteration + tvconf.C2_B;
    w = (tvconf.W_E - tvconf.W_B) * iteration / maxIteration + tvconf.W_B;
  }

  /** Update swarm with iteration. */
  private void update(Evaluation eval, int iteration) {
    updateParams(iteration);

    int gbest = -1;
    for (int i = 0; i < swarmSize; ++i) {
      for (int j = 0; j < dimension; ++j) {
        double r1 = random.nextDouble();
        double r2 = random.nextDouble();
        
        double vel = swarm[i].velocity[j] * w;
        double local = swarm[i].localBest.position[j] - swarm[i].position[j];
        double global = globalBest.position[j] - swarm[i].position[j];
        swarm[i].velocity[j] = vel + local * c1 * r1 + global * c2 * r2;
        
        double oldPos = swarm[i].position[j];
        swarm[i].position[j] = swarm[i].position[j] + swarm[i].velocity[j];
        
        if (swarm[i].position[j] < bounds[j][0] || 
            swarm[i].position[j] > bounds[j][1]) {
          double r = random.nextDouble();
          swarm[i].velocity[j] = (swarm[i].position[j] < bounds[j][0]
              ? (bounds[j][0] - oldPos) * r : (bounds[j][1] - oldPos) * r);
          swarm[i].position[j] = oldPos + swarm[i].velocity[j];
        }
      }
      
      swarm[i].fitness = eval.evaluate(swarm[i].position);
      
      if (swarm[i].fitness > swarm[i].localBest.fitness) {
        swarm[i].localBest.copyFrom(swarm[i]);
        if (swarm[i].fitness > globalBest.fitness) {
          globalBest.fitness = swarm[i].fitness;
          gbest = i;
        }
      }
    }
    
    if (gbest >= 0)
      globalBest.copyFrom(swarm[gbest]);
  }
  
  /** Optimization with given evaluation function. */
  public Point optimize(Evaluation eval) {
    initialize(eval);
    for (int i = 0; i < maxIteration; ++i)
      update(eval, i);
    return globalBest;
  }
  
  /** Optimization with given evaluation function and configuration. */
  public Point optimize(Evaluation eval, TVConf tvconf) {
    configure(tvconf);
    initialize(eval);
    for (int i = 0; i < maxIteration; ++i)
      update(eval, i);
    return globalBest;
  }
  
  public void configure(TVConf tvconf) {
    this.tvconf.setConf(tvconf);
  }
  
  public void configure(double c1_b, double c1_e, double c2_b, double c2_e, 
      double w_b, double w_e) {
    this.tvconf.setConf(c1_b, c1_e, c2_b, c2_e, w_b, w_e);
  }
}