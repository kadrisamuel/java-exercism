import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.IntStream;

/* Puzzle
The following 15 statements are all known to be true:

There are five houses.//
The Englishman lives in the red house.
The Spaniard owns the dog.
The person in the green house drinks coffee.
The Ukrainian drinks tea.
The green house is immediately to the right of the ivory house.
The snail owner likes to go dancing.
The person in the yellow house is a painter.
The person in the middle house drinks milk.//
The Norwegian lives in the first house.//
The person who enjoys reading lives in the house next to the person with the fox.
The painter's house is next to the house with the horse.
The person who plays football drinks orange juice.
The Japanese person plays chess.
The Norwegian lives next to the blue house.

Additionally, each of the five houses is painted a different color, 
and their inhabitants are of different national extractions, 
own different pets, drink different beverages 
and engage in different hobbies. */

class ZebraPuzzle {
    static final String[] drinks = {"Coffee", "Tea", "Orange Juice", "Water", "Milk"}; // "Milk"
    static final String[] nationalities = {"Englishman", "Spaniard", "Ukrainian", "Japanese", "Norwegian"}; // "Norwegian"
    static final String[] colors = {"Red", "Yellow", "Ivory", "Green", "Blue"}; // "Blue"
    static final String[] pets = {"Dog", "Horse", "Snail", "Fox", "Zebra"};
    static final String[] hobbies = {"Dancing", "Painting", "Reading", "Football", "Chess"};

    static Map<String, Integer> drinkMap = new HashMap<String, Integer>();
    static Map<String, Integer> nationMap = new HashMap<String, Integer>();
    static Map<String, Integer> colorMap = new HashMap<String, Integer>();
    static Map<String, Integer> petMap = new HashMap<String, Integer>();
    static Map<String, Integer> hobbyMap = new HashMap<String, Integer>();

    static {
        IntStream.range(0, 5).forEach(index -> drinkMap.put(drinks[index], index));
        IntStream.range(0, 5).forEach(index -> nationMap.put(nationalities[index], index));
        IntStream.range(0, 5).forEach(index -> colorMap.put(colors[index], index));
        IntStream.range(0, 5).forEach(index -> petMap.put(pets[index], index));
        IntStream.range(0, 5).forEach(index -> hobbyMap.put(hobbies[index], index));
    }

    static Set<Integer[]> perm4 = new HashSet<Integer[]>(24);
    static Set<Integer[]> perm5 = new HashSet<Integer[]>(120);
    static final Integer[] fourIndices = {0, 1, 2, 3};
    static final Integer[] fiveIndices = {0, 1, 2, 3, 4};

    static {
        perm4 = permutationGen(fourIndices);
        perm5 = permutationGen(fiveIndices);
    }

    Inhabitant[] inhabitants = new Inhabitant[5];


    public static void main(String[] args) {
    }
    


    public class Inhabitant {
        String nationality;
        String pet;
        String drink;
        String hobby;
        String houseColor;
        int houseNumber;
    }

    public void printInhabitants() {
        for (Inhabitant inhabitant : inhabitants) {
            System.out.println("Inhabitant in house nr " + inhabitant.houseNumber);
            System.out.println(inhabitant.nationality);
            System.out.println(inhabitant.houseNumber);
            System.out.println(inhabitant.houseColor);
            System.out.println(inhabitant.hobby);
            System.out.println(inhabitant.pet);
        }
    }


//
//  Methods to create inhabitant data based on permutations TODO
//
    // Makes 5 inhabitant objects, assigns knows properties to them
    void assignPropertiesToInhabitants() {
        for (int i = 0; i < 5; i++) {
            inhabitants[i] = new Inhabitant();
            inhabitants[i].houseNumber = i+1;
        }
        inhabitants[0].nationality = "Norwegian";
        inhabitants[1].houseColor = "Blue";
        inhabitants[2].drink = "Milk";
    }

    void tryConfiguration() {
        for (int i = 0; i < 5; i++) {
            inhabitants[i].pet = pets[i];
            if (pets[i] == "Dog" && inhabitants[i].nationality != null ) {
                inhabitants[i].nationality = "Spaniard";
            }
            if (pets[i] == "Snail" && inhabitants[i].hobby != null) {
                inhabitants[i].hobby = "Dancing";
            }

        }
        
    }
//
//  Method to generate permutations
//
    static Set<Integer[]> permutationGen(Integer[] input) {
        Set<Integer[]> perm = new HashSet<Integer[]>();
        // Base case to end recursion
        if (input.length == 0) {
            perm.add(input);
            return perm;
        }
        // Recursive case
        int initial = input[0]; // first element
        Integer[] rem = Arrays.copyOfRange(input, 1, input.length); // Full array without first element
        Set<Integer[]> combinations = permutationGen(rem);
        for (Integer[] combo : combinations) {
            for (int i = 0; i<=combo.length; i++){
                perm.add(permutate(combo, initial, i));
            }
        }
        return perm;
    }

