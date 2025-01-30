import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

class DnDCharacter {
    private int strength;
    private int dexterity;
    private int constitution;
    private int intelligence;
    private int wisdom;
    private int charisma;
    private int hitpoints;
    private boolean strengthSet;
    private boolean dexteritySet;
    private boolean constitutionSet;
    private boolean intelligenceSet;
    private boolean wisdomSet;
    private boolean charismaSet;
    private boolean hitpointsSet;

    ThreadLocalRandom random = ThreadLocalRandom.current();

    int ability(List<Integer> scores) {
        List<Integer> mutableList = new ArrayList<>(scores);
        mutableList.remove(mutableList.indexOf(Collections.min(mutableList)));
        int sum = 0;
        for (int i = 0; i < mutableList.size(); i++) {
            sum += mutableList.get(i);
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
        return (int) Math.floor(((double)(input - 10))/2);
    }

    int getStrength() {
        if (!strengthSet) {
            this.strength = ability(rollDice());
            strengthSet = true;
        }
        return strength;
    }

    int getDexterity() {
        if (!dexteritySet) {
            this.dexterity = ability(rollDice());
            dexteritySet = true;
        }
        return dexterity;
    }

    int getConstitution() {
        if (!constitutionSet) {
            this.constitution = ability(rollDice());
            constitutionSet = true;
        }
        return constitution;
    }

    int getIntelligence() {
        if (!intelligenceSet) {
            this.intelligence = ability(rollDice());
            intelligenceSet = true;
        }
        return intelligence;
    }

    int getWisdom() {
        if (!wisdomSet) {
            this.wisdom = ability(rollDice());
            wisdomSet = true;
        }
        return wisdom;
    }

    int getCharisma() {
        if (!charismaSet) {
            this.charisma = ability(rollDice());
            charismaSet = true;
        }
        return charisma;
    }

    int getHitpoints() {
        if (!hitpointsSet) {
            this.hitpoints = 10 + modifier(this.constitution);
            hitpointsSet = true;
        }
        return hitpoints;
    }
}
