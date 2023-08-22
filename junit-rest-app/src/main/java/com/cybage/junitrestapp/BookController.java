package com.cybage.junitrestapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/book")
public class BookController {

    @Autowired
    BookRepository bookRepository;

    @GetMapping
    public List<Book> getAllBookRecords(){
        return bookRepository.findAll();
    }

    @GetMapping("{bookId}")
    public Book getBookId(@PathVariable("bookId") Long bookId){
        return bookRepository.findById(bookId).get();
    }

    @PostMapping
    public Book createBookRecord(@RequestBody Book bookRecord){
        return bookRepository.save(bookRecord);
    }

    @PutMapping
    public Book updateBookRecord(@RequestBody Book bookRecord) throws Exception {
        if(bookRecord ==null || bookRecord.getBookId() ==null){
            throw new Exception("BookRecord or Id must not be null");
        }
        Optional<Book> optionalBook = bookRepository.findById(bookRecord.getBookId());
        if(!optionalBook.isPresent())
        {
            throw new Exception("Book with ID: "+bookRecord.getBookId()+ " does not exists.");
        }

        Book existingBookRecord = optionalBook.get();
        existingBookRecord.setName(bookRecord.getName());
        existingBookRecord.setSummary(bookRecord.getSummary());
        existingBookRecord.setRating(bookRecord.getRating());

        return bookRepository.save(existingBookRecord);
    }

    //Delete using tdd method

    @DeleteMapping("{bookId}")
    public void deleteBookById(@PathVariable("bookId") Long bookId) throws Exception {
        if(!bookRepository.findById(bookId).isPresent()) {
            throw new Exception("bookId "+bookId+" not present");
        }
        bookRepository.deleteById(bookId);
    }

}
