package AerialVehicles;

import Abilities.Ability;
import Entities.Coordinates;
import Exceptions.AerialVehicleNotCompatibleException;

import java.util.HashMap;

public abstract class AerialVehicle {
  private int hoursSinceMaintenance;
  private String flightStatus;
  private int maxHoursOfFlight;
  private Coordinates homeBase;
  private HashMap<String, Ability> ability;

  public AerialVehicle(int maxHoursOfFlight, Coordinates homeBase) {
    this.hoursSinceMaintenance = 0;
    this.flightStatus = "ready";
    this.maxHoursOfFlight = maxHoursOfFlight;
    this.homeBase = homeBase;
    this.ability = new HashMap<>();
  }

  public Coordinates getHomeBase() {
    return homeBase;
  }

  public void setAbility(Ability ability) throws AerialVehicleNotCompatibleException {
    if (this.isValidAbility(ability)) {
      this.ability.put(ability.getClass().getSimpleName(), ability);
    } else {
      throw new AerialVehicleNotCompatibleException("Invalid Ability");
    }
  }

  protected abstract boolean isValidAbility(Ability ability);

  public Ability getAbility(String abilityName) {
    return this.ability.get(abilityName);
  }

  public void setFlightStatus(String flightStatus) {
    if (isValidFlightStatus(flightStatus)) {
      this.flightStatus = flightStatus;
    } else {
      System.out.println("Invalid Flight Status");
    }
  }

  private boolean isValidFlightStatus(String flightStatus) {
    if (flightStatus.equals("ready")
        || flightStatus.equals("unready")
        || flightStatus.equals("airborne")) {
      return true;
    }
    return false;
  }

  private boolean isReady() {
    if (this.flightStatus.equals("ready")) {
      return true;
    }
    return false;
  }

  public void flyTo(Coordinates destination) {
    if (this.isReady()) {
      this.setFlightStatus("airborne");
      System.out.println("Flying to: " + destination.toString());
    } else {
      System.out.println("Aerial Vehicle isn't ready to fly");
    }
  }

  public void land(Coordinates destination) {
    System.out.println("Landing on: " + destination.toString());
    this.check();
  }

  public void check() {
    if (this.hoursSinceMaintenance > this.maxHoursOfFlight) {
      this.setFlightStatus("unready");
      this.repair();
    } else {
      this.setFlightStatus("ready");
    }
  }

  public void repair() {
    this.hoursSinceMaintenance = 0;
    this.setFlightStatus("ready");
  }
}
