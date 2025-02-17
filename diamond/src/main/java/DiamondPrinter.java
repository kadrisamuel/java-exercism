import java.util.ArrayList;
import java.util.List;

class DiamondPrinter {
    final private List<Character> alfabet =  List.of( 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' );
    List<String> diamond = new ArrayList<>();

    List<String> printToList(char a) {
        // len on strings and whole list should be (index of char) * 2 + 1
        if (alfabet.contains(a)) {
            int index = alfabet.indexOf(a);
            int len = index * 2  + 1;

            //make the top half of thr matrix
            for (int line = 0; line <= index; line++) {
                StringBuilder row = new StringBuilder(len);
                for (int column = 0; column <= index; column++){
                    if (line + column == index) {
                        row.append(alfabet.get(line));
                    } else {
                        row.append(' ');
                    }
                    // mirror the left side of the row to right
                    if (column == index) {
                        for (int i = index - 1; i >= 0; i--) {
                            row.append(row.charAt(i));
                        }
                    }
                }

                diamond.add(row.toString());
                System.out.println(diamond.toString());
            }

            //mirror top half of matrix to bottom
            for (int i = index - 1; i >= 0; i--) {
                diamond.add(diamond.get(i));
            }
            System.out.println(diamond.toString());
        }
        return diamond;
    }

}
