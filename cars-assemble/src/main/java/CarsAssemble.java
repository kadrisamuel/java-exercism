public class CarsAssemble {
    public static void main (String[] args) {
        CarsAssemble line = new CarsAssemble();
        double rate = line.productionRatePerHour(7);
        System.out.println(rate);
    }
    public double productionRatePerHour(int speed) {
        int grossRate = speed * 221;
        double netRate = 0;
        if (speed > 0) {
            if (speed >= 1 && speed <= 4 ) {
                return grossRate;
            } else if (speed >= 5 && speed <= 8) {
                return netRate = grossRate * 0.9;
            } else if (speed == 9){
                return netRate = grossRate * 0.8;
            } else if (speed == 10) {
                return netRate = grossRate * 0.77;
            } else {
                throw new UnsupportedOperationException("Input should between 0 and 10");
            }
        }

        return netRate;
    }

    public int workingItemsPerMinute(int speed) {
        double carsPerHour = productionRatePerHour(speed);
        int carsPerMinute = (int) (carsPerHour / 60);
        return carsPerMinute;
    }
}

// 1 to 4: 100% success rate.
// 5 to 8: 90% success rate.
// 9: 80% success rate.
// 10: 77% success rate.