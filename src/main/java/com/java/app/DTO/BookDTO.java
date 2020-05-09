package com.java.app.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(value = {"createdDate"}, allowGetters = true)
public class BookDTO {
    @JsonInclude
    String authorName;

    @JsonInclude
    private String bookTitle;

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    @Override
    public String toString() {
        return "BookDTO{" +
                "authorName='" + authorName + '\'' +
                ", bookTitle='" + bookTitle + '\'' +
                '}';
    }
}
