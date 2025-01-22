package search;

public class SearchController {
    private final SearchView view;
    private final SearchModel model;

    public SearchController(SearchView view, SearchModel model) {
        this.view = view;
        this.model = model;
    }

    public void run() {
        String firstLine = view.getInput();
        String secondLine = view.getInput();

        int position = model.getWordPosition(firstLine, secondLine);

        if (position != -1) {
            view.printOutput(position);
        } else {
            view.printOutput(Messages.NOT_FOUND);
        }
    }
}
