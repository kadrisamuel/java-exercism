
import java.util.List;
import java.util.stream.IntStream;

class IsbnVerifier {
    private static final List<Character> ISBN_DIGITS = List.of('0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'X');

    boolean isValid(String stringToVerify) {
        if (!stringToVerify.matches("[0-9X-]+")) {
            return false;
        }

        int[] isbnToVerify = strip(stringToVerify);

        if (isbnToVerify.length != 10) {
            return false;
        }

        if (IntStream.range(0, 9).anyMatch(x -> isbnToVerify[x] == 10)) {
            return false;
        }

        return IntStream.rangeClosed(1, 10)
            .map(i -> isbnToVerify[10 - i] * i)
            .sum() % 11 == 0;
    }

    private int[] strip(String stringToVerify) {
        return stringToVerify.chars()
            .mapToObj(nr -> (char) nr)
            .filter(c -> ISBN_DIGITS.contains(c))
            .mapToInt(c -> {
                if (c == 'X') {
                    return 10;
                }
                return c - '0';
            })
            .toArray();
    }

}
