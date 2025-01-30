import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

class DnDCharacter {
    ThreadLocalRandom random = ThreadLocalRandom.current();

    int ability(List<Integer> scores) {
        scores.remove(scores.indexOf(Collections.min(scores)));
        int sum = 0;
        for (int i = 0; i < scores.size(); i++) {
            sum += scores.get(i);
        }
        return sum;
    }

    List<Integer> rollDice() {
        List<Integer> results = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            results.add(random.nextInt(1,7));
        }
        return results;
    }

    int modifier(int input) {
        int modifier;
        
        return 1;
    }

    int getStrength() {
        throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
    }

    int getDexterity() {
        throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
    }

    int getConstitution() {
        throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
    }

    int getIntelligence() {
        throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
    }

    int getWisdom() {
        throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
    }

    int getCharisma() {
        throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
    }

    int getHitpoints() {
        throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
    }
}
