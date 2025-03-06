package org.skypro.skyshop.model.searchengine;

import org.skypro.skyshop.model.interfaces.Searchable;

import java.util.UUID;

public class SearchResult {

    private final UUID id;
    private final String name;
    private final String contentType;

    public SearchResult(UUID id, String name, String contentType) {
        this.id = id;
        this.name = name;
        this.contentType = contentType;
    }

    public static SearchResult fromSearchable(Searchable searchable) {
        return new SearchResult ( searchable.getId (), searchable.getSearchableName (), searchable.checkContentType () );
    }

    @Override
    public String toString() {
        return "ID: {" + id + '}' +
                "name: {" + name + '}' +
                "contentType: {" + contentType + '}';
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getContentType() {
        return contentType;
    }

}
