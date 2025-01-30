import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

class DnDCharacter {
    private final int strength;
    private final int dexterity;
    private final int constitution;
    private final int intelligence;
    private final int wisdom;
    private final int charisma;
    private final int hitpoints;

    ThreadLocalRandom random = ThreadLocalRandom.current();

    public DnDCharacter () {
        this.strength = getAbility();
        this.dexterity = getAbility();
        this.constitution = getAbility();
        this.intelligence = getAbility();
        this.wisdom = getAbility();
        this.charisma = getAbility();
        this.hitpoints = 10 + modifier(this.constitution);
    }

    int ability(List<Integer> scores) {
        int sum = 0 - Collections.min(scores);
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
        return Math.floorDiv(input - 10, 2);
    }

    int getAbility () {
        return ability(rollDice());
    }

    int getStrength() {
        return strength;
    }

    int getDexterity() {
        return dexterity;
    }

    int getConstitution() {
        return constitution;
    }

    int getIntelligence() {
        return intelligence;
    }

    int getWisdom() {
        return wisdom;
    }

    int getCharisma() {
        return charisma;
    }

    int getHitpoints() {
        return hitpoints;
    }
}
