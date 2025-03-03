import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class HighScores {
    List<Integer> scores = List.of();
    List<Integer> sortedScores;

    public HighScores(List<Integer> highScores) {
        this.scores = highScores;
        this.sortedScores = new ArrayList<>(highScores);
        Collections.sort(sortedScores);
    }

    List<Integer> scores() {
        return this.scores;
    }

    Integer latest() {
        return scores.getLast();
    }

    Integer personalBest() {
        return sortedScores.getLast();
    }

    List<Integer> personalTopThree() {
        return (sortedScores.size() >= 3)? sortedScores.reversed().subList(0, 3) : sortedScores.reversed().subList(0, sortedScores.size());
    }

}
