import java.util.List;
import java.util.stream.IntStream;

class KindergartenGarden {
    private final static List<String> STUDENTS = List.of("Alice", "Bob", "Charlie", "David", "Eve", "Fred", "Ginny", "Harriet", "Ileana", "Joseph", "Kincaid", "Larry"); 
    private final List<List<Plant>> plants;

    KindergartenGarden(String garden) {
        String[] rows = garden.split("\n");

        this.plants = IntStream.range(0, garden.length() / 4)
            .mapToObj(student -> List.of(
                Plant.getPlant(rows[0].charAt(student * 2)),
                Plant.getPlant(rows[0].charAt(student * 2 + 1)),
                Plant.getPlant(rows[1].charAt(student * 2)),
                Plant.getPlant(rows[1].charAt(student * 2 + 1))
            ))
            .toList();
    }

    List<Plant> getPlantsOfStudent(String student) {
        return plants.get(STUDENTS.indexOf(student));
    }

}
