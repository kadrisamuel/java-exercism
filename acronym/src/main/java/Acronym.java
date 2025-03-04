import java.util.Arrays;
import java.util.stream.Collectors;

class Acronym {
    private final String acronym;

    Acronym(String phrase) {
        this.acronym = calcAcronym(phrase);
    }

    String get() {
        return this.acronym;
    }
    
    String calcAcronym(String phrase) {
        return Arrays.asList(phrase.split("[-_ ]"))
            .stream()
            .map(str -> str.isEmpty()? str : str.substring(0, 1).toUpperCase())
            .collect(Collectors.joining());
    }

}
