import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.IntStream;

class School {
    // there are 7 grades
    List<SortedSet<String>> roster = new ArrayList<>(7);
    SortedSet<String> allStudents = new TreeSet<>();

    public School() {
        IntStream.range(0, 7)
            .forEach(x -> roster.add(x, new TreeSet<>()));
    }

    boolean add(String student, int grade) {
        if (allStudents.add(student)) {
            return roster.get(grade-1).add(student);
        }
        return false;
    }

    List<String> roster() {
        if (allStudents.isEmpty()) {
            return List.of();
        }
        return roster.stream().flatMap(s -> s.stream()).toList();
    }

    List<String> grade(int grade) {
        return roster.get(grade-1).stream().toList();
    }

}
