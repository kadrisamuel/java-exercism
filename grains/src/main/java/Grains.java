import java.math.BigInteger;
import java.util.stream.IntStream;
import java.util.stream.Stream;


class Grains {
    // formula: 2^(x-1)
    BigInteger grainsOnSquare(final int square) throws IllegalArgumentException {
        if (square <= 0 || square > 64) {
            throw new IllegalArgumentException("square must be between 1 and 64");
        }
        return BigInteger.TWO.pow(square-1);
    }

    BigInteger grainsOnBoard() {
        BigInteger total = BigInteger.ZERO;
        for (int i = 1; i < 65; i++) {
            total = total.add(grainsOnSquare(i));
        }
        return total;
    }    
}
