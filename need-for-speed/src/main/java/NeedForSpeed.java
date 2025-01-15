class NeedForSpeed {
    private static int NITRO_SPEED = 50;
    private static int NITRO_DRAIN = 4;
    
    int speed;
    int batteryDrain;
    int distanceDriven = 0;
    int batteryLeft = 100;

    public NeedForSpeed(int speed, int batteryDrain) {
        this.speed = speed;
        this.batteryDrain = batteryDrain;
    }

    public boolean batteryDrained() {
        return batteryLeft < batteryDrain;
    }

    public int distanceDriven() {
        return this.distanceDriven;
    }

    public void drive() {
        if (!batteryDrained()) {
            this.distanceDriven += this.speed;
            this.batteryLeft -= this.batteryDrain;
        }

    }

    public static NeedForSpeed nitro() {
        return new NeedForSpeed(NITRO_SPEED, NITRO_DRAIN);
    }
}

class RaceTrack {
    private int distance;

    RaceTrack(int distance) {
        this.distance = distance;
    }

    public boolean canFinishRace(NeedForSpeed car) {
       return car.batteryDrain * this.distance / car.speed <= 100;
    }
}
