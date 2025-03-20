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
        return switch (yachtCategory) {
            case YACHT -> getYachtScore();
            case ONES -> getBasicScore(1);
            case TWOS -> getBasicScore(2);
            case THREES -> getBasicScore(3);
            case FOURS -> getBasicScore(4);            
            case FIVES -> getBasicScore(5);
            case SIXES -> getBasicScore(6);
            case FULL_HOUSE -> getHouseScore();
            case FOUR_OF_A_KIND -> getFourScore(); 
            case LITTLE_STRAIGHT -> getLittleScore();
            case BIG_STRAIGHT -> getBigScore();
            case CHOICE -> getChoiceScore();
        };
    }

    int getBasicScore(int nr) {
        return nr * (int) dice.stream().filter(x -> x == nr).count();
    }

    int getYachtScore() {
        return (dice.stream().distinct().count() == 1)? 50 : 0;
    }

    int getHouseScore(){
        return dice.stream().distinct().count() == 2 && 
                    dice.stream().distinct().allMatch(n -> Collections.frequency(dice, n) >= 2)?
                    dice.stream().reduce(0, (a, b) -> a + b) : 0;
    }

    int getFourScore() {
        return dice.stream().filter(n -> Collections.frequency(dice, n) >= 4)
                    .limit(4).reduce(0, (a, b) -> a + b);
    }

    int getLittleScore(){
        return dice.containsAll(LITTLE_STRAIGHT)? 30 : 0;
    }

    int getBigScore(){
        return dice.containsAll(BIG_STRAIGHT)? 30 : 0;
    }

    int getChoiceScore(){
        return dice.stream().reduce(0, (a, b) -> a + b);
    }

}
