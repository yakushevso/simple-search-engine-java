package search;

public class Main {
    public static void main(String[] args) {
        new SearchController(new SearchView(), new SearchModel()).run();
    }
}
