class IsogramChecker {

    boolean isIsogram(String phrase) {
        int allLetters = (int) phrase.codePoints().filter(c -> Character.isLetter(c)).count();
        int distinctLetters = (int) phrase.toLowerCase().codePoints().filter(c -> Character.isLetter(c)).distinct().count();

        return allLetters == distinctLetters;
    }

}
