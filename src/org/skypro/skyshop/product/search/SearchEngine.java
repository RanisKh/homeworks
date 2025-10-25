package org.skypro.skyshop.product.search;

import java.util.*;

public class SearchEngine {
    private static Set<Searchable> searchables;


    public SearchEngine(int initialCapacity) {
        this.searchables = new HashSet<>(initialCapacity);
    }

    public static final Comparator<Searchable> LENGTH_THEN_NATURAL_COMPARATOR = new Comparator<Searchable>() {
        @Override
        public int compare(Searchable o1, Searchable o2) {
            int lengthCompare = Integer.compare(
                    o2.getName().length(),
                    o1.getName().length()
            );
            if (lengthCompare != 0 ){
                return lengthCompare;
            }

            return o1.getName().compareTo(o2.getName());
        }
    };

    public static Set<Searchable> search(String query) {
        Set<Searchable> results = new TreeSet<>(LENGTH_THEN_NATURAL_COMPARATOR);

        if (query == null || query.trim().isEmpty()) {
            return results;
        }

        String LowerQuery = query.toLowerCase();

        for (Searchable item : searchables) {
            if (item == null) continue;

            String searchTerm = item.getSearchTerm();

            if (searchTerm != null && searchTerm.toLowerCase().contains(LowerQuery)) {
                results.add(item);
            }
        }
        return results;
    }

    public static boolean add(Searchable item) {
        if (item != null) {
           return searchables.add(item);
        }
        return false;
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

    public boolean remove(Searchable item){
        return searchables.remove(item);
    }

    public boolean contains(Searchable item){
        return searchables.contains(item);
    }

    public int getSearchableCount() {
        return searchables.size();
    }

    public void clear() {
        searchables.clear();
    }

    public static List<Searchable> getSearchables() {
        List<Searchable> sortedList = new ArrayList<>(searchables);
        sortedList.sort(LENGTH_THEN_NATURAL_COMPARATOR);
        return sortedList;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        SearchEngine that = (SearchEngine) o;
        return Objects.equals(searchables, that.searchables);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(searchables);
    }
}
