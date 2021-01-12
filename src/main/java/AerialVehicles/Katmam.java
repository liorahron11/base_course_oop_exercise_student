package AerialVehicles;

import Entities.Coordinates;

public abstract class Katmam extends AerialVehicle {

  public Katmam(int maxHoursOfFlight, Coordinates homeBase) {
    super(maxHoursOfFlight, homeBase);
  }

  public String hoverOverLocation(Coordinates destination) {
    this.setFlightStatus("airborne");
    System.out.println("Hovering over:" + destination.toString());
    return destination.toString();
  }
}
