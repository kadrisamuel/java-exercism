import java.util.ArrayList;
import java.util.List;

class Flattener {

    List<Object> flatten(List<?> list) {
        List<Object> res = new ArrayList<>();

        for (Object elem : list) {
            if (elem == null) {
                continue;
            }
            if (elem instanceof List) {
                @SuppressWarnings("unchecked")
                List<Object> temp = (List<Object>) elem;
                if (!temp.isEmpty()) {
                    res.addAll(flatten(temp));
                }
                continue;
            }
            res.add(elem);
        }
        
        return res;
    }

}