package search.strategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AllSearchStrategy implements SearchStrategy {
    @Override
    public List<String> search(List<String> data, Map<String, List<Integer>> invertedIndex, List<String> searchQueries) {
        List<String> foundListOfPeople = new ArrayList<>();
        List<Integer> indexes = new ArrayList<>(invertedIndex.getOrDefault(searchQueries.get(0).toLowerCase(), List.of()));

        for (int i = 1; i < searchQueries.size(); i++) {
            indexes.retainAll(invertedIndex.getOrDefault(searchQueries.get(i).toLowerCase(), List.of()));
        }

        indexes.forEach(index -> foundListOfPeople.add(data.get(index)));

        return foundListOfPeople;
    }
}
