import java.util.ArrayList;
import java.util.List;

class DiamondPrinter {

    List<String> printToList(char a) {
        List<String> diamond = new ArrayList<>();
        int charIndex = a - 'A'; 

        //populate the top half of the matrix
        for (int line = 0; line <= charIndex; line++) {
            diamond.add(newLine(line, charIndex));
        }     

        //mirror top half of the matrix to the bottom
        for (int line = charIndex - 1; line >= 0; line--) {
            diamond.add(diamond.get(line));            
        }

        return diamond;
    }

    String newLine (int lineIndex, int charIndex) {
        StringBuilder line = new StringBuilder(charIndex * 2  + 1); //length of strings in list is (index of char) * 2 + 1            
        
        for (int columnIndex = 0; columnIndex <= charIndex; columnIndex++){
            // fill the left side of the line
            if (lineIndex + columnIndex == charIndex) {
                line.append((char) ('A' + lineIndex));
            } else {
                line.append(' ');
            }
            
            // when reaching the center of the line,
            // mirror the left side of the line to the right
            if (columnIndex == charIndex) {
                for (int i = columnIndex - 1; i >= 0; i--) {
                    line.append(line.charAt(i));
                }
            }
        }
        return line.toString();
    }

}
