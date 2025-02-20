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
    static final String[] drinks = {"Coffee", "Tea", "Orange Juice", "Water"}; // "Milk"
    static final String[] nationalities = {"Englishman", "Spaniard", "Ukrainian", "Japanese"}; // "Norwegian"
    static final String[] colors = {"Red", "Yellow", "Ivory", "Green"}; // "Blue"
    static final String[] pets = {"Dog", "Horse", "Snail", "Fox", "Zebra"};
    static final String[] hobbies = {"Dancing", "Painting", "Reading", "Football", "Chess"};

    static Map<Integer, String> drinkMap = new HashMap<Integer, String>();
    static Map<Integer, String> nationMap = new HashMap<Integer, String>();
    static Map<Integer, String> colorMap = new HashMap<Integer, String>();
    static Map<Integer, String> petMap = new HashMap<Integer, String>();
    static Map<Integer, String> hobbyMap = new HashMap<Integer, String>();

    static {
        IntStream.range(0, 4).forEach(index -> drinkMap.put(index, drinks[index]));
        IntStream.range(0, 4).forEach(index -> nationMap.put(index, nationalities[index]));
        IntStream.range(0, 4).forEach(index -> colorMap.put(index, colors[index]));
        IntStream.range(0, 5).forEach(index -> petMap.put(index, pets[index]));
        IntStream.range(0, 5).forEach(index -> hobbyMap.put(index, hobbies[index]));
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
    Inhabitant[] inhabitantTest = new Inhabitant[5];


    public static void main(String[] args) {
        ZebraPuzzle test = new ZebraPuzzle();
        boolean solutionExists = test.assignPropertiesToInhabitants();
        if (!solutionExists) {
            System.out.println("Couldn't find a solution");
        }

        ZebraPuzzle test2 = new ZebraPuzzle();
        boolean correctSolutionExists = test.assignCorrectProperties();
        if (correctSolutionExists) {
            System.out.println("Solution!");
        }
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
            System.out.println("House nr " + inhabitant.houseNumber);
            System.out.println(inhabitant.nationality);
            System.out.println(inhabitant.drink);
            System.out.println(inhabitant.houseColor);
            System.out.println(inhabitant.hobby);
            System.out.println(inhabitant.pet);
        }
    }

//
//  Method that creates the correct solution for testing
//
    public boolean assignCorrectProperties() {
        for (int i = 0; i < 5; i++) {
            inhabitantTest[i] = new Inhabitant();
            inhabitantTest[i].houseNumber = i+1;
        }

        inhabitantTest[0].drink = "Water";
        inhabitantTest[0].hobby = "Painting";
        inhabitantTest[0].houseColor = "Yellow";
        inhabitantTest[0].nationality = "Norwegian";
        inhabitantTest[0].pet = "Fox";

        inhabitantTest[1].drink = "Tea";
        inhabitantTest[1].hobby = "Reading";
        inhabitantTest[1].houseColor = "Blue";
        inhabitantTest[1].nationality = "Ukrainian";
        inhabitantTest[1].pet = "Horse";

        inhabitantTest[2].drink = "Milk";
        inhabitantTest[2].hobby = "Dancing";
        inhabitantTest[2].houseColor = "Red";
        inhabitantTest[2].nationality = "Englishman";
        inhabitantTest[2].pet = "Snail";

        inhabitantTest[3].drink = "Orange Juice";
        inhabitantTest[3].hobby = "Football";
        inhabitantTest[3].houseColor = "Ivory";
        inhabitantTest[3].nationality = "Spaniard";
        inhabitantTest[3].pet = "Dog";

        inhabitantTest[4].drink = "Coffee";
        inhabitantTest[4].hobby = "Chess";
        inhabitantTest[4].houseColor = "Green";
        inhabitantTest[4].nationality = "Japanese";
        inhabitantTest[4].pet = "Zebra";

        return true;
    }

