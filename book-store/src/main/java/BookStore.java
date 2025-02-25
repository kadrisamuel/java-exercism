import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class BookStore {
    static final double COST = 8;
    static final double[] DISCOUNT_MULTIPLIERS = {1, 0.95, 0.90, 0.80, 0.75};
    
    double calculateBasketCost(List<Integer> books) {
        List<Integer> bookPileMaxLens = new ArrayList<>(getMaxPileLens(books));
        List<Integer> bestPiles = new ArrayList<>();
        bestPiles = getBestPiles(bookPileMaxLens);
        return getTotal(bestPiles);
    }

    // final cost = for each list add up (len * discount multiplier for that len) * 8
    double getTotal(List<Integer> bestPiles) {
        double total = 0;
        for (int i = 0; i < bestPiles.size(); i++) {
            total += bestPiles.get(i) * DISCOUNT_MULTIPLIERS[bestPiles.get(i)-1];
        }
        return total * COST;
    }
    
    // find pairs of 5 and 3 and replace them with 4s
    // this code would not work for other sales, 
    // perhaps the true solution to this exercise should solve a general case 
    List<Integer> getBestPiles(List<Integer> maxLens) {
        List<Integer> betterPile = new ArrayList<>(maxLens);
        int len = maxLens.size();
        if (len > 1 && (maxLens.contains(5) && maxLens.contains(3))) {
            betterPile.remove(Integer.valueOf(5));
            betterPile.remove(Integer.valueOf(3));
            betterPile.addAll(List.of(4,4));
            betterPile = getBestPiles(betterPile);
        }
        return betterPile;
    }

    // make set of unique items, after every iteration, remove the set from list
    // save the lengths of the sets to a list
    List<Integer> getMaxPileLens(List<Integer> books) {
        List<Integer> mutableBooks = new ArrayList<>(books);
        Collections.sort(mutableBooks);
        List<Integer> bookPileLens = new ArrayList<>();
        while (mutableBooks.size() > 0) {
            List<Integer> distinct_titles = mutableBooks.stream().distinct().collect(Collectors.toList());
            int len = distinct_titles.size();
            bookPileLens.add(len);
            IntStream.range(0, len).forEach(index -> mutableBooks.remove(mutableBooks.indexOf(distinct_titles.get(index))));
        } 
        return bookPileLens;
    }
}