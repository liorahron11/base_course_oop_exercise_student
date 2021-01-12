package AerialVehicles;

import Abilities.Ability;
import Abilities.Attacker;
import Abilities.IntelCollector;
import Abilities.BdaAssessor;
import Entities.Coordinates;

public class Shoval extends Katmam {

  public Shoval(int maxHoursOfFlight, Coordinates homeBase) {
    super(maxHoursOfFlight, homeBase);
  }

  @Override
  protected boolean isValidAbility(Ability ability) {
    if (ability instanceof Attacker
        || ability instanceof BdaAssessor
        || ability instanceof IntelCollector) {
      return true;
    }
    return false;
  }
}
