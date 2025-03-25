import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class ChangeCalculator {
    private final List<Integer> availableCoins;

    ChangeCalculator(List<Integer> currencyCoins) {
        this.availableCoins = currencyCoins;
    }

    // Based on jagdishdrp's and ErikSchierboom's solutions
    List<Integer> computeMostEfficientChange(int grandTotal) {
        if (grandTotal < 0) {
            throw new IllegalArgumentException("Negative totals are not allowed.");
        }
        if (grandTotal == 0) {
            return List.of();
        }
        if (grandTotal < availableCoins.get(0)) {
            throw  new IllegalArgumentException(String.format
                ("The total %d cannot be represented in the given currency.", grandTotal));
        }
        if (availableCoins.contains(grandTotal)) {
            return List.of(grandTotal);
        }

        List<List<Integer>> coinsUsed = compileCoinsLists(grandTotal);

        if (coinsUsed.get(grandTotal) == null) {
            throw  new IllegalArgumentException(String.format
                ("The total %d cannot be represented in the given currency.", grandTotal));
        }

        return coinsUsed.get(grandTotal);
    }

    List<List<Integer>> compileCoinsLists(int grandTotal){
        List<List<Integer>> coinsUsed = new ArrayList<>(grandTotal + 1);
        coinsUsed.add(new ArrayList<>());

        for (int i = 1; i <= grandTotal; i++) {
            final int amount = i;
            List<Integer> bestCombo = availableCoins.stream()
                .filter(coin -> coin <= amount && coinsUsed.get(amount - coin) != null)
                .map(coin -> {
                    List<Integer> currentCombo = new ArrayList<>(coinsUsed.get(amount - coin));
                    currentCombo.add(0, coin);
                    return currentCombo;
                })
                .sorted(Comparator.comparingInt(List::size))
                .findFirst()
                .orElse(null);

            coinsUsed.add(bestCombo);
        }
        return coinsUsed;
    }

}
