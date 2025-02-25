import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

class BookStore {
    static final double COST = 8;
    static final double[] DISCOUNT_MULTIPLIERS = {1, 0.95, 0.90, 0.80, 0.75};
    
    double calculateBasketCost(List<Integer> books) {
        Collections.sort(books);
        final List<Integer> bookPiles = getInitPiles(books);
        final List<Integer> bestPiles = rearrange(bookPiles);
        return getTotal(bestPiles);
    }

    // final cost = for each list add up (len * discount multiplier for that len) * 8
    double getTotal(List<Integer> books) {
        double total = 0;
        for (int i = 0; i < books.size(); i++) {
            total += books.get(i) * DISCOUNT_MULTIPLIERS[books.get(i)-1];
        }
        return total * COST;
    }

    // find pairs of 5 and 3 and replace them with 4s
    // this code would not work for other sales, 
    // perhaps the true solution to this exercise should solve a general case 
    List<Integer> rearrange(List<Integer> bookPiles) {
        if (bookPiles.contains(5) && bookPiles.contains(3)) {
            bookPiles.remove(Integer.valueOf(5));
            bookPiles.remove(Integer.valueOf(3));
            bookPiles.addAll(List.of(4,4));
            bookPiles = rearrange(bookPiles);
        }
        return bookPiles;
    }

    // make set of unique items, after every iteration, remove the set from list
    // save the lengths of the sets to a list
    List<Integer> getInitPiles(List<Integer> books) {
        List<Integer> mutableBooks = new ArrayList<>(books);
        List<Integer> bookPiles = new ArrayList<>();
        while (mutableBooks.size() > 0) {
            List<Integer> distinct_titles = mutableBooks.stream().distinct().collect(Collectors.toList());
            final int pile = distinct_titles.size();
            bookPiles.add(pile);
            distinct_titles.forEach(item -> mutableBooks.remove(Integer.valueOf(item)));
        } 
        return bookPiles;
    }
}