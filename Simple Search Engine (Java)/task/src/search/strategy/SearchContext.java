package search.strategy;

import java.util.List;
import java.util.Map;

public class SearchContext {
    private SearchStrategy strategy;

    public void setStrategy(SearchStrategy strategy) {
        this.strategy = strategy;
    }

    public List<String> search(List<String> data, Map<String, List<Integer>> invertedIndex, List<String> searchQueries) {
        return this.strategy.search(data, invertedIndex, searchQueries);
    }
}
