import java.util.Arrays;
import java.util.List;

class ResistorColorDuo {
    private static final String[] colors = {"black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white"};
    private static final List<String> lookup = Arrays.asList(colors);

    int value(String[] colors) {
        return lookup.indexOf(colors[0]) * 10 + lookup.indexOf(colors[1]);
    }
}
