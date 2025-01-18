class ProductionRemoteControlCar implements RemoteControlCar, Comparable<ProductionRemoteControlCar> {
    private static int DISTANCE = 10;
    private int totalDistance;
    private int totalVictories;

    public void drive() {
        this.totalDistance += DISTANCE;    
    }

    public int getDistanceTravelled() {
        return this.totalDistance;
    }

    public int getNumberOfVictories() {
        return this.totalVictories;
    }

    public void setNumberOfVictories(int numberOfVictories) {
        this.totalVictories = numberOfVictories;
    }

    @Override
    public int compareTo(ProductionRemoteControlCar otherCar) {
        //return otherCar.totalDistance - this.totalVictories; //others had solved it this way instead, I thinkit might be better than mine
        return Integer.compare(otherCar.getNumberOfVictories(), this.totalVictories); //reversed arguments for descending order
    }
}
