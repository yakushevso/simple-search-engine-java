package search.strategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AnySearchStrategy implements SearchStrategy {
    @Override
    public List<String> search(List<String> data, Map<String, List<Integer>> invertedIndex, List<String> searchQueries) {
        List<String> foundListOfPeople = new ArrayList<>();
        List<Integer> indexes = new ArrayList<>();

        for (String query : searchQueries) {
            indexes.addAll(invertedIndex.getOrDefault(query.toLowerCase(), List.of()));
        }

        indexes.forEach(index -> foundListOfPeople.add(data.get(index)));

        return foundListOfPeople;
    }
}