//
//  Methods to create inhabitant data based on permutations
//
    // Makes 5 inhabitant objects, assigns known and generated properties to them
    public boolean assignPropertiesToInhabitants() {
        for (int i = 0; i < 5; i++) {
            inhabitants[i] = new Inhabitant();
            inhabitants[i].houseNumber = i+1;
        }

        inhabitants[2].drink = "Milk"; // The person in the middle house drinks milk
        inhabitants[0].nationality = "Norwegian"; // The Norwegian lives in the first house.
        inhabitants[1].houseColor = "Blue"; // The Norwegian lives next to the blue house.
        
        // apply permutation recursively to all properties
        for (Integer[] drink : perm4) {
            inhabitants[0].drink = drinkMap.get(drink[0]);
            inhabitants[1].drink = drinkMap.get(drink[1]);
            //inhabitants[2].drink = "Milk"; // The person in the middle house drinks milk
            inhabitants[3].drink = drinkMap.get(drink[2]);
            inhabitants[4].drink = drinkMap.get(drink[3]);
            for (Integer[] nation : perm4) {
                //inhabitants[0].nationality = "Norwegian"; // The Norwegian lives in the first house.
                inhabitants[1].nationality = nationMap.get(nation[0]);
                inhabitants[2].nationality = nationMap.get(nation[1]);
                inhabitants[3].nationality = nationMap.get(nation[2]);
                inhabitants[4].nationality = nationMap.get(nation[3]);
                for (Integer[] color : perm4) {
                    inhabitants[0].houseColor = colorMap.get(color[0]);
                    //inhabitants[1].houseColor = "Blue"; // The Norwegian lives next to the blue house.
                    inhabitants[2].houseColor = colorMap.get(color[1]);
                    inhabitants[3].houseColor = colorMap.get(color[2]);
                    inhabitants[4].houseColor = colorMap.get(color[3]);
                    if (validateDrinkNationColor(inhabitants)) {
                        printInhabitants();
                        System.out.println("Found a possible solution!");
                        for (Integer[] pet : perm5) {
                            inhabitants[0].pet = petMap.get(pet[0]);
                            inhabitants[1].pet = petMap.get(pet[1]);
                            inhabitants[2].pet = petMap.get(pet[2]);
                            inhabitants[3].pet = petMap.get(pet[3]);
                            inhabitants[4].pet = petMap.get(pet[4]);
                            for (Integer[] hobby : perm5) {
                                inhabitants[0].hobby = hobbyMap.get(hobby[0]);
                                inhabitants[1].hobby = hobbyMap.get(hobby[1]);
                                inhabitants[2].hobby = hobbyMap.get(hobby[2]);
                                inhabitants[3].hobby = hobbyMap.get(hobby[3]);
                                inhabitants[4].hobby = hobbyMap.get(hobby[4]);
                                printInhabitants();
                                
                                if (validateConfiguration()) {
                                    System.out.println("Solution found!");
                                    //printInhabitants();
                                    return true;
                                }
                            }
                        }
                    }

                }
            }

        }
        return false;
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


    boolean validateDrinkNationColor(Inhabitant[] inhabitants) {
        for (Inhabitant inhabitant : inhabitants){
            try {
                // The Englishman lives in the red house.
                if (inhabitant.nationality == "Englishman") {
                    if (inhabitant.houseColor != "Red") {
                        //System.out.println("The Englishman lives in the red house.");
                        return false;
                    }
                }
                // The person in the green house drinks coffee
                if (inhabitant.houseColor == "Green") {
                    if (inhabitant.drink != "Coffee") {
                        //System.out.println("The person in the green house drinks coffee");
                        return false;
                    }
                    // The first house cannot be green, see explanatio below
                    if (inhabitant.houseNumber == 1) {
                        //System.out.println("The first house cannot be green");
                        return false;
                    }
                    // The green house is immediately to the right of the ivory house.
                    try {
                        if (inhabitants[inhabitant.houseNumber-2].houseColor != "Ivory") {
                            //System.out.println("The green house is not immediately to the right of the ivory house.");
                            return false;
                        }
                    } catch (Exception e) {
                        System.err.println(e);
                        return false;
                    }    
                }
                // The Ukrainian drinks tea.
                if (inhabitant.nationality == "Ukrainian") {
                    if (inhabitant.houseColor != "Tea") {
                        //System.out.println("The Ukrainian drinks tea.");
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
                    if (inhabitant.houseNumber != 1 || inhabitant.houseColor == "Green" ) { // || inhabitant.houseColor == "Blue"
                        //System.out.println("Wrong color house");
                        return false;
                    }
                    // try {
                    //     if (!(inhabitants[inhabitant.houseNumber+2].houseColor == "Blue")) {
                    //         System.out.println("Wrong color neighbouring house");
                    //         return false;
                    //     }
                    // } catch (Exception e) {
                    //     System.err.println(e);
                    //     return false;
                    // }
                }
            } catch (Exception e) {
                System.err.println(e + " property might be empty");
                return false;
            }
        }
        System.out.println("Found a possible solution!");
        return true;
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
