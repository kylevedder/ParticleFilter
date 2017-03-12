package io.vedder.robotics.particlefilter.messages;

public class InitMessage {
  private final double x;
  private final double y;
  private final double theta;
  
  public InitMessage(double x, double y, double theta) {
    this.x = x;
    this.y = y;
    this.theta = theta;
  }

  public double getX() {
    return x;
  }

  public double getY() {
    return y;
  }

  public double getTheta() {
    return theta;
  }
}
