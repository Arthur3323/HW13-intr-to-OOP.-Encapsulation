package org.skypro.skyshop.product;

public interface Searchable {

     String getSearchTerm();
     String getSearchType();
     String getSearchName();

    default String getStringRepresentation() {
        return "`" + getSearchName() + "` - имя Searchable-объекта "
              + "`" + getSearchType() + "` - тип Searchable-объекта";
    }


}
