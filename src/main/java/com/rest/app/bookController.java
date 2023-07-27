package com.rest.app;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/book")
public class bookController {

    @Autowired
    bookRepo bookRepo;

    @GetMapping
    public List<book> getAllBookRecords(){
        return bookRepo.findAll();
    }

    @GetMapping(value = "{bookId}")
    public book getBookById(@PathVariable(value = "bookId") Long bookId){
        return bookRepo.findById(bookId).get();
    }

    @PostMapping
    public book createBookRecord(@RequestBody @Valid book bookRecord){
        return bookRepo.save(bookRecord);
    }

    @PutMapping
    public book updateBookRecord(@RequestBody @Valid book bookRecord) throws NotFoundException {
        if(bookRecord==null||bookRecord.getBookId()==null){
            throw new NotFoundException("ID and BookRecord must not be null");
        }
        Optional<book> optionalBook=bookRepo.findById(bookRecord.getBookId());
        if(!optionalBook.isPresent()){
            throw new NotFoundException("Book with ID: "+bookRecord.getBookId()+" does not exist");
        }

        book existingBookRecord = optionalBook.get();
        existingBookRecord.setName(bookRecord.getName());
        existingBookRecord.setSum(bookRecord.getSum());
        existingBookRecord.setRate(bookRecord.getRate());

        return bookRepo.save(existingBookRecord);
    }

}
