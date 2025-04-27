package org.skypro.skyshop.product.SearchEngine;

import org.skypro.skyshop.product.Searchable;

public class SearchEngine {

    private int count;
    private Searchable[] searchables;


    public SearchEngine (int sizeArray) {
        this.searchables = new Searchable[sizeArray];
        this.count = 0;
    }



    public void add(Searchable searchable) {
        if (count >= searchables.length) {
            System.out.println("Переполнено!");
        } else {
            searchables[count++] = searchable;
        }
    }

    public Searchable[] search ( String searchTerm) {
        int countResult = 0;
        Searchable[] result = new Searchable[5];
        for (int i = 0; i < count; i++) {
            if (searchables[i].getSearchTerm().contains(searchTerm)) {
                result[countResult] = searchables[i];
                countResult++;
            }

        if (countResult == 5) break;
    }
        return result;
    }

    public Searchable findBestMatch(String search) throws BestResultNotFound {
        if (search == null || search.isBlank() || count == 0) {
            throw new BestResultNotFound("Search term is invalid: '" + search + "'");
        }



        Searchable bestMatch = null;
        int maxCount = -1;

        for (int i = 0; i < count; i++) {
            Searchable current = searchables[i];
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
            if (pos == -1) {
                break;
            }
            count++;
            index = pos + substringLength;
        }

        return count;
    }


}


