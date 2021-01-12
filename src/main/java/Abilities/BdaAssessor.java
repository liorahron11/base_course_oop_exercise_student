package Abilities;

import Exceptions.CameraTypeNotCompatibleException;

public class BdaAssessor extends Ability {
  private String cameraType;

  public BdaAssessor(String cameraType) throws CameraTypeNotCompatibleException {
    this.setCameraType(cameraType);
  }

  public String getCameraType() {
    return cameraType;
  }

  private boolean isValidCameraType(String cameraType) {
    if (cameraType.equals("Regular")
        || cameraType.equals("Thermal")
        || cameraType.equals("NightVision")) {
      return true;
    }
    return false;
  }

  public void setCameraType(String cameraType) throws CameraTypeNotCompatibleException {
    if (isValidCameraType(cameraType)) {
      this.cameraType = cameraType;
    } else {
      throw new CameraTypeNotCompatibleException("Invalid sensor type");
    }
  }
}
