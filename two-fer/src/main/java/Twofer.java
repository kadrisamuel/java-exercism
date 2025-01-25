public class Twofer {
    public String twofer(String name) {
        return new StringBuilder()
        .append("One for ")
        .append((name != null)? name : "you")
        .append(", one for me.")
        .toString();
        //String.format("One for %s, one for me.", (name != null)? name : "you");
    }
}
