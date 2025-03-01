import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.IntStream;

class ZebraPuzzle {
    static final String[] drinks = {"Coffee", "Tea", "Orange Juice", "Water", "Milk"}; // "Milk"
    static final String[] nationalities = {"Englishman", "Spaniard", "Ukrainian", "Japanese", "Norwegian"}; // "Norwegian"
    static final String[] colors = {"Red", "Yellow", "Ivory", "Green", "Blue"}; // "Blue"
    static final String[] pets = {"Dog", "Horse", "Snail", "Fox", "Zebra"};
    static final String[] hobbies = {"Dancing", "Painting", "Reading", "Football", "Chess"};

    static Map<Integer, String> drinkMap = new HashMap<Integer, String>();
    static Map<Integer, String> nationMap = new HashMap<Integer, String>();
    static Map<Integer, String> colorMap = new HashMap<Integer, String>();
    static Map<Integer, String> petMap = new HashMap<Integer, String>();
    static Map<Integer, String> hobbyMap = new HashMap<Integer, String>();

    static Map< String, Integer> revDrinkMap =  new HashMap< String, Integer>();
    static Map< String, Integer> revNationMap = new HashMap< String, Integer>();
    static Map< String, Integer> revColorMap =  new HashMap< String, Integer>();
    static Map< String, Integer> revPetMap =    new HashMap< String, Integer>();
    static Map< String, Integer> revHobbyMap =  new HashMap< String, Integer>();

    static Set<Integer[]> perm4 = new HashSet<Integer[]>(24);
    static Set<Integer[]> perm5 = new HashSet<Integer[]>(120);
    static final Integer[] fourIndices = {0, 1, 2, 3};
    static final Integer[] fiveIndices = {0, 1, 2, 3, 4};

    static Inhabitant[] inhabArray = new Inhabitant[5];
    static Inhabitant[] inhabArrayTest = new Inhabitant[5];

    static {
        perm4 = permutationGen(fourIndices);
        perm5 = permutationGen(fiveIndices);
    }

    static {
        IntStream.range(0, 5).forEach(index ->  drinkMap.put(index, drinks[index]));
        IntStream.range(0, 5).forEach(index -> nationMap.put(index, nationalities[index]));
        IntStream.range(0, 5).forEach(index ->  colorMap.put(index, colors[index]));
        IntStream.range(0, 5).forEach(index ->    petMap.put(index, pets[index]));
        IntStream.range(0, 5).forEach(index ->  hobbyMap.put(index, hobbies[index]));

        IntStream.range(0, 5).forEach(index ->  revDrinkMap.put(drinks[index],        index));
        IntStream.range(0, 5).forEach(index -> revNationMap.put(nationalities[index], index));
        IntStream.range(0, 5).forEach(index ->  revColorMap.put(colors[index],        index));
        IntStream.range(0, 5).forEach(index ->    revPetMap.put(pets[index],          index));
        IntStream.range(0, 5).forEach(index ->  revHobbyMap.put(hobbies[index],       index));
    }

    static {
        ZebraPuzzle puzzle = new ZebraPuzzle();
       // inhabArray = puzzle.assignPropertiesToInhabitants(inhabArray);
        ZebraPuzzle correct = new ZebraPuzzle();
        inhabArrayTest = correct.assignCorrectProperties(inhabArrayTest);
    }

    public static void main(String[] args) {
        //perm5.forEach(array -> System.out.println(Arrays.toString(array)));
        /* ZebraPuzzle test = new ZebraPuzzle();
        test.assignCorrectProperties(inhabArrayTest);
        boolean correctSolutionExists = test.testPermutation(2, inhabArrayTest);
        if (correctSolutionExists) {
            System.out.println("Solution!");
        } else {
            System.out.println("So sad!");
        }*/
    }
    

    public class Inhabitant {
        int nationality;
        int pet;
        int drink;
        int hobby;
        int houseColor;
        int houseNumber;
    }

