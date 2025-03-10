import java.util.HashMap;

public class Say {
    HashMap<Integer, String> lookup = new HashMap<>(){{
        //put(-1, "-");
        put(0, "zero");
        put(1, "one");
        put(2, "two");
        put(3, "three");
        put(4, "four");
        put(5, "five");
        put(6, "six");
        put(7, "seven");
        put(8, "eight");
        put(9, "nine");
        put(10, "ten");
        put(11, "eleven");
        put(12, "twelve");
        put(13, "thirteen");
        put(14, "fourteen");
        put(15, "fifteen");
        put(16, "sixteen");
        put(17, "seventeen");
        put(18, "eighteen");
        put(19, "nineteen");
        put(20, "twenty");
        put(30, "thirty");
        put(40, "forty");
        put(50, "fifty");
        put(60, "sixty");
        put(70, "seventy");
        put(80, "eighty");
        put(90, "ninety");
        //put(100, "hundred");
        //put(103, "thousand");
        //put(106, "million");
        //put(109, "billion");
    }};

    public String say(long number) throws IllegalArgumentException {
        if (number < 0 || number > 999_999_999_999L) {
            throw new IllegalArgumentException("Input has to be between 0 and 999,999,999,999");
        }
        final String num = Long.toString(number);
        final int length = num.length();
        return digitsTo99(num).toString();

    }

    StringBuffer digitsTo99(String number) {
        StringBuffer temp = new StringBuffer();

        // 0-20, 30, 40, 50, 60, 70, 80, 90
        if (lookup.containsKey(Integer.valueOf(number)) ) {
            temp.append(lookup.get(Integer.valueOf(number)));
            return temp;
        }
        if (number.length() == 2) {
            // everything else in range 21-99
            temp.append(digitsTo99(String.valueOf(number.charAt(0) + "0")));
            temp.append("-");
            // x1-x9
            temp.append(digitsTo99(String.valueOf(number.charAt(1))));
            return temp;
        }

        // hundreds
        if (number.length() == 3) {
            temp.append(digitsTo99(String.valueOf(number.charAt(0)))).append(" hundred");
            if (number.charAt(1) != '0' || number.charAt(2) != '0') {
                temp.append(" ").append(digitsTo99(number.substring(1, 3)));
            }
            return temp;
        }
        return temp;

    }
}
