import AerialVehicles.F15;
import AerialVehicles.Kochav;
import AerialVehicles.Zik;
import Entities.Coordinates;
import Missions.AttackMission;
import Missions.BdaMission;
import Missions.IntelligenceMission;

import static javafx.scene.input.KeyCode.F15;

public class main {
  public static void main(String[] args) throws Exception {

    Coordinates palmachim = new Coordinates(10.25,156.2);
    Coordinates hatzor = new Coordinates(10.25,156.2);

    F15 f15 = new F15(250, hatzor);
    AttackMission warehouseAttackMission =
        new AttackMission(
            new Coordinates(12.34, 56.78), "Lior", f15, "Weapons warehouse", 1, "Python");
    warehouseAttackMission.begin();
    warehouseAttackMission.finish();

    Kochav kochav = new Kochav(65,palmachim);

    BdaMission bdaMission =
        new BdaMission(
            new Coordinates(245.1, 15.8), "Dolev", kochav, "warehouse", "NightVision");
    bdaMission.begin();
    bdaMission.finish();

    Zik zik = new Zik(57, hatzor);
    IntelligenceMission intelligenceMission =
            new IntelligenceMission(
                    new Coordinates(45.2, 41.2), "Ohad", zik, "Gaza", "InfraRed");
    intelligenceMission.begin();
    intelligenceMission.finish();
    zik.hoverOverLocation(new Coordinates(124.1, 15.5));
  }
}
