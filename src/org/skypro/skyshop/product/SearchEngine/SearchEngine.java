package org.skypro.skyshop.product.SearchEngine;

import org.skypro.skyshop.product.Searchable;

import java.util.Arrays;

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
            if (searchables[i].searchTerm().contains(searchTerm)) {
                result[countResult] = searchables[i];
                countResult++;
            }
        if (countResult == 5) break;
    }
        return result;
    }


    }


