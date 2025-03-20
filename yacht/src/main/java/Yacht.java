import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Yacht {
    private final List<Integer> dice;
    private final YachtCategory yachtCategory;
    private final static List<Integer> LITTLE_STRAIGHT = List.of(1, 2, 3, 4, 5);
    private final static List<Integer> BIG_STRAIGHT = List.of(2, 3, 4, 5, 6);

    Yacht(int[] dice, YachtCategory yachtCategory) {
        this.dice = Arrays.stream(dice).boxed().sorted().toList();
        this.yachtCategory = yachtCategory;
    }

    int score() {
        switch (yachtCategory) {
            case YACHT:
                return (dice.stream().distinct().count() == 1)? 50 : 0;
            case ONES:
                return (int) dice.stream().filter(x -> x == 1).count();
            case TWOS:
                return 2 * (int) dice.stream().filter(x -> x == 2).count();
            case THREES:
                return 3 * (int) dice.stream().filter(x -> x == 3).count();
            case FOURS:
                return 4 * (int) dice.stream().filter(x -> x == 4).count();
            case FIVES:
                return 5 * (int) dice.stream().filter(x -> x == 5).count();
            case SIXES:
                return 6 * (int) dice.stream().filter(x -> x == 6).count();

            case FULL_HOUSE: 
                return dice.stream().distinct().count() == 2 && 
                    dice.stream().distinct().allMatch(n -> Collections.frequency(dice, n) >= 2)?
                    dice.stream().reduce(0, (a, b) -> a + b) : 0;

            case FOUR_OF_A_KIND: 
                return dice.stream().filter(n -> Collections.frequency(dice, n) >= 4)
                    .limit(4).reduce(0, (a, b) -> a + b);
                
            case LITTLE_STRAIGHT:
                return dice.containsAll(LITTLE_STRAIGHT)? 30 : 0;
            case BIG_STRAIGHT:
                return dice.containsAll(BIG_STRAIGHT)? 30 : 0;
            case CHOICE:
                return dice.stream().reduce(0, (a, b) -> a + b);
        
            default:
                return 0;
        }
    }

}
