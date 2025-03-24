import java.util.ArrayList;
import java.util.List;

class ChangeCalculator {
    private final List<Integer> availableCoins;

    ChangeCalculator(List<Integer> currencyCoins) {
        this.availableCoins = currencyCoins;
    }

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

        List<List<Integer>> coinsUsed = new ArrayList<>(grandTotal + 1);
        coinsUsed.add(new ArrayList<>());

        // heavily based on https://exercism.org/tracks/java/exercises/change/approaches/dynamic-programming 
        for (int i = 1; i <= grandTotal; i++) {
            List<Integer> bestCombo = null;
            for (Integer coin : availableCoins) {
                if (coin <= i && coinsUsed.get(i - coin) != null) {
                    List<Integer> currentCombo = new ArrayList<>(coinsUsed.get(i - coin));
                    currentCombo.add(0, coin);
                    if (bestCombo == null || currentCombo.size() < bestCombo.size()) {
                        bestCombo = currentCombo;
                    }
                }
            }
            coinsUsed.add(bestCombo);
        }

        if (coinsUsed.get(grandTotal) == null) {
            throw  new IllegalArgumentException(String.format
                ("The total %d cannot be represented in the given currency.", grandTotal));
        }

        return coinsUsed.get(grandTotal);
    }

}
