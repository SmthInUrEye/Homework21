package org.skypro.skyshop.service;

import org.skypro.skyshop.model.interfaces.Searchable;
import org.skypro.skyshop.model.searchengine.SearchResult;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SearchService {

    private final StorageService storageService;

    public SearchService(StorageService storageService) {
        this.storageService = storageService;
    }

    public Collection<SearchResult> search(String searchQuery) {

        List<Searchable> tempSet = storageService.getAllStorage ()
                .stream ()
                .filter ( searchable -> searchable.searchTerm ().toLowerCase ().contains ( searchQuery.toLowerCase () ) )
                .toList ();

        List<SearchResult> results = tempSet
                .stream ()
                .map ( SearchResult::fromSearchable )
                .toList ();

        return (results);
    }

}