    public void printInhabitants(Inhabitant[] inhabitants) {
        for (Inhabitant inhabitant : inhabitants) {
            System.out.println("House nr " + inhabitant.houseNumber);
            System.out.println(nationMap.get(inhabitant.nationality));
            System.out.println(drinkMap.get(inhabitant.drink));
            System.out.println(colorMap.get(inhabitant.houseColor));
            System.out.println(hobbyMap.get(inhabitant.hobby));
            System.out.println(petMap.get(inhabitant.pet));
        }
    }

//
//  Method that creates the correct solution (for testing purposes)
//
    public Inhabitant[] assignCorrectProperties(Inhabitant[] inhabitants) {
        for (int i = 0; i < 5; i++) {
            inhabitants[i] = new Inhabitant();
            inhabitants[i].houseNumber = i+1;
        }

        inhabitants[0].drink = revDrinkMap.get("Water");
        inhabitants[0].hobby = revHobbyMap.get("Painting"); 
        inhabitants[0].houseColor = revColorMap.get("Yellow"); 
        inhabitants[0].nationality = revNationMap.get("Norwegian");
        inhabitants[0].pet = revPetMap.get("Fox");

        inhabitants[1].drink = revDrinkMap.get("Tea"); 
        inhabitants[1].hobby = revHobbyMap.get("Reading"); 
        inhabitants[1].houseColor = revColorMap.get("Blue");
        inhabitants[1].nationality = revNationMap.get("Ukrainian"); 
        inhabitants[1].pet = revPetMap.get("Horse"); 

        inhabitants[2].drink = revDrinkMap.get("Milk"); 
        inhabitants[2].hobby = revHobbyMap.get("Dancing"); 
        inhabitants[2].houseColor = revColorMap.get("Red"); 
        inhabitants[2].nationality = revNationMap.get("Englishman");
        inhabitants[2].pet = revPetMap.get("Snail"); 

        inhabitants[3].drink = revDrinkMap.get("Orange Juice"); 
        inhabitants[3].hobby = revHobbyMap.get("Football"); 
        inhabitants[3].houseColor = revColorMap.get("Ivory"); 
        inhabitants[3].nationality = revNationMap.get("Spaniard"); 
        inhabitants[3].pet = revPetMap.get("Dog"); 

        inhabitants[4].drink = revDrinkMap.get("Coffee");
        inhabitants[4].hobby = revHobbyMap.get("Chess"); 
        inhabitants[4].houseColor = revColorMap.get("Green");
        inhabitants[4].nationality = revNationMap.get("Japanese");
        inhabitants[4].pet = revPetMap.get("Zebra"); 

        return inhabitants;
    }

//
//  Methods to create inhabitant data based on permutations
//
    // Makes 5 inhabitant objects, assigns known and generated properties to them
    public Inhabitant[] assignPropertiesToInhabitants(Inhabitant[] inhabitants) {
        for (int i = 0; i < 5; i++) {
            inhabitants[i] = new Inhabitant();
            inhabitants[i].houseNumber = i+1;
        }
        
        // apply permutations recursively to all properties
        for (Integer[] drink : perm4) {
            assignAttribute(drink, "drink", inhabitants);

            for (Integer[] nation : perm4) {
                assignAttribute(nation, "nationality", inhabitants);

                for (Integer[] color : perm4) {
                    assignAttribute(color, "color", inhabitants);

                    // Continue with the permutation only if the first three attributes pass the tests
                    if (testPermutation(1, inhabitants)) {

                        for (Integer[] pet : perm5) {
                            assignAttribute(pet, "pet", inhabitants);
                            for (Integer[] hobby : perm5) {
                                assignAttribute(hobby, "hobby", inhabitants);
                                
                                if (testPermutation(2, inhabitants)) {
                                    //System.out.println("Solution found!");
                                    return inhabitants;
                                } 
                                //System.out.println("Wrong solution");
                            }
                        }
                        
                    }

                }
            }

        }
        return inhabitants;
    }


