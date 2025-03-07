import java.util.stream.IntStream;

class NaturalNumber {

    private final int number;
    private int aliquotSum = 0;

    NaturalNumber(int number) {
        if (number < 1) { throw new IllegalArgumentException("You must supply a natural number (positive integer)");}
        this.number = number;
        this.aliquotSum = getAliquotSum(number);
    }

    Classification getClassification() {
        if (number > aliquotSum) {
            return Classification.DEFICIENT;
        }
        if (number < aliquotSum) {
            return Classification.ABUNDANT;
        }
        return Classification.PERFECT;
    }


    /*
     * Iterate from 1 to the square root of n.
     * For each number i in this range, check if n is divisible by i.
     * If i is a divisor, add i and n/i to the list of divisors (if n/i is different from i).
     * Edge case: if number is 1, its aliquotnumber is 0.
     */
    private int getAliquotSum(int number) {
        IntStream
        .rangeClosed(1, (int) Math.sqrt(number))
        .forEach(i -> {
            if (number % i == 0 && number != 1) {
                aliquotSum += i;
                if (number / i != number && number / i != i) {
                    aliquotSum += (number / i);
                }
            }
        });
        return aliquotSum;
    }
}
