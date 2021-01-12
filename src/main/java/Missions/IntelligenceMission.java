package Missions;

import Abilities.IntelCollector;
import AerialVehicles.AerialVehicle;
import Entities.Coordinates;
import Exceptions.AerialVehicleNotCompatibleException;
import Exceptions.SensorTypeNotCompatibleException;

public class IntelligenceMission extends Mission {
  private String region;

  public IntelligenceMission(
      Coordinates destination,
      String pilotName,
      AerialVehicle operatorVehicle,
      String region,
      String sensorType)
      throws AerialVehicleNotCompatibleException, SensorTypeNotCompatibleException {
    super(destination, pilotName, operatorVehicle);
    this.setSensor(sensorType);
    this.region = region;
  }

  private void setSensor(String sensorType)
      throws SensorTypeNotCompatibleException, AerialVehicleNotCompatibleException {
    this.operatorVehicle.setAbility(new IntelCollector(sensorType));
  }

  public String getRegion() {
    return this.region;
  }

  @Override
  protected String executeMission() {
    IntelCollector intelCollector =
        (IntelCollector) (this.getOperatorVehicle().getAbility("IntelCollector"));
    return this.getPilotName()
        + ": "
        + this.getOperatorVehicle().getClass().getSimpleName()
        + " Collecting Data in "
        + this.getRegion()
        + " with: sensor type: "
        + intelCollector.getSensorType();
  }
}
