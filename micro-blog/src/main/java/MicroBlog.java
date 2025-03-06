import java.util.stream.Collectors;

class MicroBlog {
    public String truncate(String input) {
        return input.codePoints()
            .limit(5)
            .mapToObj(c -> Character.toString(c))
            .collect(Collectors.joining());
    }
}