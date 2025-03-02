import java.math.BigInteger;

class Grains {
    
    // formula: 2^(x-1)
    BigInteger grainsOnSquare(final int square) throws IllegalArgumentException {
        if (square < 1 || square > 64) {
            throw new IllegalArgumentException("square must be between 1 and 64");
        }
        return BigInteger.TWO.pow(square-1);
    }

    BigInteger grainsOnBoard() {
        return BigInteger.TWO.pow(64).subtract(BigInteger.ONE);
    }
}
