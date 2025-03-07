public class PangramChecker {

    public boolean isPangram(String input) {
        int[] cps = input.toLowerCase().replaceAll("[^a-z]", "")
            .codePoints()
            .distinct()
            .toArray();

        return cps.length == 26;
    }

}
