import java.util.HashSet;
import java.util.List;
import java.util.Set;

class GottaSnatchEmAll {

    static Set<String> newCollection(List<String> cards) {
        Set<String> newCollection = new HashSet<>(cards);
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
        newCollection.addAll(collections.get(0));
        collections.forEach(newCollection::retainAll);
        return newCollection;
    }

    static Set<String> allCards(List<Set<String>> collections) {
        Set<String> allCards = new HashSet<>();
        collections.forEach(allCards::addAll);
        return allCards;
    }
}
