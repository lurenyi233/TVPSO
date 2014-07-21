package pso.core;

/**
 * A Particle is a moving point with velocity in the search space. 
 * It keeps a record of its previous position where it generated
 * the highest fitness so far.
 */
public class Particle extends Point {

  protected double[] velocity;
  protected Point localBest;
  
  public Particle() {}
  
  /** Construct with another particle. */
  public Particle(Particle particle) {
    super(particle.position, particle.fitness);
    this.localBest = new Point(particle.localBest);
    this.velocity = new double[particle.dimension];
    System.arraycopy(particle.velocity, 0, this.velocity, 0, this.dimension);
  }
  
  /** Construct with dimension. */
  public Particle(int dimension) {
    super(dimension);
    this.velocity = new double[dimension];
    this.localBest = new Point(dimension);
  }
  
  public void setVelocity(double[] velocity) {
    this.velocity = velocity;
  }
  
  /** Set velocity for a given dimension. */
  public void setVelocity(double vel, int d) {
    velocity[d] = vel;
  }
  
  /** Get velocity for a given dimension. */
  public double getVelocity(int d) {
    return velocity[d];
  }
  
  public double[] getVelocity() {
    return velocity;
  }
  
  public void setLocalBest(Point localBest) {
    this.localBest = localBest;
  }
  
  public Point getLocalBest() {
    return localBest;
  }
  
}
