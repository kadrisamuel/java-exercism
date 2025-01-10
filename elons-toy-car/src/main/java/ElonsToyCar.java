public class ElonsToyCar {
    private int distance = 0;
    private int battery = 0;
    public static void main (String[] args) {
        ElonsToyCar car = ElonsToyCar.buy();
        System.out.println(car);
        car.drive();
        System.out.println(car.distanceDisplay());
        System.out.println(car.batteryDisplay());
    }
    public static ElonsToyCar buy() {
        return new ElonsToyCar();
    }

    public String distanceDisplay() {
        return String.format("Driven %d meters", distance);
    }

    public String batteryDisplay() {
        String message = (battery > 0) ? String.format("Battery at %d%%", battery) : "Battery empty";
        return message;
        //return String.format("Battery at %d%%", battery);
    }

    public void drive() {
        if (battery > 0) {
            distance += 20;
            battery--;
        }
    }
}
