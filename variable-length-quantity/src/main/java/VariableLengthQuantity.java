import java.util.ArrayList;
import java.util.List;

class VariableLengthQuantity {
    // use | to set bit to 1, use &~ to set bit to 0
    final static int BITMASK = 0x80; 
    
    List<String> encode(List<Long> numbers) {
        List<String> result = new ArrayList<>();

        for (Long num : numbers) {
            List<String> currentNumber = new ArrayList<>();
            currentNumber.add(String.format("%#2x", (byte)(num & ~BITMASK)));
            num >>= 7;
            while (num != 0) {
                currentNumber.add(0, String.format("%#2x", (byte)(num | BITMASK)));
                num >>= 7;
            }
            result.addAll(currentNumber);

        }
        return result;
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