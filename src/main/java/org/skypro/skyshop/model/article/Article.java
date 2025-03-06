package org.skypro.skyshop.model.article;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.skypro.skyshop.model.interfaces.Searchable;

import java.util.Objects;
import java.util.UUID;

public class Article implements Searchable {

    private final UUID id;
    private final String articleName;
    private final String articleText;

    public Article(UUID id, String articleName, String articleText) {
        this.id = id;
        this.articleName = articleName;
        this.articleText = articleText;
    }

    @Override
    public String toString() {
        return
                "ArticleName{" + articleName + '}' +
                        "ArticleText{" + articleText + '}';
    }

    @Override
    public String searchTerm() {
        return toString ();
    }

    @Override
    public String checkContentType() {
        return "ARTICLE";
    }

    @JsonIgnore
    @Override
    public String getSearchableName() {
        return "AricleName{" + articleName + '}';
    }

    @Override
    public UUID getId() {
        return id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode ( articleName );
    }

    @Override
    public boolean equals(Object obj) {
        if ( this == obj ) return true;
        if ( obj == null || getClass () != obj.getClass () ) return false;
        Article article = (Article) obj;
        return Objects.equals ( articleName, article.articleName );
    }

}




