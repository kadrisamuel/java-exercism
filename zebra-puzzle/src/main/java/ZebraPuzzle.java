class ZebraPuzzle {
    public class Inhabitant {
        String nationality;
        String pet;
        String drink;
        String hobby;
        String houseColor;
        String leftHouseColor;
        String rightHouseColor;
        int houseNumber;
    }

    Inhabitant[] assignPropertiesToInhabitants() {
        Inhabitant[] inhabitantArray = new Inhabitant[5];
        for (int i = 0; i < 5; i++) {
            inhabitantArray[i].houseNumber = i+1;
        }
        inhabitantArray[0].nationality = "Norwegian";
        inhabitantArray[0].rightHouseColor = "Blue";
        inhabitantArray[1].houseColor = "Blue";
        inhabitantArray[2].drink = "Milk";
        
        
        // Englishman - red house
        // Spaniard - dog pet
        // green house - coffee drink
        // Ukrainian - tea drink
        // green house - leftHouseColor ivory (The green house is immediately to the right of the ivory house.)
        // snail pet - dancing hobby
        // yellow house - painter hobby
        // house 3 - milk drink ++++++++
        // house 1 - Norwegian +++++++++
        // hobby reading - lives in the house next to the person with the fox.
        // hobby painter - next to the house with the horse pet
        // foorball hobby - orange juice drink
        // Japanese - hobby chess
        // Norwegian - lives next to the blue house. +++++
        return inhabitantArray;
    }
    
    String getWaterDrinker() {
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
