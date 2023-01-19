package com.book.demo.bookproject.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Data
@NoArgsConstructor
@Component
public class Demo implements Serializable {

    private int bookID;
    private String bookTitle;
    private String bookPages;
    private Rating bookRating;
    private String bookISBN;
    private String bookPublishedDate;
    private String bookAuthor;
    private Genres bookGenres;
    private String bookPublishers;
    private double bookPrice;
    private String bookDescription;
    private String bookLanguage;

}