    void assignAttribute(Integer[] array, String attribute, Inhabitant[] inhabitants) {
        switch (attribute) {
            case "drink":
                inhabitants[0].drink = array[0];
                inhabitants[1].drink = array[1];
                inhabitants[2].drink = revDrinkMap.get("Milk"); // The person in the middle house drinks milk
                inhabitants[3].drink = array[2];
                inhabitants[4].drink = array[3];
                break;

            case "color":
                inhabitants[0].houseColor = array[0];
                inhabitants[1].houseColor = revColorMap.get("Blue"); // The Norwegian lives next to the blue house.
                inhabitants[2].houseColor = array[1];
                inhabitants[3].houseColor = array[2];
                inhabitants[4].houseColor = array[3];
                break;

            case "nationality":
                inhabitants[0].nationality = revNationMap.get("Norwegian"); // The Norwegian lives in the first house.
                inhabitants[1].nationality = array[0];
                inhabitants[2].nationality = array[1];
                inhabitants[3].nationality = array[2];
                inhabitants[4].nationality = array[3];
                break;

            case "pet":                
                inhabitants[0].pet = array[0];
                inhabitants[1].pet = array[1];
                inhabitants[2].pet = array[2];
                inhabitants[3].pet = array[3];
                inhabitants[4].pet = array[4];
                break;

            case "hobby":                
                inhabitants[0].hobby = array[0];
                inhabitants[1].hobby = array[1];
                inhabitants[2].hobby = array[2];
                inhabitants[3].hobby = array[3];
                inhabitants[4].hobby = array[4];
                break;
        
            default:
                break;
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
//  Method to test if a permutation has the correct solution
//
    boolean testPermutation(int scope, Inhabitant[] inhabitants) {
        for (Inhabitant inhabitant : inhabitants) {
            // nationality, color, drink
            if (scope >= 1) {

                // The Englishman lives in the red house.
                if (inhabitant.nationality == revNationMap.get("Englishman")) {
                    if (inhabitant.houseColor != revColorMap.get("Red")) {
                        //System.out.println("The Englishman lives in the red house.");
                        return false;
                    }
                }

                // The person in the green house drinks coffee
                if (inhabitant.houseColor == revColorMap.get("Green")) {
                    if (inhabitant.drink != revDrinkMap.get("Coffee")) {
                        //System.out.println("The person in the green house drinks coffee");
                        return false;
                    }
                    // The first house cannot be green, see explanatio below
                    if (inhabitant.houseNumber == 1) {
                        //System.out.println("The first house cannot be green");
                        return false;
                    }
                    // The green house is immediately to the right of the ivory house.
                    if (inhabitant.houseNumber > 1 && inhabitants[inhabitant.houseNumber-2].houseColor != revColorMap.get("Ivory")) {
                        //System.out.println("The green house is immediately to the right of the ivory house.");
                        return false;
                    }   
                }

                // The Ukrainian drinks tea.
                if (inhabitant.nationality == revNationMap.get("Ukrainian")) {
                    if (inhabitant.drink != revDrinkMap.get("Tea")) {
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
                if (inhabitant.nationality == revNationMap.get("Norwegian")) {
                    if (inhabitant.houseNumber != 1 || inhabitant.houseColor == revColorMap.get("Green") || inhabitant.houseColor == revColorMap.get("Blue")) {
                        //System.out.println("The Norwegian lives in the first house. 1. if");
                        return false;
                    }
                    if (inhabitant.houseNumber < 5 && !(inhabitants[inhabitant.houseNumber].houseColor == revColorMap.get("Blue"))) {
                        //System.out.println("The Norwegian lives in the first house. 2. if");
                        return false;
                    }
                }
            }

            if (scope >= 2) {

                // The Spaniard owns the dog.
                if (inhabitant.nationality == revNationMap.get("Spaniard")) {
                    if (inhabitant.pet != revPetMap.get("Dog")) {
                        //System.out.println("The Spaniard owns the dog.");
                        return false;
                    }
                }

                // The snail owner likes to go dancing.
                if (inhabitant.pet == revPetMap.get("Snail")) {
                    if (inhabitant.hobby != revHobbyMap.get("Dancing")) {
                        //System.out.println("The snail owner likes to go dancing.");
                        return false;
                    }
                }

                // The person in the yellow house is a painter.
                if (inhabitant.houseColor == revColorMap.get("Yellow")) {
                    if (inhabitant.hobby != revHobbyMap.get("Painting")) {
                        //System.out.println("The person in the yellow house is a painter.");
                        return false;
                    }
                    // The painter's house is next to the house with the horse.
                    if ((inhabitant.houseNumber > 1 && (inhabitants[inhabitant.houseNumber-2].pet != revPetMap.get("Horse"))) && (inhabitant.houseNumber < 5 && (inhabitants[inhabitant.houseNumber].pet != revPetMap.get("Horse")))) {
                        //System.out.println("The painter's house is next to the house with the horse.");
                        return false;
                    }
                }

                // The person who enjoys reading lives in the house next to the person with the fox.
                if (inhabitant.hobby == revHobbyMap.get("Reading")) {
                    if ((inhabitant.houseNumber > 1 && (inhabitants[inhabitant.houseNumber-2].pet != revPetMap.get("Fox"))) && (inhabitant.houseNumber < 5 && (inhabitants[inhabitant.houseNumber].pet != revPetMap.get("Fox")))) {
                        //System.out.println("The person who enjoys reading lives in the house next to the person with the fox.");
                        return false;
                    }
                }

                // The person who plays football drinks orange juice.
                if (inhabitant.hobby == revHobbyMap.get("Football")) {
                    if (inhabitant.drink != revDrinkMap.get("Orange Juice")) {
                        //System.out.println("The person who plays football drinks orange juice.");
                        return false;
                    }
                }

                // The Japanese person plays chess.
                if (inhabitant.nationality == revNationMap.get("Japanese")) {
                    //The Japanese person plays chess.
                    if (inhabitant.hobby != revHobbyMap.get("Chess")) {
                        //System.out.println("The Japanese person plays chess.");
                        return false;
                    }
                    // The Japanese person owns a zebra
                    if (inhabitant.pet != revPetMap.get("Zebra")) {
                        //System.out.println("The Japanese person owns a zebra");
                        return false;
                    }
                }

                // The Norwegian drinks water
                if (inhabitant.nationality == revNationMap.get("Norwegian")){
                    if (inhabitant.drink != revDrinkMap.get("Water")) {
                        //System.out.println("The Norwegian drinks water");
                        return false;
                    }
                }
            }
        }

        //printInhabitants(inhabitants);
        return true;
    }


//
//  Getter methods used by tests
//  
    String getWaterDrinker() {
        for (Inhabitant inhabitant : inhabArray) {
            if (inhabitant.drink == revDrinkMap.get("Water")) {
                return nationMap.get(inhabitant.nationality);
            }
        }
        return "waterDrinker";
    }

    String getZebraOwner() {
        for (Inhabitant inhabitant : inhabArray) {
            if (inhabitant.pet == revPetMap.get("Zebra")) {
                return nationMap.get(inhabitant.nationality);
            }
        }
        return "zebraOwner";
    }
}
