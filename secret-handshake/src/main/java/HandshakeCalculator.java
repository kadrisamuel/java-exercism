import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

class HandshakeCalculator {
    private List<Signal> output;
    private int maxDigits;

    List<Signal> calculateHandshake(int number) {
        output  = new ArrayList<>(Integer.bitCount(number));
        String input = new StringBuffer(Integer.toBinaryString(number))
            .reverse().toString();
        maxDigits = (input.length() < 4)? input.length() : 4;

        IntStream.range(0, maxDigits)
            .filter(x -> input.charAt(x) == '1')
            .forEach(x -> output.add(Signal.getSignal(x)));


        if (input.length() > 4 && input.charAt(4) == '1') {
            return output.reversed();
        }

        return output;
    }

}
