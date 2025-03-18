import java.util.List;
import java.util.stream.Stream;

class KindergartenGarden {
    private final static List<String> STUDENTS = List.of("Alice", "Bob", "Charlie", "David", "Eve", "Fred", "Ginny", "Harriet", "Ileana", "Joseph", "Kincaid", "Larry"); 
    private final String garden;

    KindergartenGarden(String garden) {
        this.garden = garden;
    }

    List<Plant> getPlantsOfStudent(String student) {
        return garden.lines()
            .flatMap(line -> Stream.of(
                Plant.getPlant(line.charAt(STUDENTS.indexOf(student) * 2)), 
                Plant.getPlant(line.charAt(STUDENTS.indexOf(student) * 2 + 1))))
            .toList();
    }

}
