package Missions;

import Abilities.Attacker;
import AerialVehicles.AerialVehicle;
import Entities.Coordinates;
import Exceptions.AerialVehicleNotCompatibleException;
import Exceptions.MissileKindNotCompatibleException;

public class AttackMission extends Mission {
  private String target;

  public AttackMission(
      Coordinates destination,
      String pilotName,
      AerialVehicle operatorVehicle,
      String target,
      int missileAmount,
      String missileKind)
      throws AerialVehicleNotCompatibleException, MissileKindNotCompatibleException {
    super(destination, pilotName, operatorVehicle);
    this.setAmmo(missileAmount, missileKind);
    this.target = target;
  }

  private void setAmmo(int missileAmount, String missileKind)
      throws MissileKindNotCompatibleException, AerialVehicleNotCompatibleException {
    this.operatorVehicle.setAbility(new Attacker(missileAmount, missileKind));
  }

  public String getTarget() {
    return this.target;
  }

  @Override
  protected String executeMission() {
    Attacker attacker = (Attacker) (this.getOperatorVehicle().getAbility("Attacker"));
    return this.getPilotName()
        + ": "
        + this.getOperatorVehicle().getClass().getSimpleName()
        + " Attacking "
        + this.getTarget()
        + " with: "
        + attacker.getMissileKind()
        + "X"
        + attacker.getMissileAmount();
  }
}
