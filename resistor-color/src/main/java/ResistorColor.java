import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

class ResistorColor {
    private static final String[] colors = {"black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white"};
    private static final Map<String, Integer> lookup = new HashMap<>();
    static {
        IntStream.range(0, colors.length).forEach(i -> lookup.put(colors[i], i));
    }
    
    int colorCode(String color) {
        return lookup.get(color);
    }

    String[] colors() {
        return colors;
    }
}
