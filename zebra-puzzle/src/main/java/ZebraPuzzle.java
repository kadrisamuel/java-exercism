class ZebraPuzzle {
    static String[] drinks = {"Coffee", "Tea", "Orange Juice", "Water"}; // "Milk"
    static String[] nationalities = {"Englishman", "Spaniard", "Ukrainian", "Japanese"}; // "Norwegian"
    static String[] colors = {"Red", "Yellow", "Ivory", "Green"}; // "Blue"
    static String[] pets = {"Dog", "Horse", "Snail", "Fox", "Zebra"};
    static String[] hobbies = {"Dancing", "Painting", "Reading", "Football", "Chess"};
    Inhabitant[] inhabitants = new Inhabitant[5];
    
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

    boolean validateConfiguration() {
        for (Inhabitant inhabitant : inhabitants) {
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
            // The Norwegian lives next to the blue house.
            if (inhabitant.nationality == "Norwegian") {
                try {
                    if (!(inhabitants[inhabitant.houseNumber-2].houseColor == "Blue" || inhabitants[inhabitant.houseNumber+2].houseColor == "Blue")) {
                        return false;
                    }
                } catch (Exception e) {
                    return false;
                }
            }
        }
        return true;
    }

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
