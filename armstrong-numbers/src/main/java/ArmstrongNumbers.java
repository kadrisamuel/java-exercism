class ArmstrongNumbers {
    private static int length;
    private static String asStr;
    private int sum = 0;

    boolean isArmstrongNumber(int numberToCheck) {
        
        numberToCheck = Math.abs(numberToCheck);
        asStr = Integer.toString(numberToCheck);
        length = asStr.length();

        for (int i = 0; i < length; i++) {
            // {asStr.charAt(i) - '0'} converts a char into an int
            sum += Math.pow(asStr.charAt(i) - '0', length);
        }
        
        return (sum == numberToCheck);
    }

}
