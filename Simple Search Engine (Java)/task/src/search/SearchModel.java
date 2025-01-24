package search;

import java.util.ArrayList;
import java.util.List;

public class SearchModel {

    public List<String> searchPeople(List<String> peopleList, String searchQuery) {
        List<String> foundPeopleList = new ArrayList<>();

        for (String person : peopleList) {
            if (person.toLowerCase().contains(searchQuery.toLowerCase())) {
                foundPeopleList.add(person);
            }
        }

        return foundPeopleList;
    }
}
