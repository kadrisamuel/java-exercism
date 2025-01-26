class Darts {
    int score(double xOfDart, double yOfDart) {
        final double INNER_CIRCLE = 1;
        final double MIDDLE_CIRCLE = 5 * 5;
        final double OUTER_CIRCLE = 10 * 10;

        double x2PlusY2 = Math.pow(Math.abs(xOfDart), 2) + Math.pow(Math.abs(yOfDart), 2);

        if (x2PlusY2 <= OUTER_CIRCLE) {
            if (x2PlusY2 <= MIDDLE_CIRCLE) {
                if (x2PlusY2 <= INNER_CIRCLE) {
                    return 10;
                }
                return 5;
            }
            return 1;
        }

        return 0;
    }
}
