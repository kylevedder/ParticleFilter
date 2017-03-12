package io.vedder.robotics.particlefilter.messages;

public class BaseMessage {
    final MessageType messageType;
    final OdomMessage odomMessage;
    final SensorMessage sensorMessage;
    final InitMessage initMessage;
    
    public BaseMessage(MessageType messageType, OdomMessage odomMessage, SensorMessage sensorMessage, 
        InitMessage initMessage) {
      this.messageType = messageType;
      this.odomMessage = odomMessage;
      this.sensorMessage = sensorMessage;
      this.initMessage = initMessage;
    }

    public MessageType getMessageType() {
      return messageType;
    }
    
    public InitMessage getInitMessage() {
      return initMessage;
    }

    public OdomMessage getOdomMessage() {
      return odomMessage;
    }

    public SensorMessage getSensorMessage() {
      return sensorMessage;
    }
}
