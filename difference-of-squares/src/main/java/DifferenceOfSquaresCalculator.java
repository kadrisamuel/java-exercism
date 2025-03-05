import java.util.stream.IntStream;

class DifferenceOfSquaresCalculator {

    int computeSquareOfSumTo(int input) {
        return (int) Math.pow(IntStream.rangeClosed(1, input).sum(), 2);
    }

    // [n(n+1)(2n+1)] / 6
    int computeSumOfSquaresTo(int input) {
        return (input*(input + 1)*(2 * input + 1))/6;
    }

    int computeDifferenceOfSquares(int input) {
        return Math.abs(computeSumOfSquaresTo(input) - computeSquareOfSumTo(input));
    }

}
