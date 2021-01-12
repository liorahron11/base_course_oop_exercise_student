package Exceptions;

public class CameraTypeNotCompatibleException extends Exception {
  public CameraTypeNotCompatibleException(String message) {
    super(message);
  }

    public static class AerialVehicleNotCompatibleException extends Exception {
        public AerialVehicleNotCompatibleException(String message) {
            super(message);
        }
    }
}
