
class MicroBlog {
    private final static int MAX_POST_LENGTH = 5;

    public String truncate(String input) {
        return input.codePoints()
            .limit(MAX_POST_LENGTH)
            .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
            .toString();
    }
}