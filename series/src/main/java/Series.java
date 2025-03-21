import java.util.List;
import java.util.stream.IntStream;

class Series {
    final String string;

    Series(String string) throws IllegalArgumentException {
        if (string.isEmpty()) {
            throw new IllegalArgumentException("series cannot be empty");
        }
        this.string = string;
    }

    List<String> slices(int num) throws IllegalArgumentException {
        if (num < 1) {
            throw new IllegalArgumentException("slice length cannot be negative or zero");
        }
        if (num > string.length()) {
            throw new IllegalArgumentException("slice length cannot be greater than series length");
        }

        //int beginIndex = 0;
        //int endIndex = num;
        //int maxEndIndex = string.length();
        return IntStream.rangeClosed(num, string.length())
            .mapToObj(index -> string.substring(index - num, index))
            .toList();

        //return List.of("test");
    }
}
