import java.util.stream.IntStream;

public class Hamming {

    final private int distance;

    public Hamming(String leftStrand, String rightStrand) throws IllegalArgumentException {

        if (leftStrand.length() != rightStrand.length()) {
            throw new IllegalArgumentException("strands must be of equal length");
        }

        this.distance = (int) IntStream
        .range(0, leftStrand.length())
        .filter(i -> leftStrand.charAt(i) != rightStrand.charAt(i))
        .count();

    }

    public int getHammingDistance() {
        return this.distance;
    }


}
