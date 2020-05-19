package com.example.ignite.view;

import com.example.ignite.model.ResultListOfBook;

public interface Mainview {
//abstract method to show list of books
    void getBooks(ResultListOfBook resultListOfBook);
    void getBooksNextBook(ResultListOfBook resultListOfBook);
    void getBooksNextBookSearch(ResultListOfBook resultListOfBook);
}
