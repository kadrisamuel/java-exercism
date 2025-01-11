public class CarsAssemble {
    private static final int DEFAULT_PRODUCTION_RATE = 221;
    public static void main (String[] args) {
        CarsAssemble line = new CarsAssemble();
        double rate = line.productionRatePerHour(7);
        System.out.println(rate);
    }

    private double getSuccessRate (int speed) {
        if (speed == 0){
            return 0;
        } else if (speed >= 1 && speed <= 4 ) {
            return 1;
        } else if (speed >= 5 && speed <= 8) {
            return 0.9;
        } else if (speed == 9){
            return 0.8;
        } else { //(speed == 10)
            return 0.77;
        }
    }

    public double productionRatePerHour(int speed) {
        return speed * DEFAULT_PRODUCTION_RATE * getSuccessRate(speed);
    }
    public int workingItemsPerMinute(int speed) {
        return (int) (productionRatePerHour(speed)/60);
    }
}

// 1 to 4: 100% success rate.
// 5 to 8: 90% success rate.
// 9: 80% success rate.
// 10: 77% success rate.