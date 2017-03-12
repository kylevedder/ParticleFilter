package io.vedder.robotics.particlefilter.messages;

import java.util.List;

public class SensorMessage {
  final double timeSinceEpoch;
  final int numRays;
  final double minAngle;
  final double maxAngle;
  final double angleIncrement;
  final List<Double> scanRays;

  public SensorMessage(double timeSinceEpoch, int numRays, double minAngle, double maxAngle,
      double angleIncrement, List<Double> scanRays) {
    this.timeSinceEpoch = timeSinceEpoch;
    this.numRays = numRays;
    this.minAngle = minAngle;
    this.maxAngle = maxAngle;
    this.angleIncrement = angleIncrement;
    this.scanRays = scanRays;
  }

  public double getTimeSinceEpoch() {
    return timeSinceEpoch;
  }

  public int getNumRays() {
    return numRays;
  }

  public double getMinAngle() {
    return minAngle;
  }

  public double getMaxAngle() {
    return maxAngle;
  }

  public double getAngleIncrement() {
    return angleIncrement;
  }

  public List<Double> getScanRays() {
    return scanRays;
  }
}
