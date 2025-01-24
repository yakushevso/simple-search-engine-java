package search;

public enum Messages {
    NOT_FOUND("No matching people found."),
    ENTER_NUMBER_PEOPLE("Enter the number of people:"),
    ENTER_ALL_PEOPLE("Enter all people:"),
    ENTER_NUMBER_SEARCH("Enter the number of search queries:"),
    ENTER_DATA_SEARCH("Enter data to search people:"),
    FOUND_PEOPLE("Found people:");

    private final String message;

    Messages(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return this.message;
    }
}
