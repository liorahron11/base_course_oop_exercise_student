package AerialVehicles;

import Abilities.Ability;
import Abilities.Attacker;
import Abilities.BdaAssessor;
import Abilities.IntelCollector;
import Entities.Coordinates;

public class Eitan extends Katmam {

  public Eitan(int maxHoursOfFlight, Coordinates homeBase) {
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
