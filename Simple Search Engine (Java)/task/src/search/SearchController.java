package search;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
        List<String> data = filePath == null ? loadDataFromConsole() : loadDataFromFile(filePath);

        while (true) {
            view.printOutput(Messages.MENU);

            String userChoice = view.getInput();

            switch (userChoice) {
                case "1" -> searchForPeople(data);
                case "2" -> displayAllPeople(data);
                case "0" -> {
                    view.printOutput(Messages.BYE);
                    return;
                }
                default -> view.printOutput(Messages.INCORRECT_OPTION);
            }
        }
    }

    private void searchForPeople(List<String> data) {
        view.printOutput(Messages.ENTER_NAME_OR_EMAIL);
        String searchQuery = view.getInput();

        Map<String, List<Integer>> invertedIndex = model.creatingInvertedIndex(data);
        List<String> matchingListOfPeople = model.searchPeople(data, invertedIndex, searchQuery);

        if (matchingListOfPeople.isEmpty()) {
            view.printOutput(Messages.NOT_FOUND);
        } else {
            view.printOutput(matchingListOfPeople.size() + Messages.FOUND_PEOPLE.toString());
            matchingListOfPeople.forEach(view::printOutput);
        }
    }

    private void displayAllPeople(List<String> data) {
        view.printOutput(Messages.LIST_OF_PEOPLE);
        data.forEach(view::printOutput);
    }

    private List<String> loadDataFromFile(String filePath) {
        try {
            return Files.readAllLines(Path.of(filePath));
        } catch (IOException e) {
            throw new RuntimeException("Failed to read the file at path: " + filePath, e);
        }
    }

    private List<String> loadDataFromConsole() {
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
