import java.util.List;
import java.util.stream.IntStream;

class HandshakeCalculator {

    List<Signal> calculateHandshake(int number) {

        List<Signal> output = IntStream.range(0, 4)
            .filter(x -> ((1 << x) & number) > 0)
            .mapToObj(x -> Signal.values()[x])
            .toList();


        if (((1 << 4) & number) > 0) {
            return output.reversed();
        }

        return output;
    }

}
