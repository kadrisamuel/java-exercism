import java.util.Arrays;
import java.util.List;

class ResistorColorDuo {
    private static final String[] colors = {"black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white"};
    private static final List<String> lookup = Arrays.asList(colors);
    
    int colorCode(String color) {
        return lookup.indexOf(color);
    }

    int value(String[] colors) {
        throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
    }
}
