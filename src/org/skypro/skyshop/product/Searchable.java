package org.skypro.skyshop.product;

public interface Searchable {

     String searchTerm();
     String searchType();
     String searchName();

    default String getStringRepresentation() {
        return  searchName() + " имя Searchable-объекта "
                + searchType() + " тип Searchable-объекта";
    }


}
