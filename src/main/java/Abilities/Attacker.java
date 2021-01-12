package Abilities;

import Exceptions.MissileKindNotCompatibleException;

public class Attacker extends Ability {
  private int missileAmount;
  private String missileKind;

  public Attacker(int missileAmount, String missileKind) throws MissileKindNotCompatibleException {
    this.missileAmount = missileAmount;
    this.setMissileKind(missileKind);
  }

  private boolean isValidMissileKind(String missileKind) {
    if (missileKind.equals("Python")
        || missileKind.equals("Amram")
        || missileKind.equals("Spice250")) {
      return true;
    }
    return false;
  }

  public int getMissileAmount() {
    return missileAmount;
  }

  public void setMissileAmount(int missileAmount) {
    this.missileAmount = missileAmount;
  }

  public String getMissileKind() {
    return missileKind;
  }

  public void setMissileKind(String missileKind) throws MissileKindNotCompatibleException {
    if (isValidMissileKind(missileKind)) {
      this.missileKind = missileKind;
    } else {
      throw new MissileKindNotCompatibleException("Invalid missile kind");
    }
  }
}
