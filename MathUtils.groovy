class MathUtils {

    private static final double TOLERANCE = 0.00000001

    static boolean equals(double a, double b) {
        Math.abs(a - b) < TOLERANCE
    }

}
