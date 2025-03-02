class ArmstrongNumbers {

    boolean isArmstrongNumber(int numberToCheck) {
        
        numberToCheck = Math.abs(numberToCheck);
        String asStr = Integer.toString(numberToCheck);
        int length = asStr.length();
        
        //return numberToCheck == asStr.chars().map(c -> (int) Math.pow(Character.getNumericValue(c), length)).sum();
        return numberToCheck == asStr.chars().reduce(0, (subtotal, c) -> subtotal + (int) Math.pow(Character.getNumericValue(c), length));

    }

}
