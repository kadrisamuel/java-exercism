import java.util.stream.IntStream;

class DifferenceOfSquaresCalculator {

    // ([n(n + 1)] / 2)^2
    int computeSquareOfSumTo(int n) {
        int sum = (n * (n + 1) / 2);
        return sum*sum;
    }

    // [n(n + 1)(2n + 1)] / 6
    int computeSumOfSquaresTo(int n) {
        return (n * (n + 1) * (2 * n + 1)) / 6;
    }

    int computeDifferenceOfSquares(int input) {
        return Math.abs(computeSumOfSquaresTo(input) - computeSquareOfSumTo(input));
    }

}
