package org.skypro.skyshop.product;

import org.skypro.skyshop.product.search.Searchable;

public final class Article implements Searchable {
    private final String articleName;
    private final String articleValue;

    public Article(String articleName, String articleValue) {
        this.articleName = articleName;
        this.articleValue = articleValue;
    }

    @Override
    public String toString() {
        return "articleName='" + articleName + '\'' +
                ", articleValue='" + articleValue + '\'';
    }

    public String getArticleName() {
        return articleName;
    }

    public String getArticleValue() {
        return articleValue;
    }


    @Override
    public String getSearchTerm() {
        return toString();
    }

    @Override
    public String getContentType() {
        return "ARTICLE";
    }

    @Override
    public String getName() {
        return articleName;
    }

    @Override
    public String getStringRepresentation() {
        return Searchable.super.getStringRepresentation();
    }
}

