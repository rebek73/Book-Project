package com.book.demo.bookproject.controller;

import com.book.demo.bookproject.model.Book;
import com.book.demo.bookproject.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookService;

    private HashMap<Integer, Book> bookHashMap = new HashMap<>();
    private static Logger logger = LoggerFactory.getLogger(BookController.class);

    //insertBook - POST - requestBody
    //updateBook - PUT - requestBody
    //deleteBook - DELETE - PathVariable(idBook)
    //getBookDetails - GET - PathVariable
    //getAllBooks - GET - return book list

    @PostMapping("insertBook")
    public ResponseEntity insertBook(@RequestBody Book book){
        logger.info("Book coming for insertion");
        if(bookHashMap.containsValue(book.getBookID())){
            logger.error("Book already present.");
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        bookHashMap.put(book.getBookID(), book);
        System.out.println(bookHashMap.values() + " was inserted");
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping("updateBook")
    public Book updateBook(@RequestBody Book book){
        bookHashMap.put(book.getBookID(), book);
        return bookHashMap.get(book.getBookID());
    }

    @DeleteMapping("/deleteBook/{id}")
    public String deleteBookBy(@PathVariable("id") int bookId){
        bookHashMap.remove(bookId);
        return "Book was deleted successfully!!";
    }

    @GetMapping("/{bookId}")
    public Book getBookByBookId(@PathVariable("bookId") int bookId){
        logger.info("bookId received: {}", bookId);
        return bookHashMap.get(bookId);
    }

    @GetMapping("/books")
    public List<Book> getBooks(){
        return bookHashMap.values().stream()
                .collect(Collectors.toList());
    }

    @PatchMapping("/updateBookDetails/{bookId}")
    public Book updateBookDetails(@RequestBody Book book,@PathVariable("bookId") int id){
        bookHashMap.put(book.getBookID(), book);
        return bookHashMap.get(book.getBookID());
    }

}

