package io.vedder.robotics.particlefilter;

public class Pose {
  private final double x;
  private final double y;
  private final double theta;

  public Pose(double x, double y, double theta) {
    this.x = x;
    this.y = y;
    this.theta = angleMod(theta);
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

  public static double angleMod(final double angle) {
    if (angle > Math.PI) {
      return (angle - Math.PI) % 2 * Math.PI - Math.PI;
    } else if (angle < -Math.PI) {
      return Math.PI - Math.abs((angle + Math.PI) % (2 * Math.PI));
    }
    return angle;
  }

  public Pose addPose(final Pose other) {
    return new Pose(this.getX() + other.getX(), this.getY() + other.getY(),
        angleMod(this.getTheta() + other.getTheta()));
  }

  @Override
  public String toString() {
    return "Pose [x=" + x + ", y=" + y + ", theta=" + theta + "]";
  }
  
  
}
