package Abilities;

import Exceptions.SensorTypeNotCompatibleException;

public class IntelCollector extends Ability {
  private String sensorType;

  public IntelCollector(String sensorType) throws SensorTypeNotCompatibleException {
    this.setSensorType(sensorType);
  }

  public String getSensorType() {
    return sensorType;
  }

  private boolean isValidSensorType(String sensorType) {
    if (sensorType.equals("InfraRed") || sensorType.equals("Elint")) {
      return true;
    }
    return false;
  }

  public void setSensorType(String sensorType) throws SensorTypeNotCompatibleException {
    if (isValidSensorType(sensorType)) {
      this.sensorType = sensorType;
    } else {
      throw new SensorTypeNotCompatibleException("Invalid sensor type");
    }
  }
}
