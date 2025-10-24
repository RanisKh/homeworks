package org.skypro.skyshop.product.search;

import java.util.ArrayList;
import java.util.List;

public class SearchEngine {
    private static List<Searchable> searchables;

    public SearchEngine(){
        this.searchables = new ArrayList<>();
    }

    public static List<Searchable> search(String query){
        List<Searchable> results = new ArrayList<>();

        if (query == null || query.trim().isEmpty()){
            return results;
        }

        String LowerQuery = query.toLowerCase();

        for (Searchable item : searchables){
            if (item == null) continue;

            String searchTerm = item.getSearchTerm();

            if (searchTerm != null && searchTerm.toLowerCase().contains(LowerQuery)){
                results.add(item);
                }
            }
        return results;
    }

    public static void add(Searchable item){
        if (item != null){
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
