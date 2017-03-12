package io.vedder.robotics.particlefilter.messages;

public class OdomMessage {
  final double timeSinceEpoch;
  final double xOdom;
  final double yOdom;
  final double angleOdom;
  public OdomMessage(double timeSinceEpoch, double xOdom, double yOdom, double angleOdom) {
    this.timeSinceEpoch = timeSinceEpoch;
    this.xOdom = xOdom;
    this.yOdom = yOdom;
    this.angleOdom = angleOdom;
  }
  public double getTimeSinceEpoch() {
    return timeSinceEpoch;
  }
  public double getXOdom() {
    return xOdom;
  }
  public double getYOdom() {
    return yOdom;
  }
  public double getAngleOdom() {
    return angleOdom;
  }  
}
