class ArmstrongNumbers {
    private static int length;
    private static String asStr;
    private int sum = 0;

    boolean isArmstrongNumber(int numberToCheck) {
        
        numberToCheck = Math.abs(numberToCheck);
        asStr = Integer.toString(numberToCheck);
        length = asStr.length();

        asStr.chars().forEach(c -> {sum += Math.pow(c - '0', length);});
        
        return sum == numberToCheck;
    }

}
