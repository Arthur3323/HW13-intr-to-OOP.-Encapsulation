package org.skypro.skyshop.product.SearchEngine;

import org.skypro.skyshop.product.Searchable;
import java.util.Comparator;

public class SearchableComparator implements Comparator<Searchable> {
    @Override
    public int compare(Searchable s1, Searchable s2) {
        String term1 = s1.getSearchTerm();
        String term2 = s2.getSearchTerm();

        int lengthCompare = Integer.compare(term2.length(), term1.length());
        if (lengthCompare != 0) {
            return lengthCompare;
        }

        return term1.compareTo(term2);
    }
}