package AerialVehicles;

import Abilities.Ability;
import Abilities.IntelCollector;
import Abilities.BdaAssessor;
import Entities.Coordinates;

public class Zik extends Katmam {

  public Zik(int maxHoursOfFlight, Coordinates homeBase) {
    super(maxHoursOfFlight, homeBase);
  }

  @Override
  protected boolean isValidAbility(Ability ability) {
    if (ability instanceof BdaAssessor || ability instanceof IntelCollector) {
      return true;
    }
    return false;
  }
}