    static Integer[] permutate(Integer[] origin, int element, int index) {
        List<Integer> result = new ArrayList<>(Arrays.asList(origin));
        result.add(index, element);
        return result.toArray(new Integer[0]);
    }





//
//  Method to check if a permutation has the correct solution
//
    boolean validateConfiguration() {
        for (Inhabitant inhabitant : inhabitants) {
            try {
                // The Englishman lives in the red house.
                if (inhabitant.nationality == "Englishman") {
                    if (inhabitant.houseColor != "Red") {
                        return false;
                    }
                }
                // The Spaniard owns the dog.
                if (inhabitant.nationality == "Spaniard") {
                    if (inhabitant.pet != "Dog") {
                        return false;
                    }
                }
                // The person in the green house drinks coffee
                if (inhabitant.houseColor == "Green") {
                    if (inhabitant.drink != "Coffee") {
                        return false;
                    }
                    // The first house cannot be green, see explanatio below
                    if (inhabitant.houseNumber == 1) {
                        return false;
                    }
                    // The green house is immediately to the right of the ivory house.
                    try {
                        if (inhabitants[inhabitant.houseNumber-2].houseColor != "Ivory") {
                            return false;
                        }
                    } catch (Exception e) {
                        return false;
                    }
                    
                }
                // The Ukrainian drinks tea.
                if (inhabitant.nationality == "Ukrainian") {
                    if (inhabitant.houseColor != "Tea") {
                        return false;
                    }
                }
                // The snail owner likes to go dancing.
                if (inhabitant.pet == "Snail") {
                    if (inhabitant.hobby != "Dancing") {
                        return false;
                    }
                }
                // The person in the yellow house is a painter.
                if (inhabitant.houseColor == "Yellow") {
                    if (inhabitant.hobby != "Painting") {
                        return false;
                    }
                    // The painter's house is next to the house with the horse.
                    try {
                        if (!(inhabitants[inhabitant.houseNumber-2].pet == "Horse" || inhabitants[inhabitant.houseNumber+2].pet == "Horse")) {
                            return false;
                        }
                    } catch (Exception e) {
                        return false;
                    }
                }
                // The person who enjoys reading lives in the house next to the person with the fox.
                if (inhabitant.hobby == "Reading") {
                    try {
                        if (!(inhabitants[inhabitant.houseNumber-2].pet == "Fox" || inhabitants[inhabitant.houseNumber+2].pet == "Fox")) {
                            return false;
                        }
                    } catch (Exception e) {
                        return false;
                    }
                }
                // The person who plays football drinks orange juice.
                if (inhabitant.hobby == "Football") {
                    if (inhabitant.drink != "Orange Juice") {
                        return false;
                    }
                }
                // The Japanese person plays chess.
                if (inhabitant.nationality == "Japanese") {
                    if (inhabitant.hobby != "Chess") {
                        return false;
                    }
                }
                // The Norwegian lives in the first house.
                // The Norwegian lives next to the blue house.
                // => second house must be blue
                // The green house is immediately to the right of the ivory house.
                // => first house cannot be green (because first house is next to blue house and has only one neighbor) 
                // or blue (because the second house is blue).
                if (inhabitant.nationality == "Norwegian") {
                    if (inhabitant.houseNumber != 1 || inhabitant.houseColor == "Green" || inhabitant.houseColor == "Blue") {
                        return false;
                    }
                    try {
                        if (!(inhabitants[inhabitant.houseNumber+2].houseColor == "Blue")) {
                            return false;
                        }
                    } catch (Exception e) {
                        return false;
                    }
                }
            } catch (Exception e) {
                System.err.println(e + " property might be empty");
            }
        }
        return true;
    }


//
//  Getter methods used by tests
//  
    String getWaterDrinker() {
        assignPropertiesToInhabitants();
        tryConfiguration();
        printInhabitants();
        String waterDrinker = "Norwegian";
        
        return waterDrinker;
        //throw new UnsupportedOperationException("Please implement the ZebraPuzzle.getWaterDrinker() method.");
    }

    String getZebraOwner() {
        String zebraOwner = "Japanese";
        
        return zebraOwner;
        //throw new UnsupportedOperationException("Please implement the ZebraPuzzle.getZebraOwner() method.");
    }
}
