package Missions;

import AerialVehicles.AerialVehicle;
import Entities.Coordinates;

public abstract class Mission {
  protected Coordinates destination;
  protected String pilotName;
  protected AerialVehicle operatorVehicle;

  public Mission(Coordinates destination, String pilotName, AerialVehicle operatorVehicle) {
    this.destination = destination;
    this.pilotName = pilotName;
    this.operatorVehicle = operatorVehicle;
  }

  public Coordinates getDestination() {
    return destination;
  }

  public void setDestination(Coordinates destination) {
    this.destination = destination;
  }

  public String getPilotName() {
    return pilotName;
  }

  public void setPilotName(String pilotName) {
    this.pilotName = pilotName;
  }

  public AerialVehicle getOperatorVehicle() {
    return operatorVehicle;
  }

  public void setOperatorVehicle(AerialVehicle operatorVehicle) {
    this.operatorVehicle = operatorVehicle;
  }

  public void begin() {
    this.operatorVehicle.flyTo(this.destination);
    System.out.println("Beginning Mission!");
  }

  public void cancel() {
    this.operatorVehicle.land(this.operatorVehicle.getHomeBase());
    System.out.println("Abort Mission!");
  }

  public void finish() {
    System.out.println(this.executeMission());
    this.operatorVehicle.land(this.operatorVehicle.getHomeBase());
    System.out.println("Finish Mission!");
  }

  protected abstract String executeMission();
}
