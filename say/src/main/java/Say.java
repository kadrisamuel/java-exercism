import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

    final static List<String> SCALES = List.of("ten","hundred", "thousand", "million", "billion", "trillion");
 

    public String say(long number) throws IllegalArgumentException {

        if (number < 0 || number > 999_999_999_999L) {
            throw new IllegalArgumentException("Input has to be between 0 and 999,999,999,999");
        }

        String num = Long.toString(number);
        int length = num.length();
        List<Integer> indices = new ArrayList<>(getIndices(length));

        // 
        List<StringBuffer> pieces = new ArrayList<>();
        indices.forEach(index -> pieces.add(getSubstrings(index, num)));

        // List scales that are applicable to the input number: Billion, million, thousand
        List<StringBuffer> scales = new ArrayList<>();
        scales = IntStream.iterate(2, i -> i + 1)
            .limit(indices.size()-1)
            .mapToObj(i -> new StringBuffer(SCALES.get(i)))
            .collect(Collectors.toList())
            .reversed();

        return combine(pieces, scales);   

    }

    private String combine(List<StringBuffer> pieces, List<StringBuffer> scales) {
        String result = IntStream.range(0, pieces.size())
            .mapToObj(x -> {
                StringBuffer temp = new StringBuffer();

                // if there is only one piece, there can be no scale over 100
                // if piece = zero, it is added here
                // other pieces with zeroes are ignored
                if (pieces.size() == 1) {
                    temp.append(pieces.get(x));
                }

                // if there are more pieces than 1 and the current one is not zero
                // add the current piece and a space
                if (pieces.size() > 1 && !pieces.get(x).toString().equals("zero")) {
                    temp.append(pieces.get(x)).append(" ");
                    // if there is a scale available, add it
                    if (scales.size() - 1 >= x) {
                        temp.append(scales.get(x)).append(" ");
                    }
                }
                return temp;
            })
            .collect(StringBuffer::new, StringBuffer::append, StringBuffer::append)
            .toString()
            .strip();
        
        return result;
    }

    // find indices where spaces can be inserted following the format x xxx xxx
    private ArrayList<Integer> getIndices(int len) {
        ArrayList<Integer> result = new ArrayList<>((len % 3 == 0)? (len / 3) : (len / 3 + 1));
        // number is not divisible into 3-char pieces, first piece has to be shorter
        // adding index of where the first piece ends in this case
        if (len % 3 != 0) {
            result.add(len % 3 - 1);
            len -= len % 3;
        }
        while (len > 0) {
            // if sth in result, next index is last + 3
            if (!result.isEmpty()) {
                result.add(result.getLast() + 3);
            }
            // if nothing in result have to add where first piece ends
            // which is always index 2 since shorter lenghts have already been handled
            if (result.isEmpty()) {
                result.add(2);
            }
            len -= 3;
        }
        return result;
    }

    private StringBuffer getSubstrings(int index, String number) {
        StringBuffer temp = new StringBuffer();
        // the first substring can be 1-3 chars
        // index 0 means 1 char, index 1 means 2 chars
        if (index < 2) {
            temp = digitsToSB(number.substring(0, index + 1));
            return temp;
        }
        // subsequent substring are all 3 chars
        temp = digitsToSB(number.substring(index - 2, index + 1));
        return temp;
    }

    private StringBuffer digitsToSB(String number) {
        StringBuffer temp = new StringBuffer();

        // 0-20, 30, 40, 50, 60, 70, 80, 90
        if (lookup.containsKey(Integer.valueOf(number)) ) {
            temp.append(lookup.get(Integer.valueOf(number)));
            return temp;
        }
        if (number.length() == 2) {
            // everything else in range 21-99
            temp.append(digitsToSB(String.valueOf(number.charAt(0) + "0")));
            temp.append("-");
            // x1-x9
            temp.append(digitsToSB(String.valueOf(number.charAt(1))));
            return temp;
        }

        // hundreds
        if (number.length() == 3) {
            temp.append(digitsToSB(String.valueOf(number.charAt(0)))).append(" hundred");
            if (number.charAt(1) != '0' || number.charAt(2) != '0') {
                temp.append(" ").append(digitsToSB(number.substring(1, 3)));
            }
            return temp;
        }
        return temp;

    }
}
