package Missions;

import Abilities.BdaAssessor;
import AerialVehicles.AerialVehicle;
import Entities.Coordinates;
import Exceptions.AerialVehicleNotCompatibleException;
import Exceptions.CameraTypeNotCompatibleException;

public class BdaMission extends Mission {
  private String objective;

  public BdaMission(
      Coordinates destination,
      String pilotName,
      AerialVehicle operatorVehicle,
      String objective,
      String cameraType)
      throws AerialVehicleNotCompatibleException, CameraTypeNotCompatibleException {
    super(destination, pilotName, operatorVehicle);
    this.setCamera(cameraType);
    this.objective = objective;
  }

  private void setCamera(String cameraType)
      throws CameraTypeNotCompatibleException, AerialVehicleNotCompatibleException {
    this.operatorVehicle.setAbility(new BdaAssessor(cameraType));
  }

  public String getObjective() {
    return this.objective;
  }

  @Override
  protected String executeMission() {
    BdaAssessor bdaAssessor = (BdaAssessor) (this.getOperatorVehicle().getAbility("BdaAssessor"));
    return this.getPilotName()
        + ": "
        + this.getOperatorVehicle().getClass().getSimpleName()
        + " taking pictures of "
        + this.getObjective()
        + " with: "
        + bdaAssessor.getCameraType()
        + " camera";
  }
}
