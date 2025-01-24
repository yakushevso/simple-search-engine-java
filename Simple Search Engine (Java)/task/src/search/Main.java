package search;

public class Main {
    public static void main(String[] args) {
        if (args.length == 2 && "--data".equals(args[0])) {
            new SearchController(new SearchView(), new SearchModel(), args[1]).run();
        } else {
            new SearchController(new SearchView(), new SearchModel(), null).run();
        }
    }
}
