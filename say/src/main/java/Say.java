import java.util.HashMap;

public class Say {
    final static HashMap<Integer, String> lookup = new HashMap<>(){{
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
    }};

    final static long BILLION = 1_000_000_000L;
    final static long MILLION = 1_000_000L;
    final static long THOUSAND = 1_000L;
    final static String SPACE = " ";
    final static String DASH = "-"; 

    public String say(long number) throws IllegalArgumentException {

        if (number < 0 || number > 999_999_999_999L) {
            throw new IllegalArgumentException("Input has to be between 0 and 999,999,999,999");
        }

        if (number == 0) {
            return "zero";
        }

        return sayIt(number);
    }

    private String sayIt(long number) {
        if (number >= BILLION) { return sayIt(number/BILLION) + SPACE + "billion" + more(number % BILLION); }
        if (number >= MILLION) { return sayIt(number/MILLION) + SPACE + "million" + more(number % MILLION); }
        if (number >= THOUSAND) { return sayIt(number/THOUSAND) + SPACE + "thousand" + more(number % THOUSAND); }
        if (number >= 100) { return sayIt(number/100) + SPACE + "hundred" + more(number % 100); }

        Integer num = (int) number;
        if (number >= 20) {
            if (number % 10 != 0) {
                return lookup.get(num - num % 10) + DASH + lookup.get(num % 10);
            }
            return lookup.get(num);
        }
        return lookup.get(num);
    }

    private String more(long number) {
        return (number != 0)? SPACE + sayIt(number) : "";
    }
}