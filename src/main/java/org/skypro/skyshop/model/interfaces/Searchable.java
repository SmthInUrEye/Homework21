package org.skypro.skyshop.model.interfaces;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.UUID;

public interface Searchable {

    String searchTerm();

    String checkContentType();

    String getSearchableName();

    UUID getId();


    default String getStringRepresentation() {
        return (searchTerm () + " - " + checkContentType ());
    }

    default int getSearchTerm(String search, String placeToSearch) {
        int maxRepeats = 0;
        int index = 0;
        while ((index = placeToSearch.indexOf ( search, index )) != -1) {
            maxRepeats++;
            index += search.length ();
        }
        return maxRepeats;
    }

}