package search.strategy;

import java.util.List;
import java.util.Map;

public interface SearchStrategy {
    List<String> search(List<String> data, Map<String, List<Integer>> invertedIndex, List<String> searchQueries);
}
