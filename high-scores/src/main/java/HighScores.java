import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class HighScores {
    private final List<Integer> scores;

    public HighScores(List<Integer> highScores) {
        this.scores = new ArrayList<>(highScores);
    }

    List<Integer> scores() {
        return new ArrayList<>(this.scores);
    }

    Integer latest() {
        return scores.getLast();
    }

    Integer personalBest() {
        return personalTopThree().get(0);
    }

    List<Integer> personalTopThree() {
        return scores.stream().sorted(Comparator.reverseOrder()).limit(3).toList();
    }

}
