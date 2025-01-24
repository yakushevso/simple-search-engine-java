package search;

import java.util.ArrayList;
import java.util.List;

public class SearchModel {

    public List<String> findPeople(List<String> peopleList, String dataOfSearch) {
        List<String> foundPeopleList = new ArrayList<>();

        for (String person : peopleList) {
            if (person.toLowerCase().contains(dataOfSearch.toLowerCase())) {
                foundPeopleList.add(person);
            }
        }

        return foundPeopleList;
    }
}
