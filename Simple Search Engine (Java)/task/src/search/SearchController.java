package search;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class SearchController {
    private final SearchView view;
    private final SearchModel model;
    private final String filePath;

    public SearchController(SearchView view, SearchModel model, String filePath) {
        this.view = view;
        this.model = model;
        this.filePath = filePath;
    }

    public void run() {
        List<String> people = filePath == null ? loadPeopleData() : loadPeopleFromFile(filePath);

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

    private List<String> loadPeopleFromFile(String filePath) {
        try {
            return Files.readAllLines(Path.of(filePath));
        } catch (IOException e) {
            throw new RuntimeException("Failed to read the file at path: " + filePath, e);
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
        List<String> data = new ArrayList<>();

        for (int i = 0; i < numOfPeople; i++) {
            data.add(view.getInput());
        }

        return data;
    }
}
