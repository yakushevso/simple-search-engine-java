package search;

public enum Messages {
    BYE("Bye!"),
    ENTER_ALL_PEOPLE("Enter all people:"),
    ENTER_NAME_OR_EMAIL("Enter a name or email to search all suitable people."),
    ENTER_NUMBER_PEOPLE("Enter the number of people:"),
    FILED_TO_READ_FILE("Failed to read the file at path: "),
    FOUND_PEOPLE(" persons found:"),
    INCORRECT_OPTION("Incorrect option! Try again."),
    LIST_OF_PEOPLE("=== List of people ==="),
    MENU("""
            === Menu ===
            1. Find a person
            2. Print all people
            0. Exit"""),
    NOT_FOUND("No matching people found."),
    SELECT_STRATEGY("Select a matching strategy: ALL, ANY, NONE");


    private final String message;

    Messages(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return this.message;
    }
}
