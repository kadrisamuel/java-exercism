import java.util.ArrayList;
import java.util.List;

class DiamondPrinter {
    final private List<Character> alfabet =  List.of( 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' );
    List<String> diamond = new ArrayList<>();

    List<String> printToList(char a) {
        // len on strings and whole list should be (index of char) * 2 + 1
        if (alfabet.contains(a)) {
            System.out.println(a);
            int index = alfabet.indexOf(a);
            System.out.println(index);
            int len = index * 2  + 1;
            System.out.println(len);

            for (int i = 0; i < len; i++) {
                StringBuilder line = new StringBuilder(len);
                if (i == index) {
                    line.append(a);
                    System.out.println("i == index " + line.toString());
                } else {
                    line.append(' ');
                }
                System.out.println("Diamond size " + diamond.size());
                String temp = line.toString();
                boolean success = diamond.add(temp);
                System.out.println(success);
                System.out.println("Diamond size " + diamond.size());
                System.out.println("Diamond.add  " + diamond.toString());
            }
        }
        return diamond;
    }

}
