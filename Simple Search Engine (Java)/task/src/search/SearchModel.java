package search;

import search.strategy.AllSearchStrategy;
import search.strategy.AnySearchStrategy;
import search.strategy.NoneSearchStrategy;
import search.strategy.SearchContext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchModel {

    public Map<String, List<Integer>> creatingInvertedIndex(List<String> data) {
        Map<String, List<Integer>> invertedIndex = new HashMap<>();

        for (int i = 0; i < data.size(); i++) {
            String line = data.get(i);
            String[] words = line.split("\\s");

            for (String word : words) {
                String lowerCaseWord = word.toLowerCase();
                invertedIndex.putIfAbsent(lowerCaseWord, new ArrayList<>());

                if (!invertedIndex.get(lowerCaseWord).contains(i)) {
                    invertedIndex.get(lowerCaseWord).add(i);
                }
            }
        }

        return invertedIndex;
    }

    public List<String> searchPeople(List<String> data, Map<String, List<Integer>> invertedIndex, List<String> searchQueries, String userChoiceStrategy) {
        SearchContext context = new SearchContext();

        switch (userChoiceStrategy) {
            case "all" -> context.setStrategy(new AllSearchStrategy());
            case "any" -> context.setStrategy(new AnySearchStrategy());
            case "none" -> context.setStrategy(new NoneSearchStrategy());
            default -> {
                return null;
            }
        }

        return context.search(data, invertedIndex, searchQueries);
    }
}
