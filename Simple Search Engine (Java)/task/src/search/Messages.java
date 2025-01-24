package search;

public enum Messages {
    NOT_FOUND("No matching people found."),
    ENTER_NUMBER_PEOPLE("Enter the number of people:"),
    ENTER_ALL_PEOPLE("Enter all people:"),
    FOUND_PEOPLE("Found people:"),
    MENU("""
            === Menu ===
            1. Find a person
            2. Print all people
            0. Exit"""),
    INCORRECT_OPTION("Incorrect option! Try again."),
    ENTER_NAME_OR_EMAIL("Enter a name or email to search all suitable people."),
    LIST_OF_PEOPLE("=== List of people ==="),
    BYE("Bye!");

    private final String message;

    Messages(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return this.message;
    }
}
