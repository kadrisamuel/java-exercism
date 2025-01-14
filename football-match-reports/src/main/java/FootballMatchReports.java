public class FootballMatchReports {    
    public static String onField(int shirtNum) {
        String description = "";
        switch (shirtNum) {
            case 1:
                description = "goalie";
                break;
            case 2:
                description = "left back";
                break;
            case 3: case 4:
                description = "center back";
                break;
            case 5:
                description = "right back";
                break;
            case 6: case 7: case 8:
                description = "midfielder";
                break;
            case 9: 
                description = "left wing";
                break;
            case 10: 
                description = "striker";
                break;
            case 11:
                description = "right wing";
                break;
            default:
                throw new IllegalArgumentException("Shirt number outside the range 1-11 is processed in FootballMatchReports.onField() method");
        }
        return description;
    }
}


/* String direction = getDirection();
switch (direction) {
    case "left":
        goLeft();
        break;
    case "right":
        goRight();
        break;
    default:
        // otherwise
        markTime();
        break;
}

1 -> "goalie"
2 -> "left back"
3 & 4 "center back"
5 -> "right back"
6, 7, & 8 -> "midfielder"
9 -> "left wing"
10 -> "striker"
11 -> "right wing" */