package org.skypro.skyshop.product.search;

public interface Searchable {
    String getSearchTerm();

    String getContentType();

    String getName();

    default String getStringRepresentation() {
        return getName() + " - " + getContentType();
    }
}
