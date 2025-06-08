package org.skypro.skyshop.product.SearchEngine;
import org.skypro.skyshop.product.Searchable;
import java.util.*;
import java.util.stream.Collectors;

public class SearchEngine {

    private Set<Searchable> searchables;

    public SearchEngine (int sizeArray) {
        this.searchables = new HashSet<>(sizeArray);
    }



    public void add(Searchable searchable) {
        searchables.add(searchable);
    }

    public Set<Searchable> search(String searchTerm) {
        return searchables.stream()
                .filter(item -> item.getSearchTerm().contains(searchTerm))
                .collect(Collectors.toCollection(() -> new TreeSet<>(new SearchableComparator())));
    }





    public Searchable findBestMatch(String search) throws BestResultNotFound {
        if (search == null || search.isBlank() || searchables.isEmpty()) {
            throw new BestResultNotFound("Search term is invalid: '" + search + "'");
        }

        Searchable bestMatch = null;
        int maxCount = -1;

        for (Searchable current : searchables) {
            String term = current.getSearchTerm();
            int currentCount = countOccurrences(term, search);

            if (currentCount > maxCount) {
                maxCount = currentCount;
                bestMatch = current;
            }
        }

        if (maxCount <= 0) {
            throw new BestResultNotFound("No matching result found for search term: '" + search + "'");
        }

        return bestMatch;
    }

    private int countOccurrences(String str, String substring) {
        int count = 0;
        int index = 0;
        int substringLength = substring.length();

        if (substringLength == 0) {
            return 0;
        }

        while (true) {
            int pos = str.indexOf(substring, index);
            if (pos == -1){
                break;
            }
            count++;
            index = pos + substringLength;
        }

        return count;
    }


}


