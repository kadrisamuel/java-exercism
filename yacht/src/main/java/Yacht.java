import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
            case FULL_HOUSE:

                int twos = Arrays.stream(dice).filter(i -> Collections.frequency(Arrays.asList(dice), i) == 2).limit(1).map(x -> x * 2).sum();
                int threes = Arrays.stream(dice).filter(i -> Collections.frequency(Arrays.asList(dice), i) == 3).sum();

                Set<int[]> name = Arrays.asList(dice).stream().filter(i -> Collections.frequency(Arrays.asList(dice), i) > 1).collect(Collectors.toSet());
                //int res = Arrays.stream(dice)//.filter(i -> Collections.frequency(Arrays.asList(dice), i) > 1)
                  //  .collect(Collectors.groupingBy(Function.identity()), Collectors.counting())
                    
                if (twos != 0 && threes != 0) {
                    return twos + threes;
                }
                return 0;

            case FOUR_OF_A_KIND:
                final int ones = Arrays.stream(dice).filter(i -> Collections.frequency(Arrays.asList(dice), i) == 1).sum();
                final int fours = Arrays.stream(dice).filter(i -> Collections.frequency(Arrays.asList(dice), i) == 4).sum();

                if (ones != 0 && fours != 0) {
                    return ones + fours;
                }
                return 0;
                
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

}
