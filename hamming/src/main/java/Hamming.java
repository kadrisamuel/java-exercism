public class Hamming {
    public String left;
    public String right;
    public int length;
    private int distance;

    public Hamming(String leftStrand, String rightStrand) throws IllegalArgumentException {
        
        if (leftStrand.length() != rightStrand.length()) {
            throw new IllegalArgumentException("strands must be of equal length");
        }

        this.length = leftStrand.length();
        this.left = leftStrand;
        this.right = rightStrand;

        for (int i = 0; i < length; i++) {
            if (left.charAt(i) != right.charAt(i)) {
                this.distance += 1;
            }
        }
    }

    public int getHammingDistance() {
        return this.distance;
    }


}
