class ArmstrongNumbers {
    static int length;

    boolean isArmstrongNumber(int numberToCheck) {
        if (numberToCheck != 0) {
            numberToCheck = Math.abs(numberToCheck);
            length = (int) (Math.log10(numberToCheck) + 1);
            for (int i = 1; i < length + 1; i++) {
                
            }
        }
        return true;
    }

}
