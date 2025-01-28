// Predicate solution: https://exercism.org/tracks/java/exercises/darts/solutions/bobahop 
class Darts {
    final private static double INNER_CIRCLE = 1.0;
    final private static double MIDDLE_CIRCLE = 5.0;
    final private static double OUTER_CIRCLE = 10.0;

    int calculate(double radius) {
        if (radius <= INNER_CIRCLE) {
            return 10;
        }
        if (radius <= MIDDLE_CIRCLE) {
            return 5;
        }
        if (radius <= OUTER_CIRCLE) {
            return 1;
        }
        return 0;
    }

    int score(double xOfDart, double yOfDart) {
        return calculate(Math.hypot(xOfDart, yOfDart));
    }
}
