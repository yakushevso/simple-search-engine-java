package search;

public class Main {
    public static void main(String[] args) {
        SearchView view = new SearchView();
        SearchModel model = new SearchModel();

        new SearchController(view, model).run();
    }
}
