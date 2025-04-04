import java.util.ArrayList;
import java.util.List;

class VariableLengthQuantity {
    // limit is 4 bytes
    // bits go from N-0, 
    // shift 8th bit (index 7) of every byte left to the next byte
    // if current byte is rightmost (last), set 8th bit to 0
    // otherwise set 8th bit to 1

    // Returns 1 if the bit at position n is one
    // compress(x, 1L << n) == (x >> n & 1)
    final static int BITMASK = 0x80; // use | to set bit to 1, use ~& to set bit to 0

    List<String> encode(List<Long> numbers) {
        List<String> result = new ArrayList<>();

        for (Long num : numbers) {
            if (num == 0) {
                result.add("0x0");
                continue;
            }

            List<String> currentNumber = new ArrayList<>();

            // getting the final byte and setting its 8th bit to 0
            // adding it to list
            currentNumber.add(String.format("%#2x", (byte)(num & ~BITMASK)));
            num >>= 7;

            // getting the other bytes and setting their 8th bits to 1
            // prepending them to the list
            while (num != 0) {
                currentNumber.add(0, String.format("%#2x", (byte)(num | BITMASK)));
                num >>= 7;
            }

            result.addAll(currentNumber);

        }
        return result;
    }

    List<String> decode(List<Long> bytes) {
        throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
    }
}
