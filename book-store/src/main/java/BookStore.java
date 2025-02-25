import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class BookStore {
    static final int COST = 8;
    static final double DISCOUNT_MULTIPLIER_2_DIFF = 0.95;
    static final double DISCOUNT_MULTIPLIER_3_DIFF = 0.90;
    static final double DISCOUNT_MULTIPLIER_4_DIFF = 0.80;
    static final double DISCOUNT_MULTIPLIER_5_DIFF = 0.75;
    
    // make set of unique items, after every iteration, remove the set from list
    // save the lengths of the sets to a list
    // redistribute length values in different ways
    // calculate cost for each way = (len1 * discount multiplier for that len) + (lenK * discount) + ...
    // compare costs of ways
    // final cost = for each list add up (len * discount multiplier for that len) * 8
    double calculateBasketCost(List<Integer> books) {
        List<Integer> mutableBooks = new ArrayList<>(books);
        Collections.sort(mutableBooks);
        List<Integer> bookPileLens = new ArrayList<>();
        while (mutableBooks.size() > 0) {
            List<Integer> distinct_titles = mutableBooks.stream().distinct().collect(Collectors.toList());
            bookPileLens.add(distinct_titles.size());
            IntStream.range(0, distinct_titles.size()).forEach(index -> mutableBooks.remove(mutableBooks.indexOf(distinct_titles.get(index))));
        }        
    
        return 8.00;
    }

}