package pso.core;

/**
 * A Point is a static point with position and fitness in the search space.
 */
public class Point {

  protected int dimension;
  protected double fitness;
  protected double[] position;
  
  public Point() {}
  
  /** Construct with position and fitness. */
  public Point(double[] position, double fitness) {
    this.dimension = position.length;
    this.fitness = fitness;
    this.position = new double[this.dimension];
    System.arraycopy(position, 0, this.position, 0, this.dimension);
  }
  
  /** Construct with dimension. */
  public Point(int dimension) {
    this.dimension = dimension;
    this.fitness = 0;
    this.position = new double[this.dimension];
  }
  
  /** Construct with another point. */
  public Point(Point point) {
    this(point.position, point.fitness);
  }
  
  public void setPosition(double[] position) {
    this.position = position;
  }

  /** Set position for a given dimension. */
  public void setPosition(double value, int d) {
    position[d] = value;
  }
  
  /** Get position for a given dimension. */
  public double getPosition(int d) {
    return position[d];
  }
  
  public double[] getPosition() {
    return position;
  }

  public void setFitness(double fitness) {
    this.fitness = fitness;
  }

  public double getFitness() {
    return fitness;
  }
  
  /** Get optimal minimum/maximum value. */
  public double getOptimal(boolean minimize) {
    return (minimize ? -fitness : fitness);
  }
  
  public double getDimension() {
    return dimension;
  }
  
  public void copyFrom(double[] position, double fitness) {
    this.fitness = fitness;
    System.arraycopy(position, 0, this.position, 0, this.dimension);
  }
  
  public void copyFrom(Point point) {
    this.fitness = point.fitness;
    System.arraycopy(point.position, 0, this.position, 0, this.dimension);
  }
}
