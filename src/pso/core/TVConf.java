package pso.core;

/**
 * Configuration of Time Variant PSO.
 */
public class TVConf {

  public double C1_B = 2.5;
  public double C1_E = 0.5;
  public double C2_B = 0.5;
  public double C2_E = 2.5;
  public double W_B = 0.9;
  public double W_E = 0.4;

  TVConf() {}
  
  TVConf(double c1_b, double c1_e, double c2_b, double c2_e, 
      double w_b, double w_e) {
    C1_B = c1_b;
    C1_E = c1_e;
    C2_B = c2_b;
    C2_E = c2_e;
    W_B = w_b;
    W_E = w_e;
  }
  
  public void setConf(double c1_b, double c1_e, double c2_b, double c2_e, 
      double w_b, double w_e) {
    C1_B = c1_b;
    C1_E = c1_e;
    C2_B = c2_b;
    C2_E = c2_e;
    W_B = w_b;
    W_E = w_e;
  }

  public void setConf(TVConf tvconf) {
    setConf(tvconf.C1_B, tvconf.C1_E, tvconf.C2_B, tvconf.C2_E, 
        tvconf.W_B, tvconf.W_E);
  }
}
