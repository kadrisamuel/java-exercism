import java.util.ArrayList;
import java.util.List;

class VariableLengthQuantity {
    // use | to set bit to 1, use &~ to set bit to 0
    final static int BITMASK = 0x80; 
    
    List<String> encode(List<Long> numbers) {
        return numbers.stream().map(num -> encodeNumber(num)).flatMap(List::stream).toList();
    }

    List<String> encodeNumber(Long number){
        List<String> numberStrings = new ArrayList<>();
        numberStrings.add(String.format("%#2x", (byte)(number & ~BITMASK)));
        number >>= 7;
        while (number != 0) {
            numberStrings.add(0, String.format("%#2x", (byte)(number | BITMASK)));
            number >>= 7;
        }
        return numberStrings;
    }

    List<String> decode(List<Long> bytes) throws IllegalArgumentException {
        if (bytes.get(bytes.size()-1) > 127) {
            throw new IllegalArgumentException("Invalid variable-length quantity encoding");
        }

        List<String> results = new ArrayList<>();
        Long res = 0L;
        for (Long num : bytes) {
            res <<= 7;
            // last byte in long
            if (num < 128) {
                res += num;
                results.add(String.format("%#2x", res));
                res = 0L;
                continue;
            }
            num = (num & ~BITMASK);
            res += num;
        }

        return results;
    }
}