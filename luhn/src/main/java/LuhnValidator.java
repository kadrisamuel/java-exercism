
import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;



class LuhnValidator {

    boolean isValid(String candidate) {
        if (candidate.strip().length() <= 1) {
            return  false;
        }        
        if (Pattern.compile("[^0-9 ]").matcher(candidate).find()) {
            return false;
        }

        // Make a list of ID numbers and reverse it
        ArrayList<Integer> id = candidate.chars()
            .filter(c -> Character.isDigit(c))
            .mapToObj(c -> Character.getNumericValue(c))
            .collect(Collectors.toCollection(ArrayList::new));
        Collections.reverse(id);

        // Double every second number on the list
        IntStream.rangeClosed(0, id.size() / 2)
            .forEach(i -> {
                if (id.size() > i * 2 + 1) {
                    int temp = 2 * id.get(i*2+1);
                    id.set(i*2+1, (temp > 9)? temp - 9 : temp);
                }
            });

        // Check if the sum is div by 10
        return id.stream().reduce(0, (a, b) -> a + b) % 10 == 0;
    }

}
