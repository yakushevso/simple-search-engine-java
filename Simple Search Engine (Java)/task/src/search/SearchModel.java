package search;

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

    public List<String> searchPeople(List<String> data, Map<String, List<Integer>> invertedIndex, String searchQuery) {
        List<String> foundListOfPeople = new ArrayList<>();
        List<Integer> indexes = invertedIndex.getOrDefault(searchQuery.toLowerCase(), List.of());

        indexes.forEach(index -> foundListOfPeople.add(data.get(index)));

        return foundListOfPeople;
    }
}
