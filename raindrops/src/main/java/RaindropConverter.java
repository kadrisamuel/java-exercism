import java.util.HashMap;

class RaindropConverter {
    final static HashMap<Integer, String> lookup = new HashMap<>(){{
        put(3, "Pling");
        put(5, "Plang");
        put(7, "Plong");
    }};


    String convert(int number) {
        return lookup.keySet()
            .stream()
            .filter(key -> number % key == 0)
            .map(key -> lookup.get(key))
            .reduce((s1, s2) -> s1 + s2)
            .orElse(Integer.toString(number));
    }

}
