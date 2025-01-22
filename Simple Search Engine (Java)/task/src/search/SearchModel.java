package search;

public class SearchModel {
    public int getWordPosition(String first, String second) {
        String[] parts = first.split("\\s");

        for (int i = 0; i < parts.length; i++) {
            String part = parts[i];
            if (part.equals(second)) {
                return i + 1;
            }
        }

        return -1;
    }
}
