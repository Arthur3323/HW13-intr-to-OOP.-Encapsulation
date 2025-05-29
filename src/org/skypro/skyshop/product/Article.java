package org.skypro.skyshop.product;

import java.util.Objects;

public class Article implements Searchable {

    private final String articleName;
    private final String articleText;


    public Article(String articleName, String articleText) {
        this.articleName = articleName;
        this.articleText = articleText;
    }

    public String toString() {
        return "ARTICLE{" +
                "articleName='" + articleName + '\'' +
                ", articleText='" + articleText + '\'' +
                '}';
    }
    public String getSearchTerm() {
        return articleName;
    }

    public String getSearchType() {
        return "ARTICLE";
    }


    public String getName() {
        return articleName;
    }

    public String getText() {
        return articleText;
    }

    @Override
    public String getSearchName() {
        return getName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return Objects.equals(articleName, article.articleName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(articleName);
    }
}
