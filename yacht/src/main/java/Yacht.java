import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

class Yacht {
    private int[] dice;
    private YachtCategory yachtCategory;
    private final static int[] LITTLE_STRAIGHT = {1, 2, 3, 4, 5};
    private final static int[] BIG_STRAIGHT = {2, 3, 4, 5, 6};

    Yacht(int[] dice, YachtCategory yachtCategory) {
        this.dice = Arrays.stream(dice).sorted().toArray();
        this.yachtCategory = yachtCategory;
    }

    int score() {
        switch (yachtCategory) {
            case YACHT:
                return (Arrays.stream(dice).distinct().count() == 1)? 50 : 0;
            case ONES:
                return (int) Arrays.stream(dice).filter(x -> x == 1).count();
            case TWOS:
                return 2 * (int) Arrays.stream(dice).filter(x -> x == 2).count();
            case THREES:
                return 3 * (int) Arrays.stream(dice).filter(x -> x == 3).count();
            case FOURS:
                return 4 * (int) Arrays.stream(dice).filter(x -> x == 4).count();
            case FIVES:
                return 5 * (int) Arrays.stream(dice).filter(x -> x == 5).count();
            case SIXES:
                return 6 * (int) Arrays.stream(dice).filter(x -> x == 6).count();

            case FULL_HOUSE: {
                Map<Integer, Integer> lookup = getFrequencyMap();

                if (lookup.containsValue(2) && lookup.containsValue(3)) {
                    return lookup.entrySet().stream()
                    .filter(entry -> entry.getValue() == 2)
                    .map(entry -> entry.getKey() * 2)
                    .findFirst()
                    .orElse(-1)
                    +
                    lookup.entrySet().stream()
                    .filter(entry -> entry.getValue() == 3)
                    .map(entry -> entry.getKey() * 3)
                    .findFirst()
                    .orElse(-1);
                }

                return 0;
            }

            case FOUR_OF_A_KIND: {
                Map<Integer, Integer> lookup = getFrequencyMap();

                if (lookup.containsValue(4) || lookup.containsValue(5)) {
                    return lookup.entrySet().stream()
                    .filter(entry -> entry.getValue() >= 4)
                    .map(entry -> entry.getKey() * 4)
                    .findFirst()
                    .orElse(-1);
                }

                return 0;
            }
                
            case LITTLE_STRAIGHT:
                return Arrays.compare(LITTLE_STRAIGHT, dice) == 0? 30 : 0;
            case BIG_STRAIGHT:
                return Arrays.compare(BIG_STRAIGHT, dice) == 0? 30 : 0;
            case CHOICE:
                return Arrays.stream(dice).sum();
        
            default:
                return 0;
        }
    }

    private Map<Integer, Integer> getFrequencyMap(){
        return Arrays.stream(dice)
            .boxed()
            .collect(Collectors.groupingBy(
                i -> i, 
                Collectors.reducing(0, e -> 1, Integer::sum)
            ));
    }

}
