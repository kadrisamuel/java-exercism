public class ExperimentalRemoteControlCar implements RemoteControlCar {
    private static int DISTANCE = 20;
    private int totalDistance;

    public void drive() {
        this.totalDistance += DISTANCE;
    }

    public int getDistanceTravelled() {
        return this.totalDistance;
    }
}
