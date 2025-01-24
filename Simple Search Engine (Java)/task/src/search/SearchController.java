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
        List<String> people = loadPeopleData();

        while (true) {
            view.printOutput(Messages.MENU);

            String userChoice = view.getInput();

            switch (userChoice) {
                case "1" -> searchForPeople(people);
                case "2" -> displayListOfPeople(Messages.LIST_OF_PEOPLE, people);
                case "0" -> {
                    view.printOutput(Messages.BYE);
                    return;
                }
                default -> view.printOutput(Messages.INCORRECT_OPTION);
            }
        }
    }

    private void displayListOfPeople(Messages listOfPeople, List<String> people) {
        view.printOutput(listOfPeople);
        people.forEach(view::printOutput);
    }

    private void searchForPeople(List<String> people) {
        view.printOutput(Messages.ENTER_NAME_OR_EMAIL);
        String searchQuery = view.getInput();

        List<String> matchingPeople = model.searchPeople(people, searchQuery);

        if (matchingPeople.isEmpty()) {
            view.printOutput(Messages.NOT_FOUND);
        } else {
            displayListOfPeople(Messages.FOUND_PEOPLE, matchingPeople);
        }
    }

    private List<String> loadPeopleData() {
        view.printOutput(Messages.ENTER_NUMBER_PEOPLE);
        int numOfPeople = Integer.parseInt(view.getInput());

        view.printOutput(Messages.ENTER_ALL_PEOPLE);

        return getPeopleList(numOfPeople);
    }

    private List<String> getPeopleList(int numOfPeople) {
        List<String> data = new ArrayList<>();

        for (int i = 0; i < numOfPeople; i++) {
            data.add(view.getInput());
        }

        return data;
    }
}
