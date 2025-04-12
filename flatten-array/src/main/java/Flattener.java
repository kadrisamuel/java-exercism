import java.util.ArrayList;
import java.util.List;

class Flattener {

    @SuppressWarnings("unchecked")
    List<Object> flatten(List<?> list) {
        List<Object> flat = new ArrayList<>();

        for (Object elem : list) {
            if (elem == null) {
                continue;
            }
            if (elem instanceof List) {
                flat.addAll(flatten((List<Object>)elem));
                continue;
            }
            flat.add(elem);
        }
        
        return flat;
    }

}