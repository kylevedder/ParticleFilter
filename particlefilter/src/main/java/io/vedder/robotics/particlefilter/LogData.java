package io.vedder.robotics.particlefilter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import io.vedder.robotics.particlefilter.messages.BaseMessage;
import io.vedder.robotics.particlefilter.messages.InitMessage;
import io.vedder.robotics.particlefilter.messages.MessageType;
import io.vedder.robotics.particlefilter.messages.OdomMessage;
import io.vedder.robotics.particlefilter.messages.SensorMessage;

public class LogData {
  private final List<BaseMessage> data;

  public LogData(final String logPath) {
    try (Stream<String> stream = Files.lines(Paths.get(logPath))) {
      data = stream.map(l -> {
        List<String> elements = Arrays.asList(l.split(" "));
        switch (elements.get(0)) {
          case "L": {
            final double timeSinceEpoch = Double.parseDouble(elements.get(1));
            final int numberOfScanRays = Integer.parseInt(elements.get(2));
            final double minAngle = Double.parseDouble(elements.get(3));
            final double maxAngle = Double.parseDouble(elements.get(4));
            final double angleIncrement = Double.parseDouble(elements.get(5));
            List<Double> scanRays = elements.subList(6, elements.size()).stream()
                .map(s -> Double.parseDouble(s)).collect(Collectors.toList());
            return new BaseMessage(MessageType.SENSOR, null, new SensorMessage(timeSinceEpoch,
                numberOfScanRays, minAngle, maxAngle, angleIncrement, scanRays), null);
          }
          case "O": {
            final double timeSinceEpoch = Double.parseDouble(elements.get(1));
            final double xOdom = Double.parseDouble(elements.get(2));
            final double yOdom = Double.parseDouble(elements.get(3));
            final double angleOdom = Double.parseDouble(elements.get(4));
            return new BaseMessage(MessageType.ODOM,
                new OdomMessage(timeSinceEpoch, xOdom, yOdom, angleOdom), null, null);
          }
          case "I": {
            final double x = Double.parseDouble(elements.get(2));
            final double y = Double.parseDouble(elements.get(3));
            final double angle = Double.parseDouble(elements.get(4));
            return new BaseMessage(MessageType.INIT, null, null, new InitMessage(x, y, angle));
          }
          default:
            throw new IllegalStateException("Unknown type '" + elements.get(0) + "'");
        }
      }).collect(Collectors.toList());
    } catch (IOException e) {
      throw new IllegalStateException("Cannot open Map!");
    }
     System.out.println("Read " + data.size() + " commands!");
  }

  public List<BaseMessage> getData() {
    return data;
  }
}
