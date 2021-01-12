package AerialVehicles;

import Abilities.Ability;
import Abilities.Attacker;
import Abilities.BdaAssessor;
import Abilities.IntelCollector;
import Entities.Coordinates;

public class F15 extends AerialVehicle {


  public F15(int maxHoursOfFlight, Coordinates homeBase) {
    super(maxHoursOfFlight, homeBase);
  }

  @Override
  protected boolean isValidAbility(Ability ability) {
    if (ability instanceof Attacker || ability instanceof IntelCollector) {
      return true;
    }
    return false;
  }
}
