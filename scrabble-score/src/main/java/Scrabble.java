class Scrabble {
    private final int score;

    Scrabble(String word) {
        this.score = word.toUpperCase()
            .codePoints()
            .reduce(0, (score, letter) -> score + getPoints((char) letter));
    }

    int getScore() {
        return this.score;
    }

    private int getPoints(char letter) {
        return switch (letter) {
            case 'A', 'E', 'I', 'O', 'U', 'L', 'N', 'R', 'S', 'T' -> 1;        
            case 'D', 'G' -> 2;
            case 'B', 'C', 'M', 'P' -> 3;
            case 'F', 'H', 'V', 'W', 'Y' -> 4;
            case 'K' -> 5;
            case 'J', 'X' -> 8;
            case 'Q', 'Z' -> 10;
            default -> 0;
        };
    }

}
