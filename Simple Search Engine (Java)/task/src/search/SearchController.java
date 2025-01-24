package search;

import java.util.ArrayList;
import java.util.List;

public class SearchController {
    private final SearchView view;
    private final SearchModel model;

    public SearchController(SearchView view, SearchModel model) {
        this.view = view;
        this.model = model;
    }

    public void run() {
        view.printOutput(Messages.ENTER_NUMBER_PEOPLE);
        int numOfPeople = Integer.parseInt(view.getInput());

        view.printOutput(Messages.ENTER_ALL_PEOPLE);
        List<String> peopleList = getPeopleList(numOfPeople);

        view.printOutput(Messages.ENTER_NUMBER_SEARCH);
        int numberOfSearch = Integer.parseInt(view.getInput());

        for (int i = 0; i < numberOfSearch; i++) {
            view.printOutput(Messages.ENTER_DATA_SEARCH);
            String dataOfSearch = view.getInput();

            List<String> foundPeople = model.findPeople(peopleList, dataOfSearch);

            if (foundPeople.isEmpty()) {
                view.printOutput(Messages.NOT_FOUND);
            } else {
                view.printOutput(Messages.FOUND_PEOPLE);
                foundPeople.forEach(view::printOutput);
            }
        }
    }

    private List<String> getPeopleList(int numOfPeople) {
        List<String> data = new ArrayList<>();

        for (int i = 0; i < numOfPeople; i++) {
            data.add(view.getInput());
        }

        return data;
    }
}
