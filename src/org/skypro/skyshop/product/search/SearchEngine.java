package org.skypro.skyshop.product.search;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SearchEngine {
    private static List<Searchable> searchables;


    public SearchEngine(int initialCapacity) {
        this.searchables = new ArrayList<>(initialCapacity);
    }

    public static Map<String, Searchable> search(String query) {
        Map<String, Searchable> results = new TreeMap<>();

        if (query == null || query.trim().isEmpty()) {
            return results;
        }

        String LowerQuery = query.toLowerCase();

        for (Searchable item : searchables) {
            if (item == null) continue;

            String searchTerm = item.getSearchTerm();

            if (searchTerm != null && searchTerm.toLowerCase().contains(LowerQuery)) {
                results.put(item.getName(), item);
            }
        }
        return results;
    }

    public static void add(Searchable item) {
        if (item != null) {
            searchables.add(item);
        }
    }

    public void addAll(List<Searchable> items) {
        if (items != null) {
            for (Searchable item : items) {
                if (item != null) {
                    searchables.add(item);
                }
            }
        }
    }

    public int getSearchableCount() {
        return searchables.size();
    }

    public void clear() {
        searchables.clear();
    }

    public static List<Searchable> getSearchables() {
        return new ArrayList<>(searchables);
    }
}
