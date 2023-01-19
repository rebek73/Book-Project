package com.book.demo.bookproject.serviceImpl;

import com.book.demo.bookproject.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service("B1")
@Primary
public class BookServiceImpl implements BookService {

    private static Logger logger = LoggerFactory.getLogger(BookServiceImpl.class);

    @Override
    public void printBook() {
     logger.info("In book implementation...");
    }
}
