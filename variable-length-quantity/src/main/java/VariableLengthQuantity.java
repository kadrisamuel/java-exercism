import java.util.ArrayList;
import java.util.List;

class VariableLengthQuantity {
    /*
     * limit is 4 bytes,
     * bits go from N to 0,
     * 
     * Encoding: 
     * shift 8th bit (index 7) of every byte left to the next byte
     * if current byte is rightmost (last), set 8th bit to 0
     * otherwise set 8th bit to 1
     * 
     * Decoding:
     * long res = 0
     * while byte is not last,
     *  set 8th bit to 0 
     *  and shift res left by 7
     *  add byte to res
     * if byte is last,
     *  shift res left by 7
     *  add  byte to res
     *  add hex string of res to output list
     * check if more bytes to process
     */
    
    // Returns 1 if the bit at position n is one
    // compress(x, 1L << n) == (x >> n & 1)
    final static int BITMASK = 0x80; // use | to set bit to 1, use &~ to set bit to 0
    
    // TODO: decoding

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
            // shifting the bits to the right by 7
            // so that the last bit of prev byte would be first of current
            currentNumber.add(String.format("%#2x", (byte)(num & ~BITMASK)));
            num >>= 7;

            // getting the other bytes and setting their 8th bits to 1
            // prepending them to the list
            // shifting
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

        return null;
    }
}
