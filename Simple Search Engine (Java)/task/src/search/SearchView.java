package search;

import java.util.Scanner;

public class SearchView {
    private final Scanner scanner = new Scanner(System.in);

    public String getInput() {
        return scanner.nextLine();
    }

    public void printOutput(Object obj) {
        System.out.println(obj);
    }
}
