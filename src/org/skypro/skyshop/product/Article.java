package org.skypro.skyshop.product;

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
    public String searchTerm () {
        return toString();
    }

    public String searchType () {
        return "ARTICLE";
    }


    public String getName() {
        return articleName;
    }

    public String getText() {
        return articleText;
    }

    @Override
    public String searchName() {
        return getName();
    }
}
