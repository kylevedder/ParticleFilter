package io.vedder.robotics.particlefilter;

public class MapWall {
  private final Vector2d point1, point2;

  public MapWall(Vector2d point1, Vector2d point2) {
    this.point1 = point1;
    this.point2 = point2;
  }

  public Vector2d getPoint1() {
    return point1;
  }

  public Vector2d getPoint2() {
    return point2;
  }
}
