class RaindropConverter {
    final static String divBy3 = "Pling";
    final static String divBy5 = "Plang";
    final static String divBy7 = "Plong";

    String convert(int number) {
        StringBuilder result = new StringBuilder();
        if (number % 3 == 0) {
            result.append(divBy3);
        }
        if (number % 5 == 0) {
            result.append(divBy5);
        }
        if (number % 7 == 0) {
            result.append(divBy7);
        }
        if (result.isEmpty()) {
            result.append(String.valueOf(number));
        }
        return result.toString();
    }

}
