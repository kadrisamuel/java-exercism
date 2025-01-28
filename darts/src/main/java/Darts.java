// Better solution to think about https://exercism.org/tracks/java/exercises/darts/solutions/bobahop 
class Darts {
    final private static double INNER_CIRCLE = 1.0;
    final private static double MIDDLE_CIRCLE = 5.0;
    final private static double OUTER_CIRCLE = 10.0;

    int score(double xOfDart, double yOfDart) {

        double radius = Math.hypot(xOfDart, yOfDart);

        if (radius <= OUTER_CIRCLE) {
            if (radius <= MIDDLE_CIRCLE) {
                if (radius <= INNER_CIRCLE) {
                    return 10;
                }
                return 5;
            }
            return 1;
        }

        return 0;
    }
}
