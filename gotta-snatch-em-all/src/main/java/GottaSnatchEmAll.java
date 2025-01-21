import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

class GottaSnatchEmAll {

    static Set<String> newCollection(List<String> cards) {
        Set<String> newCollection = new HashSet<>();
        for (int i = 0; i < cards.size(); i++) {
            newCollection.add(cards.get(i));
        }
        return newCollection;
    }

    static boolean addCard(String card, Set<String> collection) {
        return collection.add(card);
    }

    static boolean canTrade(Set<String> myCollection, Set<String> theirCollection) {
        return (myCollection.isEmpty() || theirCollection.isEmpty() || myCollection.containsAll(theirCollection) || theirCollection.containsAll(myCollection))? false : true;
    }

    static Set<String> commonCards(List<Set<String>> collections) {
        Set<String> newCollection = new HashSet<>();
        Iterator<String> cardsIterator = collections.get(0).iterator();

        while (cardsIterator.hasNext() ) {
            String card = cardsIterator.next();
            int setsWithCard = 0;

            for (int i = 0; i < collections.size(); i++) {
                if (collections.get(i).contains(card) && setsWithCard < collections.size()) {
                    setsWithCard += 1;
                }
                if (setsWithCard == collections.size()) {
                    newCollection.add(card);
                }
            }
        }

        return newCollection;
        
    }

    static Set<String> allCards(List<Set<String>> collections) {
        Set<String> allCards = new HashSet<>();

        for (int i = 0; i < collections.size(); i++) {
            Iterator<String> cardsIterator = collections.get(i).iterator();
            while (cardsIterator.hasNext()) {
                allCards.add(cardsIterator.next());
            }
        }

        return allCards;
    }
}
