public class FootballMatchReports {   
    public static void main(String[] args) {
        String sth = onField(4);
        System.out.println(sth);
    }
    public static String onField(int shirtNum) {
        return switch (shirtNum) {
            case 1 ->       "goalie";
            case 2 ->       "left back";
            case 3, 4 ->    "center back";
            case 5 ->       "right back";
            case 6, 7, 8 -> "midfielder";
            case 9 ->       "left wing";
            case 10 ->      "striker";
            case 11 ->      "right wing";
            default -> throw new IllegalArgumentException("Shirt number outside the range 1-11 in FootballMatchReports.onField() method");
        };
    }
}