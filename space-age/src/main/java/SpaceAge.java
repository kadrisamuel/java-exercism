class SpaceAge {
    private final double seconds;
    private final double earthAge;

    SpaceAge(double seconds) {
        this.seconds = seconds;
        this.earthAge = seconds / 31_557_600;
    }

    double getSeconds() {
        return seconds;
    }

    double onEarth() {
        return earthAge;
    }

    double onMercury() {
        return earthAge / Planet.MERCURY.getMultiplier();
    }

    double onVenus() {
        return earthAge / Planet.VENUS.getMultiplier();
    }

    double onMars() {
        return earthAge / Planet.MARS.getMultiplier();
    }

    double onJupiter() {
        return earthAge / Planet.JUPITER.getMultiplier();
    }

    double onSaturn() {
        return earthAge / Planet.SATURN.getMultiplier();
    }

    double onUranus() {
        return earthAge / Planet.URANUS.getMultiplier();
    }

    double onNeptune() {
        return earthAge / Planet.NEPTUNE.getMultiplier();
    }

}
