import java.util.Arrays;
import java.util.List;

class ResistorColorTrio {
    private static final String[] colors = {"black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white"};
    private static final List<String> lookup = Arrays.asList(colors);

    int stripTail(int originalValue, int toStrip){
        return Integer.parseInt(String.valueOf(originalValue).substring(0, String.valueOf(originalValue).length() - toStrip));
    }

    boolean trailingZero(int input){
        String value = String.valueOf(input);
        return value.charAt(value.length() - 1) == '0';
    }

    String label(String[] colors) {
        int value = (lookup.indexOf(colors[0]) * 10 + lookup.indexOf(colors[1]));
        boolean extraZero = trailingZero(value);
        int exponent = lookup.indexOf(colors[2]);


        if (exponent < 2) {
            value = value * (int) Math.pow(10, exponent);
        } else {
            if (exponent % 3 != 0 && extraZero) {      
            value = stripTail(value, 1);
            exponent += 1;
            }
            if (exponent % 3 != 0 && !extraZero){
                value = value * 10;
                exponent -= 1;
            }
        }


        switch (exponent) {
            case 0, 1, 2:
                return value + " ohms";

            case 3, 4, 5:
                return value + " kiloohms";

            case 6, 7, 8:
                return value + " megaohms";

            case 9, 10:
                return value + " gigaohms";
        
            default:
                return "wrong input";
        }
    }

}






